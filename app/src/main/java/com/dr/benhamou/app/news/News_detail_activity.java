package com.dr.benhamou.app.news;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.benhamou.app.IsInternetExist;
import com.dr.benhamou.app.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class News_detail_activity extends AppCompatActivity {
    IsInternetExist isExist = new IsInternetExist();
    OkHttpClient client;
    Response response;
    ImageView news_main_back,share_button;
    TextView news_main_title;
    int id;
    String img,link;
    WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail_activity);
        news_main_back = (ImageView) findViewById(R.id.news_main_back);
        news_main_title = (TextView) findViewById(R.id.news_main_title);

        share_button = (ImageView) findViewById(R.id.share_button);
        wb = (WebView) findViewById(R.id.webView);


        Intent intent = getIntent();
        id = Integer.valueOf(intent.getStringExtra("id"));
        img = intent.getStringExtra("img");
        link = intent.getStringExtra("link");
        Picasso.with(this)
                .load(img)
                .fit().centerCrop()
                .into(news_main_back);
        client = new OkHttpClient();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if(isExist.isNetworkConnected(getApplicationContext())==true){
            new get_post().execute();
        }


        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/*");
                //Uri uri = Uri.fromFile(file);
                // shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Consultez cet article sur Dr.Benhamou.com -"+link);
                getApplicationContext().startActivity(shareIntent);
            }
        });


    }

    String content,title;
    public class get_post extends AsyncTask <String,Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... params) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://dr-benhamou.com/api/get_post/?post_id="+id)
                    .build();
            Response responses = null;

            try {
                responses = client.newCall(request).execute();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try{
                String jsonData = responses.body().string();
                Log.i("ANSWER1", jsonData);
                JSONObject json_object = new JSONObject(jsonData);
                JSONObject c = json_object.getJSONObject("post");
                content= c.getString("content");
                title=c.getString("title");
               // content = content.substring(1056);
               // content = content.replace("<!--"," ");
               // content = content.replace("//-->"," ");
               // content = content.replace("if(wpa2a)wpa2a.script_load();"," ");
               // content = content.replace("//"," ");
              //  content = content.replace("%"," ");
              // Log.i("CONTENT",c.getString("content"));



            }catch (JSONException e){e.printStackTrace();} catch (IOException io){io.printStackTrace();}







            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
          //  news_main_content.setText(Html.fromHtml(content));
            news_main_title.setText(title);
          //  wb.getSettings().setJavaScriptEnabled(true);
           // wb.getSettings().setBlockNetworkImage(true);
            wb.getSettings().setLoadsImagesAutomatically(true);
            wb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            wb.loadData(content,"text/html; charset=UTF-8", null);





            super.onPostExecute(aVoid);
        }
    }













    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_detail_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
