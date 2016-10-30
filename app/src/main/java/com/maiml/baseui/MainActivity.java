package com.maiml.baseui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BaseItemUI layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (BaseItemUI) findViewById(R.id.layout);

        initData();
    }

    private void initData() {

        List<String> valueList = new ArrayList<>();

        for(int i = 0 ; i< 4;i++){
            valueList.add("item " +i);
        }

        List<Integer> resIdList = new ArrayList<>();

        for(int i = 0 ;i < 4;i++){
            resIdList.add(R.drawable.img_friends);
        }


        layout.setValueList(valueList);
        layout.setResList(resIdList);
        layout.setArrowResId(R.drawable.img_find_arrow);
        layout.create();

    }
}
