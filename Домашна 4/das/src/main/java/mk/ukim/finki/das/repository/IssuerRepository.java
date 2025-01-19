package mk.ukim.finki.das.repository;

import mk.ukim.finki.das.model.SentimentResult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssuerRepository {
    private final List<SentimentResult> results = new ArrayList<>();

    public void saveResult(SentimentResult result) {
        results.add(result);
    }

    public List<SentimentResult> getAllResults() {
        return results;
    }
}