package com.example.himanshu.sqlregistration;

import android.provider.BaseColumns;

/**
 * Created by HIMANSHU on 2/22/2016.
 */
public class TableData {
    public TableData(){

    }
    public abstract class TableInfo implements BaseColumns{
        public static final String USERNAME="user_name";
        public static final  String PASSWORD="password";
        public static final String DATABASE="REGS";
        public static final String TABLE="test";

    }
    public abstract class UserInfo implements BaseColumns{
        public static final String NOTES="notes";
        public static final String DATABASE="REGS";

    }
}
