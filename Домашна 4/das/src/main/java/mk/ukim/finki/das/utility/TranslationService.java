package mk.ukim.finki.das.utility;

import org.springframework.stereotype.Component;

@Component
public class TranslationService {
    public String translate(String text, String sourceLang, String targetLang) {
        return "Translated text: " + text;
    }
}
