package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RssFeedListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<RssFeedModel> rssFeedList;
    private LayoutInflater inflater;

    public RssFeedListAdapter(Context context, ArrayList<RssFeedModel> rssFeedList) {
        this.context = context;
        this.rssFeedList = rssFeedList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return rssFeedList.size();
    }

    @Override
    public Object getItem(int position) {
        return rssFeedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemTitle = convertView.findViewById(R.id.item_title);
        TextView itemDescription = convertView.findViewById(R.id.item_description);

        RssFeedModel item = rssFeedList.get(position);

        itemTitle.setText(item.getTitle());
        itemDescription.setText(item.getDescription());

        if (item.getImageUrl() != null && !item.getImageUrl().isEmpty()) {
            Picasso.get().load(item.getImageUrl()).into(itemImage);
        } else {
            itemImage.setImageResource(R.drawable.baseline_newspaper_24);  // Add a placeholder image in your drawable resources
        }

        return convertView;
    }
}
