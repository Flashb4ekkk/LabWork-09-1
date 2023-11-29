package org.example;

import java.io.Serializable;
import java.util.Random;

public class Student implements Serializable {
    private final int numberInGroup;
    private final String secondName;
    private final int course;
    private final specialication specialication;
    private final int marksPhysics;
    private final int marksMath;
    private final int marksInfo;

    public Student() {
        Random ran = new Random();
        this.numberInGroup = ran.nextInt(28) + 1;
        this.secondName = randomSecondName();
        this.course = ran.nextInt(4) + 1;
        this.specialication = randomSpecialication();
        this.marksPhysics = ran.nextInt(5) + 1;
        this.marksMath = ran.nextInt(5) + 1;
        this.marksInfo = ran.nextInt(5) + 1;
    }

    @Override
    public String toString() {
        return String.format("| %3s | %15s | %9s | %9s | %8s | %11s | %11s |", numberInGroup, secondName, course, specialication, marksPhysics, marksMath, marksInfo);
    }

    private specialication randomSpecialication() {
        Random ran = new Random();
        specialication[] specializations = org.example.specialication.values();
        return specializations[ran.nextInt(specializations.length)];
    }

    private String randomSecondName() {
        Random ran = new Random();
        String[] secondNames = {"Shevchenko", "Kovalenko", "Boyko", "Kolesnik", "Ponomarenko", "Stepanenko", "Savchenko", "Tkachenko", "Tereshchenko", "Romanenko",
                "Lysenko", "Polishchuk", "Kryvonos", "Tkachuk", "Melnyk", "Fedorenko", "Bondarenko", "Dovzhenko", "Kushnir", "Hrytsenko"};
        return secondNames[ran.nextInt(secondNames.length)];
    }

    public int getMarksPhysics() {
        return marksPhysics;
    }

    public int getMarksMath() {
        return marksMath;
    }

    public int getMarksInfo() {
        return marksInfo;
    }

    public String getSecondName() {
        return secondName;
    }
}
