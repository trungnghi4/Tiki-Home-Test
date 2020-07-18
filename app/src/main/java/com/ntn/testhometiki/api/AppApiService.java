package com.ntn.testhometiki.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppApiService {
    @GET("keywords.json")
    Call<List<String>> getKeyWords();
}
