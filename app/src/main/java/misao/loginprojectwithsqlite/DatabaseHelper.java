package misao.loginprojectwithsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sonu on 1/31/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase sqLiteDatabase;

    public static String DBNAME="LoginSystem";

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table UserInfo(id INTEGER AUTO_INCREMENT PRIMARY KEY,Name varchar(50) NOT NULL,Email varchar(50) NOT NULL,Number varchar(50) NOT NULL,Password varchar(15))");
        this.sqLiteDatabase=sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        this.onCreate(sqLiteDatabase);
    }

    public void insert(String username,String email, String phone, String password)
    {    sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Name",username);
        cv.put("Email",email);
        cv.put("Number",phone);
        cv.put("Password",password);
        sqLiteDatabase.insert("UserInfo",null,cv);
    }

    public String getData(String mname,String pass)
    {
        sqLiteDatabase=this.getReadableDatabase();
        Cursor c=sqLiteDatabase.rawQuery("Select Password from UserInfo where Name='"+mname+"'",null);
        if (c.getCount()>0)
        {
            c.moveToFirst();
            if(c.getString(c.getColumnIndexOrThrow("Password")).contentEquals(pass)) {

                return "success";
            }
        }


        c.close();
        return null;
    }

}
