package com.example.dushyantha.attendanceapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUpdtStudentActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText Stud_Reg, Stud_Name, Stud_Password, Stud_Level;
    Button btn_Add_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_updt_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDb = new DatabaseHelper(this);

        Stud_Reg = (EditText)findViewById(R.id.Stud_Reg);
        Stud_Name = (EditText)findViewById(R.id.Stud_Name);
        Stud_Level = (EditText)findViewById(R.id.Stud_Level);
        Stud_Password = (EditText)findViewById(R.id.Stud_Password);

        btn_Add_data = (Button)findViewById(R.id.btn_Add);
        AddData();


    }

    public void AddData(){
        btn_Add_data.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(Stud_Reg.getText().toString(),
                                Stud_Name.getText().toString(),
                                Stud_Level.getText().toString(),
                                Stud_Password.getText().toString()   );

                        if(isInserted == true)
                            Toast.makeText(AddUpdtStudentActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AddUpdtStudentActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
