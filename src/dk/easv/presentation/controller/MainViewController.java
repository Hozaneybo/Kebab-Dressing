package dk.easv.presentation.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private GridPane gridPane;

    private File directory;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        directory = new File("src/Image/Home");
        getRandomPictures();

    }

    @FXML
    void getHighestrated(MouseEvent event) {
        directory = new File("src/Image/Highest rated");
        getRandomPictures();

    }

    @FXML
    void getHistory(MouseEvent event) {
        directory = new File("src/Image/History");
        getRandomPictures();

    }

    @FXML
    void getLogout(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dk/easv/presentation/view/LogIn.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Movie Recommendation System 0.01 Beta");
        stage.show();


    }

    @FXML
    void getSimilarusers(MouseEvent event) {
        directory = new File("src/Image/users");
        getRandomPictures();

    }

    @FXML
    void getSuggestmovies(MouseEvent event) {
        directory = new File("src/Image/Suggested movies");
        getRandomPictures();

    }

    public void getHome(MouseEvent mouseEvent) {
        directory = new File("src/Image/Home");
        getRandomPictures();
    }

    private void getRandomPictures(){
        File[] imageFiles = directory.listFiles((dir, name) -> name.endsWith(".jpg") || name.endsWith(".png")); // add more file extensions if needed
        List<File> imageList = new ArrayList<>();
        Collections.addAll(imageList, imageFiles);


        for (int i = 0; i < gridPane.getChildren().size(); i++) {
            if (gridPane.getChildren().get(i) instanceof ImageView) {
                ImageView imageView = (ImageView) gridPane.getChildren().get(i);
                int randomIndex = (int) (Math.random() * imageList.size());
                File imageFile = imageList.get(randomIndex);
                Image image = new Image(imageFile.toURI().toString());
                imageView.setImage(image);
                imageList.remove(randomIndex);
            }
        }
    }
}
