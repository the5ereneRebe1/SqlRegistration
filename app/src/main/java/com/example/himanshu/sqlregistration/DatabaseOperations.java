package com.example.himanshu.sqlregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.example.himanshu.sqlregistration.TableData.UserInfo;
import com.example.himanshu.sqlregistration.TableData.TableInfo;
/**
 * Created by HIMANSHU on 2/22/2016.
 */
public class DatabaseOperations extends SQLiteOpenHelper{

    String QUIERY="CREATE TABLE "+TableInfo.TABLE+"("+TableInfo.USERNAME+" text,"+TableInfo.PASSWORD+" text);";
    public DatabaseOperations(Context context) {
        super(context,TableInfo.DATABASE, null, 1);
    }


    public void putInfo(DatabaseOperations d,String user,String pass){

        SQLiteDatabase dp =d.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(TableInfo.USERNAME,user);
        cv.put(TableInfo.PASSWORD,pass);
        dp.insert(TableInfo.TABLE,null,cv);
    }
    public Cursor extractInfo(DatabaseOperations d){
        SQLiteDatabase dp =d.getReadableDatabase();
        String[] columns={TableInfo.USERNAME,TableInfo.PASSWORD};
        Cursor c=dp.query(TableInfo.TABLE,columns,null,null,null,null,null);
        return c;
    }
    public int createUserTable(DatabaseOperations d,String user){

        String USER_Q="CREATE TABLE "+user+"("+UserInfo.NOTES+" text);";
        SQLiteDatabase dp=d.getWritableDatabase();
        try {
            dp.execSQL(USER_Q);
        }catch(Exception e)
        {
            return 0;
        }
        return 1;
    }
    public Cursor extractNotesFromUser(DatabaseOperations d,String user){
        SQLiteDatabase dp =d.getReadableDatabase();
        String column[]={UserInfo.NOTES};
        Cursor c=dp.query(user,column,null,null,null,null,null);
        return c;
    }
    public void putNotesIntoUser(DatabaseOperations d,String user,String notes){
        SQLiteDatabase dp =d.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put(UserInfo.NOTES,notes);
        dp.insert(user,null,cv);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUIERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
