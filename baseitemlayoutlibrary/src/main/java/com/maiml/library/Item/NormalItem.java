package com.maiml.library.item;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by maimingliang on 2016/12/4.
 * c创建正常的item
 */

public class NormalItem extends com.maiml.library.item.AbstractItem {


    public NormalItem(Context context) {
        super(context);


    }



    public NormalItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NormalItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void createWidget() {

    }

    @Override
    public void createWidgetLayoutParams() {

    }

    @Override
    public void addWidget() {
        super.addWidget();
    }
}
