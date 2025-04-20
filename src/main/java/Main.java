import ComporatorsForStudents.ComparatorTypeForStudents;
import ComporatorsForUniversities.ComparatorTypeForUniversities;
import Students.Student;
import Universities.University;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> studentList = CollectionsCreator.getSudentsList();
        List<University> universitiesList = CollectionsCreator.getUniversitiesList();

        Comparator<Student> studentComparatorByName =
                SelectorComparator.StudentsComparatorByType(ComparatorTypeForStudents.NAME);
        Comparator<Student> studentComparatorById =
                SelectorComparator.StudentsComparatorByType(ComparatorTypeForStudents.ID);
        Comparator<Student> studentComparatorByCourseNumber =
                SelectorComparator.StudentsComparatorByType(ComparatorTypeForStudents.COURSENUMBER);
        Comparator<Student> studentComparatorByAvgExamScore =
                SelectorComparator.StudentsComparatorByType(ComparatorTypeForStudents.AVGEXAMSCORE);

        Comparator<University> universityComparatorById =
                SelectorComparator.UniversitiesComparatorByType(ComparatorTypeForUniversities.ID);
        Comparator<University> universityComparatorByFullName =
                SelectorComparator.UniversitiesComparatorByType(ComparatorTypeForUniversities.FULLNAME);
        Comparator<University> universityComparatorByShortName =
                SelectorComparator.UniversitiesComparatorByType(ComparatorTypeForUniversities.SHORTNAME);
        Comparator<University> universityComparatorByYearOfFoundation =
                SelectorComparator.UniversitiesComparatorByType(ComparatorTypeForUniversities.YEAROFFOUNDATIONR);
        Comparator<University> universityComparatorByMainProfile =
                SelectorComparator.UniversitiesComparatorByType(ComparatorTypeForUniversities.MAINPROFILE);

        studentList.stream()
                .sorted(studentComparatorByName)
                .forEach(System.out::println);

        universitiesList.stream()
                .sorted(universityComparatorByFullName)
                .forEach(System.out::println);
    }
}