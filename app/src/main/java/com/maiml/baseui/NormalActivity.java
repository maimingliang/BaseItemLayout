package com.maiml.baseui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;

import com.maiml.library.BaseItemLayout;
import com.maiml.library.config.ConfigAttrs;
import com.maiml.library.config.Mode;

import java.util.ArrayList;
import java.util.List;

public class NormalActivity extends AppCompatActivity {

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
        SurfaceView s = new SurfaceView(this);

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
                .setItemBgSelector( R.drawable.btn_list_item_black_bg2)
                 .setItemMode(Mode.NORMAL);

        layout.setConfigAttrs(attrs)
                .create(); //

        layout.setOnBaseItemClick(new BaseItemLayout.OnBaseItemClick() {
            @Override
            public void onItemClick(int position) {

            }
        });

        layout.setOnSwitchClickListener(new BaseItemLayout.OnSwitchClickListener() {
            @Override
            public void onClick(int position, boolean isCheck) {

            }
        });


    }
}
