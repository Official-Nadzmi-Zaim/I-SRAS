package com.seladanghijau.i_sras.helper;


import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.adapter.SoalanAdapter;
import com.seladanghijau.i_sras.custom.CustomTextView;
import com.seladanghijau.i_sras.dtos.Answer;
import com.seladanghijau.i_sras.providers.AnswerProvider;

public class Helper {
    public static void getListViewSize(ListView listView , int typeSize){
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null){
            return;
        }

        //0 - normal
        //1 - bigger

        //setting listadapter in loop for getting final size
        int totalHeight = 0;
        int extraHeight = 0;

        if (typeSize == 1){
            extraHeight = 45;
        }else if (typeSize == 2){
            extraHeight = 25;
        }else if (typeSize==3){
            extraHeight = 55;
        }else if (typeSize==4){
            extraHeight = 70;
        }else if (typeSize==5){
            extraHeight = 130;
        }

        for (int size=0; size<listAdapter.getCount(); size++){
            View listItem = listAdapter.getView(size, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight() + extraHeight;
        }

        //setting listview item in adapter
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount()-1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    // helper utk amik value answer dlm setiap row utk setiap soalan dlm listview
    public static void getUserAnswer(int soalanCategory, ListView listView) {
        for(int x=0 ; x<listView.getChildCount() ; x++) {
            View tempRowView;
            Button tempBtn1, tempBtn2;
            CustomTextView tempQId;
            boolean tempAnswer;

            tempRowView = listView.getChildAt(x); // amik data drp
            tempQId = (CustomTextView) tempRowView.findViewById(R.id.qId); // get soalan id
            tempBtn1 = (Button) tempRowView.findViewById(R.id.qButton1); // get vital button state
            tempBtn2 = (Button) tempRowView.findViewById(R.id.qButton2); // get recommended button state

            // kalau salah satu button ada 'yes', return yes
            if(tempBtn1.getText().toString().equalsIgnoreCase("yes") || tempBtn2.getText().toString().equalsIgnoreCase("yes"))
                tempAnswer = true;
            else
                tempAnswer = false;

            // simpan Answer object dlm database
            AnswerProvider.storeAnswer(new Answer(0, Integer.parseInt(tempQId.getText().toString()), soalanCategory, tempAnswer));
        }
    }
}
