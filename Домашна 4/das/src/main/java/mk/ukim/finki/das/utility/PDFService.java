package mk.ukim.finki.das.utility;

import org.springframework.stereotype.Component;

@Component
public class PDFService {
    public String extractTextFromPDF(String issuer) {
        return "Sample extracted text for issuer " + issuer;
    }
}
