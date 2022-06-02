package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;
import com.codepath.asynchttpclient.AsyncHttpClient;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String Now_Playing_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.thecatapi.com/v1/images/search", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                // Access a JSON array response with `json.jsonArray`
                Log.d("DEBUG ARRAY", json.jsonArray.toString());
                // Access a JSON object response with `json.jsonObject`
                Log.d("DEBUG OBJECT", json.jsonObject.toString());
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {

            }
        });
        RequestParams params = new RequestParams();
        params.put("limit", "5");
        params.put("page", "0");
        client.get("https://api.thecatapi.com/v1/images/search", params, new TextHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Headers headers, String response) {
                        // called when response HTTP status is "200 OK"
                    }

                    @Override
                    public void onFailure(int statusCode, Headers headers, String errorResponse, Throwable t) {
                        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                    }
                }
        );
    }
}