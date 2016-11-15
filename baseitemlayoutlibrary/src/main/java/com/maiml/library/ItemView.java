package com.maiml.library;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.library.utils.DensityUtil;


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
    private TextView rightTextView;
    private LayoutParams rightTextViewlp;
    private SwitchImageView switchImageView;
    private LayoutParams switchCblp;


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

        createWidget(context);

        createWidgetLayoutParams();

        addWidget();

        setBackgroundResource(R.drawable.btn_list_item_bg);



     }

    private void addWidget() {
        addView(textView, txtLp);
        addView(iconImg, iconLp);
        addView(arrowImg, arrowLp);
        addView(rightTextView,rightTextViewlp);
        addView(switchImageView,switchCblp);
    }

    /**
     * 创建item 中没一个控件的  layotParams
     */
    private void createWidgetLayoutParams() {
        iconLp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        iconLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);

        txtLp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        txtLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        txtLp.addRule(RelativeLayout.RIGHT_OF, R.id.img_id);


        arrowLp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        arrowLp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        arrowLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);


        rightTextViewlp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightTextViewlp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        rightTextViewlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);


        switchCblp = new LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switchCblp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        switchCblp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
    }

    /**
     * 创建item 中的控件
     * @param context
     */

    private void createWidget(Context context) {
        iconImg = new ImageView(context);
        iconImg.setId(R.id.img_id);

        textView = new TextView(context);
        textView.setId(R.id.txt_id);

        arrowImg = new ImageView(context);
        arrowImg.setId(R.id.arrow_id);

        rightTextView = new TextView(context);

        rightTextView.setId(R.id.right_text_id);


        switchImageView = new SwitchImageView(context);

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
    /**
     * 箭头的
     * @param resId 资源ID
     *
     */
    public void setArrowStyle(int resId,int arrowMarginRight){

        if(resId == 0){
            arrowImg.setVisibility(GONE);
            return;
        }

        arrowLp.rightMargin = DensityUtil.dip2px(mContext,arrowMarginRight);

        arrowImg.setImageResource(resId);

    }

    /**
     * 设置文字的样式
     * @param text
     */
    public void setRightTextStyle(String text,int textSize,int textColor,int arrowMarginRight,int arrowResId){


        if(text == null || text.equals("")){
            text = "";
        }
        rightTextViewlp.rightMargin = DensityUtil.dip2px(mContext,arrowMarginRight);
        rightTextView.setText(text);
        rightTextView.setTextColor(textColor);
        rightTextView.setTextSize(textSize);

        if(arrowResId == 0){
            return;
        }

        Drawable drawable= getResources().getDrawable(arrowResId);
        /// 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        rightTextView.setCompoundDrawables(null,null,drawable,null);
        rightTextView.setCompoundDrawablePadding(20);


    }

    /**
     * 设置文字的样式
     * @param text
     */
    public void setRightText(String text){

         rightTextView.setText(text);

    }

    public SwitchImageView setSwitchImageViewStyle(final int trunResId, final int upresId,int arrowMarginRight){


        if(trunResId == 0 || upresId == 0){
            throw new RuntimeException("turnResId or upResId is not set");
        }


        switchCblp.rightMargin = DensityUtil.dip2px(mContext,arrowMarginRight);

        switchImageView.setImageResource(trunResId);


        return switchImageView;
    }

    public void setShowStyle(BaseItemLayout.Mode mode){

        hideRightAllType();

        if(mode == null){
            mode = BaseItemLayout.Mode.DEFAULT;
        }
        if(mode == BaseItemLayout.Mode.IMAGE){
            arrowImg.setVisibility(VISIBLE);
        }else if(mode == BaseItemLayout.Mode.TXT){
            rightTextView.setVisibility(VISIBLE);
        }else if(mode == BaseItemLayout.Mode.BUTTON){
            switchImageView.setVisibility(VISIBLE);
        }

    }

    /**
     * 隐藏右边全部类型的控件
     */
    private void hideRightAllType() {
        arrowImg.setVisibility(GONE);
        rightTextView.setVisibility(GONE);
        switchImageView.setVisibility(GONE);
    }


     private BaseItemLayout.OnSwitchClickListener onSwitchClickListener;

    public BaseItemLayout.OnSwitchClickListener getOnSwitchClickListener() {
        return onSwitchClickListener;
    }
}
