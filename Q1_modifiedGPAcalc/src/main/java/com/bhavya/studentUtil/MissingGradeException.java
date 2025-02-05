package com.bhavya.studentUtil;

public class MissingGradeException extends Exception { // Checked Exception
    private final int studentId;

    // Constructor to initialize studentId
    public MissingGradeException(int studentId) {
        super("Grade is missing for student ID: " + studentId);
        this.studentId = studentId;
    }

    // Overloaded constructor to allow custom messages
    public MissingGradeException(String message) {
        super(message);
        this.studentId = -1; // Default value when studentId is not given
    }

    // Getter for studentId
    public int getStudentId() {
        return studentId;
    }
}
