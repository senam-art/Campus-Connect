package org.innovations.campusconnect;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Student extends Person {
    private String course;
    private String phoneNumber;

    private String graduationYear;
    private List<String> interests;
    private String preferredHostel;

    private String studentID;


    public Student(String name, int age, String course, String phoneNumber, String graduationYear) {
        super(name, age);
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.graduationYear = graduationYear;
    }

    public Student(String name, String ID, String course, String graduationYear) {
        super(name);
        this.studentID= ID;
        this.graduationYear = graduationYear;
        this.course =course;
    }




    public  Student(String name, int age, String course, String phoneNumber, String graduationYear, List<String> interests) {
        super(name, age);
        this.course = course;
        this.phoneNumber = phoneNumber;
        this.graduationYear = graduationYear;
        this.interests = new ArrayList<>(interests);
    }

    public void setPreferredHostel(String hostel) {
        this.preferredHostel = hostel;
    }

    public String getPreferredHostel() {
        return this.preferredHostel;
    }

    public List<String> findCompatibleRoommates(String filename, int numberOfRoommates) throws IOException {
        List<String> results = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filename));

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length < 7) continue; // Ensure all parts are present

            String studentName = parts[0];
            String studentPhone = parts[3];
            List<String> studentInterests = Arrays.asList(parts[5].split(";"));
            String studentHostel = parts[6];

            if (!this.getName().equals(studentName) && this.preferredHostel.equalsIgnoreCase(studentHostel)) {
                for (String interest : this.interests) {
                    if (studentInterests.contains(interest)) {
                        results.add(studentName + " - " + studentPhone);
                        break;
                    }
                }
            }
        }
        return results.subList(0, Math.min(results.size(), numberOfRoommates));
    }

    public void saveStudentDetails(String filename) throws IOException {
        String details = String.join(",", this.getName(), this.course, this.phoneNumber, this.graduationYear, String.valueOf(this.getAge()),
                                     String.join(";", this.interests), this.preferredHostel) + "\n";
        Files.write(Paths.get(filename), details.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getCourse() {
        return course;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public String getStudentID() {
        return studentID;
    }


}

