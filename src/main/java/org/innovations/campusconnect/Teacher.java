package org.innovations.campusconnect;

import java.io.*;
import java.nio.file.*;

//create teacher class to inherit from person calss
import java.util.ArrayList;
public class Teacher extends Person {
    //instance variables for Teacher class
    private String department;
    private ArrayList<String> comments = new ArrayList<>();

    //constructor for teacher calss taking String name, int age, and string department and inherits name and age from super class person
    public Teacher(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    // Getter and setter for department
    public String getDepartment() {
        return department;
    }

    public String[] getComments() {
        String[] allComments = new String[comments.size()];
        for (int i = 0; i < comments.size(); i++) {
            allComments[i] = comments.get(i);
        }
        return allComments;
    }
    public void setComments(String studentComment) {
        comments.add(studentComment);
    }



    public void setDepartment(String department) {
        this.department = department;
    }

    // Overridden toString method to display the teachers information
    @Override
    public String toString() {
        String finalSaying = this.getName() + "in the" + this.getDepartment() + " Department"; // Add comma and space
        return finalSaying;
    }


    // various teacher objects
    static Teacher davidEbo = new Teacher("David Ebo", 47, "Computer Science and Information Systems");
    static Teacher patrickDwomfuor = new Teacher("Patrick Dwomfuor", 33, "Computer Science and Information Systems");
    static Teacher kwabenaBamfo = new Teacher("Kwabena Bamfo", 26, "Computer Science and Information Systems");
    static Teacher govindahDash = new Teacher("Govindah", 56, "Computer Science and Information Systems");
    static Teacher ayorkorKorsah = new Teacher("Ayorkor Korsah", 47, "Computer Science and Information Systems");
    static Teacher josephMensah = new Teacher("Joseph Mensah", 33, "Computer Science and Information Systems");

    //store teacher objects in a Teacher array for their specific department
    static Teacher[] computerDepartment = {davidEbo, patrickDwomfuor, kwabenaBamfo, govindahDash, ayorkorKorsah,josephMensah};

    static Teacher jewelThompson = new Teacher("Jewel Thompson", 23, "Business Administration and Economics ");
    static Teacher princeBaah = new Teacher("Prince Baah", 59, "Business Administration and Economics ");
    //store teacher objects in a Teacher array for their specific department

    static Teacher[] businessAdministrationDepartment = {jewelThompson, princeBaah};

    static Teacher kwakuAttakora = new Teacher("Kwaku Attakora", 23, "Humanities and Social Sciences");
    static Teacher maameYaa = new Teacher("Maame Yaa", 39, "Humanities and Social Sciences");
    static Teacher kwameAquah = new Teacher("Kwame Aquah", 23, "Humanities and Social Sciences");
    //store teacher objects in a Teacher array for their specific department

    static Teacher[] humanitiesandSocialSciencesDepartment = {kwakuAttakora, maameYaa, kwameAquah};
    //store the departments into broad departments array

    public static Teacher findLecturerByNameAndDepartment(String name, String department, String comment) {
        // Depending on the selected department, search through the corresponding array of teachers
        if ("Computer Science and Information Systems".equals(department)) {
            for (Teacher teacher : computerDepartment) {
                if (teacher.getName().equals(name) && teacher.getDepartment().equals(department)) {
                    teacher.setComments(comment); // Add the comment to the teacher object
                    return teacher;
                }
            }
        } else if ("Business Administration and Economics ".equals(department)) {
            for (Teacher teacher : businessAdministrationDepartment) {
                if (teacher.getName().equals(name) && teacher.getDepartment().equals(department)) {
                    teacher.setComments(comment); // Add the comment to the teacher object
                    return teacher;
                }
            }
        } else if ("Humanities and Social Sciences".equals(department)) {
            for (Teacher teacher : humanitiesandSocialSciencesDepartment) {
                if (teacher.getName().equals(name) && teacher.getDepartment().equals(department)) {
                    teacher.setComments(comment); // Add the comment to the teacher object
                    return teacher;
                }
            }
        }
        // If the lecturer is not found, return null
        return null;
    }




}


