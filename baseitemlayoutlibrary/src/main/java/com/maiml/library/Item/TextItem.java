package com.maiml.library.Item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.library.utils.AbstractItem;
import com.maiml.library.utils.DensityUtil;

/**
 * Created by maimingliang on 2016/12/5.
 */

public class TextItem extends AbstractItem {


    private TextView rightTextView;

    private LayoutParams rightTextViewlp;


    public TextItem(Context context) {
        super(context);
    }

    public TextItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void createWidget() {
        rightTextView = new TextView(mContext);

        rightTextView.setId(R.id.right_text_id);
    }

    @Override
    public void createWidgetLayoutParams() {


        rightTextViewlp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightTextViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        rightTextViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);

    }


    @Override
    public void addWidget() {
        super.addWidget();
        addView(rightTextView, rightTextViewlp);
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



        rightTextViewlp.rightMargin = DensityUtil.dip2px(mContext,configAttrs.getArrowMarginRight());

        rightTextView.setText(text);

        rightTextView.setTextColor(configAttrs.getRightTextColor());
        rightTextView.setTextSize(configAttrs.getRightTextSize());


        if(configAttrs.getArrowResId() != 0){

            Drawable drawable= getResources().getDrawable(configAttrs.getArrowResId());
            /// 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            rightTextView.setCompoundDrawables(null,null,drawable,null);
            rightTextView.setCompoundDrawablePadding(20);

        }

    }





}
