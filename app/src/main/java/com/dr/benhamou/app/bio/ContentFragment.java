package com.dr.benhamou.app.bio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.dr.benhamou.app.R;
import com.squareup.picasso.Picasso;

/**
 * Created by taras on 10.09.2015.
 */
public class ContentFragment extends Fragment {
    @Nullable
    ImageView facebook,twitter,gplus;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment,container,false);
        facebook = (ImageView)v.findViewById(R.id.imageFacebook);
        twitter = (ImageView)v.findViewById(R.id.imageTwitter);
        gplus = (ImageView)v.findViewById(R.id.imageGoogle);
      //  Picasso.with(getActivity()).load(R.drawable.facebook).resize(100,100).into(facebook);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/docteurfranckbenhamou?ref=hl")), "Ouvrir avec:"));
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/chiresthetique")), "Ouvrir avec:"));
            }
        });
        gplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/+DrFranckBenhamouChirurgienEsth%C3%A9tiqueParis")), "Ouvrir avec:"));
            }
        });






        return v;
    }
}
