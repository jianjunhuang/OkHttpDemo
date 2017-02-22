package com.demo.jianjunhuang.okhttpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button test_intent_btn;
    private Button sample_intent_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        test_intent_btn = (Button) findViewById(R.id.test_intent_btn);
        sample_intent_btn = (Button) findViewById(R.id.sample_intent_btn);

        //register onClickListener
        test_intent_btn.setOnClickListener(this);
        sample_intent_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if(v.getId() == R.id.test_intent_btn){
            intent.setClass(this,TestActivity.class);
        }else{
            intent.setClass(this,SampleActivity.class);
        }
        startActivity(intent);
    }
}
