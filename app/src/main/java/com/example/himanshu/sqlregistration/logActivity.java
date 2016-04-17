package com.example.himanshu.sqlregistration;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logActivity extends AppCompatActivity {

    public final static String USER="com.logActivity.USERNAMES";
    EditText user,pass;
    Button log;
    String username,password;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        user=(EditText)findViewById(R.id.lUsername);
        pass=(EditText)findViewById(R.id.lPassword);
        log=(Button)findViewById(R.id.lButton);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     DatabaseOperations dp=new DatabaseOperations(ctx);
                     Cursor c=dp.extractInfo(dp);
                        boolean ls=false;
                          username=user.getText().toString();
                         password=pass.getText().toString();
                        c.moveToFirst();
                        do {
                            //Toast.makeText(getBaseContext(),"Login Successful.."+username+","+c.getString(0)+";"+password+","+c.getString(1),Toast.LENGTH_LONG).show();
                                 if(username.equals(c.getString(0)) && password.equals(c.getString(1))){
                                ls=true;

                                 }
                        }while(c.moveToNext());
                if(ls==false){
                    Toast.makeText(getBaseContext(),"Login failed..",Toast.LENGTH_LONG).show();
                    finish();
                }
                else{
                    Toast.makeText(getBaseContext(),"Login Successful.."+username,Toast.LENGTH_LONG).show();
                    Intent i =new Intent(getBaseContext(),secretMessage.class);
                    i.putExtra(USER,username);
                    startActivity(i);
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
