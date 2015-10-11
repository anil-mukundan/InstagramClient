package com.mukundan.www.instagramclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InstagramPhotoAdapter extends ArrayAdapter<InstagramPhoto> {
    public InstagramPhotoAdapter(Context context, ArrayList<InstagramPhoto> photos) {
        super(context, android.R.layout.simple_list_item_1, photos);
    }

    // Returns the view for each row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramPhoto photo = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);
        TextView tvLikeCount = (TextView) convertView.findViewById(R.id.tvLikeCount);
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        ImageView ivAvatar = (ImageView) convertView.findViewById(R.id.ivAvatar);

        tvUsername.setText(photo.username);
        if (!photo.location.equalsIgnoreCase("null")) {
            try {
                JSONObject location = new JSONObject(photo.location);
                tvLocation.setText(location.getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        tvLikeCount.setText(Integer.toString(photo.likeCount));
        tvCaption.setText(photo.caption);
        ivPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);

        ivAvatar.setImageResource(0);
        Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(50)
                .oval(false)
                .build();
        Picasso.with(getContext()).load(photo.avatar).transform(transformation).into(ivAvatar);

        return convertView;
    }
}

