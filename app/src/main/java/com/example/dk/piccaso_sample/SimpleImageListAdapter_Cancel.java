package com.example.dk.piccaso_sample;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by dk on 10-04-2017.
 */

public class SimpleImageListAdapter_Cancel extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;

    private String[] imageUrls;

    public SimpleImageListAdapter_Cancel(Context context, String[] imageUrls) {
        super(context, R.layout.listview_item_image, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.listview_item_image, parent, false);
        }

        ImageView imageView = (ImageView) convertView;

        if (TextUtils.isEmpty(imageUrls[position])) {
            // option 1: cancel Picasso request and clear ImageView
            Picasso
                    .with(context)
                    .cancelRequest(imageView);

            imageView.setImageDrawable(null);

            // option 2: load placeholder with Picasso
        /*
        Picasso
                .with(context)
                .load(R.drawable.floorplan)
                .into(imageView);
        */
        } else {
            Picasso
                    .with(context)
                    .load(imageUrls[position])
                    .fit() // will explain later
                    .into(imageView);
        }

        return convertView;
    }
}