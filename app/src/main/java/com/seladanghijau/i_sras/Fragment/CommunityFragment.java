package com.seladanghijau.i_sras.Fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.adapter.SoalanAdapter;
import com.seladanghijau.i_sras.dtos.Soalan;
import com.seladanghijau.i_sras.helper.DBHelper;
import com.seladanghijau.i_sras.helper.Helper;
import com.seladanghijau.i_sras.providers.SoalanProvider;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

    Fragment homeFragment, communityFragment, workplaceFragment;
    Button btnPreviousC, btnNextC;
    List<Soalan> soalanList, soalanList2, soalanList3, soalanList4, soalanList5, soalanList6, soalanList7, soalanList8, soalanList9;
    ListView lvKeyArea1_1, lvKeyArea1_2, lvKeyArea1_3, lvKeyArea1_4, lvKeyArea1_5, lvKeyArea2_1, lvKeyArea3_1, lvKeyArea3_2, lvKeyArea4_1;
    SoalanAdapter soalanAdapter, soalanAdapter2, soalanAdapter3, soalanAdapter4, soalanAdapter5, soalanAdapter6, soalanAdapter7, soalanAdapter8, soalanAdapter9;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dalam ini untuk apa apa code selain set listener dgn findviewbyid
        try {
            new DBHelper(getActivity()).initDB(); // initialize sqlitedb
        } catch (Exception e) {
            e.printStackTrace();
        }

        soalanList = new ArrayList<>();
        soalanList2 = new ArrayList<>();
        soalanList3 = new ArrayList<>();
        soalanList4 = new ArrayList<>();
        soalanList5 = new ArrayList<>();
        soalanList6 = new ArrayList<>();
        soalanList7 = new ArrayList<>();
        soalanList8 = new ArrayList<>();
        soalanList9 = new ArrayList<>();

        //soalanList = SoalanProvider.loadSoalanBasedOnCategory(1);
        soalanList = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 1, 3);
        soalanList2 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 4, 10);
        soalanList3 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 11, 13);
        soalanList4 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 14, 14);
        soalanList5 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 15, 17);
        soalanList6 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 18, 26);
        soalanList7 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 27, 29);
        soalanList8 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 30, 31);
        soalanList9 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(1, 32, 34);


        soalanAdapter = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList);
        soalanAdapter2 = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList2);
        soalanAdapter3 = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList3);
        soalanAdapter4 = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList4);
        soalanAdapter5 = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList5);
        soalanAdapter6 = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList6);
        soalanAdapter7 = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList7);
        soalanAdapter8 = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList8);
        soalanAdapter9 = new SoalanAdapter(getActivity(), R.layout.soalanlistitem, soalanList9);

        soalanAdapter.notifyDataSetChanged();
        soalanAdapter2.notifyDataSetChanged();
        soalanAdapter3.notifyDataSetChanged();
        soalanAdapter4.notifyDataSetChanged();
        soalanAdapter5.notifyDataSetChanged();
        soalanAdapter6.notifyDataSetChanged();
        soalanAdapter7.notifyDataSetChanged();
        soalanAdapter8.notifyDataSetChanged();
        soalanAdapter9.notifyDataSetChanged();
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
        lvKeyArea1_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_1);
        lvKeyArea1_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_2);
        lvKeyArea1_3 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_3);
        lvKeyArea1_4 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_4);
        lvKeyArea1_5 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_5);
        lvKeyArea2_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_1);
        lvKeyArea3_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_1);
        lvKeyArea3_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_2);
        lvKeyArea4_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea4_1);

        lvKeyArea1_1.setAdapter(soalanAdapter);
        lvKeyArea1_2.setAdapter(soalanAdapter2);
        lvKeyArea1_3.setAdapter(soalanAdapter3);
        lvKeyArea1_4.setAdapter(soalanAdapter4);
        lvKeyArea1_5.setAdapter(soalanAdapter5);
        lvKeyArea2_1.setAdapter(soalanAdapter6);
        lvKeyArea3_1.setAdapter(soalanAdapter7);
        lvKeyArea3_2.setAdapter(soalanAdapter8);
        lvKeyArea4_1.setAdapter(soalanAdapter9);

        Helper.getListViewSize(lvKeyArea1_1, 0);
        Helper.getListViewSize(lvKeyArea1_2, 2);
        Helper.getListViewSize(lvKeyArea1_3, 1);
        Helper.getListViewSize(lvKeyArea1_4, 0);
        Helper.getListViewSize(lvKeyArea1_5, 0);
        Helper.getListViewSize(lvKeyArea2_1, 1);
        Helper.getListViewSize(lvKeyArea3_1, 0);
        Helper.getListViewSize(lvKeyArea3_2, 0);
        Helper.getListViewSize(lvKeyArea4_1, 1);

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
