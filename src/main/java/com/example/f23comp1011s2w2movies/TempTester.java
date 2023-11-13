package com.example.f23comp1011s2w2movies;

import java.io.IOException;

public class TempTester {
    public static void main(String[] args) throws IOException, InterruptedException {
        APIResponse apiResponse = APIUtility.searchMovies("Infinity War");
        System.out.println(apiResponse);
    }
}
