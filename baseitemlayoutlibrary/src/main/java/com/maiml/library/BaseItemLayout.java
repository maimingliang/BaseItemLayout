package com.maiml.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.maiml.baseitemlayoutlibrary.R;
import com.maiml.library.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maimingliang on 2016/10/27.
 */

public class BaseItemLayout extends LinearLayout {



    private Context mContext;

    /**
     * 线的颜色
     */
    private int lineColor = 0xff303F9F;

    /**
     * 图标的 高宽
     */
    private int iconWidth = 24;
    private int iconHeight = 24;

    /**
     * 是否显示 右边的箭头
     */
    private boolean arrowIsShow = false;

    /**
     * 字体的大小
     */
    private int textSize = 15;

    /**
     * 字体的颜色
     */
    private int textColor = 0xff333333;

    /**
     * 图标距离左边的 marginLeft 大小
     */
    private int iconMarginLeft = 10;

    /**
     * 文字 距离 图标的 marginLeft 大小
     */
    private int iconTextMargin = 10;





    /**
     * 箭头距离 最右边 的 marginRight 大小
     */
    private int arrowMarginRight =10;

    /**
     * item 的 高度
     */
    private int itemHeight = 40;




    /**
     * 字体的大小
     */
    private int rightTextSize = 15;

    /**
     * 字体的颜色
     */
    private int rightTextColor = 0xff333333;


    private int trunResId = 0;
    private int upResId = 0;
    /**
     * 右边字体和箭头的间距
     */
    private int rightTextMagin = 10;

    /**
     *    TextView 的显示文字 按顺序 插入
     */
    private List<String> valueList = new ArrayList<>();

    /**
     *   icon 图标的 resId 按顺序插入
     */
    private List<Integer> resIdList = new ArrayList<>();

    /**
     *  每一个 item 与 item 之间的 marginTop 的大小
     */
    private SparseArray marginArray=new SparseArray<Integer>();


    /**
     *  item 的模式
     */
    private SparseArray<Mode> modeArray = new SparseArray<>();

    private SparseArray<String> rightTextArray = new SparseArray<>();

    /**
     * 箭头的资源Id
     */
    private int arrowResId = 0;


    private List<View> viewList = new ArrayList<>();


    private static int DEFAULT_HEIGHT = 10;
    private static int ZERO_HEIGHT = 0;

    public BaseItemLayout(Context context) {
        this(context,null);
    }

    public BaseItemLayout(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public BaseItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ItemAttrs);

        lineColor = a.getColor(R.styleable.ItemAttrs_line_color,lineColor);
        textSize = a.getInt(R.styleable.ItemAttrs_text_size,textSize);
        textColor = a.getColor(R.styleable.ItemAttrs_text_color,textColor);
        iconMarginLeft = a.getInt(R.styleable.ItemAttrs_icon_margin_left,iconMarginLeft);
        iconTextMargin = a.getInt(R.styleable.ItemAttrs_icon_text_margin,iconTextMargin);
        arrowMarginRight = a.getInt(R.styleable.ItemAttrs_margin_right,arrowMarginRight);
        itemHeight = a.getInt(R.styleable.ItemAttrs_item_height,itemHeight);
        rightTextSize = a.getInt(R.styleable.ItemAttrs_right_text_size,rightTextSize);
        rightTextColor = a.getColor(R.styleable.ItemAttrs_right_text_color,rightTextColor);
        rightTextMagin = a.getInt(R.styleable.ItemAttrs_right_text_margin,rightTextMagin);

        a.recycle();
        init(context);
    }



    private void init(Context context){
        mContext = context;
        setOrientation(VERTICAL);
     }



    public void create(){

        if(valueList.size() <= 0){
            throw new RuntimeException("valueList  is null");
        }

        if(resIdList.size() <= 0){
            throw new RuntimeException(" resIdList is null");
        }

        if(valueList.size() != resIdList.size()){
            throw new RuntimeException("params not match, valueList.size() should be equal resIdList.size()");
        }

        for( int i = 0 ;i < valueList.size();i++){

            ItemView itemView = new ItemView(mContext);
            itemView.setImageStyle(iconWidth,iconHeight, resIdList.get(i),iconMarginLeft);
            itemView.setTextStyle(valueList.get(i),textSize,textColor,iconTextMargin);
            itemView.setArrowStyle(arrowResId,arrowMarginRight);

            itemView.setRightTextStyle(rightTextArray.get(i),rightTextSize,rightTextColor,rightTextMagin,arrowResId);

            itemView.setLayoutParams(itemHeight);

            itemView.setShowStyle(modeArray.get(i));

            setSwitchImage(i, itemView);

            addItem(itemView,i);

        }

    }

    private void setSwitchImage(final int i, ItemView itemView) {

        if(modeArray.get(i) == Mode.BUTTON){

           final SwitchImageView switchImageView = itemView.setSwitchImageViewStyle(trunResId, upResId, arrowMarginRight);

            switchImageView.setOnSwitchClickListener(new SwitchImageView.OnSwitchClickListener() {
                @Override
                public void onClick(boolean isCheck) {

                    if(isCheck){
                        switchImageView.setImageResource(upResId);

                    }else{
                        switchImageView.setImageResource(trunResId);
                    }
                    if(onSwitchClickListener != null){
                        onSwitchClickListener.onClick(i,isCheck);
                    }
                }
            });


        }
    }


    /**
     * 添加 item
     * @param view
     * @param pos
     */
    private void addItem(ItemView view, final int pos){


        if (marginArray.get(pos) != null ) {

            if((Integer) marginArray.get(pos) > 0){
                addView(createLineView((Integer) marginArray.get(pos)));
            }

        } else {
            addView(createLineView(DEFAULT_HEIGHT));
        }
        addView(view);
        addView(createLineView(ZERO_HEIGHT));

        if(onBaseItemClick != null){
            setListener(view,pos);
        }

        viewList.add(view);
    }

    /**
     * 创建线
     * @param margin
     * @return
     */
    private View createLineView(int margin){

        View view = new View(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        lp.topMargin = DensityUtil.dip2px(mContext,margin);

        view.setLayoutParams(lp);
        view.setBackgroundColor(lineColor);
        return view;
    }

    private void setOnClick() {
        if(onBaseItemClick != null){
            for(int i = 0 ;i <viewList.size();i++){
                View view = viewList.get(i);
                setListener(view,i);
            }
        }
    }

    /**
     * 设置 item 的监听回调
     * @param view
     * @param position
     */
    private void setListener(View view, final int position) {
        if(view == null){
            return;
        }

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBaseItemClick.onItemClick(position);
            }
        });
    }


  //===========================================设置值=============================





    public BaseItemLayout setItemMarginTop(int index, int value){
        marginArray.put(index,value);
        return this;
    }

    public BaseItemLayout setItemMarginTop(int value){

        if(valueList.size() <= 0){
            throw  new RuntimeException("");
        }

        for(int i = 0 ;i<valueList.size();i++){
            marginArray.put(i,value);
        }
        return this;
    }


    public BaseItemLayout setItemMode(Mode value){

        if(valueList.size() <= 0){
            throw  new RuntimeException("values is null");
        }

        for(int i = 0 ;i<valueList.size();i++){
            modeArray.put(i,value);
        }
        return this;
    }

    public BaseItemLayout setItemMode(int index, Mode value){
        modeArray.put(index,value);
        return this;
    }

    public BaseItemLayout setItemMode(int index, Mode value,String text){
        modeArray.put(index,value);
        rightTextArray.put(index,text);
         Log.e("indext",index +"----->"+ text);
        return this;
    }


    public BaseItemLayout setItemRightText(List<String> values){

        if(values == null){
            throw  new RuntimeException("values is null");
        }

        if(values.size() <= 0){
            throw  new RuntimeException("");
        }

        for(int i = 0 ;i<values.size();i++){
             rightTextArray.put(i,values.get(i));
        }
        return this;
    }


    public void setRightText(int position,String text){
        rightTextArray.put(position,text);
        ItemView view = (ItemView) viewList.get(position);
        view.setRightText(text);

    }




    public BaseItemLayout setValueList(List<String> valueList) {
        this.valueList = valueList;
        return this;
    }

    public BaseItemLayout setResIdList(List<Integer> resIdList) {
        this.resIdList = resIdList;
        return this;
    }

    public BaseItemLayout setArrowResId(int arrowResId) {
        this.arrowResId = arrowResId;
        return this;
    }

    public BaseItemLayout setTrunResId(int trunResId) {
        this.trunResId = trunResId;
        return this;
    }
    public BaseItemLayout setUpResId(int upResId) {
        this.upResId = upResId;
        return this;
    }

    public BaseItemLayout setIconWidth(int iconWidth) {
        this.iconWidth = iconWidth;
        return this;
    }

    public BaseItemLayout setIconHeight(int iconHeight) {
        this.iconHeight = iconHeight;
        return this;
    }







    //=================================监听事件====================================

    private OnBaseItemClick onBaseItemClick;

    public void setOnBaseItemClick(OnBaseItemClick onBaseItemClick) {
        this.onBaseItemClick = onBaseItemClick;
        setOnClick();
    }

    public interface OnBaseItemClick{

        void onItemClick(int position);
    }


    private OnSwitchClickListener onSwitchClickListener;

    public void setOnSwitchClickListener(OnSwitchClickListener onSwitchClickListener) {
        this.onSwitchClickListener = onSwitchClickListener;
    }

    public interface OnSwitchClickListener{

        void onClick(int position,boolean isCheck);
    }



    public enum Mode {

        TXT,
        IMAGE,
        DEFAULT,
        BUTTON


    }



}
