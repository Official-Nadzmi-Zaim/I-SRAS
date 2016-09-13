package com.seladanghijau.i_sras.helper;


import android.content.Intent;
import android.annotation.TargetApi;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
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
    public static void getListViewSize(ListView listView){
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null){
            return;
        }

        //0 - normal
        //1 - bigger

        //setting listadapter in loop for getting final size
        int totalHeight = 0;

        int size;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        for (size = 0; size<listAdapter.getCount(); size++){
            View listItem = listAdapter.getView(size, null, listView);
            if (size == 0){
                listItem.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            //listItem.measure(0, 0);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
            Log.d("Height", ""+totalHeight);
        }


        totalHeight += listView.getDividerHeight()*size;
        totalHeight = totalHeight + (totalHeight/2);
        //setting listview item in adapter
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount()-1));
        listView.setLayoutParams(params);
        //listView.requestLayout();
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
