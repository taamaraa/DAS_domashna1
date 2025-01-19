package mk.ukim.finki.das.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/tech-analysis")
    public String techAnalysis() {
        return "tehnicka.html";
    }

    @GetMapping("/fund-analysis")
    public String fundAnalysis() {
        return "fundamentalna.html";
    }

    @GetMapping("/predict-lstm")
    public String predictLSTM() {
        return "LSTM.html";
    }

    @GetMapping("/about-us")
    public String aboutUs() {
        return "base.html";
    }
}
