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

public class EnvironmentFragment extends Fragment {

    Fragment workplaceFragment, environmentFragment, marketplaceFragment;
    Button btnPreviousE, btnNextE;
    List<Soalan> soalanList, soalanList2, soalanList3, soalanList4, soalanList5, soalanList6, soalanList7, soalanList8, soalanList9, soalanList10, soalanList11, soalanList12, soalanList13;
    ListView lvKeyArea1_1, lvKeyArea2_1,lvKeyArea2_2, lvKeyArea2_3, lvKeyArea2_4, lvKeyArea2_5, lvKeyArea2_6, lvKeyArea3_1, lvKeyArea3_2, lvKeyArea4_1, lvKeyArea4_2, lvKeyArea5_1, lvKeyArea5_2;
    SoalanAdapter soalanAdapter, soalanAdapter2, soalanAdapter3, soalanAdapter4, soalanAdapter5, soalanAdapter6, soalanAdapter7, soalanAdapter8, soalanAdapter9, soalanAdapter10, soalanAdapter11, soalanAdapter12, soalanAdapter13;
    List<Answer> answerList, answerList2, answerList3, answerList4, answerList5, answerList6, answerList7, answerList8, answerList9, answerList10, answerList11, answerList12, answerList13;



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
        answerList9 = new ArrayList<>();
        answerList10 = new ArrayList<>();
        answerList11 = new ArrayList<>();
        answerList12 = new ArrayList<>();
        answerList13 = new ArrayList<>();

        soalanList = new ArrayList<>();
        soalanList2 = new ArrayList<>();
        soalanList3 = new ArrayList<>();
        soalanList4 = new ArrayList<>();
        soalanList5 = new ArrayList<>();
        soalanList6 = new ArrayList<>();
        soalanList7 = new ArrayList<>();
        soalanList8 = new ArrayList<>();
        soalanList9 = new ArrayList<>();
        soalanList10 = new ArrayList<>();
        soalanList11 = new ArrayList<>();
        soalanList12 = new ArrayList<>();
        soalanList13 = new ArrayList<>();

        //soalanList = SoalanProvider.loadSoalanBasedOnCategory(1);
        soalanList = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 1, 1);
        soalanList2 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 2, 2);
        soalanList3 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 3, 8);
        soalanList4 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 9, 9);
        soalanList5 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 10, 11);
        soalanList6 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 12, 12);
        soalanList7 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 13, 13);
        soalanList8 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 14, 15);
        soalanList9 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 16, 16);
        soalanList10 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 17, 18);
        soalanList11 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 19, 19);
        soalanList12 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 20, 20);
        soalanList13 = SoalanProvider.loadSoalanBasedOnRangeAndCategory(3, 21, 21);


        //answerlist
        answerList = CreateAnswer(soalanList);
        answerList2 = CreateAnswer(soalanList2);
        answerList3 = CreateAnswer(soalanList3);
        answerList4 = CreateAnswer(soalanList4);
        answerList5 = CreateAnswer(soalanList5);
        answerList6 = CreateAnswer(soalanList6);
        answerList7 = CreateAnswer(soalanList7);
        answerList8 = CreateAnswer(soalanList8);
        answerList9 = CreateAnswer(soalanList9);
        answerList10 = CreateAnswer(soalanList10);
        answerList11 = CreateAnswer(soalanList11);
        answerList12 = CreateAnswer(soalanList12);
        answerList13 = CreateAnswer(soalanList13);

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

        lvKeyArea1_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea1_1_1b);
        lvKeyArea2_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_1_2b);
        lvKeyArea2_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_2_3b);
        lvKeyArea2_3 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_3_4b);
        lvKeyArea2_4 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_4_5b);
        lvKeyArea2_5 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_5_6b);
        lvKeyArea2_6 = (ListView) getActivity().findViewById(R.id.lvKeyArea2_6_7b);
        lvKeyArea3_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_1_8b);
        lvKeyArea3_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea3_2_9b);
        lvKeyArea4_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea4_1_10b);
        lvKeyArea4_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea4_2_11b);
        lvKeyArea5_1 = (ListView) getActivity().findViewById(R.id.lvKeyArea5_1_12b);
        lvKeyArea5_2 = (ListView) getActivity().findViewById(R.id.lvKeyArea5_2_13b);

        Helper.getListViewSize(lvKeyArea1_1);
        Helper.getListViewSize(lvKeyArea2_1);
        Helper.getListViewSize(lvKeyArea2_2);
        Helper.getListViewSize(lvKeyArea2_3);
        Helper.getListViewSize(lvKeyArea2_4);
        Helper.getListViewSize(lvKeyArea2_5);
        Helper.getListViewSize(lvKeyArea2_6);
        Helper.getListViewSize(lvKeyArea3_1);
        Helper.getListViewSize(lvKeyArea3_2);
        Helper.getListViewSize(lvKeyArea4_1);
        Helper.getListViewSize(lvKeyArea4_2);
        Helper.getListViewSize(lvKeyArea5_1);
        Helper.getListViewSize(lvKeyArea5_2);

        soalanAdapter = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList, answerList,lvKeyArea1_1);
        soalanAdapter2 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList2, answerList2, lvKeyArea2_1);
        soalanAdapter3 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList3, answerList3, lvKeyArea2_2);
        soalanAdapter4 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList4, answerList4, lvKeyArea2_3);
        soalanAdapter5 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList5, answerList5, lvKeyArea2_4);
        soalanAdapter6 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList6, answerList6, lvKeyArea2_5);
        soalanAdapter7 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList7, answerList7, lvKeyArea2_6);
        soalanAdapter8 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList8, answerList8, lvKeyArea3_1);
        soalanAdapter9 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList9, answerList9, lvKeyArea3_2);
        soalanAdapter10 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList10, answerList10, lvKeyArea4_1);
        soalanAdapter11 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList11, answerList11, lvKeyArea4_2);
        soalanAdapter12 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList12, answerList12, lvKeyArea5_1);
        soalanAdapter13 = new SoalanAdapter(getActivity(), R.layout.layout_rowview_soalan, soalanList13, answerList13, lvKeyArea5_2);

        soalanAdapter.notifyDataSetChanged();
        soalanAdapter2.notifyDataSetChanged();
        soalanAdapter3.notifyDataSetChanged();
        soalanAdapter4.notifyDataSetChanged();
        soalanAdapter5.notifyDataSetChanged();
        soalanAdapter6.notifyDataSetChanged();
        soalanAdapter7.notifyDataSetChanged();
        soalanAdapter8.notifyDataSetChanged();
        soalanAdapter9.notifyDataSetChanged();
        soalanAdapter10.notifyDataSetChanged();
        soalanAdapter11.notifyDataSetChanged();
        soalanAdapter12.notifyDataSetChanged();
        soalanAdapter13.notifyDataSetChanged();

        lvKeyArea1_1.setAdapter(soalanAdapter);
        lvKeyArea2_1.setAdapter(soalanAdapter2);
        lvKeyArea2_2.setAdapter(soalanAdapter3);
        lvKeyArea2_3.setAdapter(soalanAdapter4);
        lvKeyArea2_4.setAdapter(soalanAdapter5);
        lvKeyArea2_5.setAdapter(soalanAdapter6);
        lvKeyArea2_6.setAdapter(soalanAdapter7);
        lvKeyArea3_1.setAdapter(soalanAdapter8);
        lvKeyArea3_2.setAdapter(soalanAdapter9);
        lvKeyArea4_1.setAdapter(soalanAdapter10);
        lvKeyArea4_2.setAdapter(soalanAdapter11);
        lvKeyArea5_1.setAdapter(soalanAdapter12);
        lvKeyArea5_2.setAdapter(soalanAdapter13);


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
                    // retrieve user's answer & store the answer into db
                    Helper.getUserAnswer(3, lvKeyArea1_1);
                    Helper.getUserAnswer(3, lvKeyArea2_1);
                    Helper.getUserAnswer(3, lvKeyArea2_2);
                    Helper.getUserAnswer(3, lvKeyArea2_3);
                    Helper.getUserAnswer(3, lvKeyArea2_4);
                    Helper.getUserAnswer(3, lvKeyArea2_5);
                    Helper.getUserAnswer(3, lvKeyArea2_6);
                    Helper.getUserAnswer(3, lvKeyArea3_1);
                    Helper.getUserAnswer(3, lvKeyArea3_2);
                    Helper.getUserAnswer(3, lvKeyArea4_1);
                    Helper.getUserAnswer(3, lvKeyArea4_2);
                    Helper.getUserAnswer(3, lvKeyArea5_1);
                    Helper.getUserAnswer(3, lvKeyArea5_2);

                    fragmentTransaction.hide(environmentFragment);
                    fragmentTransaction.show(marketplaceFragment);
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
