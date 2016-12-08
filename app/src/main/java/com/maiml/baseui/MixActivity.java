package com.maiml.baseui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.maiml.library.BaseItemLayout;
import com.maiml.library.config.ConfigAttrs;
import com.maiml.library.config.Mode;

import java.util.ArrayList;
import java.util.List;

public class MixActivity extends AppCompatActivity {

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



        ConfigAttrs attrs = new ConfigAttrs(); // 把全部参数的配置，委托给ConfigAttrs类处理。

        //参数 使用链式方式配置
        attrs.setValueList(valueList)  // 文字 list
                .setResIdList(resIdList) // icon list
                .setIconWidth(24)  //设置icon 的大小
                .setIconHeight(24)
                .setItemMarginTop(10) //设置 全部item的间距
                .setItemMarginTop(1,20)// 设置 position 下的item 的 间距
                .setItemMode(Mode.NORMAL)//设置item 为 Mode.NORMAL 模式
                .setItemMode(1,Mode.TEXT) //设置第二个item 为 Mode.TEXT 模式
                .setItemMode(2,Mode.ARROW)//设置第三个item 为 Mode.ARROW 模式
                .setItemMode(3,Mode.BOTTON)//设置第四个item 为 Mode.BOTTON 模式
                .setItemMode(4,Mode.RED_TEXT)//设置第五个item 为 Mode.RED_TEXT 模式
                .setRightText(1,"text1") // 设置第二个Item 的值，Mode.TEXT 模式下必须设置值
                .setRightText(4,"22") //设置第五个item  Mode.RED_TEXT 模式下必须设置值并且为数字
                .setArrowResId(R.drawable.img_find_arrow) //设置箭头资源值
                .setUpResId(R.drawable.img_up) //设置开闭按钮资源值
                .setTrunResId(R.drawable.img_turn_down)//设置开闭按钮资源值
                .setMarginRight(10); //设置距右边边距


        layout.setConfigAttrs(attrs)
                .create(); //
    }
}
