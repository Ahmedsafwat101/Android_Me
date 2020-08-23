package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    private static final  String  HEAD="head_index";
    private static final  String  BODY="body_index";
    private  static final  String  LEG="leg_index";

    private int headIndex;
    private int bodyIndex;
    private int legIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onImageSelected(int pos) {
        Toast.makeText(this,pos+"", Toast.LENGTH_SHORT).show();
        if(pos==0 || pos<12)
            headIndex=pos;
        else if(pos==12||pos<24)
            bodyIndex=pos-12;
        else
            legIndex=pos-24;


        Bundle bundle= new Bundle();
        bundle.putInt(HEAD,headIndex);
        bundle.putInt(BODY,bodyIndex);
        bundle.putInt(LEG,legIndex);

        final Intent intent= new Intent(this,AndroidMeActivity.class);
        intent.putExtras(bundle);

        Button button= findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


    }
}