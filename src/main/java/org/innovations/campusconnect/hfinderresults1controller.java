/* author
https://www.w3schools.com/java/java_files_create.asp
https://ioflood.com/blog/bufferedreader-java/#:~:text=BufferedReader%20in%20Java%20is%20a,characters%2C%20arrays%2C%20and%20lines
https://www.w3docs.com/snippets/java/accessing-a-variable-from-another-class.html

**/




package org.innovations.campusconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.List;


public class hfinderresults1controller {
    hostelfindercontroller campusDecision = new hostelfindercontroller();

    String newCampusDecision = campusDecision.getCampusDecision();

    @FXML
    private Button submitbutton2;

    @FXML
    private Text hostel1;
    @FXML
    private Text hostel2;
    @FXML
    private Text hostel3;

    @FXML
    private Text price1;

    @FXML
    private Text price2;

    @FXML
    private Text price3;

    private Stage stage;
    private Scene scene;

    private Parent root;

    @FXML
    private Label facilities1;

    @FXML
    private Label facilities2;

    @FXML
    private Label facilities3;

    List<String> topHostels = new ArrayList<>();
    List<Double> topPrices = new ArrayList<>();
    String line;
@FXML
private Label oneoption;

    @FXML
    private RadioButton selection1;

    @FXML
    private RadioButton selection2;

    @FXML
    private RadioButton selection3;

    @FXML
    private Button submitResults;


    // Initialize method that will be called when the FXML is loaded
    public void initialize() {
        // Read hostel information from file
        readHostelsFromFile();
        setTopHostelsAndPrices();
    }


    // Method to read hostel information from file
    public void readHostelsFromFile() {
        System.out.println(newCampusDecision);
        if (newCampusDecision == "on campus") {
            try (BufferedReader reader = new BufferedReader(new FileReader("on_campus_hostels.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Split each line by the delimiter ": "
                    String[] parts = line.split(": ");
                    // Format is "Hostel Name: Price"
                    topHostels.add(parts[0]);
                    topPrices.add(Double.parseDouble(parts[1]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader("off_campus_hostels.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Split each line by the delimiter ": "
                    String[] parts = line.split(": ");
                    // Format is "Hostel Name: Price"
                    topHostels.add(parts[0]);
                    topPrices.add(Double.parseDouble(parts[1]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // Method to set top hostel names in the GUI fields
    public void setTopHostelsAndPrices() {
        if (topHostels.size() >= 3 && topPrices.size() >= 3) {
            hostel1.setText(topHostels.get(0).substring(0, topHostels.get(0).indexOf(':')));
            hostel2.setText(topHostels.get(1).substring(0, topHostels.get(1).indexOf(':')));
            hostel3.setText(topHostels.get(2).substring(0, topHostels.get(2).indexOf(':')));
            price1.setText("GH¢" + String.valueOf(String.format("%.2f", topPrices.get(0))));
            price2.setText("GH¢" + String.valueOf(String.format("%.2f", topPrices.get(1))));
            price3.setText("GH¢" + String.valueOf(String.format("%.2f", topPrices.get(2))));
            facilities1.setText(topHostels.get(0).toString().substring(topHostels.get(0).toString().indexOf(':') + 1));
            facilities2.setText(topHostels.get(1).toString().substring(topHostels.get(1).toString().indexOf(':') + 1));
            facilities3.setText(topHostels.get(2).toString().substring(topHostels.get(2).toString().indexOf(':') + 1));

        }
    }

    String finalHostelChoiceUser;

    public void chooseFinalHostel(RadioButton selection1, RadioButton selection2, RadioButton selection3) {
        if (selection1.isSelected()) {
            finalHostelChoiceUser = hostel1.getText();

        }
        if (selection2.isSelected()) {
            finalHostelChoiceUser = hostel2.getText();

        }
        if (selection3.isSelected()) {
            finalHostelChoiceUser = hostel3.getText();

        }
    }

    @FXML
    void submitToFile(ActionEvent event) throws IOException {
        if(!selection1.isSelected() &&!selection2.isSelected()&&!selection3.isSelected()) {
            oneoption.setText("You haven't selected any hostels. Select one hostel");
            return;


        }
        root = FXMLLoader.load(getClass().getResource("hfinderresults2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void saveselection(MouseEvent mouseEvent) {
    }

    @FXML
    void assignFinalHostel1(ActionEvent actionEvent) {
        if (selection1.isSelected()) {
            finalHostelChoiceUser = hostel1.getText();
            writeFile(finalHostelChoiceUser);
        }

    }
    @FXML
     void assignFinalHostel2(ActionEvent actionEvent) {
        if (selection2.isSelected()) {
            finalHostelChoiceUser = hostel2.getText();
            writeFile(finalHostelChoiceUser);
        }
    }
    @FXML
    public void assignFinalHostel3(ActionEvent actionEvent) {
        if (selection3.isSelected()) {
            finalHostelChoiceUser = hostel3.getText();
            writeFile(finalHostelChoiceUser);
        }
    }

    public void writeFile(String text) {
        File file = new File("finalhostelresult.txt");

        try (FileWriter writer = new FileWriter(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }

            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}