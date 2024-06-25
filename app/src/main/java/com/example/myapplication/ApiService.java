package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("feeds/rss/uk.xml")
    Call<RssFeed> getRssFeed();
}
