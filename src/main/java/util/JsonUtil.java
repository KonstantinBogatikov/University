package util;

import model.Student;
import model.University;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    //Метод получения JSON из List<Student>
    public static String toJsonFromStudents(List<Student> studentsList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(studentsList);
    }

    //Метод получения List<Student> из JSON
    public static List<Student> toStudentsFromJson(String studentsListJson) {
        return new Gson().fromJson(studentsListJson, new TypeToken<List<Student>>() {}.getType());
    }

    //Метод получения JSON из List<University>
    public static String toJsonFromUniversities(List<University> universitiesList) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universitiesList);
    }

    //Метод получения List<University> из JSON
    public static List<University> toUniversitiesFromJson(String universitiesListJson) {
        return new Gson().fromJson(universitiesListJson, new TypeToken<List<University>>() {}.getType());
    }

    //Метод получения JSON из объекта класса Student
    public static String jsonFromStudent (Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    //Метод получения объекта класса Student из JSON
    public static Student studentFromJson (String studentJson) {
        return new Gson().fromJson(studentJson, Student.class);
    }

    //Метод получения JSON из объекта класса University
    public static String jsonFromUniversity(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    //Метод получения объекта класса University из JSON
    public static University universityFromJson(String universityJson) {
        return new Gson().fromJson(universityJson, University.class);
    }
}