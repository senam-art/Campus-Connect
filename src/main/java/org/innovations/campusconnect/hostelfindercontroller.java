/* Author
https://stackoverflow.com/questions/27767107/access-returnvalue-from-another-class
https://www.baeldung.com/java-buffered-reader
 */
package org.innovations.campusconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class hostelfindercontroller {

    @FXML
    private Text errlabel1;

    @FXML
    private Text errlabel2;

    @FXML
    private TextField budget;

    @FXML
    private ToggleGroup campusLocation;

    @FXML
    private CheckBox closetocampus;

    @FXML
    private CheckBox hasagenerator;

    @FXML
    private CheckBox hasakitchen;

    @FXML
    private CheckBox hasgoodwifi;

    @FXML
    private RadioButton offcampusbutton;

    @FXML
    private RadioButton oncampusbutton;

    @FXML
    private Button submitbutton;

    @FXML
    private Text errlabel3;

    @FXML
    private Text errlabel4;



    public static String campusDecision;
    private String isClose = "no";
    private String hasKitchen = "no";
    private String goodWifi ="no";
    private double price;
    private String hasGenerator = "no";

    // Top prices variables
    double topPrice1 = 0;
    double topPrice2 = 0;
    double topPrice3 = 0;


    private Stage stage;
    private Scene scene;

    private Parent root;

    @FXML
    void onoroff(ActionEvent event) {
        this.campusDecision = this.oncampusbutton.isSelected() ? "on campus" : "off campus";

        // Determine campus decision

    }



    @FXML
    void calc1(ActionEvent event) {
        this.isClose = this.closetocampus.isSelected() ? "yes" : "no";

    }

    @FXML
    void calc2(ActionEvent event) {
        this.hasKitchen = this.hasakitchen.isSelected() ? "yes" : "no";

    }
    @FXML
    void calc3(ActionEvent event) {
        this.goodWifi = this.hasgoodwifi.isSelected() ? "yes" : "no";
    }
    @FXML
    void calc4(ActionEvent event) {
        this.hasGenerator = this.hasagenerator.isSelected() ? "yes" : "no";
    }


    // Write hostel information to file
    public void writeHostelsToFile(List<Hostel> topHostels, double[] topPrices, String campusDecision) {
        File file;
        if (campusDecision.equalsIgnoreCase("on campus")) {
            file = new File("on_campus_hostels.txt");
        } else if (campusDecision.equalsIgnoreCase("off campus")) {
            file = new File("off_campus_hostels.txt");
        } else {
            System.err.println("Invalid campus decision.");
            return;
        }

        try (FileWriter writer = new FileWriter(file)) {
            if (!file.exists()) {
                file.createNewFile();
            }

            for (int i = 0; i < topHostels.size(); i++) {
                writer.write(topHostels.get(i) + ": " + topPrices[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void submitinfo(ActionEvent actionEvent) throws IOException {

        // Validate budget
        String budgetText = this.budget.getText().trim();
        if (budgetText.isEmpty()) {
            errlabel1.setText("Budget cannot be empty");
            if(campusDecision == null) {
                errlabel2.setText("Select either on or off campus ");

            }
            return; // Exit method if budget is empty
        }
      else if(campusDecision == null){
           errlabel2.setText("Select either on or off campus ");
           return; // Exit method if on or off campus untouched
       }

        try {
            this.price = Double.parseDouble(budgetText);
            if (this.price < 4000) {
                errlabel3.setText("Budget must be greater than GH¢4000.00");
                return; // Exit method if budget is less than 4000
            }
        }
        catch (NumberFormatException e) {
            errlabel4.setText("Invalid budget input. Please enter a valid number");
            return; // Exit method if budget is not a valid number
        }


//processing
        // Calculate top 3 hostels based on the campus decision
        Hostel[] allHostelsArray = Hostel.displayTop3RecommendedHostels(this.campusDecision, Hostel.getOffCampusHostels(), Hostel.getOnCampusHostels(), this.isClose, this.hasKitchen, this.goodWifi, this.price, this.hasGenerator);

        // Separate hostels and prices based on campus decision
        List<Hostel> onCampusHostels = new ArrayList<>();
        List<Hostel> offCampusHostels = new ArrayList<>();
        List<Double> onCampusPrices = new ArrayList<>();
        List<Double> offCampusPrices = new ArrayList<>();

        for (Hostel hostel : allHostelsArray) {
            if (hostel.isClose()) {
                if (this.campusDecision.equals("on campus")) {
                    onCampusHostels.add(hostel);
                    onCampusPrices.add(hostel.getPrice());
                } else {
                    offCampusHostels.add(hostel);
                    offCampusPrices.add(hostel.getPrice());
                }
            }
        }

        // Write hostel information to file based on campus decision
        writeHostelsToFile(onCampusHostels, onCampusPrices.stream().mapToDouble(Double::doubleValue).toArray(), "on campus");
        writeHostelsToFile(offCampusHostels, offCampusPrices.stream().mapToDouble(Double::doubleValue).toArray(), "off campus");

        // Load the results page
        root = FXMLLoader.load(getClass().getResource("hfinderresults1.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static String getCampusDecision() {
        return campusDecision;
    }
}
