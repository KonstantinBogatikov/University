package io;

import model.XMLInfo;
import util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void generateJSON(XMLInfo xmlInfo) {
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Создан каталог jsonReqs");
        } catch (IOException e) {
            logger.log(Level.FINE, "Каталог jsonReqs уже существует", e);
        }

        writeStudentsOnJsonFile(xmlInfo);
        writeUniversitiesOnJsonFile(xmlInfo);
        writeStatisticsListOnJsonFile(xmlInfo);

        logger.log(Level.INFO, "Генерация JSON файлов завершена");
    }

    private static void writeStudentsOnJsonFile(XMLInfo xmlInfo) {
        String studentsJson = JsonUtil.writeListToJson(xmlInfo.getStudentsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/students" + xmlInfo.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Ошибка записи данных в students.json");
            String diagnosticTrace = Arrays.stream(Thread.currentThread().getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            logger.log(Level.WARNING, diagnosticTrace);
            logger.log(Level.WARNING, "--------------");
        }
    }

    private static void writeUniversitiesOnJsonFile(XMLInfo xmlInfo) {
        String universitiesJson = JsonUtil.writeListToJson(xmlInfo.getUniversitiesList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/universities" + xmlInfo.getProcessDate().getTime() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Ошибка записи данных в universities.json");
            String diagnosticTrace = Arrays.stream(Thread.currentThread().getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            logger.log(Level.WARNING, diagnosticTrace);
            logger.log(Level.WARNING, "--------------");
        }
    }

    private static void writeStatisticsListOnJsonFile(XMLInfo xmlInfo) {
        String studentsJson = JsonUtil.writeListToJson(xmlInfo.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/statistics" + xmlInfo.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Ошибка записи данных в statistics.json");
            String diagnosticTrace = Arrays.stream(Thread.currentThread().getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            logger.log(Level.WARNING, diagnosticTrace);
            logger.log(Level.WARNING, "--------------");
        }
    }
}
