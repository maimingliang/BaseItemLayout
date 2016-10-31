package com.maiml.baseui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.maiml.baseitemlayoutlibrary.BaseItemLayout;

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


        layout.setValueList(valueList)
              .setResIdList(resIdList)
              .setArrowResId(R.drawable.img_find_arrow)
                .setArrowIsShow(false)
                .setItemMarginTop(10)
                .setItemMarginTop(0,0)
                .setIconHeight(24)
                .setIconWidth(24)
             .create();


        layout.setOnBaseItemClick(new BaseItemLayout.OnBaseItemClick() {
            @Override
            public void onItemClick(int position) {
                Log.e(TAG,"----- position = " + position);
            }
        });

    }
}
