package com.example.f23comp1011s2w2movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.Objects;

public class MovieDetailsController implements LoadMovie {

    @FXML
    private ListView<String> actorsListView;

    @FXML
    private Label directorLabel;

    @FXML
    private Label genreLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label ratedLabel;

    @FXML
    private ListView<Rating> ratingsListView;

    @FXML
    private Label runTimeLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label writerLabel;

    @FXML
    void showSearch(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "search-view.fxml");
    }

    public void loadMovie(String movieId) {
        try {
            MovieDetails movieDetails = APIUtility.getMovie(movieId);
            titleLabel.setText(movieDetails.getTitle());
            ratedLabel.setText(movieDetails.getRated());
            runTimeLabel.setText(movieDetails.getRuntime());
            genreLabel.setText(movieDetails.getGenre());
            directorLabel.setText(movieDetails.getDirector());
            writerLabel.setText(movieDetails.getWriter());
            actorsListView.getItems().clear();
            actorsListView.getItems().addAll(movieDetails.getActorList());
            ratingsListView.getItems().clear();
            ratingsListView.getItems().addAll(movieDetails.getRatings());
            try {
                imageView.setImage(new Image(movieDetails.getPoster()));
            } catch (IllegalArgumentException e) {
                imageView.setImage(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/default_poster.png"))));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
