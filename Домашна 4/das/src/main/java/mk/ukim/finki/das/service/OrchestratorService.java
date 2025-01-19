package mk.ukim.finki.das.service;

import mk.ukim.finki.das.model.SentimentResult;
import mk.ukim.finki.das.repository.IssuerRepository;
import mk.ukim.finki.das.utility.PDFService;
import mk.ukim.finki.das.utility.SentimentAnalysisService;
import mk.ukim.finki.das.utility.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrchestratorService {

    @Autowired
    private PDFService pdfService;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private IssuerRepository issuerRepository;

    private final List<SentimentResult> results = new ArrayList<>();

    public SentimentResult processIssuer(String issuer) {
        String extractedText = pdfService.extractTextFromPDF(issuer);
        String translatedText = translationService.translate(extractedText, "mk", "en");
        Map<String, Double> sentimentScores = sentimentAnalysisService.analyzeSentiment(translatedText);

        String recommendation;
        String predictedChange;
        double compoundScore = sentimentScores.getOrDefault("compound", 0.0);

        if (compoundScore > 0.1) {
            recommendation = "Buy";
            predictedChange = "will increase";
        } else if (compoundScore < -0.1) {
            recommendation = "Sell";
            predictedChange = "will decrease";
        } else {
            recommendation = "Hold";
            predictedChange = "will remain stable";
        }

        SentimentResult result = new SentimentResult(issuer, recommendation);
        issuerRepository.saveResult(result);
        return result;
    }

    public List<SentimentResult> getAllResults() {
        return issuerRepository.getAllResults();
    }
}
