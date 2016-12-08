package com.maiml.baseui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.maiml.library.BaseItemLayout;
import com.maiml.library.config.ConfigAttrs;
import com.maiml.library.config.Mode;

import java.util.ArrayList;
import java.util.List;

public class TxtActivity extends AppCompatActivity {

    private BaseItemLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        layout = (BaseItemLayout) findViewById(R.id.layout);

        initData();
    }

    private void initData() {
        List<String> valueList = new ArrayList<>();

        valueList.add("相册");
        valueList.add("收藏");
        valueList.add("钱包");
        valueList.add("卡包");
        valueList.add("设置");

        List<Integer> resIdList = new ArrayList<>();

        resIdList.add(R.drawable.xc);
        resIdList.add(R.drawable.sc);
        resIdList.add(R.drawable.qb);
        resIdList.add(R.drawable.kb);
        resIdList.add(R.drawable.sz);

        List<String> rightTextList = new ArrayList<>();

        rightTextList.add("test1");
        rightTextList.add("test2");
        rightTextList.add("test3");
        rightTextList.add("test4");
        rightTextList.add("test5");

        ConfigAttrs attrs = new ConfigAttrs(); // 把全部参数的配置，委托给ConfigAttrs类处理。

        //参数 使用链式方式配置
        attrs.setValueList(valueList)  // 文字 list
                .setResIdList(resIdList) // icon list
                .setIconWidth(24)  //设置icon 的大小
                .setIconHeight(24)
                .setItemMarginTop(10) //该方法是 设置全部item的间距，还有个重载方法 setItemMarginTop(1,20) // 该方法是 设置 position（某个位置） 下的item 的 间距
                .setItemMode(Mode.TEXT) // 该方法是设置全部Item的模式显示模式  ,还有个重载的方法 setItemMode(1,Mode.BUTTON); //该方法是设置position（某个位置） 下Item的 显示模式
                .setRightText(rightTextList);// 只有在Mode.TXT 才需要设置改值，还有个重载的方法 setRightText(1,"love u");//设置position （某个位置）Mode.TXT 模式下的值。

        layout.setConfigAttrs(attrs)
                .create(); //
    }
}
