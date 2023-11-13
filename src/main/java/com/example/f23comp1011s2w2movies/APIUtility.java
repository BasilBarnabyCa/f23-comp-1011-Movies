package com.example.f23comp1011s2w2movies;

public class APIUtility {
    /**
     * This method will search the OMDB API for a movie with the given name
     * @param movieName
     */
    public static void searchMovies(String movieName)
    {
        String uri = "http://www.omdbapi.com/?apikey=c05b3979&s=" + movieName;

        // Configure the environment to make HTTP requests (this includes an update to the module-info.java file)

    }
}