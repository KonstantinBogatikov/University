package model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlType(name = "XMLInfo", propOrder = {"studentsList", "universitiesList", "statisticsList", "processDate"})
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLInfo {

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    public List<Student> studentsList;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    public List<University> universitiesList;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    public List<Statistics> statisticsList;

    @XmlElement(name = "processedAt")
    private Date processDate;

    public XMLInfo() {
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public XMLInfo setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
        return this;
    }

    public List<University> getUniversitiesList() {
        return universitiesList;
    }

    public XMLInfo setUniversitiesList(List<University> universitiesList) {
        this.universitiesList = universitiesList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public XMLInfo setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public XMLInfo setProcessDate(Date processDate) {
        this.processDate = processDate;
        return this;
    }
}
