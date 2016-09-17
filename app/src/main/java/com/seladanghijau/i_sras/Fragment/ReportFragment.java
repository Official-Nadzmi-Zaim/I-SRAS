package com.seladanghijau.i_sras.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.activities.MainActivity;
import com.seladanghijau.i_sras.custom.CustomTextView;
import com.seladanghijau.i_sras.dtos.Score;

public class ReportFragment extends Fragment {

    FrameLayout frame;
    LinearLayout community, workplace, environmental, marketplace;
    Fragment homeFragment, communityFragment, workplaceFragment, environmentFragment, marketplaceFragment;
    CustomTextView txtCommunity, txtWorkplace, txtEnviromental, txtMarketplace;
    CustomTextView IrasScore, VitalScore, RecommendedScore;
    CustomTextView IrasScoreLevel, VitalScoreLevel, RecommendedScoreLevel;
    Button btnDone;
    
    Score score;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Dalam ini untuk apa apa code selain set listener dgn findviewbyid
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentreport, container, false);
        //inflate fragment layout kat sini
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //kat sini set findviewby id dgn listener e.g Button btnNext = (Button) getActivity().findViewById(R.id.btnNext2);
        homeFragment = getFragmentManager().findFragmentById(R.id.HomeFragment);
        workplaceFragment = getFragmentManager().findFragmentById(R.id.WorkplaceFragment);
        environmentFragment = getFragmentManager().findFragmentById(R.id.EnvironmentFragment);
        marketplaceFragment = getFragmentManager().findFragmentById(R.id.MarketplaceFragment);
        communityFragment = getFragmentManager().findFragmentById(R.id.CommunityFragment);
        frame = (FrameLayout) getActivity().findViewById(R.id.content_frame);

        txtCommunity = (CustomTextView) getActivity().findViewById(R.id.txtCommunity);
        txtWorkplace = (CustomTextView) getActivity().findViewById(R.id.txtWorkplace);
        txtEnviromental = (CustomTextView) getActivity().findViewById(R.id.txtEnviromental);
        txtMarketplace = (CustomTextView) getActivity().findViewById(R.id.txtMarketplace);

        IrasScore = (CustomTextView) getActivity().findViewById(R.id.IrasScore);
        VitalScore = (CustomTextView) getActivity().findViewById(R.id.VitalScore);
        RecommendedScore = (CustomTextView) getActivity().findViewById(R.id.RecommendedScore);

        IrasScoreLevel = (CustomTextView) getActivity().findViewById(R.id.IrasScoreLevel);
        VitalScoreLevel = (CustomTextView) getActivity().findViewById(R.id.VitalScoreLevel);
        RecommendedScoreLevel = (CustomTextView) getActivity().findViewById(R.id.RecommendedScoreLevel);

        community = (LinearLayout) getActivity().findViewById(R.id.communityL);
        environmental = (LinearLayout) getActivity().findViewById(R.id.enviromentalL);
        workplace = (LinearLayout) getActivity().findViewById(R.id.worplaceL);
        marketplace = (LinearLayout) getActivity().findViewById(R.id.marketplaceL);

        btnDone = (Button) getActivity().findViewById(R.id.btnDone);

        //Set onClick Listener
        community.setOnClickListener(new OnButtonClick());
        environmental.setOnClickListener(new OnButtonClick());
        workplace.setOnClickListener(new OnButtonClick());
        marketplace.setOnClickListener(new OnButtonClick());
        btnDone.setOnClickListener(new OnButtonClick());

        initScore();
        initVars();
    }
    
    private void initScore() {
        score = ((MainActivity) getActivity()).score;
    }

    private void initVars() {
        // setup scores
        // community
        txtCommunity.setText(String.valueOf(score.getCommunityVitalScore() + score.getCommunityRecommendedScore()));
        // workplace
        txtWorkplace.setText(String.valueOf(score.getWorkplaceVitalScore() + score.getWorkplaceRecommendedScore()));
        // environment
        txtEnviromental.setText(String.valueOf(score.getEnvironmentVitalScore() + score.getEnvironmentRecommendedScore()));
        // marketplace
        txtMarketplace.setText(String.valueOf(score.getMarketplaceVitalScore() + score.getMarketplaceRecommendedScore()));

        // isras
        switch (score.getIsrasLevel()) {
            case 1:
                IrasScore.setText(String.valueOf(score.getIsrasScore()));
                IrasScoreLevel.setText(getResources().getText(R.string.lvl_1));
                IrasScore.setBackgroundColor(Color.GREEN);
                IrasScoreLevel.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                IrasScore.setText(String.valueOf(score.getIsrasScore()));
                IrasScoreLevel.setText(getResources().getText(R.string.lvl_2));
                IrasScore.setBackgroundColor(Color.YELLOW);
                IrasScoreLevel.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                IrasScore.setText(String.valueOf(score.getIsrasScore()));
                IrasScoreLevel.setText(getResources().getText(R.string.lvl_3));
                IrasScore.setBackgroundColor(Color.RED);
                IrasScoreLevel.setBackgroundColor(Color.RED);
                break;
        }
        // vital
        switch (score.getVitalLevel()) {
            case 1:
                VitalScore.setText(String.valueOf(score.getVitalLevel()));
                VitalScoreLevel.setText(getResources().getText(R.string.lvl_1));
                VitalScore.setBackgroundColor(Color.GREEN);
                VitalScoreLevel.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                VitalScore.setText(String.valueOf(score.getVitalLevel()));
                VitalScoreLevel.setText(getResources().getText(R.string.lvl_2));
                VitalScore.setBackgroundColor(Color.YELLOW);
                VitalScoreLevel.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                VitalScore.setText(String.valueOf(score.getVitalLevel()));
                VitalScoreLevel.setText(getResources().getText(R.string.lvl_3));
                VitalScore.setBackgroundColor(Color.RED);
                VitalScoreLevel.setBackgroundColor(Color.RED);
                break;
        }
        // recommended
        switch (score.getRecommendedLevel()) {
            case 1:
                RecommendedScore.setText(String.valueOf(score.getRecommendedLevel()));
                RecommendedScoreLevel.setText(getResources().getText(R.string.lvl_1));
                RecommendedScore.setBackgroundColor(Color.GREEN);
                RecommendedScoreLevel.setBackgroundColor(Color.GREEN);
                break;
            case 2:
                RecommendedScore.setText(String.valueOf(score.getRecommendedLevel()));
                RecommendedScoreLevel.setText(getResources().getText(R.string.lvl_2));
                RecommendedScore.setBackgroundColor(Color.YELLOW);
                RecommendedScoreLevel.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                RecommendedScore.setText(String.valueOf(score.getRecommendedLevel()));
                RecommendedScoreLevel.setText(getResources().getText(R.string.lvl_3));
                RecommendedScore.setBackgroundColor(Color.RED);
                RecommendedScoreLevel.setBackgroundColor(Color.RED);
                break;
        }

        txtCommunity.invalidate();
        txtWorkplace.invalidate();
        txtEnviromental.invalidate();
        txtMarketplace.invalidate();

        IrasScore.invalidate();
        VitalScore.invalidate();
        RecommendedScore.invalidate();

        IrasScoreLevel.invalidate();
        VitalScoreLevel.invalidate();
        RecommendedScoreLevel.invalidate();
    }

    private class OnButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            switch (v.getId()){
                case R.id.communityL:
                    frame.setVisibility(View.GONE);
                    fragmentTransaction.show(communityFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.enviromentalL:
                    frame.setVisibility(View.GONE);
                    fragmentTransaction.show(environmentFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.worplaceL:
                    frame.setVisibility(View.GONE);
                    fragmentTransaction.show(workplaceFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.marketplaceL:
                    frame.setVisibility(View.GONE);
                    fragmentTransaction.show(marketplaceFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.btnDone:
                    fragmentTransaction.remove(communityFragment);
                    fragmentTransaction.remove(workplaceFragment);
                    fragmentTransaction.remove(environmentFragment);
                    fragmentTransaction.remove(marketplaceFragment);
                    fragmentTransaction.commit();
                    getActivity().finish();
                    break;
                default:
                    break;
            }
        }
    }
}
