package com.example.f23comp1011s2w2movies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class APIResponse {
    private String totalResults;

    @SerializedName("Response")
    private String response;

    @SerializedName("Search")
    private Movie[] movies;

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public Movie[] getMovies() {
        return movies;
    }
}
