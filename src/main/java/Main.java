import io.XlsReader;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;
import util.JsonUtil;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> studentsList = XlsReader.getSudentsList();
        List<University> universitiesList = XlsReader.getUniversitiesList();

        String pathExcelFile = "src/main/resources/ExcelFiles/statistics.xlsx";

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(studentsList, universitiesList);
        try {
            XlsWriter.createXlsFileWithStatistics(statisticsList, pathExcelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Вывод на печать в консоль JSON ARRAY из студентов
        String studentsListJson = JsonUtil.toJsonFromStudents(studentsList);
        System.out.println("JSON из студентов");
        System.out.println(studentsListJson);

        //Вывод на печать в консоль коллекции студентов полученных из JSON
        List<Student> studentsListFromJson = JsonUtil.toStudentsFromJson(studentsListJson);
        System.out.println("Коллекция студентов полученных из JSON");
        studentsListFromJson.forEach(System.out::println);

        System.out.println(studentsList.size() == studentsListFromJson.size() ?
                        "Размеры коллекций студентов равны" : "Размеры коллекций студентов не равны");

        //Вывод на печать в консоль JSON ARRAY из университетов
        String universitiesListJson = JsonUtil.toJsonFromUniversities(universitiesList);
        System.out.println("JSON из университетов");
        System.out.println(universitiesListJson);

        //Вывод на печать в консоль коллекции университетов полученных из JSON
        List<University> universitiesListFromJson = JsonUtil.toUniversitiesFromJson(universitiesListJson);
        System.out.println("Коллекция студентов полученных из JSON");
        universitiesListFromJson.forEach(System.out::println);

        System.out.println(universitiesList.size() == universitiesListFromJson.size() ?
                "Размеры коллекций университетов равны" : "Размеры коллекций университетов не равны");

        System.out.println("--------------------");
        System.out.println("Вторая часть задания");

        studentsList.forEach(student -> {
            String studentJson = JsonUtil.jsonFromStudent(student);
            //выводим на печать в консоль json из отдельного объекта класса Student
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.studentFromJson(studentJson);
            //выводим на печать в консоль объект класса Student, полученный из JSON
            System.out.println(studentFromJson);
        });

        universitiesList.forEach(university -> {
            String universityJson = JsonUtil.jsonFromUniversity(university);
            //выводим на печать в консоль json из отдельного объекта класса University
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.universityFromJson(universityJson);
            //выводим на печать в консоль объект класса University, полученный из JSON
            System.out.println(universityFromJson);
        });


        /*Comparator<Student> studentComparatorByName =
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
        studentsList.stream()
                .sorted(studentComparatorByName)
                .forEach(System.out::println);

        System.out.println("Сортировка студентов по идентификатору университета");
        studentsList.stream()
                .sorted(studentComparatorByIdUniversity)
                .forEach(System.out::println);

        System.out.println("Сортировка студентов по номеру курса");
        studentsList.stream()
                .sorted(studentComparatorByCourseNumber)
                .forEach(System.out::println);

        System.out.println("Сортировка студентов по среднему балу");
        studentsList.stream()
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
                .forEach(System.out::println);*/


    }
}