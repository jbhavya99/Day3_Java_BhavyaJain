package com.bhavya.studentUtil;

import java.util.ArrayList;

public class StudentUtil {

    // HELPER METHOD TO CONVERT GRADES TO POINTS
    private static int gradeToPoints(char grade) throws MissingGradeException{//will write like this, in exc case
        return switch (grade) {
            case 'A' -> 4;
            case 'B' -> 3;
            case 'C' -> 2;
            case ' ' -> throw new MissingGradeException("Grade is Missing");
            default -> 0; // not affecting average
        };
    }

    // METHOD 1: TO CALCULATE GPA
    // TASK1 & TASK2 ARE DONE IN THIS METHOD
    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException{
        // fIRSTLY: Check if arrays are not in sync i.e. not able to determine -> Grades of which Student
        if (studentIdList.length != studentsGrades.length) {
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. " +
                    "studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);
        }

        double[] gpaArr = new double[studentIdList.length];

        for (int i = 0; i < studentIdList.length; i++) {
            int cntSubjects = studentsGrades[i].length; // Get the number of subjects for this student
            if (cntSubjects == 0) {  // Handle case where a student has no subjects
                throw new IllegalArgumentException("Student with ID " + studentIdList[i] + " has no grades.");
            }
            int totalPoints = 0;

            for (char grade : studentsGrades[i]) {
                if (grade == ' ') {
                    throw new MissingGradeException(studentIdList[i]); // Task 2: Throw MissingGradeException
                }
                totalPoints += gradeToPoints(grade);
            }
            gpaArr[i] = (double) totalPoints / cntSubjects;
        }
        return gpaArr;
    }

    // METHOD 2: TO GET STUDENTS BY GPA
    // TASK3 IS DONE IN THIS METHOD
    // Catch MissingGradeException inside getStudentsByGPA.
    // Instead of propagating it, wrap it inside InvalidDataException and rethrow it
    public static ArrayList<Integer> getStudentsByGPA(double lower, double upper, int[] studentIdList, char[][] studentsGrades) {
        ArrayList<Integer> studentList = new ArrayList<>();

        try {
            double[] gpaArr = calculateGPA(studentIdList, studentsGrades);

            for (int i = 0; i < gpaArr.length; i++) {
                if (gpaArr[i] >= lower && gpaArr[i] <= upper) {
                    studentList.add(studentIdList[i]);
                }
            }

        } catch (MissingGradeException e) {
            throw new InvalidDataException("Invalid data encountered while computing GPA", e);
        }

        return studentList;
    }
}
