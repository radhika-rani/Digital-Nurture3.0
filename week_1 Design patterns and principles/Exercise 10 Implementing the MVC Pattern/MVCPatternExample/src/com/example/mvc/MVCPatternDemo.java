package com.example.mvc;

public class MVCPatternDemo {
    public static void main(String[] args) {
        // Create a Student model
        Student student = new Student("Ashutosh Dash", 123, "A");

        // Create a StudentView to display student details
        StudentView view = new StudentView();

        // Create a StudentController to control the student data and view
        StudentController controller = new StudentController(student, view);

        // Display student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Aparna Dash");
        controller.setStudentId(456);
        controller.setStudentGrade("B");

        // Display updated student details
        controller.updateView();
    }
}
