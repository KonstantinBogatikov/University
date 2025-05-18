package util;

import enums.StudyProfile;
import io.XlsReader;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticsUtil {

    private static final Logger logger = Logger.getLogger(StatisticsUtil.class.getName());

    private StatisticsUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {

        List<Statistics> statisticsList = new ArrayList<>();

        //Собираем сет из профилей университетов
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setMainProfile(profile);

            //Получаем список идентификаторов университетов, которые соответствуют профилю
            List<String> universityIdsList = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .toList();

            statistics.setNameOfUniversities(StringUtils.EMPTY);
            //Формируем строку со списком университетов и записываем ее в поле статистики
            universities.stream()
                    .filter(university -> universityIdsList.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setNameOfUniversities(
                            statistics.getNameOfUniversities() + fullNameUniversity + "; "));

            //Заполняем в статистике количество университетов
            statistics.setCountOfUniversities(universityIdsList.size());

            //Получаем список студентов, которые учатся в университетах определенного профиля.
            //Сравниваются ID университета и ID университета у объекта студент.
            List<Student> studentsList = students.stream()
                    .filter(student -> universityIdsList.contains(student.getUniversityId()))
                    .toList();

            //Заполняем в статистике количество студентов
            statistics.setCountOfStudents(studentsList.size());

            //Получаем Optional среднего бала
            OptionalDouble avgExamScore = studentsList.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            //Устанавливаем 0, если вдруг нет студентов у университета, а значит нет среднего бала
            statistics.setAvgExamScore(0);
            //Заполняем средний бал в статистике
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });
        logger.log(Level.INFO, "Сформирована статистика по университетам и студентам");
        return statisticsList;
    }
}