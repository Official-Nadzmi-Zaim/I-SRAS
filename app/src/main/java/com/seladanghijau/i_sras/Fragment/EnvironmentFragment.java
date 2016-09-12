package com.seladanghijau.i_sras.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.seladanghijau.i_sras.R;

public class EnvironmentFragment extends Fragment {

    Fragment workplaceFragment, environmentFragment, marketplaceFragment;
    Button btnPreviousE, btnNextE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Dalam ini untuk apa apa code selain set listener dgn findviewbyid
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentenvironment, container, false);
        //inflate fragment layout kat sini
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //kat sini set findviewby id dgn listener e.g Button btnNext = (Button) getActivity().findViewById(R.id.btnNext2);
        environmentFragment = getFragmentManager().findFragmentById(R.id.EnvironmentFragment);
        marketplaceFragment = getFragmentManager().findFragmentById(R.id.MarketplaceFragment);
        workplaceFragment = getFragmentManager().findFragmentById(R.id.WorkplaceFragment);

        btnPreviousE = (Button) getActivity().findViewById(R.id.btnPreviousE);
        btnNextE = (Button) getActivity().findViewById(R.id.btnNextE);

        btnPreviousE.setOnClickListener(new OnButtonClick());
        btnNextE.setOnClickListener(new OnButtonClick());
    }

    private class OnButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            switch (v.getId()){
                case R.id.btnPreviousE:
                    fragmentTransaction.hide(environmentFragment);
                    fragmentTransaction.show(workplaceFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.btnNextE :
                    fragmentTransaction.hide(environmentFragment);
                    fragmentTransaction.show(marketplaceFragment);
                    fragmentTransaction.commit();
                    break;
                default:
                    break;
            }
        }
    }
}
