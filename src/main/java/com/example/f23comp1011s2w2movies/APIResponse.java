package com.example.f23comp1011s2w2movies;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class APIResponse {
    private String totalResults;

    @SerializedName("Response")
    private String response;

    @SerializedName("Search")
    private ArrayList<Movie> movies;

    /**
     * This method will return the total number of results
     * @return totalResults The total number of results
     */
    public String getTotalResults() {
        return totalResults;
    }

    /**
     * This method will return true if the response is "True"
     * @return response True if the response is "True"
     */
    public String getResponse() {
        return response;
    }

    /**
     * This method will return an ArrayList of Movies
     * @return movies An ArrayList of Movies
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
