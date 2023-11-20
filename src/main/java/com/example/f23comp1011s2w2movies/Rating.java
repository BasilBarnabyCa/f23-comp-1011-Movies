package com.example.f23comp1011s2w2movies;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("Source")
    private String source;

    @SerializedName("Value")
    private String value;

    @Override
    public String toString() {
        return String.format("%s: %s", source, value);
    }
}
