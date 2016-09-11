package com.seladanghijau.i_sras.custom;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import com.seladanghijau.i_sras.R;

public class CustomTextView extends TextView{

    public CustomTextView(Context context) {
        super(context);
        init(null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attributeSet){
        if (attributeSet != null){
            TypedArray a = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomTextView);
            String fontName = a.getString(R.styleable.CustomTextView_font);

            try {
                if (fontName != null){
                    Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/"+ fontName);
                    setTypeface(typeface);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            a.recycle();
        }
    }
}
