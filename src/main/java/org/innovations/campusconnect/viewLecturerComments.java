package org.innovations.campusconnect;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class viewLecturerComments {
    @FXML
    private Text viewComments;

    @FXML
    public void initialize() {
        viewComments.setText(readFile());
    }

    @FXML
    void closewindow(ActionEvent event) {
        // Get a reference to the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Close the stage
        stage.close();
    }

    private String readFile() {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Path.of("comments.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
