package com.dr.benhamou.app.news;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dr.benhamou.app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by taras on 23.12.2015.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private ArrayList<Data> newsDataSet;
    public Context mContext;
    private int lastPosition = -1;
    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView title;
        Button lire;
        ImageView picture,link;
        CardView container;
        public MyViewHolder(View itemView){
            super (itemView);
            this.picture = (ImageView)itemView.findViewById(R.id.news_back);
            this.title = (TextView)itemView.findViewById(R.id.news_titles);
            this.lire = (Button)itemView.findViewById(R.id.lire_plus);
            this.container = (CardView)itemView.findViewById(R.id.news_card_view);
            this.link = (ImageView)itemView.findViewById(R.id.share_button);
        }



    }

    public NewsAdapter(Context context, ArrayList<Data> news){
        this.newsDataSet= news;
        mContext=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_card, parent, false);

       // view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }




    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView textViewTitle = holder.title;
        Button buttonLire = holder.lire;
        ImageView back = holder.picture;
        final ImageView link = holder.link;
        //textViewName.setText(perfumeDataSet.get(listPosition).getName());
        textViewTitle.setText(newsDataSet.get(listPosition).getTitle());


        String src = newsDataSet.get(listPosition).getImage();
        Picasso.with(mContext)
                .load(src)
                .fit().centerCrop()
                .into(back);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/*");
                //Uri uri = Uri.fromFile(file);
               // shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Consultez cet article sur Dr.Benhamou.com -"+link);
                mContext.startActivity(shareIntent);
            }
        });

        buttonLire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, News_detail_activity.class);
                intent.putExtra("id", String.valueOf(newsDataSet.get(listPosition).getId()));
                intent.putExtra("img", newsDataSet.get(listPosition).getImage());
                intent.putExtra("link",newsDataSet.get(listPosition).getLink());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        setAnimation(holder.container, listPosition);

    }

    private void setAnimation(View viewToAnimate, int listPosition) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (listPosition > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = listPosition;
        }

    }

    @Override
    public int getItemCount() {
        return newsDataSet.size();
    }





}
