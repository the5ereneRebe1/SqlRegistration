package com.example.himanshu.sqlregistration;

import android.content.Intent;
import android.database.Cursor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class secretMessage extends AppCompatActivity {
  @Override
  protected void onPostResume() {
        super.onPostResume();
       Intent i=getIntent();
        final String user=i.getStringExtra(logActivity.USER);
        setContentView(R.layout.activity_secret_message);
        DatabaseOperations d=new DatabaseOperations(getBaseContext());
        Cursor c=d.extractNotesFromUser(d,user);
        LinearLayout ll = (LinearLayout)findViewById(R.id.rel);
        int ii=0;
        //LinearLayout.LayoutParams lp = new    LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


            c.moveToFirst();
        if(c.moveToNext()) {
            c.moveToFirst();

            do {

                TextView tv = new TextView(this);
                tv.setId(ii);
                tv.setTextSize(30);
                //Toast.makeText(getBaseContext(), c.getString(0),Toast.LENGTH_SHORT).show();
                tv.setText(ii+". "+c.getString(0));
                tv.setHighlightColor(Color.BLUE);
                // tv.setLayoutParams(lp);
                ll.addView(tv);
                ii++;
            } while (c.moveToNext());
        }
        Button b=new Button(this);
        b.setText("ADD A NOTE");
       b.setGravity(Gravity.CENTER);

        ll.addView(b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),addNote.class);
                i.putExtra("KEY",user);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Intent i=getIntent();
        final String user=i.getStringExtra(logActivity.USER);
        setContentView(R.layout.activity_secret_message);
        DatabaseOperations d=new DatabaseOperations(getBaseContext());
        Cursor c=d.extractNotesFromUser(d,user);
        LinearLayout ll = (LinearLayout)findViewById(R.id.rel);
        int ii=0;
        //LinearLayout.LayoutParams lp = new    LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


            c.moveToFirst();
        if(c.moveToNext()) {
            c.moveToFirst();

            do {

                TextView tv = new TextView(this);
                tv.setId(ii);
                tv.setTextSize(30);
                //Toast.makeText(getBaseContext(), c.getString(0),Toast.LENGTH_SHORT).show();
                tv.setText(ii+". "+c.getString(0));
                tv.setHighlightColor(Color.BLUE);
                // tv.setLayoutParams(lp);
                ll.addView(tv);
                ii++;
            } while (c.moveToNext());
        }
        Button b=new Button(this);
        b.setText("ADD A NOTE");
       b.setGravity(Gravity.CENTER);

        ll.addView(b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),addNote.class);
                i.putExtra("KEY",user);
                startActivityForResult(i,1);
            }
        });
    }
}
