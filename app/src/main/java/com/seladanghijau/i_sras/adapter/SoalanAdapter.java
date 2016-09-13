package com.seladanghijau.i_sras.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.seladanghijau.i_sras.R;
import com.seladanghijau.i_sras.dtos.Answer;
import com.seladanghijau.i_sras.dtos.Soalan;

import java.util.List;

public class SoalanAdapter extends ArrayAdapter<Soalan> {

    List<Soalan> soalanList;
    List<Answer> answerList;
    Context context;
    int layoutResourceId;

    public SoalanAdapter(Context context, int layoutResourceId, List<Soalan> soalanList, List<Answer> answerList) {
        super(context, layoutResourceId, soalanList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.soalanList = soalanList;
        this.answerList = answerList;
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
            viewHolder.id.setText(String.valueOf(soalanList.get(position).getSoalanNo()));
            viewHolder.question.setText(soalanList.get(position).getSoalanDesc());

            int button;
            button = soalanList.get(position).getSoalanType();

            if (button==1){
                viewHolder.btn1.setVisibility(View.VISIBLE);
                viewHolder.btn1.setOnClickListener(new OnClick(position, viewHolder));
                viewHolder.btn2.setVisibility(View.INVISIBLE);
            }else if (button==2){
                viewHolder.btn1.setVisibility(View.INVISIBLE);
                viewHolder.btn2.setVisibility(View.VISIBLE);
                viewHolder.btn2.setOnClickListener(new OnClick(position, viewHolder));
            }
        }
        return  convertView;
    }

    static class ViewHolder{
        TextView id, question;
        Button btn1, btn2;
    }


    private class OnClick implements View.OnClickListener{

        ViewHolder viewHolder;
        int position;
        public OnClick(int position, ViewHolder viewHolder){
            this.position = position;
            this.viewHolder = viewHolder;
        }

        @Override
        public void onClick(View v) {
            boolean answerValue;

            switch (v.getId()){
                case R.id.qButton1:
                    answerValue = answerList.get(position).getAnswer();

                    if (answerValue){
                        viewHolder.btn1.setText(R.string.no);
                        viewHolder.btn1.setBackgroundResource(R.color.red);
                        viewHolder.btn1.setTextColor(viewHolder.btn1.getResources().getColor(R.color.white));
                        answerList.get(position).setAnswer(false);
                    }else{
                        viewHolder.btn1.setText(R.string.yes);
                        viewHolder.btn1.setBackgroundResource(R.color.green);
                        viewHolder.btn1.setTextColor(viewHolder.btn1.getResources().getColor(R.color.black));
                        answerList.get(position).setAnswer(true);
                    }
                    break;
                case R.id.qButton2:
                    answerValue = answerList.get(position).getAnswer();

                    if (answerValue){
                        viewHolder.btn2.setText(R.string.no);
                        viewHolder.btn2.setBackgroundResource(R.color.red);
                        viewHolder.btn2.setTextColor(viewHolder.btn2.getResources().getColor(R.color.white));
                        answerList.get(position).setAnswer(false);
                    }else{
                        viewHolder.btn2.setText(R.string.yes);
                        viewHolder.btn2.setBackgroundResource(R.color.yes_recommended);
                        viewHolder.btn2.setTextColor(viewHolder.btn2.getResources().getColor(R.color.white));
                        answerList.get(position).setAnswer(true);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
