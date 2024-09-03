package org.innovations.campusconnect;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static org.innovations.campusconnect.getstartedcontroller.user;

public class dashboardcontroller {

    @FXML
    private Label course;

    @FXML
    private Label fullname;


    @FXML
    private Label gradYear;

    @FXML
    private Label majOR;

    @FXML
    private Label stuID;

    @FXML
 void initialize() {
        fullname.setText(user.getName());
        stuID.setText(user.getStudentID());
        majOR.setText(user.getCourse());
        gradYear.setText(user.getGraduationYear());
    }
}
