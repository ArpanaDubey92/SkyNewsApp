package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.rss.Item;
import com.example.myapplication.rss.Rssfeed;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FeedListViewAdapter.OnClickListener {

    private RecyclerView rssFeedListView;
    private ArrayList<RssFeedModel> rssFeedList;
    private FeedListViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView pageTitle = findViewById(R.id.page_title);
        pageTitle.setText("Sky News RSS Feed");

        rssFeedListView = findViewById(R.id.rss_feed_list);
        rssFeedList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rssFeedListView.setLayoutManager(linearLayoutManager);
        rssFeedListView.setHasFixedSize(true);

        adapter = new FeedListViewAdapter(rssFeedList,this,getApplicationContext());

        rssFeedListView.setAdapter(adapter);
      /*  rssFeedListView.setOnItemClickListener((parent, view, position, id) -> {
            RssFeedModel item = rssFeedList.get(position);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLink()));
            startActivity(browserIntent);
        });*/

        fetchRssFeed();
    }

    private void fetchRssFeed() {
        ApiService apiService =RetrofitClient.getInstance().create(ApiService.class);
        apiService.getRssFeed().enqueue(new Callback<RssFeed>() {
            @Override
            public void onResponse(Call<RssFeed> call, Response<RssFeed> response) {
                if (response.isSuccessful() && response.body() != null) {
                  //  List<Rssfeed> items = response.body().getChannel().getItemList();
                    Rssfeed rss = response.body();
                    List<Item> items = response.body().getChannel().getItems();
                    for (Item item: items) {
                        rssFeedList.add(new RssFeedModel(item.getTitle(),rss.getChannel().getDescription(),item.getLink(), item.getLink()));

                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Failed to fetch RSS feed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RssFeed> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to fetch RSS feed", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCustomerClick(RssFeedModel rssFeedModel) {
      //  RssFeedModel item = rssFeedList.get(position);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rssFeedModel.getLink()));
        startActivity(browserIntent);
    }
}
