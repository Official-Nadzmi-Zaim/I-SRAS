package com.seladanghijau.i_sras.providers;

import com.seladanghijau.i_sras.dtos.Score;

/**
 * Created by seladanghijau on 11/9/2016.
 */
public class ScoreProvider {
    public static Score loadScore() { // load semua kategori score dan return dlm bentuk object Score
        return null;
    }

    public static int loadISRASScore() { // load score bagi kategori isras drp database
        return 0;
    }

    public static int loadVitalScore() {  // load score bagi kategori vital drp database
        return 0;
    }

    public static int loadRecommendedScore() { // load score bagi kategori recommended drp database
        return 0;
    }

    public static Score calculateScore() { // kira semua score (ISRAS, VITAL, RECOMMENDED) dan return dlm object Score
        return null;
    }

    public static int calculateScoreISRAS() { // kira jumlah score antara vital & recommended
        return 0;
    }

    public static int calculateScoreVital() { // kira score bagi kategori vital
        return 0;
    }

    public static int calculateScoreRecommended() { // kira skor bagi kategori recommended
        return 0;
    }

    public static Score getLevelScore(int isras, int vital, int recommended) { // produce appopriate category berdasarkan value <param1> (tengok range skor yg miss buat). Return semua score dlm bentuk Score objek
        return null;
    }

    public static int getLevelISRAS(int isras) { // produce appopriate category berdasarkan value <param1> (tengok range skor yg miss buat)
        return 0;
    }

    public static int getLevelVital(int vital) { // produce appopriate category berdasarkan value <param1> (tengok range skor yg miss buat)
        return 0;
    }

    public static int getLevelRecommended(int recommended) { // produce appopriate category berdasarkan value <param1> (tengok range skor yg miss buat)
        return 0;
    }

    public static boolean storeScore(Score score) { // simpan score baru. retrieve 3 jenis score(ISRAS, Vital & Recommended) dalam object <param1>
        return false;
    }

    public static boolean updateScore(int scoreId, Score score) { // update data score ikut <param1> & <param2>
        return false;
    }

    public static boolean clearScore() { // buang semua data dalam table score
        return false;
    }
}
