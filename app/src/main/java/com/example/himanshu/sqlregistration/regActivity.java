package com.example.himanshu.sqlregistration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class regActivity extends AppCompatActivity {
    EditText USERNAME,PASS,CPASS;
    Button REGS;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        USERNAME=(EditText)findViewById(R.id.username);
        PASS=(EditText)findViewById(R.id.Pass);
        CPASS=(EditText)findViewById(R.id.cPass);
        REGS=(Button)findViewById(R.id.register);
        REGS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Perform the sql functions here
                String user_name=USERNAME.getText().toString();
                String pass=PASS.getText().toString();
                String cpass=CPASS.getText().toString();
                if(!pass.equals(cpass)){
                    Toast.makeText(getBaseContext(),"Password Does not match!",Toast.LENGTH_LONG).show();
                }
                else{
                    DatabaseOperations db=new DatabaseOperations(ctx);
                    db.putInfo(db,user_name,pass);
                    if(db.createUserTable(db,user_name)==1)
                    Toast.makeText(getBaseContext(),"Registation Successful!",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getBaseContext(), "User already exists..", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
