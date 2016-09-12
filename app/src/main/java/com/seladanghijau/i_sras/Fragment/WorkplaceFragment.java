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

public class WorkplaceFragment extends Fragment {

    Fragment communityFragment, workplaceFragment, environmentFragment;
    Button btnPreviousW, btnNextW;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Dalam ini untuk apa apa code selain set listener dgn findviewbyid
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentworkplace, container, false);
        //inflate fragment layout kat sini
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //kat sini set findviewby id dgn listener e.g Button btnNext = (Button) getActivity().findViewById(R.id.btnNext2);
        environmentFragment = getFragmentManager().findFragmentById(R.id.EnvironmentFragment);
        communityFragment = getFragmentManager().findFragmentById(R.id.CommunityFragment);
        workplaceFragment = getFragmentManager().findFragmentById(R.id.WorkplaceFragment);

        btnPreviousW = (Button) getActivity().findViewById(R.id.btnPreviousW);
        btnNextW = (Button) getActivity().findViewById(R.id.btnNextW);

        btnPreviousW.setOnClickListener(new OnButtonClick());
        btnNextW.setOnClickListener(new OnButtonClick());
    }

    private class OnButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            switch (v.getId()){
                case R.id.btnPreviousW:
                    fragmentTransaction.hide(workplaceFragment);
                    fragmentTransaction.show(communityFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.btnNextW :
                    fragmentTransaction.hide(workplaceFragment);
                    fragmentTransaction.show(environmentFragment);
                    fragmentTransaction.commit();
                    break;
                default:
                    break;
            }
        }
    }
}
