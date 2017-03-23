package com.example.tkach_a.joketeller;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @LayoutRes
    private int getLayoutResId() {
        if (!BuildConfig.IS_PAID) {
            return R.layout.activity_main;
        } else {
            return R.layout.activity_main_paid;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

    }
}
