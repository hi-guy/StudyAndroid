package com.example.zy_mac.myapplication;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
//        myToolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
//        myToolbar.setNavigationIcon(R.mipmap.ic_launcher);
//        myToolbar.setTitle("Title");//设置主标题
//        myToolbar.setSubtitle("Subtitle");//设置子标题
//        myToolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_favorite:
//                        Toast.makeText(MainActivity.this , R.string.menu_favorite , Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(MainActivity.this, ChildActivity.class);
//                        startActivity(intent);
                        Log.d("dddd", "-------");
                        return true;

                    case R.id.menu_settings:
                        Toast.makeText(MainActivity.this , R.string.menu_settings , Toast.LENGTH_SHORT).show();
//                        Snackbar.make(toolbar,"Click More",Snackbar.LENGTH_SHORT).show();
                        return true;

                    default:
                        return false;

                }
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.menu_favorite);
//        SearchView searchView =
//                (SearchView) MenuItemCompat.getActionView(searchItem);

        // Configure the search info and add any event listeners...
        MenuItemCompat.OnActionExpandListener expandListener = new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when action item collapses
                Log.d("dddd", "-------");
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                Log.d("dddd", "=======");
                return true;  // Return true to expand action view
            }
        };

        // Get the MenuItem for the action item
//        MenuItem actionMenuItem = menu.findItem(R.id.myActionItem);

        // Assign the listener to that action item
        MenuItemCompat.setOnActionExpandListener(searchItem, expandListener);

        return super.onCreateOptionsMenu(menu);
    }

}
