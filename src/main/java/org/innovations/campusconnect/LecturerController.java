package org.innovations.campusconnect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LecturerController {

    @FXML
    private Label confirmation;
    @FXML
    private Label errorcomment;
    @FXML
    private ComboBox<String> lecturerCourse;

    @FXML
    private ComboBox<String> lecturerDepartments;

    @FXML
    private ComboBox<String> lecturerNames;

    @FXML
    private TextField studentComment;

    @FXML
    private Button submitCommentButton;



    private String[] populateArray = {
            "Computer Science and Information Systems",
            "Business Administration and Economics",
            "Humanities and Social Sciences"
    };

    private String[] populateAnotherArray = {
            "Object Oriented Programming", "Discrete Structures and Theories", "Text and Meaning", "Calculus 2", "Written and Oral Communication", "Foundation of Design and Entrepreneurship", "Leadership 1", "Leadership 2"
    };

    private String[] populateYetAnotherArray = {
            "David Ebo", "Maame Yaa", "Jewel Thompson", "Joseph Mensah", "Patrick Dwomfuor", "Kwaku Attakora", "Kwabena Bamfo", "Kwame Aquah", "Ayorkor Korsah", "Prince Baah", "Govindah"
    };

    @FXML
    private void initialize() {
        lecturerDepartments.getItems().addAll(populateArray);
        lecturerNames.getItems().addAll(populateYetAnotherArray);
        lecturerCourse.getItems().addAll(populateAnotherArray);
    }

    @FXML
    private void addComment(ActionEvent actionEvent) throws IOException {
        String lecturerName = lecturerNames.getValue(); // Use getValue() instead of getText()
        String selectedDepartment = lecturerDepartments.getValue();
        String comment = studentComment.getText();





        // Check if any field is empty
        if (lecturerName == null || selectedDepartment == null || comment.isEmpty()) {
            errorcomment.setText("Please fill all fields.");

            return;
        }

        // Call the findLecturerByNameAndDepartment method to find the lecturer and add the comment
        Teacher lecturer = Teacher.findLecturerByNameAndDepartment(lecturerName, selectedDepartment, comment);
        if (lecturer != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("comments.txt", true))) {
                // Write the comment to a file
                String finalSaying ="\n Lecturer " + lecturerName + " of department: " + selectedDepartment + "\nComments: " + comment ;
                writer.write(finalSaying + "\n");
                confirmation.setText("You have successfully added a comment to " + lecturerName);
            } catch (IOException e) {
                e.printStackTrace();
                confirmation.setText("Failed to write comment to file.");
            }
        } else {
            confirmation.setText(lecturerName + " has not been found.");
        }





}
}
