package ComporatorsForStudents;

import model.Student;

public class StudentsComparatorByAvgExamScore implements StudentsComparator{
    @Override
    public int compare(Student a, Student b) {
        return -Float.compare(a.getAvgExamScore(), b.getAvgExamScore());
    }
}