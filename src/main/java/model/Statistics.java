package model;

import enums.StudyProfile;

public class Statistics {
    private StudyProfile mainProfile;
    private float avgExamScore;
    private int countOfStudents;
    private int countOfUniversities;
    private String nameOfUniversities;

    public Statistics() {}

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public Statistics setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getCountOfStudents() {
        return countOfStudents;
    }

    public Statistics setCountOfStudents(int countOfStudents) {
        this.countOfStudents = countOfStudents;
        return this;
    }

    public int getCountOfUniversities() {
        return countOfUniversities;
    }

    public Statistics setCountOfUniversities(int countOfUniversities) {
        this.countOfUniversities = countOfUniversities;
        return this;
    }

    public String getNameOfUniversities() {
        return nameOfUniversities;
    }

    public Statistics setNameOfUniversities(String nameOfUniversities) {
        this.nameOfUniversities = nameOfUniversities;
        return this;
    }
}
