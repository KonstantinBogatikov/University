import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Student> studentList = CollectionsCreator.getSudentsList();
        studentList.forEach(System.out::println);

        List<University> universitiesList = CollectionsCreator.getUniversitiesList();
        universitiesList.forEach(System.out::println);
    }
}