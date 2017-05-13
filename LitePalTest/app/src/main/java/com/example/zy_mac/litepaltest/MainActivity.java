package com.example.zy_mac.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

import javax.sql.DataSource;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createDatabase(View v) {
        LitePal.getDatabase();
    }

    public void addData(View v) {
        Book book = new Book();
        book.setName("ni hao");
        book.setAuthor("Zhou Yi");
        book.setPages(1000);
        book.setPrice(45.5);
        book.setPress("Unknow");
        book.save();
    }

    public void updateData(View v) {
//        Book book = new Book();
//        book.setName("ni hao 2");
//        book.setAuthor("Zhou Yi 2");
//        book.setPages(10000);
//        book.setPrice(45.5);
//        book.setPress("Unknow 2");
//        book.save();
//        book.setPrice(10);
//        book.save();

//        Book book = new Book();
//        book.setPrice(200.0);
//        book.setPress("Anchor");
//        book.updateAll("name = ? and author = ?", "ni hao 2", "Zhou Yi 2");

        // 调用setToDefault设置默认值，而不是setPages(0)。
        Book book = new Book();
        book.setToDefault("pages");
        book.updateAll();
    }

    public void deleteData(View v) {
        DataSupport.deleteAll(Book.class, "price < ?", "100");
    }

    public void queryData(View v) {
        List<Book> books = DataSupport.findAll(Book.class);
        for (Book book: books) {
            Log.d(TAG, book.getName());
            Log.d(TAG, book.getAuthor());
            Log.d(TAG, "" + book.getPages());
            Log.d(TAG, "" + book.getPrice());
            Log.d(TAG, book.getPress());
        }
    }
}
