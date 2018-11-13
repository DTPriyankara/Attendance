package com.example.dushyantha.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMain extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);




            button = (Button) findViewById(R.id.btn_login);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginview();
                }
            });

        }
    public void loginview() {
        Intent intent = new Intent(this, LoginViewActivity.class);
        startActivity(intent);
    }


}
