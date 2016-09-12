package com.seladanghijau.i_sras.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.adapter.SoalanAdapter;
import com.seladanghijau.i_sras.dtos.Soalan;
import com.seladanghijau.i_sras.helper.DBHelper;
import com.seladanghijau.i_sras.providers.SoalanProvider;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

    Fragment homeFragment, communityFragment, workplaceFragment;
    Button btnPreviousC, btnNextC;
    List<Soalan> soalanList = new ArrayList<>();
    ListView communityListView;
    SoalanAdapter soalanAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Dalam ini untuk apa apa code selain set listener dgn findviewbyid
        DBHelper dbHelper = new DBHelper(getActivity());
        try {
            dbHelper.initDB();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //soalanList = SoalanProvider.loadSoalanBasedOnCategory(1);
        soalanList = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 1, 4);

        soalanAdapter = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList);
        soalanAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentcommunity, container, false);
        //inflate fragment layout kat sini
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //kat sini set findviewby id dgn listener e.g Button btnNext = (Button) getActivity().findViewById(R.id.btnNext2);
        homeFragment = getFragmentManager().findFragmentById(R.id.HomeFragment);
        communityFragment = getFragmentManager().findFragmentById(R.id.CommunityFragment);
        workplaceFragment = getFragmentManager().findFragmentById(R.id.WorkplaceFragment);

        communityListView = (ListView) getActivity().findViewById(R.id.communityListView);
        communityListView.setAdapter(soalanAdapter);
        communityListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        btnPreviousC = (Button) getActivity().findViewById(R.id.btnPreviousC);
        btnNextC = (Button) getActivity().findViewById(R.id.btnNextC);

        btnPreviousC.setOnClickListener(new OnButtonClick());
        btnNextC.setOnClickListener(new OnButtonClick());
    }

    private class OnButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            switch (v.getId()){
                case R.id.btnPreviousC:
                    fragmentTransaction.hide(communityFragment);
                    fragmentTransaction.show(homeFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.btnNextC :
                    fragmentTransaction.hide(communityFragment);
                    fragmentTransaction.show(workplaceFragment);
                    fragmentTransaction.commit();
                    break;
                default:
                    break;
            }
        }
    }

}
