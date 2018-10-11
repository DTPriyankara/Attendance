package com.example.dushyantha.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LectureActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecture);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        button = (Button) findViewById(R.id.btn_lect_Add_Updt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddUpdtLectureActivity();
            }
        });

        button = (Button) findViewById(R.id.btn_lectView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewLectureActivity();
            }
        });

        button = (Button) findViewById(R.id.btn_lectDelete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeleteLectureActivity();
            }
        });
    }



    public void openAddUpdtLectureActivity() {
        Intent intent = new Intent(this, AddUpdtLectureActivity.class);
        startActivity(intent);
    }

    public void openViewLectureActivity() {
        Intent intent = new Intent(this, ViewLectureActivity.class);
        startActivity(intent);
    }

    public void openDeleteLectureActivity() {
        Intent intent = new Intent(this, DeleteLectureActivity.class);
        startActivity(intent);
    }

}
