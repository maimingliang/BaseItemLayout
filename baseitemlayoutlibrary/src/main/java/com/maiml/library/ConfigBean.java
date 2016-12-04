package com.maiml.library;

import android.util.SparseArray;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maimingliang on 2016/12/3.
 *
 * 保存配置的参数信息
 */

public class ConfigBean {


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
     * 箭头距离 最右边 的 marginRight 大小
     */
    private int arrowMarginRight;

    /**
     * item 的 高度
     */
    private int itemHeight;
    /**
     * 字体的大小
     */
    private int rightTextSize;
    /**
     * 字体的颜色
     */
    private int rightTextColor;


    /**
     * 按钮的资源ID
     */
    private int trunResId;
    private int upResId;
    /**
     * 右边字体和箭头的间距
     */
    private int rightTextMagin;

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
    private SparseArray<BaseItemLayout.Mode> modeArray = new SparseArray<>();

    /**
     *
     */
    private SparseArray<String> rightTextArray = new SparseArray<>();

    /**
     * 箭头的资源Id
     */
    private int arrowResId = 0;


    /**
     *  记录 view 的数组
     */
    private List<View> viewList = new ArrayList<>();






}
