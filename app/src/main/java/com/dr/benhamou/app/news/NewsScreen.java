package com.dr.benhamou.app.news;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dr.benhamou.app.IsInternetExist;
import com.dr.benhamou.app.MainActivity;
import com.dr.benhamou.app.R;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by taras on 23.12.2015.
 */
public class NewsScreen extends Fragment {
    @Nullable
    private static ArrayList<Data> newsData;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    IsInternetExist isExist = new IsInternetExist();
    OkHttpClient client;
    Response response;
    static private ProgressBar bar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.news_layout, container, false);
        client = new OkHttpClient();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        bar = (ProgressBar) v.findViewById(R.id.progressBar);
        if(isExist.isNetworkConnected(getActivity())==true) {
            new getPosts().execute();
        }
        else {
            Toast.makeText(getActivity(),"Pas de connection",Toast.LENGTH_SHORT).show();
        }
        return v;
    }







    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public class getPosts extends AsyncTask<String,Integer, Void>{



        @Override
        protected void onPreExecute() {

            bar.setVisibility(View.VISIBLE);


            // dialog.show();
        }
        String url;
        int count;
        protected Void doInBackground(String... params) {
            newsData = new ArrayList<Data>();

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://dr-benhamou.com/api/get_posts/?count=50")
                            .build();
                    Response responses = null;

                    try {
                        responses = client.newCall(request).execute();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        String jsonData = responses.body().string();
                        //Log.i("ANSWER1", jsonData);
                        JSONObject json_object = new JSONObject(jsonData);
                        JSONArray jsonArray = json_object.getJSONArray("posts");

                        Log.i("COUNT", String.valueOf(jsonArray.length()));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject c = jsonArray.getJSONObject(i);

                                JSONArray atach = c.getJSONArray("attachments");
                            if(!atach.isNull(0)){
                                JSONObject Position = atach.getJSONObject(0);
                                url = Position.getString("url");}
                            else if (c.has("thumbnail")) {
                                url=c.getString("thumbnail");
                            }



                           else  {url="http://dr-benhamou.com/wp-content/uploads/2014/09/Dr-Franck-BENHAMOU.jpg";}



                            newsData.add(new Data(c.getInt("id"), c.getString("title"), url,c.getString("url")));

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException er) {
                        er.printStackTrace();
                    }


            return null;
        }
        protected void onPostExecute(Void v){
            bar.setVisibility(View.GONE);
            adapter = new NewsAdapter(MainActivity.mContext,newsData);
            recyclerView.setAdapter(adapter);

        }

    }













}