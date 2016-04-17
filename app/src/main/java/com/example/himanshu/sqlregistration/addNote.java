package com.example.himanshu.sqlregistration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addNote extends AppCompatActivity {
EditText e;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i=getIntent();
        final String user=i.getStringExtra("KEY");
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        e=(EditText)findViewById(R.id.et_note);
     b=(Button)findViewById(R.id.b_add_note);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note=e.getText().toString();
                if(note!=null){
                    DatabaseOperations d=new DatabaseOperations(getBaseContext());
                    d.putNotesIntoUser(d,user,note);

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
