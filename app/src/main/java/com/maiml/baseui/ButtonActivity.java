package com.maiml.baseui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.maiml.library.BaseItemLayout;
import com.maiml.library.config.ConfigAttrs;
import com.maiml.library.config.Mode;

import java.util.ArrayList;
import java.util.List;

public class ButtonActivity extends AppCompatActivity {

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
                .setItemMarginTop(10)
                .setItemMode(Mode.BOTTON)// 设置显示模式
                .setTrunResId(R.drawable.img_turn_down)//设置未选中图片
                .setUpResId(R.drawable.img_up)//设置选中图片
                .setMarginRight(10);// 设置距离右边的间距

        layout.setConfigAttrs(attrs)
                .create(); //
    }
}
