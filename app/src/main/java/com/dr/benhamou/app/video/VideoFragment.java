package com.dr.benhamou.app.video;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.dr.benhamou.app.Config;
import com.dr.benhamou.app.IsInternetExist;
import com.dr.benhamou.app.R;
import com.dr.benhamou.app.news.News_detail_activity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by nedye on 07.01.2016.
 */
public class VideoFragment extends Fragment{
    @Nullable
    IsInternetExist isExist = new IsInternetExist();
    View v;
    ImageView vid1,vid2,vid3,vid4;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.video_layout,container,false);
        vid1 = (ImageView)v.findViewById(R.id.video1);
        vid2 = (ImageView)v.findViewById(R.id.video2);
        vid3 = (ImageView)v.findViewById(R.id.video3);
        vid4 = (ImageView)v.findViewById(R.id.video4);

        vid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExist.isNetworkConnected(getActivity())==true) {
                    Intent intent = new Intent(getActivity(), VideoDetail.class);
                    intent.putExtra("url", "http://dr-benhamou.com/wp-content/uploads/2014/09/cabinet-de-chirurgie-esthetique-paris%20trocadero.mp4");
                    intent.putExtra("name", "Cabinet de chirurgie esthetique paris trocadero");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getActivity().startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Pas de connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
        vid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExist.isNetworkConnected(getActivity())==true) {
                    Intent intent = new Intent(getActivity(), VideoDetail.class);
                    intent.putExtra("url", "http://dr-benhamou.com/wp-content/uploads/2014/09/Dr-Franck-Benhamou.mp4");
                    intent.putExtra("name", "Dr Franck Benhamou «c’est ma vie» M6");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getActivity().startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Pas de connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
        vid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExist.isNetworkConnected(getActivity())==true) {
                    Intent intent = new Intent(getActivity(), VideoDetail.class);
                    intent.putExtra("url", "http://dr-benhamou.com/wp-content/uploads/2014/09/Eylau-Consultation.mp4");
                    intent.putExtra("name", "Eylau Consultation");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getActivity().startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Pas de connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
        vid4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExist.isNetworkConnected(getActivity())==true) {
                    Intent intent = new Intent(getActivity(), VideoDetail.class);
                    intent.putExtra("url", "http://dr-benhamou.com/wp-content/uploads/2014/09/chirurgie-esthetique-mammaire.mp4");
                    intent.putExtra("name", "France guyane 27 avril");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getActivity().startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Pas de connection", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return v;
    }







}
