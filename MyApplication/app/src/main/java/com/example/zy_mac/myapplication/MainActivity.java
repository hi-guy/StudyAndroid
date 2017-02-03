package com.example.zy_mac.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
//        myToolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
//        myToolbar.setNavigationIcon(R.mipmap.ic_launcher);
//        myToolbar.setTitle("Title");//设置主标题
//        myToolbar.setSubtitle("Subtitle");//设置子标题
        myToolbar.inflateMenu(R.menu.toolbar_menu);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_favorite:
                        Toast.makeText(MainActivity.this , R.string.menu_favorite , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.menu_settings:
                        Toast.makeText(MainActivity.this , R.string.menu_settings , Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        return false;

                }
            }
        });
    }
}
