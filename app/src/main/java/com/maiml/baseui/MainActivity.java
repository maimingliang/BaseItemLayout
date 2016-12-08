package com.maiml.baseui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.maiml.library.BaseItemLayout;
import com.maiml.library.RedTextView;
import com.maiml.library.config.Mode;
import com.maiml.library.config.ConfigAttrs;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:
                startActivity(new Intent(this,NormalActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this,TxtActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this,ButtonActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this,RedTextActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this,ArrowActivity.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this,MixActivity.class));
                break;
        }
    }
}
