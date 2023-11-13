module com.example.f23comp1011s2w2movies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens com.example.f23comp1011s2w2movies to javafx.fxml;
    exports com.example.f23comp1011s2w2movies;
}