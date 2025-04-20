import ComporatorsForStudents.*;
import ComporatorsForUniversities.*;
import Students.Student;
import Universities.University;

import java.util.Comparator;
import java.util.HashMap;

public class SelectorComparator {

    private static SelectorComparator selectorComparatorInstanse;
    private static final HashMap<ComparatorTypeForStudents, Comparator<Student>> studentsComparators = new HashMap<>();
    private static final HashMap<ComparatorTypeForUniversities, Comparator<University>> universitiesComparators = new HashMap<>();

    private SelectorComparator() {
        studentsComparators.put(ComparatorTypeForStudents.NAME, new StudentsComparatorByName());
        studentsComparators.put(ComparatorTypeForStudents.IDUNIVERSITY, new StudentsComparatorByIdUniversity());
        studentsComparators.put(ComparatorTypeForStudents.COURSENUMBER, new StudentsComparatorByCourseNumber());
        studentsComparators.put(ComparatorTypeForStudents.AVGEXAMSCORE, new StudentsComparatorByAvgExamScore());

        universitiesComparators.put(ComparatorTypeForUniversities.ID, new UniversitiesComparatorById());
        universitiesComparators.put(ComparatorTypeForUniversities.FULLNAME, new UniversitiesComparatorByFullName());
        universitiesComparators.put(ComparatorTypeForUniversities.SHORTNAME, new UniversitiesComparatorByShortName());
        universitiesComparators.put(ComparatorTypeForUniversities.YEAROFFOUNDATIONR, new UniversitiesComparatorByYearOfFoundation());
        universitiesComparators.put(ComparatorTypeForUniversities.MAINPROFILE, new UniversitiesComparatorByMainProfile());
    }

    public static SelectorComparator getInstance() {
        if (selectorComparatorInstanse == null) {
            selectorComparatorInstanse = new SelectorComparator();
        }
        return selectorComparatorInstanse;
    }

    public static Comparator<Student> StudentsComparatorByType(ComparatorTypeForStudents type) {
        return getInstance().studentsComparators.get(type);
    }

    public static Comparator<University> UniversitiesComparatorByType(ComparatorTypeForUniversities type) {
        return getInstance().universitiesComparators.get(type);
    }
}