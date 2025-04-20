package ComporatorsForStudents;

import Students.Student;
import org.apache.commons.lang3.StringUtils;

public class StudentsComparatorByName implements StudentsComparator{
    @Override
    public int compare(Student a, Student b) {
        return StringUtils.compare(a.getFullName(), b.getFullName());
    }
}