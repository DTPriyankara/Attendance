package com.example.dushyantha.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class StudentActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        button = (Button) findViewById(R.id.btn_stdAdd_Updt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddUpdtStudentActivity();
            }
        });

        button = (Button) findViewById(R.id.btn_stdView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openViewStudentActivity();
            }
        });

        button = (Button) findViewById(R.id.btn_stdDelete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDeleteStudentActivity();
            }
        });
    }

    public void openAddUpdtStudentActivity() {
        Intent intent = new Intent(this, AddUpdtStudentActivity.class);
        startActivity(intent);
    }

    public void openViewStudentActivity() {
        Intent intent = new Intent(this, ViewStudentActivity.class);
        startActivity(intent);
    }

    public void openDeleteStudentActivity() {
        Intent intent = new Intent(this, DeleteStudentActivity.class);
        startActivity(intent);
    }
}
