package com.maiml.library.config;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import com.maiml.library.BaseItemLayout;
import com.maiml.library.ItemView;
import com.maiml.library.Mode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maimingliang on 2016/12/4.
 */

public  class ConfigAttrs {



    private int position;

    /**
     * item 的 高度
     */
     int itemHeight;

    /**
     * 线的颜色
     */
    private int lineColor;

    /**
     * 图标的 高宽
     */
    private int iconWidth;
    private int iconHeight;

    /**
     * 字体的大小
     */
    private int textSize;

    /**
     * 字体的颜色
     */
    private int textColor;


    /**
     * 图标距离左边的 marginLeft 大小
     */
    private int iconMarginLeft;

    /**
     * 文字 距离 图标的 marginLeft 大小
     */
    private int iconTextMargin;

    /**
     *    TextView 的显示文字 按顺序 插入
     */
    private List<String> valueList;

    /**
     *   icon 图标的 resId 按顺序插入
     */
    private List<Integer> resIdList;




    /**
     * 箭头距离 最右边 的 marginRight 大小
     */
    private int arrowMarginRight;

    /**
     * 箭头的资源Id
     */
    private int arrowResId;

    /**
     * 字体的大小
     */
    private int rightTextSize;

    /**
     * 字体的颜色
     */
    private int rightTextColor;


    /**
     * button图标的资源
     */
    private int trunResId;
    private int upResId ;
    /**
     * 右边字体和箭头的间距
     */
    private int rightTextMagin;


    /**
     *  每一个 item 与 item 之间的 marginTop 的大小
     */
    private SparseArray marginArray=new SparseArray<Integer>();


    /**
     *  item 的模式
     */
    private SparseArray<Mode> modeArray = new SparseArray<>();

    /**
     * 保存右边的text
     */

    private SparseArray<String> rightTextArray = new SparseArray<>();




    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getItemHeight() {
        return itemHeight;
    }

    public ConfigAttrs setItemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
        return this;
    }

    public int getLineColor() {
        return lineColor;
    }

    public ConfigAttrs setLineColor(int lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    public int getIconWidth() {
        return iconWidth;
    }

    public ConfigAttrs setIconWidth(int iconWidth) {
        this.iconWidth = iconWidth;
        return this;
    }

    public int getIconHeight() {
        return iconHeight;
    }

    public ConfigAttrs setIconHeight(int iconHeight) {
        this.iconHeight = iconHeight;
        return this;
    }

    public int getTextSize() {
        return textSize;
    }

    public ConfigAttrs setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public int getTextColor() {
        return textColor;
    }

    public ConfigAttrs setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getIconMarginLeft() {
        return iconMarginLeft;
    }

    public ConfigAttrs setIconMarginLeft(int iconMarginLeft) {
        this.iconMarginLeft = iconMarginLeft;
        return this;
    }

    public int getIconTextMargin() {
        return iconTextMargin;
    }

    public ConfigAttrs setIconTextMargin(int iconTextMargin) {
        this.iconTextMargin = iconTextMargin;
        return this;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public ConfigAttrs setValueList(List<String> valueList) {
        this.valueList = valueList;
        return this;
    }

    public List<Integer> getResIdList() {
        return resIdList;
    }

    public ConfigAttrs setResIdList(List<Integer> resIdList) {
        this.resIdList = resIdList;
        return this;
    }

    public int getArrowMarginRight() {
        return arrowMarginRight;
    }

    public ConfigAttrs setArrowMarginRight(int arrowMarginRight) {
        this.arrowMarginRight = arrowMarginRight;
        return this;
    }

    public int getArrowResId() {
        return arrowResId;
    }

    public ConfigAttrs setArrowResId(int arrowResId) {
        this.arrowResId = arrowResId;
        return this;
    }

    public int getRightTextSize() {
        return rightTextSize;
    }

    public ConfigAttrs setRightTextSize(int rightTextSize) {
        this.rightTextSize = rightTextSize;
        return this;
    }

    public int getRightTextColor() {
        return rightTextColor;
    }

    public ConfigAttrs setRightTextColor(int rightTextColor) {
        this.rightTextColor = rightTextColor;
        return this;
    }

    public int getTrunResId() {
        return trunResId;
    }

    public ConfigAttrs setTrunResId(int trunResId) {
        this.trunResId = trunResId;
        return this;
    }

    public int getUpResId() {
        return upResId;
    }

    public ConfigAttrs setUpResId(int upResId) {
        this.upResId = upResId;
        return this;
    }

    public int getRightTextMagin() {
        return rightTextMagin;
    }

    public ConfigAttrs setRightTextMagin(int rightTextMagin) {
        this.rightTextMagin = rightTextMagin;
        return this;
    }


    public SparseArray getMarginArray() {
        return marginArray;
    }

    public SparseArray<Mode> getModeArray() {
        return modeArray;
    }

    public SparseArray<String> getRightTextArray() {
        return rightTextArray;
    }



    public ConfigAttrs setItemMode(Mode value){

        if(valueList.size() <= 0){
            throw  new RuntimeException("values is null");
        }

        for(int i = 0 ;i<valueList.size();i++){
            modeArray.put(i,value);
        }
        return this;
    }

    public ConfigAttrs setItemMode(int index, Mode value){
        modeArray.put(index,value);
        return this;
    }

    public ConfigAttrs setItemMode(int index, Mode value, String text){
        modeArray.put(index,value);
        rightTextArray.put(index,text);
        Log.e("indext",index +"----->"+ text);
        return this;
    }


    public ConfigAttrs setItemRightText(List<String> values){

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




    public ConfigAttrs setItemMarginTop(int index, int value){
        marginArray.put(index,value);
        return this;
    }

    public ConfigAttrs setItemMarginTop(int value){

        if(valueList.size() <= 0){
            throw  new RuntimeException("");
        }

        for(int i = 0 ;i<valueList.size();i++){
            marginArray.put(i,value);
        }
        return this;
    }


}
