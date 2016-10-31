package com.maiml.baseitemlayoutlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.baseui.utils.DensityUtil;

/**
 * Created by maimingliang on 2016/10/29.
 */

public class ItemView extends RelativeLayout {


    private Context mContext;
    private ImageView iconImg;
    private TextView textView;
    private ImageView arrowImg;
    private LayoutParams txtLp;
    private LayoutParams iconLp;
    private LayoutParams arrowLp;

    public ItemView(Context context) {
        this(context,null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context){
        this.mContext = context;

        iconImg = new ImageView(context);
        iconImg.setId(R.id.img_id);

        textView = new TextView(context);
        textView.setId(R.id.txt_id);

        arrowImg = new ImageView(context);
        arrowImg.setId(R.id.arrow_id);

        iconLp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        iconLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        addView(iconImg, iconLp);

        txtLp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        txtLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        txtLp.addRule(RelativeLayout.RIGHT_OF,R.id.img_id);
         addView(textView, txtLp);

        arrowLp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        arrowLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        arrowLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        addView(arrowImg, arrowLp);

        setBackgroundResource(R.drawable.btn_list_item_bg);

     }


    public void setLayoutParams(int itemHeight) {

        ViewGroup.LayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.height = DensityUtil.dip2px(mContext,itemHeight);
        setLayoutParams(layoutParams);
    }

    /**
     * 设置文字的样式
     * @param text
     */
    public void setTextStyle(String text,int textSize,int textColor,int iconTextMargin){
        txtLp.leftMargin = DensityUtil.dip2px(mContext,iconTextMargin);
        textView.setText(text);
        textView.setTextColor(textColor);
        textView.setTextSize(textSize);

    }

    /**
     * 设置 icon 样式
     * @param width 图片的宽度
     * @param height 图片的高度
     * @param resId 资源Id
     */
    public void setImageStyle(int width,int height,int resId,int iconMarginLeft){
        iconLp.leftMargin = DensityUtil.dip2px(mContext,iconMarginLeft);

        iconImg.setBackgroundResource(resId);

        ViewGroup.LayoutParams layoutParams = iconImg.getLayoutParams();

        layoutParams.width = DensityUtil.dip2px(mContext,width);
        layoutParams.height = DensityUtil.dip2px(mContext,height);

        iconImg.setLayoutParams(layoutParams);

    }

    /**
     * 箭头的颜色
     * @param resId 资源ID
     * @param isShow 是否显示
     */
    public void setArrowStyle(int resId,boolean isShow ,int arrowMarginRight){

        if(resId == 0){
            arrowImg.setVisibility(GONE);
            return;
        }

        arrowLp.rightMargin = DensityUtil.dip2px(mContext,arrowMarginRight);

        arrowImg.setImageResource(resId);
        if(isShow){
            arrowImg.setVisibility(VISIBLE);
        }else{
            arrowImg.setVisibility(GONE);
        }
    }


}
