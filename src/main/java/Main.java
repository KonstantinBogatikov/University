import io.JsonWriter;
import io.XMLWriter;
import io.XlsReader;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;
import model.XMLInfo;
import util.JsonUtil;
import util.StatisticsUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {

    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, JAXBException {
        final Logger logger = Logger.getLogger(Main.class.getName());

        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            System.err.println("Ошибка конфигурации logger: " + e);
        }

        //Формируем List с информацией о студентах, университетах и статистике их файла excel
        List<Student> studentsList = XlsReader.getSudentsList();
        List<University> universitiesList = XlsReader.getUniversitiesList();
        List<Statistics> statisticsList = StatisticsUtil.createStatistics(studentsList, universitiesList);

        //Создаем объект XMLInfo для записи его в XML файл
        XMLInfo xmlInfo = new XMLInfo()
                .setStudentsList(studentsList)
                .setUniversitiesList(universitiesList)
                .setStatisticsList(statisticsList)
                .setProcessDate(new java.util.Date());

        XMLWriter.generateXMLFileReq(xmlInfo);
        JsonWriter.generateJSON(xmlInfo);

        /*
        //Запись файла статистики в Excel
        String pathExcelFile = "src/main/resources/ExcelFiles/statistics.xlsx";
        if (!studentsList.isEmpty() && !universitiesList.isEmpty()){
        List<Statistics> statisticsList = StatisticsUtil.createStatistics(studentsList, universitiesList);
        XlsWriter.createXlsFileWithStatistics(statisticsList, pathExcelFile);
            logger.log(Level.INFO, "Записан файл статистики");
        } else {
            logger.log(Level.WARNING, "Невозможно создать файл статистики, так как один из List<Student> " +
                    "или List<University> пустой");
        }
        */


        /*
        //Печать JSON в консоль
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
        */

        /*
        //Применение разных компараторов
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
                .forEach(System.out::println);
        */
    }
}