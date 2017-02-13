package com.example.zy_mac.okhttptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.send_request);
        responseText = (TextView)findViewById(R.id.response_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.send_request) {
                    sendRequestWithHttpURLConnection();
                }
            }
        });
    }
    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    RequestBody requestBody = RequestBody.create(JSON, "category:1");

                    Request request = new Request.Builder()
                            .url("https://dsk.des-works.cn/api/Article/articleList")
                            .post(requestBody)
                            .build();
//                    Log.d("MainActivity", "run: " + request.toString());
//                    Request request = new Request.Builder().url("https://www.baidu.com").build();

                    OkHttpClient client = new OkHttpClient.Builder().build();

                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }
}
