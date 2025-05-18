package model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlType(name = "Student", propOrder = {"fullName", "universityId", "avgExamScore"})
@XmlRootElement(name = "studentEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @SerializedName("FioOfStudent")
    @XmlElement(name = "studentName")
    private String fullName;

    @XmlElement(name = "universityId")
    private String universityId;

    @SerializedName("Course")
    @XmlTransient
    private int currentCourseNumber;

    @XmlElement(name = "avgScore")
    private float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

  //  private Student() {  // makes JAXB happy, will never be invoked
    //    throw new UnsupportedOperationException("Unexpected invocation: Customer object is not intended to be used for unmarshalling, only marshalling");
   // }

    @Override
    public String toString() {
        return "model.Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}