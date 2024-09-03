package org.innovations.campusconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class getstartedcontroller {



    @FXML
    private AnchorPane ap;

    @FXML
    private Button continueButton;

    @FXML
    private TextField fullname;

    @FXML
    private TextField graduationYear;

    @FXML
    private TextField major;

    @FXML
    private TextField studID;

    private Stage stage;
    private Scene scene;

    private Parent root;



    @FXML
    private Button nextgetstarted;

    static public Student user;


    @FXML
    private Label course;

    @FXML
    private Label gradYear;


    @FXML
    private Label err1;

    @FXML
    private Label err2;

    @FXML
    private Label err3;


    @FXML
    void nextgetstarted(ActionEvent event) throws IOException {
        // Load the next page
        root = FXMLLoader.load(getClass().getResource("studentsignup.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void endgetstarted(ActionEvent event) throws IOException {
        boolean validInput = true;

        try {
            int sID = Integer.parseInt(studID.getText());
            int year = Integer.parseInt(graduationYear.getText());

            // Check if length of input is 8 for student ID
            if (String.valueOf(sID).length() != 8) {
                err1.setText("Student ID must be 8 digits long.");
                validInput = false;
            }

            // Check if length of input is 4 for graduation year
            if (String.valueOf(year).length() != 4) {
                err2.setText("Graduation year must be 4 digits long.");
                validInput = false;
            }
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            err3.setText("Invalid input for student ID or graduation year.");
            validInput = false;
        }

        if (validInput) {
            initializeStudent();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Close the stage
            stage.close();

            //open new window

            // Load the next page
            root = FXMLLoader.load(getClass().getResource("default.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    public void initializeStudent(){

        String fullnam = fullname.getText();
        String gradYear = graduationYear.getText();
        String nMajor = major.getText();
        String StudID =studID.getText();



        user = new Student(fullnam, StudID, nMajor,gradYear);

    }

}
