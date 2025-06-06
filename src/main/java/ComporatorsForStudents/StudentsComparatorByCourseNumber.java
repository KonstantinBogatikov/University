package ComporatorsForStudents;

import model.Student;

public class StudentsComparatorByCourseNumber implements StudentsComparator {
    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(a.getCurrentCourseNumber(), b.getCurrentCourseNumber());
    }
}