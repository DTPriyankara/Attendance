package com.example.dushyantha.attendanceapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUpdtStudentActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText Stud_Reg, Stud_Name, Stud_Password, Stud_Level;
    Button btn_Add_data;
    Button btn_Update;
    Button btn_View;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_updt_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDb = new DatabaseHelper(this);

        Stud_Reg = (EditText) findViewById(R.id.Stud_Reg);
        Stud_Name = (EditText) findViewById(R.id.Stud_Name);
        Stud_Level = (EditText) findViewById(R.id.Stud_Level);
        Stud_Password = (EditText) findViewById(R.id.Stud_Password);

        btn_Add_data = (Button) findViewById(R.id.btn_Add);
        btn_Update = (Button) findViewById(R.id.btn_Update);

        btn_View = (Button) findViewById(R.id.btn_stdView);

        viewAll();
        AddData();
        UpdateData();
    }
    public void UpdateData(){
        btn_Update.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(Stud_Reg.getText().toString(),
                                Stud_Name.getText().toString(),
                                Stud_Level.getText().toString(),
                                Stud_Password.getText().toString());

                        if (isUpdate == true)
                            Toast.makeText(AddUpdtStudentActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AddUpdtStudentActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();


                    }
                }
        );
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

    public void viewAll(){
        btn_View.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("reg_no :"+res.getString(0)+"\n");
                            buffer.append("name :"+res.getString(1)+"\n");
                            buffer.append("level_of_study :"+res.getString(2)+"\n");
                            buffer.append("password :"+res.getString(3)+"\n\n");
                        }

                        //Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }


    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}
