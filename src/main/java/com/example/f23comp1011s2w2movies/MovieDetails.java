package com.example.f23comp1011s2w2movies;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class MovieDetails {
    @SerializedName("Actors")
    private String actors;

    @SerializedName("Director")
    private String director;

    @SerializedName("Genre")
    private String genre;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Rated")
    private String rated;

    @SerializedName("Ratings")
    private Rating[] ratings;

    public String getActors() {
        return actors;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getPoster() {
        return poster;
    }

    public String getRated() {
        return rated;
    }

    public Rating[] getRatings() {
        return ratings;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    @SerializedName("Runtime")
    private String runtime;

    @SerializedName("Title")
    private String title;

    @SerializedName("Writer")
    private String writer;

    public List<String> getActorList()
    {
        return Arrays.asList(actors.split(", "));
    }
}
