package com.seladanghijau.i_sras.helper;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Helper {
    public static void getListViewSize(ListView listView){
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null){
            return;
        }

        //setting listadapter in loop for getting final size
        int totalHeight = 0;
        for (int size=0; size<listAdapter.getCount(); size++){
            View listItem = listAdapter.getView(size, null, listView);
            listItem.measure(0, 0);
            totalHeight += (listItem.getMeasuredHeight()+50);
            //totalHeight *= 2;
        }

        //totalHeight += 120;
        //setting listview item in adapter
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount()-1));
        listView.setLayoutParams(params);
    }
}
