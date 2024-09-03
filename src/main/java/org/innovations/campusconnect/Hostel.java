package org.innovations.campusconnect;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Hostel {
    private String name;
    private boolean isClose;
    private boolean hasKitchen;
    private double price;
    private boolean goodWifi;
    private boolean hasGenerator;

    // Constructor
    public Hostel(String name, boolean isClose, boolean hasKitchen, boolean goodWifi, double price, boolean hasGenerator) {
        this.name = name;
        this.isClose = isClose;
        this.hasKitchen = hasKitchen;
        this.goodWifi = goodWifi;
        this.price = price;
        this.hasGenerator = hasGenerator;
    }

    public Hostel() {}

    // Getters
    public String getName() {
        return name;
    }

    public boolean isClose() {
        return isClose;
    }

    public boolean hasKitchen() {
        return hasKitchen;
    }

    public boolean goodWifi() {
        return goodWifi;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasGenerator() {
        return hasGenerator;
    }

    // Method to calculate compatibility
    public int calculateCompatibility(String isClose, String hasKitchen, String goodWifi, double price, String hasGenerator) {
        int compatibility = 0;

        if ((isClose.equals("yes") && this.isClose) || isClose.equals("no")) {
            compatibility++;
        }
        if ((hasKitchen.equals("yes") && this.hasKitchen) || hasKitchen.equals("no")) {
            compatibility++;
        }
        if ((goodWifi.equals("yes") && this.goodWifi) || goodWifi.equals("no")) {
            compatibility++;
        }
        if (this.price <= price) {
            compatibility++;
        }
        if ((hasGenerator.equals("yes") && this.hasGenerator) || hasGenerator.equals("no")) {
            compatibility++;
        }

        return compatibility * 100 / 5;
    }
    static Hostel oldDufie = new Hostel("Old Dufie", true, false, true, 4600, true);
    static Hostel newDufie = new Hostel("New Dufie", true, false, true, 4600, true);
    static Hostel oldHosanna = new Hostel("Old Hosanna", true, true, false, 4600, true);
    static Hostel newHosanna = new Hostel("New Hosanna", true, true, true, 6500, true);
    static Hostel Tanko = new Hostel("Tanko", true, false, false, 4000, true);
    static Hostel oldMasere = new Hostel("Old Masere", true, false, false, 5000, true);
    static Hostel newMasere = new Hostel("New Masere", false, true, false, 6500, true);
    static Hostel Columbiana = new Hostel("Columbiana", true, true, true, 6000, true);
    static Hostel Hillside = new Hostel("Hillside", false, true, true, 6000, true);
    static Hostel Ceewus = new Hostel("Ceewus", false, true, true, 5500, true);
    static Hostel wangariMaathai = new Hostel("Wangari Maathai", true, false, false, 10000, true);
    static Hostel kofiTawiah = new Hostel("Kofi Tawiah", true, false, true, 10000, true);
    static Hostel hostel2c = new Hostel("Hostel 2c", true, false, false, 10000, true);
    static Hostel hostel2d = new Hostel("Hostel 2d", true, false, true, 10000, true);
    static Hostel[] offCampusHostelArray = {oldDufie, newDufie, oldHosanna, newHosanna, Tanko, oldMasere, newMasere, Columbiana, Hillside, Ceewus}; // Add other off-campus hostels
    static  Hostel[] onCampusHostelArray = {wangariMaathai, kofiTawiah, hostel2c, hostel2d}; // Add on-campus hostels




    // Method to display the top 3 recommended hostels
    public static Hostel[] displayTop3RecommendedHostels(String campusDecision, Hostel[] offCampusHostelArray, Hostel[] onCampusHostelArray, String isClose, String hasKitchen, String goodWifi, double price, String hasGenerator) {
        Hostel[] hostels = variousHostel(campusDecision, offCampusHostelArray, onCampusHostelArray);

        int[] compatibilityScores = new int[hostels.length];

        // Calculate compatibility for each hostel
        for (int i = 0; i < hostels.length; i++) {
            Hostel hostel = hostels[i];
            compatibilityScores[i] = hostel.calculateCompatibility(isClose, hasKitchen, goodWifi, price, hasGenerator);
        }

        // Sort hostels based on compatibility scores
        for (int i = 0; i < hostels.length - 1; i++) {
            for (int j = 0; j < hostels.length - i - 1; j++) {
                if (compatibilityScores[j] < compatibilityScores[j + 1]) {
                    // Swap compatibility scores
                    int tempScore = compatibilityScores[j];
                    compatibilityScores[j] = compatibilityScores[j + 1];
                    compatibilityScores[j + 1] = tempScore;

                    // Swap hostels
                    Hostel tempHostel = hostels[j];
                    hostels[j] = hostels[j + 1];
                    hostels[j + 1] = tempHostel;
                }
            }
        }
        Hostel[] hostelArray = new Hostel[3];
        // Display the top 3 recommended hostels
        for (int i = 0; i < Math.min(3, hostels.length); i++) {
            hostelArray[i] = hostels[i];
            //System.out.println(i+1 + ". " + hostels[i].getName() + " is " + compatibilityScores[i] + "% compatible with your needs. \n" +  hostels[i].toString());
        }



        return hostelArray;
    }




    public static Hostel[] variousHostel(String campusDecision, Hostel[] offCampusHostelArray, Hostel[] onCampusHostelArray) {
        if (campusDecision.equalsIgnoreCase("on campus") || campusDecision.equalsIgnoreCase("on")) {
            return onCampusHostelArray;
        } else if (campusDecision.equals("off campus") || campusDecision.equals("off")) {
            return offCampusHostelArray;
        }
        return new Hostel[0]; // Return an empty array if campusDecision is invalid
    }
    public  static Hostel[] getOffCampusHostels() {
        return offCampusHostelArray;
    }

    // Getter method for on-campus hostels
    public static Hostel[] getOnCampusHostels() {
        return onCampusHostelArray;
    }


    public String toString() {
        String finalSaying = this.name + ":";
        if (this.hasGenerator == true) {
            finalSaying += "Generator,";
        }
        if (this.goodWifi == true) {
            finalSaying += " Good Wifi, ";
        }
        if (this.price <price) {
            finalSaying += " Budget friendly, ";
        }
        if (this.hasKitchen == true) {
            finalSaying += "Kitchen, ";
        }
        if (this.isClose == true) {
            finalSaying += "Close to campus";
        }
        return finalSaying;

    }
}




