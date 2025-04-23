package ComporatorsForStudents;

import model.Student;
import java.util.Comparator;

public interface StudentsComparator extends Comparator<Student> {
    int compare(Student a, Student b);
}