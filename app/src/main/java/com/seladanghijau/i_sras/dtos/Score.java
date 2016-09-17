package com.seladanghijau.i_sras.dtos;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class Score {
    private int israsScore, vitalScore, recommendedScore;
    private int israsLevel, vitalLevel, recommendedLevel;
    private int communityVitalScore, workplaceVitalScore, environmentVitalScore, marketplaceVitalScore;
    private int communityRecommendedScore, workplaceRecommendedScore, environmentRecommendedScore, marketplaceRecommendedScore;

    // constructor
    public Score() {
        israsScore = 0;
        vitalScore = 0;
        recommendedScore = 0;
        israsLevel = 0;
        vitalLevel = 0;
        recommendedLevel = 0;

        communityVitalScore = 0;
        workplaceVitalScore = 0;
        environmentVitalScore = 0;
        marketplaceVitalScore = 0;
        communityRecommendedScore = 0;
        workplaceRecommendedScore = 0;
        environmentRecommendedScore = 0;
        marketplaceRecommendedScore = 0;
    }


    // getter
    public int getIsrasScore() { return israsScore; }
    public int getVitalScore() { return vitalScore; }
    public int getRecommendedScore() { return recommendedScore; }
    public int getIsrasLevel() { return israsLevel; }
    public int getVitalLevel() { return vitalLevel; }
    public int getRecommendedLevel() { return recommendedLevel; }
    public int getCommunityVitalScore() { return communityVitalScore; }
    public int getWorkplaceVitalScore() { return workplaceVitalScore; }
    public int getEnvironmentVitalScore() { return environmentVitalScore; }
    public int getMarketplaceVitalScore() { return marketplaceVitalScore; }
    public int getCommunityRecommendedScore() { return communityRecommendedScore; }
    public int getWorkplaceRecommendedScore() { return workplaceRecommendedScore; }
    public int getEnvironmentRecommendedScore() { return environmentRecommendedScore; }
    public int getMarketplaceRecommendedScore() { return marketplaceRecommendedScore; }

    // setter
    public void setIsrasScore(int israsScore) { this.israsScore = israsScore; }
    public void setVitalScore(int vitalScore) { this.vitalScore = vitalScore; }
    public void setRecommendedScore(int recommendedScore) { this.recommendedScore = recommendedScore; }
    public void setIsrasLevel(int israsLevel) { this.israsLevel = israsLevel; }
    public void setVitalLevel(int vitalLevel) { this.vitalLevel = vitalLevel; }
    public void setRecommendedLevel(int recommendedLevel) { this.recommendedLevel = recommendedLevel; }
    public void setCommunityVitalScore(int communityVitalScore) { this.communityVitalScore = communityVitalScore; }
    public void setWorkplaceVitalScore(int workplaceVitalScore) { this.workplaceVitalScore = workplaceVitalScore; }
    public void setEnvironmentVitalScore(int environmentVitalScore) { this.environmentVitalScore = environmentVitalScore; }
    public void setMarketplaceVitalScore(int marketplaceVitalScore) { this.marketplaceVitalScore = marketplaceVitalScore; }
    public void setCommunityRecommendedScore(int communityRecommendedScore) { this.communityRecommendedScore = communityRecommendedScore; }
    public void setWorkplaceRecommendedScore(int workplaceRecommendedScore) { this.workplaceRecommendedScore = workplaceRecommendedScore; }
    public void setEnvironmentRecommendedScore(int environmentRecommendedScore) { this.environmentRecommendedScore = environmentRecommendedScore; }
    public void setMarketplaceRecommendedScore(int marketplaceRecommendedScore) { this.marketplaceRecommendedScore = marketplaceRecommendedScore; }

    // other methods
    public int calculateISRASLevel(int israsScore) {
        if(israsScore <= 60)
            return 3;
        else if(israsScore > 60 && israsScore <= 120)
            return 2;
        else
            return 1;
    }

    public int calculateVitalLevel(int vitalScore) {
        if(vitalScore <= 36)
            return 3;
        else if(vitalScore > 36 && vitalScore <= 72)
            return 2;
        else
            return 1;
    }

    public int calculateRecommendedLevel(int recommendedScore) {
        if(recommendedScore <= 26)
            return 3;
        else if(recommendedScore > 26 && recommendedScore <= 52)
            return 2;
        else
            return 1;
    }
}
