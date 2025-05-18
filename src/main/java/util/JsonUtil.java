package util;

import model.Student;
import model.University;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {

    private static final Logger logger = Logger.getLogger(JsonUtil.class.getName());

    private JsonUtil() {
    }

    public static String writeListToJson(List<?> list) {
        String msg = "Получен JSON из List<" + list.get(0).getClass().getName() + ">";
        logger.log(Level.INFO, msg);
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }

    /*
    //Метод получения JSON из List<Student>
    public static String toJsonFromStudents(List<Student> studentsList) {
        logger.log(Level.INFO, "Получен JSON из List<Student>");
        return new GsonBuilder().setPrettyPrinting().create().toJson(studentsList);
    }

    //Метод получения List<Student> из JSON
    public static List<Student> toStudentsFromJson(String studentsListJson) {
        logger.log(Level.INFO, "Получен List<Student> из JSON");
        return new Gson().fromJson(studentsListJson, new TypeToken<List<Student>>() {}.getType());
    }

    //Метод получения JSON из List<University>
    public static String toJsonFromUniversities(List<University> universitiesList) {
        logger.log(Level.INFO, "Получен JSON из List<University>");
        return new GsonBuilder().setPrettyPrinting().create().toJson(universitiesList);
    }

    //Метод получения List<University> из JSON
    public static List<University> toUniversitiesFromJson(String universitiesListJson) {
        logger.log(Level.INFO, "Получен List<University> из JSON");
        return new Gson().fromJson(universitiesListJson, new TypeToken<List<University>>() {}.getType());
    }

    //Метод получения JSON из объекта класса Student
    public static String jsonFromStudent (Student student) {
        logger.log(Level.INFO, "Получен JSON из объекта класса Student");
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    //Метод получения объекта класса Student из JSON
    public static Student studentFromJson (String studentJson) {
        logger.log(Level.INFO, "Получен объекта класса Student из JSON");
        return new Gson().fromJson(studentJson, Student.class);
    }

    //Метод получения JSON из объекта класса University
    public static String jsonFromUniversity(University university) {
        logger.log(Level.INFO, "Получен JSON из объекта класса University");
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    //Метод получения объекта класса University из JSON
    public static University universityFromJson(String universityJson) {
        logger.log(Level.INFO, "Получен объект класса University из JSON");
        return new Gson().fromJson(universityJson, University.class);
    }
    */
}