package com.seladanghijau.i_sras.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.dtos.Answer;
import com.seladanghijau.i_sras.dtos.Soalan;

import java.util.List;

public class SoalanAdapter extends ArrayAdapter<Soalan> {

    List<Soalan> soalanList;
    Context context;
    int layoutResourceId;

    public SoalanAdapter(Context context, int layoutResourceId, List<Soalan> soalanList) {
        super(context, layoutResourceId, soalanList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.soalanList = soalanList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResourceId, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.id = (TextView) convertView.findViewById(R.id.qId);
            viewHolder.question = (TextView) convertView.findViewById(R.id.qQuestion);
            viewHolder.btn1 = (Button) convertView.findViewById(R.id.qButton1);
            viewHolder.btn2 = (Button) convertView.findViewById(R.id.qButton2);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (soalanList!=null){
            viewHolder.id.setText(String.valueOf(soalanList.get(position).getSoalanId()));
            viewHolder.question.setText(soalanList.get(position).getSoalanDesc());

            int button;
            button = soalanList.get(position).getSoalanType();

            if (button==1){
                viewHolder.btn1.setVisibility(View.VISIBLE);
                //viewHolder.btn1.setOnClickListener(new OnClick(position, viewHolder));
                viewHolder.btn2.setVisibility(View.INVISIBLE);
            }else if (button==2){
                viewHolder.btn1.setVisibility(View.INVISIBLE);
                viewHolder.btn2.setVisibility(View.VISIBLE);
                //viewHolder.btn2.setOnClickListener(new OnClick(position, viewHolder));
            }
        }
        return  convertView;
    }

    static class ViewHolder{
        TextView id, question;
        Button btn1, btn2;
    }

    /*
    private class OnClick implements View.OnClickListener{

        ViewHolder viewHolder;
        int position;
        public OnClick(int position, ViewHolder viewHolder){
            this.position = position;
            this.viewHolder = viewHolder;
        }

        @Override
        public void onClick(View v) {
            boolean buttonValue;

            switch (v.getId()){
                case R.id.qButton1:
                    Log.d("Button 1", "Clicking");
                    buttonValue = soalanList.get(position).isValues();

                    if (buttonValue){
                        Log.d("False", "False");
                        viewHolder.btn1.setText(R.string.No);
                        viewHolder.btn1.setBackgroundResource(R.color.Red);
                        soalanList.get(position).setValues(false);
                    }else{
                        Log.d("True", "True");
                        viewHolder.btn1.setText(R.string.Yes);
                        viewHolder.btn1.setBackgroundResource(R.color.Green);
                        soalanList.get(position).setValues(true);
                    }
                    break;
                case R.id.qButton2:
                    Log.d("Button 2", "Clicking");
                    buttonValue = soalanList.get(position).isValues();

                    if (buttonValue){
                        Log.d("False", "False");
                        viewHolder.btn2.setText(R.string.No);
                        viewHolder.btn2.setBackgroundResource(R.color.Red);
                        questionList.get(position).setValues(false);
                    }else{
                        Log.d("True", "True");
                        viewHolder.btn2.setText(R.string.Yes);
                        viewHolder.btn2.setBackgroundResource(R.color.Green);
                        questionList.get(position).setValues(true);
                    }
                    break;
                default:
                    break;
            }
        }
    }*/
}
