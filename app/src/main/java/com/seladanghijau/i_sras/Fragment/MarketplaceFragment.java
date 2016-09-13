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
import com.seladanghijau.i_sras.dtos.Answer;
import com.seladanghijau.i_sras.dtos.Soalan;
import com.seladanghijau.i_sras.helper.Helper;
import com.seladanghijau.i_sras.providers.SoalanProvider;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceFragment extends Fragment {

    Fragment environmentFragment, marketplaceFragment, reportFragment;
    Button btnPreviousM, btnNextM;
    List<Soalan> soalanList, soalanList2, soalanList3, soalanList4, soalanList5, soalanList6, soalanList7, soalanList8;
    ListView lvKeyArea1_1, lvKeyArea2_1,lvKeyArea2_2, lvKeyArea3_1, lvKeyArea3_2, lvKeyArea3_3, lvKeyArea3_4, lvKeyArea4_1;
    SoalanAdapter soalanAdapter, soalanAdapter2, soalanAdapter3, soalanAdapter4, soalanAdapter5, soalanAdapter6, soalanAdapter7, soalanAdapter8;
    List<Answer> answerList, answerList2, answerList3, answerList4, answerList5, answerList6, answerList7, answerList8;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Dalam ini untuk apa apa code selain set listener dgn findviewbyid
        answerList = new ArrayList<>();
        answerList2 = new ArrayList<>();
        answerList3 = new ArrayList<>();
        answerList4 = new ArrayList<>();
        answerList5 = new ArrayList<>();
        answerList6 = new ArrayList<>();
        answerList7 = new ArrayList<>();
        answerList8 = new ArrayList<>();

        soalanList = new ArrayList<>();
        soalanList2 = new ArrayList<>();
        soalanList3 = new ArrayList<>();
        soalanList4 = new ArrayList<>();
        soalanList5 = new ArrayList<>();
        soalanList6 = new ArrayList<>();
        soalanList7 = new ArrayList<>();
        soalanList8 = new ArrayList<>();

        //soalanList = SoalanProvider.loadSoalanBasedOnCategory(1);
        soalanList = SoalanProvider.loadSoalanBasedOnRangeAndCategory(4, 1, 1);
        soalanList2 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(4, 2, 6);
        soalanList3 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(4, 7, 8);
        soalanList4 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(4, 9, 12);
        soalanList5 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(4, 13, 13);
        soalanList6 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(4, 14, 14);
        soalanList7 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(4, 15, 15);
        soalanList8 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(4, 16, 18);


        //answerlist
        answerList = CreateAnswer(soalanList);
        answerList2 = CreateAnswer(soalanList2);
        answerList3 = CreateAnswer(soalanList3);
        answerList4 = CreateAnswer(soalanList4);
        answerList5 = CreateAnswer(soalanList5);
        answerList6 = CreateAnswer(soalanList6);
        answerList7 = CreateAnswer(soalanList7);
        answerList8 = CreateAnswer(soalanList8);


        soalanAdapter = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList, answerList);
        soalanAdapter2 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList2, answerList2);
        soalanAdapter3 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList3, answerList3);
        soalanAdapter4 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList4, answerList4);
        soalanAdapter5 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList5, answerList5);
        soalanAdapter6 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList6, answerList6);
        soalanAdapter7 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList7, answerList7);
        soalanAdapter8 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList8, answerList8);

        soalanAdapter.notifyDataSetChanged();
        soalanAdapter2.notifyDataSetChanged();
        soalanAdapter3.notifyDataSetChanged();
        soalanAdapter4.notifyDataSetChanged();
        soalanAdapter5.notifyDataSetChanged();
        soalanAdapter6.notifyDataSetChanged();
        soalanAdapter7.notifyDataSetChanged();
        soalanAdapter8.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentmarketplace, container, false);
        //inflate fragment layout kat sini
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //kat sini set findviewby id dgn listener e.g Button btnNext = (Button) getActivity().findViewById(R.id.btnNext2);
        environmentFragment = getFragmentManager().findFragmentById(R.id.EnvironmentFragment);
        marketplaceFragment = getFragmentManager().findFragmentById(R.id.MarketplaceFragment);
        reportFragment = getFragmentManager().findFragmentById(R.id.ReportFragment);

        lvKeyArea1_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_1_1c);
        lvKeyArea2_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_1_2c);
        lvKeyArea2_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_2_3c);
        lvKeyArea3_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_1_4c);
        lvKeyArea3_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_2_5c);
        lvKeyArea3_3 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_3_6c);
        lvKeyArea3_4 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_4_7c);
        lvKeyArea4_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea4_1_8c);

        lvKeyArea1_1.setAdapter(soalanAdapter);
        lvKeyArea2_1.setAdapter(soalanAdapter2);
        lvKeyArea2_2.setAdapter(soalanAdapter3);
        lvKeyArea3_1.setAdapter(soalanAdapter4);
        lvKeyArea3_2.setAdapter(soalanAdapter5);
        lvKeyArea3_3.setAdapter(soalanAdapter6);
        lvKeyArea3_4.setAdapter(soalanAdapter7);
        lvKeyArea4_1.setAdapter(soalanAdapter8);


        Helper.getListViewSize(lvKeyArea1_1, 4);
        Helper.getListViewSize(lvKeyArea2_1, 2);
        Helper.getListViewSize(lvKeyArea2_2, 4);
        Helper.getListViewSize(lvKeyArea3_1, 3);
        Helper.getListViewSize(lvKeyArea3_2, 1);
        Helper.getListViewSize(lvKeyArea3_3, 4);
        Helper.getListViewSize(lvKeyArea3_4, 4);
        Helper.getListViewSize(lvKeyArea4_1, 4);

        btnPreviousM = (Button) getActivity().findViewById(R.id.btnPreviousM);
        btnNextM = (Button) getActivity().findViewById(R.id.btnNextM);

        btnPreviousM.setOnClickListener(new OnButtonClick());
        btnNextM.setOnClickListener(new OnButtonClick());
    }

    private class OnButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

            switch (v.getId()){
                case R.id.btnPreviousM:
                    fragmentTransaction.hide(marketplaceFragment);
                    fragmentTransaction.show(environmentFragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.btnNextM :
                    // retrieve user's answer & store the answer into db
                    Helper.getUserAnswer(4, lvKeyArea1_1);
                    Helper.getUserAnswer(4, lvKeyArea2_1);
                    Helper.getUserAnswer(4, lvKeyArea2_2);
                    Helper.getUserAnswer(4, lvKeyArea3_1);
                    Helper.getUserAnswer(4, lvKeyArea3_2);
                    Helper.getUserAnswer(4, lvKeyArea3_3);
                    Helper.getUserAnswer(4, lvKeyArea3_4);
                    Helper.getUserAnswer(4, lvKeyArea4_1);

                    fragmentTransaction.hide(marketplaceFragment);
                    fragmentTransaction.show(reportFragment);
                    fragmentTransaction.commit();
                    break;
                default:
                    break;
            }
        }
    }

    //Create answer list based on soalan id
    public List<Answer> CreateAnswer(List<Soalan> soalanList){

        List<Answer> answerList = new ArrayList<>();

        for (int i=0; i<soalanList.size(); i++){
            Answer answer = new Answer();
            answer.setAnswerId(soalanList.get(i).getSoalanId());

            answerList.add(answer);
        }

        return answerList;
    }
}
