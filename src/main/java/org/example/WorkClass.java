package org.example;

import java.io.*;
import java.util.Scanner;

public class WorkClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = scan.next();

        System.out.print("Enter number of students: ");
        int n = scan.nextInt();
        Student[] students = new Student[n];
        initArray(students);
        printArray(students);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName + ".bin"))) {
            out.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName + ".bin"))) {
            Student[] readStudents = (Student[]) in.readObject();
            printArray(readStudents);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("number of \"satisfactory\" marks from physics: " + searchGoodMarksPhys(students));
        System.out.println("number of \"satisfactory\" marks from math: " + searchGoodMarksMath(students));
        System.out.println("number of \"satisfactory\" marks from info:  " + searchGoodMarksInfo(students));
        System.out.println("student which get 4 & 5 marks: " + String.join(", ", searchSecondNameOfStudents(students)));
    }

    public static String[] searchSecondNameOfStudents(Student[] ar) {
        String[] matchingSecondNames = new String[ar.length];
        int count = 0;

        for (Student st : ar) {
            if ((st.getMarksPhysics() == 4 || st.getMarksPhysics() == 5) && (st.getMarksMath() == 4 || st.getMarksMath() == 5)) {
                matchingSecondNames[count++] = st.getSecondName();
            }
        }

        if (count == 0) {
            return new String[]{"there are no such students"};
        } else {
            String[] result = new String[count];
            System.arraycopy(matchingSecondNames, 0, result, 0, count);
            return result;
        }
    }

    public static int searchGoodMarksPhys(Student[] ar){
        int goodMarks = 0, targetMark = 3;
        for (Student student : ar) {
            if (student.getMarksPhysics() >= targetMark) {
                goodMarks++;
            }
        }
        return goodMarks;
    }

    public static int searchGoodMarksMath(Student[] ar){
        int goodMarks = 0, targetMark = 3;
        for (Student student : ar) {
            if (student.getMarksMath() >= targetMark) {
                goodMarks++;
            }
        }
        return goodMarks;
    }

    public static int searchGoodMarksInfo(Student[] ar){
        int goodMarks = 0, targetMark = 3;
        for (Student student : ar) {
            if (student.getMarksInfo() >= targetMark) {
                goodMarks++;
            }
        }
        return goodMarks;
    }

    public static void initArray(Student[] ar){
        for(int i = 0; i < ar.length; i++){
            ar[i] = new Student();
        }
    }

    public static void printArray(Student[] arr) {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("| " + String.format("%3s", "№") + " | " + String.format("%15s", "secondName") + " | " + String.format("%9s", "course") + " | " + String.format("%9s", "specialty")
                + " | " + String.format("%8s", "physics") + " | " + String.format("%11s", "Mathematics") + " | " + String.format("%11s", "informatics") + " |");
        System.out.println("----------------------------------------------------------------------------------------");
        for (Student st : arr) {
            System.out.printf("%5s\n", st);
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
}

