package com.maiml.baseui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.maiml.library.BaseItemLayout;
import com.maiml.library.config.ConfigAttrs;
import com.maiml.library.config.Mode;

import java.util.ArrayList;
import java.util.List;

public class RedTextActivity extends AppCompatActivity {

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

        rightTextList.add("12");
        rightTextList.add("45");
        rightTextList.add("1");
        rightTextList.add("125");
        rightTextList.add("1225");

        ConfigAttrs attrs = new ConfigAttrs(); // 把全部参数的配置，委托给ConfigAttrs类处理。

        //参数 使用链式方式配置
        attrs.setValueList(valueList)  // 文字 list
                .setResIdList(resIdList) // icon list
                .setIconWidth(24)  //设置icon 的大小
                .setIconHeight(24)
                .setItemMarginTop(10)
                .setItemMode(Mode.RED_TEXT)// 设置显示模式
                .setRightText(rightTextList)//Mode.RED_TXT 的值必须为数字
                .setArrowResId(R.drawable.img_find_arrow) //箭头资源
                .setMarginRight(10)// 设置距离右边的间距
                  ;

        layout.setConfigAttrs(attrs)
                .create(); //
    }
}
