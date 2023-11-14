package com.example.f23comp1011s2w2movies;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class APIUtility {
    /**
     * This method will search the OMDB API for a movie with
     * the given name
     * @param movieName The name of the movie to search for
     */
    public static APIResponse searchMovies(String movieName) throws IOException, InterruptedException {
        movieName = movieName.replaceAll(" ", "%20");

        String uri = "http://www.omdbapi.com/?apikey=c05b3979&s=" + movieName;

        // Configure the environment to make HTTP requests (this includes an update to the module-info.java file)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        // Write json response to a file
        // HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofFile(Paths.get("movies.json")));

        // Write json to a Java Object
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        // System.out.println(httpResponse.body());

        // IMPORTANT: lease make sure to update the pop.xml and module-info.java file to handle GSON
        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), APIResponse.class);

    }
}