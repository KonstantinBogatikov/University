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
        Comparator<Student> studentComparatorByIdUniversity =
                SelectorComparator.StudentsComparatorByType(ComparatorTypeForStudents.IDUNIVERSITY);
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

        System.out.println("Сортировка студентов по имени");
        studentList.stream()
                .sorted(studentComparatorByName)
                .forEach(System.out::println);

        System.out.println("Сортировка студентов по идентификатору университета");
        studentList.stream()
                .sorted(studentComparatorByIdUniversity)
                .forEach(System.out::println);

        System.out.println("Сортировка студентов по номеру курса");
        studentList.stream()
                .sorted(studentComparatorByCourseNumber)
                .forEach(System.out::println);

        System.out.println("Сортировка студентов по среднему балу");
        studentList.stream()
                .sorted(studentComparatorByAvgExamScore)
                .forEach(System.out::println);

        System.out.println("Сортировка университетов по полному названию");
        universitiesList.stream()
                .sorted(universityComparatorByFullName)
                .forEach(System.out::println);

        System.out.println("Сортировка университетов по сокращенному названию");
        universitiesList.stream()
                .sorted(universityComparatorByShortName)
                .forEach(System.out::println);

        System.out.println("Сортировка университетов по идентификатору");
        universitiesList.stream()
                .sorted(universityComparatorById)
                .forEach(System.out::println);

        System.out.println("Сортировка университетов по году основания");
        universitiesList.stream()
                .sorted(universityComparatorByYearOfFoundation)
                .forEach(System.out::println);

        System.out.println("Сортировка университетов по профилю");
        universitiesList.stream()
                .sorted(universityComparatorByMainProfile)
                .forEach(System.out::println);

    }
}