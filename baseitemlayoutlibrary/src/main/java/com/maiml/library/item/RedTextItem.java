package com.maiml.library.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.library.RedTextView;
import com.maiml.library.utils.DensityUtil;

/**
 * Created by maimingliang on 2016/12/7.
 */

public class RedTextItem extends AbstractItem {


    private TextView redTextView;
    private LayoutParams redTextViewlp;
    public RedTextItem(Context context) {
        super(context);
    }

    public RedTextItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RedTextItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void createWidget() {
        redTextView = new TextView(mContext);
        redTextView.setId(R.id.right_text_id);
    }

    @Override
    public void createWidgetLayoutParams() {
        redTextViewlp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        redTextViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        redTextViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
    }

    @Override
    public void addWidget() {
        super.addWidget();
        addView(redTextView,redTextViewlp);
        setRightTextStyle();
    }

    /**
     * 设置文字的样式
     */
    public void setRightTextStyle(){

        if(configAttrs == null){
            throw  new RuntimeException("config attrs is null");
        }


        if(configAttrs.getRightTextArray() == null){
            throw  new RuntimeException("right text array is null");
        }

        String text = configAttrs.getRightTextArray().get(configAttrs.getPosition()) == null
                ? "" : configAttrs.getRightTextArray().get(configAttrs.getPosition());



        redTextViewlp.rightMargin = DensityUtil.dip2px(mContext,configAttrs.getArrowMarginRight());

        redTextView.setText(text);
        redTextView.setBackgroundResource(R.drawable.shape_text_red);

        redTextView.setGravity(Gravity.CENTER);
        redTextView.setTextColor(0xffffffff);
        redTextView.setTextSize(configAttrs.getRightTextSize());


        if(configAttrs.getArrowResId() != 0){

            Drawable drawable= getResources().getDrawable(configAttrs.getArrowResId());
            /// 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            redTextView.setCompoundDrawables(null,null,drawable,null);
            redTextView.setCompoundDrawablePadding(40);

        }

    }

}
