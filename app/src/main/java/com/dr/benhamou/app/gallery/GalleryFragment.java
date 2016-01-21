package com.dr.benhamou.app.gallery;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.dr.benhamou.app.MainActivity;
import com.dr.benhamou.app.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

/**
 * Created by nedye on 05.01.2016.
 */
public class GalleryFragment extends Fragment implements BaseSliderView.OnSliderClickListener {
    @Nullable

    private SliderLayout mDemoSlider,mDemoSlider1, mDemoSlider2;
    View v;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.gallery_layout,container,false);

        setUpSlider();
        setUpSlider1();
        setUpSlider2();






        //mDemoSlider.addOnPageChangeListener(this);


        return v;
    }


    public void setUpSlider (){
    mDemoSlider = (SliderLayout)v.findViewById(R.id.slider);
    HashMap<String,String> url_maps = new HashMap<String, String>();
    url_maps.put("Visage 1", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-1.jpg");
    url_maps.put("Visage 2", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-2.jpg");
    url_maps.put("Visage 3", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-3.jpg");
    url_maps.put("Visage 4", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-4.jpg");
    url_maps.put("Visage 5", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-5.jpg");
    url_maps.put("Visage 6", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-6.jpg");
    url_maps.put("Visage 7", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-7.jpg");
    url_maps.put("Visage 8", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-8.jpg");
    url_maps.put("Visage 9", "http://dr-benhamou.com/wp-content/uploads/2014/09/face-lift-9.jpg");


    for(String name : url_maps.keySet()){
        TextSliderView textSliderView = new TextSliderView(MainActivity.mContext);
        textSliderView
                .description(name)
                .image(url_maps.get(name))
                .setOnSliderClickListener(this)
                .setScaleType(BaseSliderView.ScaleType.Fit);
        textSliderView.bundle(new Bundle());
        textSliderView.getBundle()
                .putString("extra", url_maps.get(name));

        mDemoSlider.addSlider(textSliderView);
    }
    mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
    mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
    mDemoSlider.setCustomAnimation(new DescriptionAnimation());
    mDemoSlider.setDuration(4000);

}

    public void setUpSlider1 (){
        mDemoSlider1 = (SliderLayout)v.findViewById(R.id.slider1);
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Silhouette 1", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction1.jpg");
        url_maps.put("Silhouette 2", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction2.jpg");
        url_maps.put("Silhouette 3", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction3.jpg");
        url_maps.put("Silhouette 4", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction4.jpg");
        url_maps.put("Silhouette 5", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction5.jpg");
        url_maps.put("Silhouette 6", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction6.jpg");
        url_maps.put("Silhouette 7", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction7.jpg");
        url_maps.put("Silhouette 8", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction8.jpg");
        url_maps.put("Silhouette 9", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction9.jpg");
        url_maps.put("Silhouette 10", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction10.jpg");
        url_maps.put("Silhouette 11", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction12.jpg");
        url_maps.put("Silhouette 12", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction13.jpg");
        url_maps.put("Silhouette 13", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction14.jpg");
        url_maps.put("Silhouette 14", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction15.jpg");
        url_maps.put("Silhouette 15", "http://dr-benhamou.com/wp-content/uploads/2014/09/liposuction16.jpg");



        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(MainActivity.mContext);
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setOnSliderClickListener(this)
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", url_maps.get(name));

            mDemoSlider1.addSlider(textSliderView);
        }
        mDemoSlider1.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider1.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider1.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider1.setDuration(4000);
    }

    public void setUpSlider2() {
        mDemoSlider2 = (SliderLayout) v.findViewById(R.id.slider2);
        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Poitrine 1", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine1.jpg");
        url_maps.put("Poitrine 2", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine2.jpg");
        url_maps.put("Poitrine 3", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine3.jpg");
        url_maps.put("Poitrine 4", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine4.jpg");
        url_maps.put("Poitrine 5", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine5.jpg");
        url_maps.put("Poitrine 6", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine6.jpg");
        url_maps.put("Poitrine 7", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine7.jpg");
        url_maps.put("Poitrine 8", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine8.jpg");
        url_maps.put("Poitrine 9", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine9.jpg");
        url_maps.put("Poitrine 11", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine11.jpg");
        url_maps.put("Poitrine 11", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine11.jpg");
        url_maps.put("Poitrine 12", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine12.jpg");
        url_maps.put("Poitrine 13", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine13.jpg");
        url_maps.put("Poitrine 14", "http://dr-benhamou.com/wp-content/uploads/2014/09/Poitrine14.jpg");



        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(MainActivity.mContext);
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setOnSliderClickListener(this)
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", url_maps.get(name));

            mDemoSlider2.addSlider(textSliderView);
        }
        mDemoSlider2.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider2.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider2.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider2.setDuration(4000);
    }












    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }


    public void onSliderClick(BaseSliderView slider) {
        Dialog builder = new Dialog(getActivity());
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(getActivity());

        Picasso.with(getActivity())
                .load(slider.getBundle().get("extra").toString())
                .resize(1200,700)
                .into(imageView);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        builder.show();



      //  Toast.makeText(MainActivity.mContext,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}


    public void onPageSelected(int position) {
        Log.i("Slider Demo", "Page Changed: " + position);
    }


    public void onPageScrollStateChanged(int state) {}


}
