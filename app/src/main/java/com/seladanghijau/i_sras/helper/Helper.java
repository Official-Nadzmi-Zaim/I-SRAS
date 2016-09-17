package com.seladanghijau.i_sras.helper;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.seladanghijau.i_sras.R;

public class Helper {
    public static void getListViewSize(ListView listView){
        //Fake height//
        int totalHeight = 0;

        totalHeight = 2500;
        //setting listview item in adapter
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight ;
        listView.setLayoutParams(params);
    }

    //realheight based on lines
    public static void realHeight(int lines, ListView listView){
        ListAdapter adapter = listView.getAdapter();

        Log.d("adapter", ""+adapter.getCount());

        int totalHeight=0;

        totalHeight = lines + 20;

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount()-1));
        listView.setLayoutParams(params);
    }

    public static int getUserAnswerVital(ListView listView) {
        int count;

        count = 0;
        for(int x=0 ; x<listView.getChildCount() ; x++) {
            View tempRowView;
            Button tempBtn1;

            tempRowView = listView.getChildAt(x); // amik data drp
            tempBtn1 = (Button) tempRowView.findViewById(R.id.qButton1); // get vital button state

            // kalau salah satu button ada 'yes', return yes
            if(tempBtn1.getText().toString().equalsIgnoreCase("yes"))
                count++;
        }

        return count;
    }

    public static int getUserAnswerRecommended(ListView listView) {
        int count;

        count = 0;
        for(int x=0 ; x<listView.getChildCount() ; x++) {
            View tempRowView;
            Button tempBtn2;

            tempRowView = listView.getChildAt(x); // amik data drp listview (rowview)
            tempBtn2 = (Button) tempRowView.findViewById(R.id.qButton2); // get recommended button state

            // kalau salah satu button ada 'yes', return yes
            if(tempBtn2.getText().toString().equalsIgnoreCase("yes"))
                count++;
        }

        return count;
    }
}
