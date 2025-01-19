package mk.ukim.finki.das.web;

import mk.ukim.finki.das.model.SentimentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/gateway")
public class GatewayController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/analyze")
    public SentimentResult analyzeIssuer(@RequestParam String issuer) {
        String url = "http://localhost:8081/api/analyze"; // URL до analyze-service
        return restTemplate.postForObject(url + "?issuer=" + issuer, null, SentimentResult.class);
    }

    @GetMapping("/results")
    public List<SentimentResult> getAllResults() {
        String url = "http://localhost:8082/api/results"; // URL до results-service
        ResponseEntity<List<SentimentResult>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SentimentResult>>() {}
        );
        return response.getBody();
    }
}