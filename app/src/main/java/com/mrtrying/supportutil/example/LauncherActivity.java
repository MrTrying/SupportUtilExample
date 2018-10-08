package com.mrtrying.supportutil.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mrtrying.supportutil.example.diffutil.DiffUtilActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);
    }

    public void openDiffUtilActivity(View view){
        DiffUtilActivity.startActivity(this);
    }
}
