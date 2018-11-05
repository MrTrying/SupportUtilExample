package com.mrtrying.support.example.constraintlayout;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mrtrying.support.example.R;

public class ConstraintLayoutActivity extends AppCompatActivity {

    public static void startActivity(@NonNull Context context){
        context.startActivity(new Intent(context,ConstraintLayoutActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
    }
}
