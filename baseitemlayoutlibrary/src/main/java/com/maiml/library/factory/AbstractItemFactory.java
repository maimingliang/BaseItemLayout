package com.maiml.library.factory;

import android.content.Context;

import com.maiml.library.config.ConfigAttrs;
import com.maiml.library.Item.AbstractItem;
import com.maiml.library.config.Mode;

/**
 * Created by maimingliang on 2016/12/4.
 *
 * 创建Item 的工厂类
 */

public abstract class AbstractItemFactory {

    protected Context mContext;

    public AbstractItemFactory(Context context){
        this.mContext = context;
    }


    public abstract  <T extends AbstractItem> T createItem(Mode mode, ConfigAttrs attrs);
}
