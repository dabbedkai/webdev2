package com.dabbedkai;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Roster roster = new Roster();

        System.out.println("=== Task 4: Testing Invalid Input Handling ===");
        try {
            Student invalidStudent = new Student("Invalid User", -5, "BSIT");
            roster.addStudent(invalidStudent);
        } catch (InvalidAgeException e) {
            System.out.println("Handled Exception: " + e.getMessage());
        }

        System.out.println("\n=== Task 3: Populating Roster ===");
        roster.addStudent(new Student("Alice Santos", 20, "BSIT"));
        roster.addStudent(new Student("Bob Reyes", 17, "BSCS"));
        roster.addStudent(new Student("Charlie Cruz", 19, "BSIS"));
        roster.addStudent(new Student("Diana Lopez", 16, "BSIT"));
        roster.addStudent(new Student("Ethan Tan", 21, "BSCS"));
        roster.addStudent(new Student("Fiona Garcia", 18, "BSIS"));

        System.out.println("\nFull Student List:");
        for (Student s : roster.getStudents()) {
            System.out.println(s + " | Standing: " + s.computeStanding());
        }

        System.out.println("\n=== Task 5: Stream-Based Roster Report ===");
        List<String> adultNames = roster.generateAdultReport();
        System.out.println("Names list: " + adultNames);
    }
}