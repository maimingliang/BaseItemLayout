package com.maiml.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by maimingliang on 2016/11/13.
 */

public class SwitchImageView extends ImageView {


    private boolean isCheck;

    public SwitchImageView(Context context) {
        this(context,null);
    }

    public SwitchImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SwitchImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {


        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                isCheck = !isCheck;

                if(onSwitchClickListener != null){
                    onSwitchClickListener.onClick(isCheck);
                }
            }
        });


    }


    public boolean isCheck() {
        return isCheck;
    }

    private OnSwitchClickListener onSwitchClickListener;

    public void setOnSwitchClickListener(OnSwitchClickListener onSwitchClickListener) {
        this.onSwitchClickListener = onSwitchClickListener;
    }

    public interface OnSwitchClickListener{

       void onClick(boolean isCheck);
    }
}
