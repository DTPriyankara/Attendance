package com.example.dushyantha.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class AdminPanelActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_panel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //button Student===============================================
        button = (Button) findViewById(R.id.btn_student);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentActivity();
            }
        });

        //button Lecture==============================================
        button = (Button) findViewById(R.id.btn_lecture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLectureActivity();
            }
        });

        //button Course================================================
        button = (Button) findViewById(R.id.btn_course);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCourseActivity();
            }
        });


        ActionBar ab = getSupportActionBar();
        ab.setLogo(R.drawable.ic_action_name);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);



    }
    public void openStudentActivity() {
        Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }

    public void openLectureActivity() {
        Intent intent = new Intent(this, LectureActivity.class);
        startActivity(intent);
    }
    public void openCourseActivity() {
        Intent intent = new Intent(this, CourseActivity.class);
        startActivity(intent);
    }



}
