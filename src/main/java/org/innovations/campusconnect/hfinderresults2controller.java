package org.innovations.campusconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



public class hfinderresults2controller {




    @FXML
    private Button closewindow;
    public String finalHostelName;


    @FXML
    private Text finalHostelChosen;


    @FXML
    public void  initialize(){
        finalHostelChosen.setText(readFile());
    }
    @FXML
    void closewindow(ActionEvent event) {
// Get a reference to the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Close the stage
        stage.close();

    }

    public String readFile() {
        String content = "";

        try {
            content = new String(Files.readAllBytes(Path.of("finalhostelresult.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }




}
