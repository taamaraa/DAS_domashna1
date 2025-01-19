package mk.ukim.finki.das.model;

import java.util.Map;

public class SentimentResult {
    private String issuer;
    private String sentiment;
    private Map<String, Double> sentimentScores;
    private String recommendation;
    private String predictedChange;

    public SentimentResult(String issuer, String sentiment) {
        this.issuer = issuer;
        this.sentiment = sentiment;
        this.sentimentScores = this.sentimentScores;
        this.recommendation = recommendation;
        this.predictedChange = this.predictedChange;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public Map<String, Double> getSentimentScores() {
        return sentimentScores;
    }

    public void setSentimentScores(Map<String, Double> sentimentScores) {
        this.sentimentScores = sentimentScores;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getPredictedChange() {
        return predictedChange;
    }

    public void setPredictedChange(String predictedChange) {
        this.predictedChange = predictedChange;
    }
}
