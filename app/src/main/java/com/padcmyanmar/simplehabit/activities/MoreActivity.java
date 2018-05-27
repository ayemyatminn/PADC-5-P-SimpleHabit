package com.padcmyanmar.simplehabit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.padcmyanmar.simplehabit.R;

import butterknife.ButterKnife;

/**
 * Created by PC on 5/27/2018.
 */

public class MoreActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this,this);
    }
}
