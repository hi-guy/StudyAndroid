package com.example.zy_mac.mydatabasehelper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
    }

    public void createDatabase(View v) {
        myDatabaseHelper.getWritableDatabase();
    }

    public void addData(View v) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "the da vinci code");
        values.put("author", "dan brown");
        values.put("pages", 45);
        values.put("price", 16);
        db.insert("Book", null, values);
        values.clear();
        values.put("name", "11111");
        values.put("author", "222222");
        values.put("pages", 4335);
        values.put("price", 1644.2);
        db.insert("Book", null, values);
    }

    public void updateData(View v) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("price", 5);
        db.update("Book", values, "name = ?", new String[] {"the da vinci code"});
    }

    public void deleteData(View v) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        db.delete("Book", "pages > ?", new String[] {"500"});
    }

    public void queryData(View v) {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.d(TAG, name);
                Log.d(TAG, author);
                Log.d(TAG, "" + pages);
                Log.d(TAG, "" + price);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
