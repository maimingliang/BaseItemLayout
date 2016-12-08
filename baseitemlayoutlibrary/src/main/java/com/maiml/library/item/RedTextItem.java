package com.maiml.library.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.library.RedTextView;
import com.maiml.library.utils.DensityUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maimingliang on 2016/12/7.
 */

public class RedTextItem extends AbstractItem {


    private TextView redTextView;
    private LayoutParams redTextViewlp;
    private ImageView arrowView;
    private LayoutParams arrowViewlp;
    // 数字格式
    private static final String REG_NUMBER = "^\\d+$";

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
        redTextView.setId(R.id.red_text_id);
        arrowView = new ImageView(mContext);
    }

    @Override
    public void createWidgetLayoutParams() {
        redTextViewlp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        redTextViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        redTextViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);


        arrowViewlp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        arrowViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        arrowViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
//        arrowViewlp.addRule(RelativeLayout.RIGHT_OF,R.id.red_text_id);
    }

    @Override
    public void addWidget() {
        super.addWidget();
        addView(redTextView,redTextViewlp);
        addView(arrowView,arrowViewlp);
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


        int marginRight = configAttrs.getMarginRight() * 2 + 5;
        redTextViewlp.rightMargin = DensityUtil.dip2px(mContext,marginRight);


        if(!number(text)){
            throw  new RuntimeException("right text must be number");
        }

        redTextView.setText(text);
        redTextView.setBackgroundResource(R.drawable.shape_text_red);

        redTextView.setPadding(10,0,10,0);
        redTextView.setGravity(Gravity.CENTER);
        redTextView.setTextColor(0xffffffff);
        redTextView.setTextSize(configAttrs.getRightTextSize());


        if(configAttrs.getArrowResId() != 0){

             arrowViewlp.rightMargin = DensityUtil.dip2px(mContext,configAttrs.getMarginRight());

             arrowView.setBackgroundResource(configAttrs.getArrowResId());
        }

    }

    /**
     * 验证数字格式(只能为0-9的值)
     */
    public  boolean number(String value) {
        return matcher(REG_NUMBER, value);
    }

    public  boolean matcher(String regEx, String input) {

        if (input != null && !"".equals(input)) {
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(input);
            return m.matches();
        } else {
            return false;
        }
    }


}
