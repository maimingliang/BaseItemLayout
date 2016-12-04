package com.maiml.library.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.library.config.ConfigAttrs;

/**
 * Created by maimingliang on 2016/12/4.
 */

public abstract class AbstractItem extends RelativeLayout{


    protected Context mContext;
    protected ImageView iconImg;
    protected TextView textView;
    protected LayoutParams txtLp;
    protected LayoutParams iconLp;


    protected ConfigAttrs configAttrs;

    public AbstractItem(Context context) {
        this(context,null);
    }

    public AbstractItem(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AbstractItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);

    }

    private void init(Context context) {
        this.mContext = context;

        setBackgroundResource(R.drawable.btn_list_item_bg);
        iconImg = new ImageView(context);
        iconImg.setId(R.id.img_id);
        textView = new TextView(context);
        textView.setId(R.id.txt_id);
        iconLp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        iconLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        txtLp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        txtLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        txtLp.addRule(RelativeLayout.RIGHT_OF, R.id.img_id);

    }


    /**
     * 创建view
     */
    public abstract void createWidget();

    public abstract void createWidgetLayoutParams();

    public  void addWidget(){

        addView(textView, txtLp);
        addView(iconImg, iconLp);


    }


    public void create(ConfigAttrs configAttrs){

        setConfigAttrs(configAttrs);

        createWidget();
        createWidgetLayoutParams();
        addWidget();

        setLayoutParams();
        setIconStyle();
        setTextStyle();


    }


    public void setConfigAttrs(ConfigAttrs configAttrs){
        this.configAttrs = configAttrs;
    }

    public void setLayoutParams() {


        if(configAttrs == null){
            throw new RuntimeException("config arrts is null");
        }


        if(configAttrs.getItemHeight() <= 0){
            throw new RuntimeException("item height is null");
        }

        ViewGroup.LayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.height = DensityUtil.dip2px(mContext,configAttrs.getItemHeight());
        setLayoutParams(layoutParams);
    }



    /**
     * 设置文字的样式
     */
    public void setTextStyle(){


        if(configAttrs == null){
            throw new RuntimeException("config arrts is null");
        }



        txtLp.leftMargin = DensityUtil.dip2px(mContext,configAttrs.getIconTextMargin());
        textView.setTextColor(configAttrs.getTextColor());
        textView.setTextSize(configAttrs.getTextSize());
        textView.setText(configAttrs.getValueList().get(configAttrs.getPosition()));

    }


    /**
     * 设置 icon 样式
     */
    public void setIconStyle(){

         if(configAttrs == null){
            throw new RuntimeException("config arrts is null");
        }


        if(configAttrs.getIconHeight() <= 0){
            throw new RuntimeException("icon height  is null");
        }

        if(configAttrs.getIconWidth() <= 0){
            throw new RuntimeException("icon width  is null");
        }

        iconLp.leftMargin = DensityUtil.dip2px(mContext,configAttrs.getIconMarginLeft());

         iconImg.setBackgroundResource(configAttrs.getResIdList().get(configAttrs.getPosition()));

        ViewGroup.LayoutParams layoutParams = iconImg.getLayoutParams();

        layoutParams.width = DensityUtil.dip2px(mContext,configAttrs.getIconWidth());
        layoutParams.height = DensityUtil.dip2px(mContext,configAttrs.getIconHeight());

        iconImg.setLayoutParams(layoutParams);

    }

}
