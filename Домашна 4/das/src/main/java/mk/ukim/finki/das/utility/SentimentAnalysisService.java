package mk.ukim.finki.das.utility;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SentimentAnalysisService {
    public Map<String, Double> analyzeSentiment(String text) {
        Map<String, Double> scores = new HashMap<>();
        scores.put("compound", 0.5);
        scores.put("positive", 0.7);
        scores.put("negative", 0.1);
        scores.put("neutral", 0.2);
        return scores;
    }
}