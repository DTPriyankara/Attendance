package com.example.dushyantha.attendanceapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddUpdtLectureActivity extends AppCompatActivity {

DatabaseHelperLogin db1;
EditText Lect_Id, Lect_Name, Lect_Password;
Button b1;
Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_updt_lecture);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db1 = new DatabaseHelperLogin(this);

        Lect_Id=(EditText)findViewById(R.id.Lect_Id);
        Lect_Name=(EditText)findViewById(R.id.Lect_Name);
        Lect_Password=(EditText)findViewById(R.id.Lect_Password);

        b1=(Button)findViewById(R.id.btn_Add);
        b2=(Button)findViewById(R.id.btn_View);

        AddData();
        viewAll();

    }
    public void AddData(){
        b1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = db1.insert(Lect_Id.getText().toString(),
                                Lect_Name.getText().toString(),
                                Lect_Password.getText().toString()   );

                        if(isInserted == true)
                            Toast.makeText(AddUpdtLectureActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(AddUpdtLectureActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


    public void viewAll(){
        b2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = db1.getAllData();
                        if(res.getCount() == 0){
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("lec_id :"+res.getString(0)+"\n");
                            buffer.append("name :"+res.getString(1)+"\n");
                            buffer.append("password :"+res.getString(2)+"\n");
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
