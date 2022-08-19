package com.bawp.onsite2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    canvas1 canvas1;
    canvas2 canvas2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        canvas1=new canvas1();
        canvas2=new canvas2();
        getSupportFragmentManager().beginTransaction().replace(R.id.con1, canvas1).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.con2,canvas2 ).commit();
    }
}