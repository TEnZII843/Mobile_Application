package bt.edu.sqliteapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String  DATABASE_NAME = "Student.db";
    public static final String  TABLE_NAME = "Student_table";
    public static final String  COL_1 = "ID";
    public static final String  COL_2 = "NAME";
    public static final String  COL_3 = "SURNAME";
    public static final String  COL_4 = "MARKS";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(" create Table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY," + "NAME TEXT , SURNAME TEXT, MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists "+ TABLE_NAME);
        onCreate(DB);
    }
    //insert data
    public boolean insertData(String id,String name,String surname,String marks){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result = DB.insert(TABLE_NAME, null ,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }

    }
    //update data
    public boolean updateData(String id,String name,String surname,String marks){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result = DB.update(TABLE_NAME, contentValues,"ID=?", new String[]{id});
        if (result!=0){
            return true;
        }
        return false;
    }


    //delete data
    public int deleteData(String id){
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.delete(TABLE_NAME,"ID=?", new String[]{id});
    }
//
    //delete dat
    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor res =  DB.rawQuery("Select * from "+TABLE_NAME, null);
        return res;
    }
}
