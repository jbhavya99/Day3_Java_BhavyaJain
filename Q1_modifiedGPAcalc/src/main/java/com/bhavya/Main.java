package com.bhavya;

import com.bhavya.studentUtil.InvalidDataException;
import com.bhavya.studentUtil.MissingGradeException;
import com.bhavya.studentUtil.StudentUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test 1: Missing Grade (Triggers MissingGradeException)
        int[] studentIdList = {1001, 1002};
        char[][] studentsGrades = {
                {'A', 'B', ' '},  // Missing grade for student 1001 (space indicates missing grade)
                {'A', 'B', 'C'}   // Valid grades for student 1002
        };

        try {
            double[] gpaArr = StudentUtil.calculateGPA(studentIdList, studentsGrades);
            for (int i = 0; i < studentIdList.length; i++) {
                System.out.println("Student ID: " + studentIdList[i] + " GPA: " + gpaArr[i]);
            }
        } catch (MissingGradeException e) {
            System.out.println("Error: Missing grade for studentss " + e.getStudentId());
        } catch (InvalidDataException e) {
            System.out.println("Error: Invalid data encountered - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 2: Arrays Out of Sync (Triggers IllegalArgumentException)
        studentIdList = new int[]{1001, 1002};
        studentsGrades = new char[][]{
                {'A', 'B', 'C'},  // Student 1001 has 3 grades
                {'A', 'B'}        // Student 1002 has 2 grades (Mismatch)
        };

        try {
            double[] gpaArr = StudentUtil.calculateGPA(studentIdList, studentsGrades);
            for (int i = 0; i < studentIdList.length; i++) {
                System.out.println("Student ID: " + studentIdList[i] + " GPA: " + gpaArr[i]);
            }
        } catch (MissingGradeException e) {
            System.out.println("Error: Missing grade for student " + e.getStudentId());
        } catch (InvalidDataException e) {
            System.out.println("Error: Invalid data encountered - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 3: Get Students by GPA (with Valid Range)
        studentIdList = new int[]{1001, 1002, 1003};
        studentsGrades = new char[][]{
                {'A', 'B', 'C'},  // GPA: (4 + 3 + 2) / 3 = 3.0
                {'A', 'A', 'A'},  // GPA: (4 + 4 + 4) / 3 = 4.0
                {'B', 'C', 'D'}   // GPA: (3 + 2 + 1) / 3 = 2.0
        };

        try {
            // Call getStudentsByGPA with GPA range 3.0 to 4.0
            System.out.println("Students with GPA between 3.0 and 4.0:");
            var studentsInRange = StudentUtil.getStudentsByGPA(3.0, 4.0, studentIdList, studentsGrades);
            for (int studentId : studentsInRange) {
                System.out.println("Student ID: " + studentId);
            }
        } catch (InvalidDataException e) {
            System.out.println("Error: Invalid data encountered - " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
