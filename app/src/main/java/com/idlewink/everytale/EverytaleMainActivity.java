package com.idlewink.everytale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EverytaleMainActivity extends AppCompatActivity {

    private ImageView mChara;
    private ImageView mTales;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChara = (ImageView) findViewById(R.id.chara_button);
        mChara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CLICKED", "I MANAGED TO CLICK IT!");
                Intent intent = new Intent(EverytaleMainActivity.this, CharaListActivity.class);
                startActivity(intent);
            }
        });

        mTales = (ImageView) findViewById(R.id.tales_button);
        mTales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("CLICKED", "I MANAGED TO CLICK IT!");
                Intent intent = new Intent(EverytaleMainActivity.this, CharaListActivity.class);
                startActivity(intent);
            }
        });

    }
}