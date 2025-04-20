package ComporatorsForStudents;

import Students.Student;
import org.apache.commons.lang3.StringUtils;

public class StudentsComparatorByIdUniversity implements StudentsComparator{
    @Override
    public int compare(Student a, Student b) {
        return StringUtils.compare(a.getUniversityId(), b.getUniversityId());
    }
}