package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class FeedListViewAdapter extends RecyclerView.Adapter<FeedListViewAdapter.RecyclerViewHolder> {

    private List<RssFeedModel> rssFeedModelList;
    private OnClickListener onClickListener;
    Context context;

    public FeedListViewAdapter(List<RssFeedModel> rssFeedModelList, OnClickListener onClickListener,Context context) {
        if(rssFeedModelList == null){
            rssFeedModelList = new ArrayList<>();
        }
        this.rssFeedModelList = rssFeedModelList;
        this.onClickListener = onClickListener;
        this.context=context;
    }






    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, onClickListener);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        RssFeedModel currentPlayer = rssFeedModelList.get(position);
        holder.mName.setText(currentPlayer.getTitle());
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.baseline_newspaper_24) // Placeholder image
                .error(R.drawable.logo) // Error image if image fails to load
                .diskCacheStrategy(DiskCacheStrategy.NONE) // Disable disk caching for now, or use .ALL if caching is needed
                .skipMemoryCache(true); // Disable memory caching for now, or use .ALL if caching is needed

        Glide.with(context)
                .load(currentPlayer.getImageUrl()) // Image URL
                .apply(requestOptions) // Apply RequestOptions
                .into(holder.mAge); // ImageView to display image

      //  holder.mAge.setText("Contact: " +currentPlayer.getImageUrl());
        holder.mPosition.setText(currentPlayer.getDescription());

    }

    @Override
    public int getItemCount() {
        return rssFeedModelList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mName;
        private ImageView mAge;
        private TextView mPosition;
        private OnClickListener mListener;

        public RecyclerViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            mName = itemView.findViewById(R.id.item_title);
            mAge = itemView.findViewById(R.id.item_image);
            mPosition = itemView.findViewById(R.id.item_description);
            this.mListener = onClickListener;

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            RssFeedModel rssFeedModel = rssFeedModelList.get(position);
               mListener.onCustomerClick(rssFeedModel);
        }
    }

    public interface OnClickListener {
        void onCustomerClick(RssFeedModel customer);
    }
}
