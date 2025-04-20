package ComporatorsForStudents;

import Students.Student;
import java.util.Comparator;

public interface StudentsComparator extends Comparator<Student> {
    int compare(Student a, Student b);
}