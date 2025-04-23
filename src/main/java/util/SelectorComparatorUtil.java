package util;

import ComporatorsForStudents.*;
import ComporatorsForUniversities.*;
import enums.ComparatorTypeForStudents;
import enums.ComparatorTypeForUniversities;
import model.Student;
import model.University;

import java.util.Comparator;
import java.util.HashMap;

public class SelectorComparatorUtil {

    private static SelectorComparatorUtil selectorComparatorInstanse;
    private static final HashMap<ComparatorTypeForStudents, Comparator<Student>> studentsComparators = new HashMap<>();
    private static final HashMap<ComparatorTypeForUniversities, Comparator<University>> universitiesComparators = new HashMap<>();

    private SelectorComparatorUtil() {
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

    public static SelectorComparatorUtil getInstance() {
        if (selectorComparatorInstanse == null) {
            selectorComparatorInstanse = new SelectorComparatorUtil();
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