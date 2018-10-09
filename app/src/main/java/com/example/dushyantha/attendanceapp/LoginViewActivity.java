package com.example.dushyantha.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class LoginViewActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = (Button) findViewById(R.id.btn_admin);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                adminpanelActivity();
            }
        });

        button = (Button) findViewById(R.id.btn_attendance);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectionviewActivity();
            }
        });
    }
    public void adminpanelActivity(){
        Intent intent = new Intent(this, AdminPanelActivity.class);
        startActivity(intent);
    }
    public void selectionviewActivity(){
        Intent intent = new Intent(this,SelctionViewActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_log_out, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
