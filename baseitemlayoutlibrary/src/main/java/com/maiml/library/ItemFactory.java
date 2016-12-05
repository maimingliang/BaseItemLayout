package com.maiml.library;

import android.content.Context;
import android.util.Log;

import com.maiml.library.Item.ArrowItem;
import com.maiml.library.Item.ButtonItem;
import com.maiml.library.Item.NormalItem;
import com.maiml.library.Item.TextItem;
import com.maiml.library.config.ConfigAttrs;
import com.maiml.library.utils.AbstractItem;

/**
 * Created by maimingliang on 2016/12/4.
 */

public class ItemFactory extends AbstractItemFactory {

    public ItemFactory(Context context) {
        super(context);
    }

    @Override
    public  <T extends AbstractItem> T createItem(Mode mode, ConfigAttrs attrs) {
        Log.e("mode",mode.name());


        if(mode == null){
            throw new RuntimeException("please set mode");
        }
        AbstractItem item = null;

        try {


            if(mode == Mode.NORMAL){

                item = new NormalItem(mContext);

            }else if(mode == Mode.ARROW){

                item = new ArrowItem(mContext);

            }else if(mode == Mode.BOTTON){

                item = new ButtonItem(mContext);
            }else if(mode == Mode.TEXT){
                item = new TextItem(mContext);
            }


            if(item != null){
                item.create(attrs);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


        return (T) item;
    }
}
