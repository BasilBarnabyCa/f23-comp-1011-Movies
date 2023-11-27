package com.example.f23comp1011s2w2movies;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
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
    public static APIResponse searchMovies(String movieName, int page) throws IOException, InterruptedException {
        movieName = movieName.replaceAll(" ", "%20");

        String uri = "http://www.omdbapi.com/?apikey=c05b3979&s=" + movieName + "&page=" + page;

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

    public static MovieDetails getMovie(String movieId) throws IOException, InterruptedException {
        movieId = movieId.replaceAll(" ", "%20");
        String uri = "http://www.omdbapi.com/?apikey=c05b3979&i=" + movieId;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), MovieDetails.class);
    }

    /**
     * This method will read from "movies.json" and create an APIResponse object
     */
    public static APIResponse getMoviesFromFile()
    {
        //Create a GSON object.  GSON is the Google library that can read and write
        //JSON
        //in order to use this library, we need to update the pom.xml and module-info.java
        //files.  Don't forget to reload the Maven dependencies
        Gson gson = new Gson();

        APIResponse apiResponse = null;

        //open the file and pass it into the Gson object to covert JSON objects
        //to Java objects
        try(
                FileReader fileReader = new FileReader("movies.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            apiResponse = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return apiResponse;
    }
}