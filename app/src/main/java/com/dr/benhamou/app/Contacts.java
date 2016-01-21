package com.dr.benhamou.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.ButterKnife;

/**
 * Created by taras on 10.12.2015.
 */
public class Contacts extends Fragment implements AppBarLayout.OnOffsetChangedListener,OnMapReadyCallback {
    @Nullable

    protected HeaderView toolbarHeaderView;
    protected HeaderView floatHeaderView;
    protected AppBarLayout appBarLayout;
    protected Toolbar toolbar;
    private boolean isHideToolbarView = false;

    IsInternetExist isExist = new IsInternetExist();
    MapView mapView;
    GoogleMap map;

    ImageView facebook,twitter,gplus;
    CardView call_card,email_card;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact,container,false);
        facebook = (ImageView)v.findViewById(R.id.imageFacebook);
        twitter = (ImageView)v.findViewById(R.id.imageTwitter);
        gplus = (ImageView)v.findViewById(R.id.imageGoogle);
        call_card = (CardView)v.findViewById(R.id.call_card);
        email_card = (CardView)v.findViewById(R.id.email_card);





        social_link();
        ButterKnife.bind(v);
        floatHeaderView = (HeaderView) v.findViewById(R.id.float_header_view);
        toolbarHeaderView = (HeaderView)v.findViewById(R.id.toolbar_header_view);
        appBarLayout = (AppBarLayout) v.findViewById(R.id.appbar);

        mapView = (MapView) v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
//



        if (isExist.isNetworkConnected(getContext())==true) {
            mapView.getMapAsync(this);
        }
        initUi();







        call_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:0158051126"));
                    startActivity(callIntent);
                } catch (ActivityNotFoundException activityException) {
                    Log.i("Calling a Phone Number", "Call failed", activityException);
                }
            }
        });

        email_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"contact@dr-benhamou.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Message from Android");
                try {
                    startActivity(Intent.createChooser(i, "Choisissez client de messagerie"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(), "Il n'y a pas les clients de messagerie installés.", Toast.LENGTH_SHORT).show();
                }
            }
        });













        return v;

    }


    public void social_link(){
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
    }


    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(48.864147, 2.285462);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));
        map.addMarker(new MarkerOptions()
                .title("Paris")
                .snippet("12, avenue d'Eylau 75116")
                .position(sydney));
    }
    private void initUi() {


        appBarLayout.addOnOffsetChangedListener(this);

        toolbarHeaderView.bindTo("Docteur Frank Benhamou", "Chirurgien esthétique à Paris ");
        floatHeaderView.bindTo("Docteur Frank Benhamou", "Chirurgien esthétique à Paris ");
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        if (percentage == 1f && isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.VISIBLE);
            isHideToolbarView = !isHideToolbarView;

        } else if (percentage < 1f && !isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.GONE);
            isHideToolbarView = !isHideToolbarView;
        }
    }

}