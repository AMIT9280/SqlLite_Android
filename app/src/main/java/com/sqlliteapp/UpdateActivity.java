package com.sqlliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText edtFn,edtLn;
    Button btnUpdate;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edtFn = findViewById(R.id.edt_fn);
        edtLn = findViewById(R.id.edt_ln);

        final DataBaseHandler db = new DataBaseHandler(this);

        btnUpdate = findViewById(R.id.btn_up);
        btnDelete = findViewById(R.id.btn_dis);

        Intent i = getIntent();
        String strfn = i.getStringExtra("KEY_Fn");
        String strln = i.getStringExtra("KEY_Ln");

        final String strId = i.getStringExtra("KEY_Id");

        edtFn.setText(strfn);
        edtLn.setText(strln);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strfn = edtFn.getText().toString();
                String strln = edtLn.getText().toString();

                ContactModel contact = new  ContactModel();
                contact.setId(strId);
                contact.setFname(strfn);
                contact.setLname(strln);

                db.updateRecord(contact);
                Intent I = new Intent(UpdateActivity.this,DispayActivity.class);
                startActivity(I);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactModel contact = new  ContactModel();
                contact.setId(strId);
                db.deleteRecord(contact);
                Intent I = new Intent(UpdateActivity.this,DispayActivity.class);
                startActivity(I);
                finish();
            }
        });

    }
}