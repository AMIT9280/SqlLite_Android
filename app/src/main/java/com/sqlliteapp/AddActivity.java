package com.sqlliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    Button btn_Dis;
    Button btn_Add;
    EditText edtfn,edtln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        btn_Dis = findViewById(R.id.btn_dis);
        btn_Add = findViewById(R.id.btn_add);
        edtfn = findViewById(R.id.edt_fn);
        edtln = findViewById(R.id.edt_ln);

        DataBaseHandler db = new DataBaseHandler(this);
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddActivity.this, "Added", Toast.LENGTH_SHORT).show();
                String strfn = edtfn.getText().toString();
                String strln = edtln.getText().toString();

                ContactModel contact = new  ContactModel();
                contact.setFname(strfn);
                contact.setLname(strln);

                db.insertRecord(contact);
                edtfn.setText("");
                edtln.setText("");
            }
        });
        btn_Dis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddActivity.this,DispayActivity.class);

                startActivity(i);
            }
        });
    }
}