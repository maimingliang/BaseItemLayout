package com.maiml.baseui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.maiml.baseui.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maimingliang on 2016/10/27.
 */

public class BaseItemUI extends LinearLayout {



    private Context mContext;

    private int itemMarginTop = 10;
    private int firstItemMarginTop = 0;
    private int lineColor = 0xff303F9F;

    private List<String> valueList = new ArrayList<>();

    private List<Integer> resList = new ArrayList<>();

    private int arrowResId = 0;

    private AttributeSet attrs;

    public BaseItemUI(Context context) {
        this(context,null);
    }

    public BaseItemUI(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public BaseItemUI(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ItemAttrs);

        itemMarginTop = a.getInt(R.styleable.ItemAttrs_item_margin_top,itemMarginTop);
        firstItemMarginTop = a.getInt(R.styleable.ItemAttrs_first_item_margin_top,firstItemMarginTop);
        lineColor = a.getColor(R.styleable.ItemAttrs_line_color,lineColor);

        a.recycle();
        init(context,attrs);
    }



    private void init(Context context,AttributeSet attrs){
        mContext = context;
        this.attrs = attrs;

        setOrientation(VERTICAL);

     }


    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    public void setResList(List<Integer> resList) {
        this.resList = resList;
    }

    public void setArrowResId(int arrowResId) {
        this.arrowResId = arrowResId;
    }

    public void create(){

        if(valueList.size() <=0){
            throw new RuntimeException("");
        }

        if(resList.size() <= 0){
            throw new RuntimeException("");
        }

        if(valueList.size() != resList.size()){
            throw new RuntimeException("");
        }

        if(arrowResId == 0){
            throw new RuntimeException("");
        }

        for(int i = 0 ;i < valueList.size();i++){

            ItemView itemView = new ItemView(mContext,attrs);
            itemView.setItemValue(valueList.get(i),resList.get(i),arrowResId);
            addView(itemView,i);
        }


    }


    private void addView(ItemView view,int pos){

        if(pos == 0){

            if(firstItemMarginTop > 0){
                addView(createView(true,pos));
                addView(view);
                addView(createView(false,pos));
            }else{
                addView(createView(false,pos));
                addView(view);
                addView(createView(false,pos));
            }

        }else{
            addView(createView(true,pos));
            addView(view);
            addView(createView(false,pos));
        }
    }


    private View createView(boolean hasMargin,int pos){


        View view = new View(mContext);

        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);


         if(hasMargin){
             if(pos == 0){
                 lp1.topMargin = itemMarginTop;
             }else{
                 lp1.topMargin = firstItemMarginTop;
             }

        }else{
            lp1.topMargin = 0;
        }

        view.setLayoutParams(lp1);

        view.setBackgroundColor(lineColor);

        return view;
    }




}
