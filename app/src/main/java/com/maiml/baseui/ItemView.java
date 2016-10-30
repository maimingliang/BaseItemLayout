package com.maiml.baseui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maiml.baseui.utils.DensityUtil;

/**
 * Created by maimingliang on 2016/10/29.
 */

public class ItemView extends RelativeLayout {


    private Context mContext;


    private int textSize = 15;
    private String text = "test";

    private int textColor = R.color.gray_333333;
    private int iconMarginLeft = 10;

    private int iconTextMargin = 10;

    private int arrowMarginRight =10;

    private int itemHeight = 40;

    private int itemBgColor = 0xffffffff;


    private int iconResId = R.drawable.img_friends;

    private int arrowResId = R.drawable.img_find_arrow;
    private ImageView iconImg;
    private TextView textView;
    private ImageView arrowImg;

    public ItemView(Context context) {
        this(context,null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ItemAttrs);

        textSize = a.getInt(R.styleable.ItemAttrs_text_size,textSize);
         textColor = a.getColor(R.styleable.ItemAttrs_text_color,context.getResources().getColor(textColor));

        iconMarginLeft = a.getInt(R.styleable.ItemAttrs_icon_margin_left,iconMarginLeft);
        iconTextMargin = a.getInt(R.styleable.ItemAttrs_icon_text_margin,iconTextMargin);

        arrowMarginRight = a.getInt(R.styleable.ItemAttrs_arrow_margin_right,arrowMarginRight);
        itemHeight = a.getInt(R.styleable.ItemAttrs_item_height,itemHeight);
        itemBgColor = a.getColor(R.styleable.ItemAttrs_item_bg_color,itemBgColor);


        a.recycle();


        init(context);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec,DensityUtil.dip2px(mContext,itemHeight));
    }


    private void init(Context context){
        this.mContext = context;

        iconImg = new ImageView(context);
        iconImg.setBackgroundResource(iconResId);

        iconImg.setId(R.id.img_id);

        textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(DensityUtil.dip2px(context,textSize));
//        textView.setTextColor(context.getResources().getColor(textColor));

        textView.setId(R.id.txt_id);
        arrowImg = new ImageView(context);
        arrowImg.setBackgroundResource(arrowResId);
        arrowImg.setId(R.id.arrow_id);

        RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lp1.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);

        lp1.leftMargin = DensityUtil.dip2px(context,iconMarginLeft);
         addView(iconImg,lp1);


        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lp2.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        lp2.addRule(RelativeLayout.RIGHT_OF,R.id.img_id);
        lp2.leftMargin = DensityUtil.dip2px(context,iconTextMargin);
         addView(textView,lp2);

        RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lp3.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        lp3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
         lp3.rightMargin = DensityUtil.dip2px(context,arrowMarginRight);

        addView(arrowImg,lp3);


        setBackgroundColor(itemBgColor);

     }



    public void setItemValue(String text,int iconResId,int arrowResId){
        textView.setText(text);
        iconImg.setBackgroundResource(iconResId);
        arrowImg.setBackgroundResource(arrowResId);
    }


}
