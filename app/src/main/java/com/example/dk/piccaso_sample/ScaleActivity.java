package com.example.dk.piccaso_sample;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.dk.piccaso_sample.ListActivity.eatFoodyImages;

public class ScaleActivity extends AppCompatActivity {

    @BindView(R.id.imageView2)
    ImageView image2;
    @BindView(R.id.imageView3)
    ImageView image3;
    @BindView(R.id.imageView4)
    ImageView image4;
    @BindView(R.id.imageView5)
    ImageView image5;
    @BindView(R.id.imageView6)
    ImageView image6;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        context = getApplicationContext();

        Picasso
                .with(context)
                .load(eatFoodyImages[0])
                .resize(600, 200) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(image2);

        Picasso
                .with(context)
                .load(eatFoodyImages[0])
                .resize(6000, 2000)
                .onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                .into(image3);

        Picasso
                .with(context)
                .load(eatFoodyImages[0])
                .resize(600, 200) // resizes the image to these dimensions (in pixel)
                .centerCrop()
                .into(image4);

        Picasso
                .with(context)
                .load(eatFoodyImages[0])
                .resize(600, 200)
                .centerInside()
                .into(image5);

        Picasso
                .with(context)
                .load(eatFoodyImages[0])
                .fit()
                // call .centerInside() or .centerCrop() to avoid a stretched image
                .into(image6);
    }

}
