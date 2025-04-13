public class Main {

    public static void main(String[] args) {

        University university1 = new University("1", "Московский государственный университет",
                "МГУ", 1755, StudyProfile.ECONOMY);

        University university2 = new University("2", "Университет Синергия",
                "Синергия", 1995, StudyProfile.PROGRAMMING);

        Student student1 = new Student("Иванов Иван Иванович", "1",
                2, 5.0f);

        Student student2 = new Student("Петров Петр Петрович", "2",
                4, 4.3f);

        System.out.println(university1);
        System.out.println(university2);
        System.out.println(student1);
        System.out.println(student2);
    }
}