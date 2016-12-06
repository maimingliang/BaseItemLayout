package com.maiml.baseui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.maiml.library.BaseItemLayout;
import com.maiml.library.config.Mode;
import com.maiml.library.config.ConfigAttrs;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BaseItemLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

//        layout.setValueList(valueList) // 文字list
//              .setResIdList(resIdList) // icon list
//              .setArrowResId(R.drawable.img_find_arrow) // 右边的箭头
////                .setItemMarginTop(10)  //设置 每一个item 自己 margin
////                .setItemMarginTop(0,0) // 设置 position 下的item 的 margin
////                .setIconHeight(24)    // icon 的高度
////                .setIconWidth(24)      // icon 的宽度
//                .setItemMode(BaseItemLayout.Mode.TXT)
////                .setItemRightText(rightTextList)
////                .setTrunResId(R.drawable.img_turn_down)
////                .setUpResId(R.drawable.img_up)
//////                .setItemRightText(rightTextList)
////                .setItemMode(valueList.size()-3, BaseItemLayout.Mode.TXT,"TEXT1")
////
////                .setItemMode(valueList.size()-2, BaseItemLayout.Mode.BUTTON)
////                .setItemMode(valueList.size()-1, BaseItemLayout.Mode.BUTTON)

        ConfigAttrs attrs = new ConfigAttrs();
        attrs.setValueList(valueList)
                .setResIdList(resIdList)
                .setItemMode(Mode.NORMAL)
                .setItemMode(2,Mode.BOTTON)
                .setItemMode(3,Mode.BOTTON)
                .setTrunResId(R.drawable.img_turn_down)
                .setUpResId(R.drawable.img_up)
                .setArrowResId(R.drawable.img_find_arrow).
                setIconHeight(24)
                .setIconWidth(24)
                .setRightText(4,"love u")
                .setItemMode(4,Mode.TEXT)
        ;

        layout.setConfigAttrs(attrs)
              .create();



        layout.setOnBaseItemClick(new BaseItemLayout.OnBaseItemClick() {
            @Override
            public void onItemClick(int position) {
                Log.e("click","---> " +position);
            }
        });


        layout.setOnSwitchClickListener(new BaseItemLayout.OnSwitchClickListener() {
            @Override
            public void onClick(int position, boolean isCheck) {
                Log.e("switch",position +"  " + isCheck);
            }
        });

    }
}
