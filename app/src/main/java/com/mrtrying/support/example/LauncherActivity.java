package com.mrtrying.support.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mrtrying.support.example.constraintlayout.ConstraintLayoutActivity;
import com.mrtrying.support.example.utillib.diffutil.DiffUtilActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laucher);
    }

    public void openDiffUtilActivity(View view){
        DiffUtilActivity.startActivity(this);
    }

    public void openConstrainLayoutActivity(View view){
        ConstraintLayoutActivity.startActivity(this);
    }
}
