package com.seladanghijau.i_sras.dto;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class Score {
    private int scoreId;
    private int israsScore, vitalScore, recommendedScore;
    private int israsLevel, vitalLevel, recommendedLevel;

    // constructor
    public Score() {
        scoreId = 0;
        israsScore = 0;
        vitalScore = 0;
        recommendedScore = 0;
        israsLevel = 0;
        vitalLevel = 0;
        recommendedLevel = 0;
    }

    public Score(int scoreId, int israsScore, int vitalScore, int recommendedScore, int israsLevel, int vitalLevel, int recommendedLevel) {
        this.scoreId = scoreId;
        this.israsScore = israsScore;
        this.vitalScore = vitalScore;
        this.recommendedScore = recommendedScore;
        this.israsLevel = israsLevel;
        this.vitalLevel = vitalLevel;
        this.recommendedLevel = recommendedLevel;
    }

    // getter
    public int getScoreId() { return scoreId; }
    public int getIsrasScore() { return israsScore; }
    public int getVitalScore() { return vitalScore; }
    public int getRecommendedScore() { return recommendedScore; }
    public int getIsrasLevel() { return israsLevel; }
    public int getVitalLevel() { return vitalLevel; }
    public int getRecommendedLevel() { return recommendedLevel; }

    // setter
    public void setScoreId(int scoreId) { this.scoreId = scoreId; }
    public void setIsrasScore(int israsScore) { this.israsScore = israsScore; }
    public void setVitalScore(int vitalScore) { this.vitalScore = vitalScore; }
    public void setRecommendedScore(int recommendedScore) { this.recommendedScore = recommendedScore; }
    public void setIsrasLevel(int israsLevel) { this.israsLevel = israsLevel; }
    public void setVitalLevel(int vitalLevel) { this.vitalLevel = vitalLevel; }
    public void setRecommendedLevel(int recommendedLevel) { this.recommendedLevel = recommendedLevel; }
}
