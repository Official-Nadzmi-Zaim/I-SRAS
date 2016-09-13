package com.seladanghijau.i_sras.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.providers.AnswerProvider;
import com.seladanghijau.i_sras.providers.ScoreProvider;

public class ReportFragment extends Fragment {

    LinearLayout community, workplace, environmental, marketplace;
    Fragment homeFragment, communityFragment, workplaceFragment, environmentFragment, marketplaceFragment, reportFragment;
    Button btnDone;

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
        reportFragment = getFragmentManager().findFragmentById(R.id.ReportFragment);

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
    }

    private class OnButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            switch (v.getId()){
                case R.id.communityL:
                    fragmentTransaction.hide(reportFragment);
                    fragmentTransaction.show(communityFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.enviromentalL:
                    fragmentTransaction.hide(reportFragment);
                    fragmentTransaction.show(environmentFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.worplaceL:
                    fragmentTransaction.hide(reportFragment);
                    fragmentTransaction.show(workplaceFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.marketplaceL:
                    fragmentTransaction.hide(reportFragment);
                    fragmentTransaction.show(marketplaceFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.btnDone:
                    AnswerProvider.clearAnswer();
                    ScoreProvider.clearScore();

                    fragmentTransaction.hide(reportFragment);
                    fragmentTransaction.show(homeFragment);
                    fragmentTransaction.commit();
                    break;
                default:
                    break;
            }
        }
    }
}
