package com.example.f23comp1011s2w2movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MoviesController {
    @FXML
    private ListView<Movie> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private Label infoLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    private ArrayList<LocalDateTime> apiCallTimes;

    @FXML
    private void initialize() {
        progressBar.setVisible(false);
        selectedVBox.setVisible(false);
        apiCallTimes = new ArrayList<>();
        resultsBox.setVisible(false);
        msgLabel.setVisible(false);
        infoLabel.setText("");

        // Configure the list view with a listener so that when a movie is selected it will show the poster art
        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldValue, movieSelected) -> {
                    if (movieSelected != null)
                    {
                        selectedVBox.setVisible(true);
                        try {
                            posterImageView.setImage(new Image(movieSelected.getPosterArt()));
                        } catch (IllegalArgumentException e) {
                            msgLabel.setVisible(true);
                            posterImageView.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/default_poster.png"))));
                        }
                    }
                });
    }

    @FXML
    void getMovies(ActionEvent event) throws IOException, InterruptedException {
        String movieName = searchTextField.getText();
        resultsBox.setVisible(false);
        msgLabel.setVisible(false);
        infoLabel.setText("");
        clearOldTimeStamps();

        if (!movieName.trim().isEmpty())
        {
            apiCallTimes.add(LocalDateTime.now());
            if(apiCallTimes.size() < 30)
            {
                APIResponse apiResponse = APIUtility.searchMovies(movieName.trim());
                if(apiResponse.getMovies() != null) {
                    resultsBox.setVisible(true);
                    listView.getItems().clear();
                    listView.getItems().addAll(apiResponse.getMovies());
                    infoLabel.setText("Showing " + apiResponse.getMovies().length + " of " + apiResponse.getTotalResults() + " results");
                } else {
                    msgLabel.setVisible(true);
                    msgLabel.setText("No movies found");
                }
            }
        }
        else
        {
            msgLabel.setVisible(true);
            msgLabel.setText("Please enter a movie name");
        }
    }

    @FXML
    private void showDetails(ActionEvent event) throws IOException {
        Movie selectedMovie = listView.getSelectionModel().selectedItemProperty().getValue();
        SceneChanger.changeScenes(event, "details-view.fxml", selectedMovie.getImdbID());
    }

    private void clearOldTimeStamps()
    {
        List<LocalDateTime> validTimes = (apiCallTimes.stream()
                .filter(timeStamp -> Duration.between(timeStamp, LocalDateTime.now()).toSeconds() < 60)
                .toList());

        apiCallTimes.clear();
        apiCallTimes.addAll(validTimes);
    }

}
