package org.innovations.campusconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static org.innovations.campusconnect.getstartedcontroller.user;

public class menucontroller {


    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;

    @FXML
    void dashboard(MouseEvent event) {

        loadPage("dashboard");
    }

    @FXML
    void hostelfinder(MouseEvent event) {
        loadPage("starthostel");
    }

    @FXML
    void lecturerreview(MouseEvent event) {
        loadPage("startlecturerreview");
    }


    @FXML
    void lecturercoments(MouseEvent event) {
        loadPage("comments");
    }



    @FXML
    private Button starthostel;



    @FXML
    void starthostel(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hostelfinder.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage newStage = new Stage();;
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPage(String page) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
            bp.setCenter(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





    public void calc(ActionEvent actionEvent) {
    }

    public void submitinfo(ActionEvent actionEvent) {
    }

    public void startlecturer(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LecturerReview.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage newStage = new Stage();;
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}