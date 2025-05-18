package model;

import enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlType(name = "Statistics", propOrder = {"mainProfile", "avgExamScore"})
@XmlRootElement(name = "statisticsEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;

    @XmlElement(name = "avgScore")
    private float avgExamScore;

    @XmlTransient
    private int countOfStudents;

    @XmlTransient
    private int countOfUniversities;

    @XmlTransient
    private String nameOfUniversities;

    public Statistics() {
    }

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
