package model;

import enums.StudyProfile;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlType(name = "University", propOrder = {"id", "fullName", "mainProfile"})
@XmlRootElement(name = "universityEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @XmlElement(name = "universityId")
    private String id;

    @SerializedName("NameOfUniversity")
    @XmlElement(name = "universityName")
    private String fullName;

    @XmlTransient
    private String shortName;

    @SerializedName("StartYearForUniversity")
    @XmlTransient
    private int yearOfFoundation;

    @SerializedName("Specialization")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "model.University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}