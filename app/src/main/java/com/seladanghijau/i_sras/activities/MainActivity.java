package com.seladanghijau.i_sras.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.dtos.Score;


public class MainActivity extends AppCompatActivity {
    // views
    Fragment homeFragment, communityFragment, workplaceFragment, environmentFragment, marketplaceFragment, reportFragment;

    // vars
    public Score score;
    public int communityVitalCount, workplaceVitalCount, environmentalVitalCount, marketplaceVitalCount;
    public int communityRecommendedCount, workplaceRecommendedCount, environmentalRecommendedCount, marketplaceRecommendedCount;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dekat sini akan guna getFragmentManager untuk find id fragment
        homeFragment = getFragmentManager().findFragmentById(R.id.HomeFragment);
        workplaceFragment = getFragmentManager().findFragmentById(R.id.WorkplaceFragment);
        environmentFragment = getFragmentManager().findFragmentById(R.id.EnvironmentFragment);
        marketplaceFragment = getFragmentManager().findFragmentById(R.id.MarketplaceFragment);
        communityFragment = getFragmentManager().findFragmentById(R.id.CommunityFragment);
        reportFragment = getFragmentManager().findFragmentById(R.id.ReportFragment);

        //Guna FragmentTransaction untuk buat fragment visible. HomeFragment je dulu kat sini
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.show(homeFragment);
        fragmentTransaction.hide(communityFragment);
        fragmentTransaction.hide(workplaceFragment);
        fragmentTransaction.hide(environmentFragment);
        fragmentTransaction.hide(marketplaceFragment);
        fragmentTransaction.hide(reportFragment);
        fragmentTransaction.commit();

        initVars();
    }

    private void initVars() {
        score = new Score();

        communityVitalCount = 0;
        workplaceVitalCount = 0;
        environmentalVitalCount = 0;
        marketplaceVitalCount = 0;

        communityRecommendedCount = 0;
        workplaceRecommendedCount = 0;
        environmentalRecommendedCount = 0;
        marketplaceRecommendedCount = 0;
    }
}
