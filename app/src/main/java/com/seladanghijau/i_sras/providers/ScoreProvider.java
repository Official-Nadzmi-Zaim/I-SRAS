package com.seladanghijau.i_sras.provider;

import com.seladanghijau.i_sras.dto.Score;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class ScoreProvider {
    public static Score loadScore() { return null; }

    public static int loadISRASScore() { return 0; }

    public static int loadVitalScore() { return 0; }

    public static int loadRecommendedScore() { return 0; }

    public static Score calculateScore() {  return null; }

    public static int calculateScoreISRAS() { return 0; }

    public static int calculateScoreVital() { return 0; }

    public static int calculateScoreRecommended() { return 0; }

    public static Score getLevelScore() {  return null; }

    public static int getLevelISRAS() { return 0; }

    public static int getLevelVital() { return 0; }

    public static int getLevelRecommended() { return 0; }

    public static boolean storeScore(Score score) { return false; }

    public static boolean updateScore(int scoreId, Score score) { return false; }
}
