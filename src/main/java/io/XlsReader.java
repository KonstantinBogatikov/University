package io;

import model.Student;
import enums.StudyProfile;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class XlsReader {

    private static final Logger logger = Logger.getLogger(XlsReader.class.getName());

    private static XlsReader xlsReaderInstance;
    private static String pathExcelFile = "src/main/resources/ExcelFiles/universityInfo.xlsx";

    private XlsReader() {
    }

    public static XlsReader getInstance() {
        if (xlsReaderInstance == null) {
            xlsReaderInstance = new XlsReader();
        }
        return xlsReaderInstance;
    }

    public static List<Student> getSudentsList() {
        List<Student> studentsList = new ArrayList<>();
        try {
            XSSFSheet studentsSheet = (XSSFSheet) getSheet("Студенты");
            Iterator<Row> studentsListIterator = studentsSheet.iterator();
            studentsListIterator.next();
            while (studentsListIterator.hasNext()) {
                Row row = studentsListIterator.next();
                Student student = new Student(
                        row.getCell(1).getStringCellValue(),
                        row.getCell(0).getStringCellValue(),
                        (int) row.getCell(2).getNumericCellValue(),
                        (float) row.getCell(3).getNumericCellValue());

                studentsList.add(student);
            }
            logger.log(Level.INFO, "Прочитан файл universityInfo.xlsx, сформирован List<Student>");
            return studentsList;
        } catch (IOException e) {
            //System.out.println("Ошибка чтения файла universityInfo.xlsx");
            logger.log(Level.WARNING, "Ошибка чтения файла universityInfo.xlsx");
            String diagnosticTrace = Arrays.stream(Thread.currentThread().getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            logger.log(Level.WARNING, diagnosticTrace);
            logger.log(Level.WARNING, "--------------");
        }
        return new ArrayList<>();
    }

    public static List<University> getUniversitiesList() {
        List<University> universitiesList = new ArrayList<>();
        try {
            XSSFSheet universitiesSheet = (XSSFSheet) getSheet("Университеты");
            Iterator<Row> universitiesListIterator = universitiesSheet.iterator();
            universitiesListIterator.next();
            while (universitiesListIterator.hasNext()) {
                Row row = universitiesListIterator.next();
                University university = new University(
                        row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        (int) row.getCell(3).getNumericCellValue(),
                        StudyProfile.valueOf(row.getCell(4).getStringCellValue()));

                universitiesList.add(university);
            }
            logger.log(Level.INFO, "Прочитан файл universityInfo.xlsx, сформирован List<University>");
            return universitiesList;
        } catch (IOException e) {
            //System.out.println("Ошибка чтения файла universityInfo.xlsx");
            logger.log(Level.WARNING, "Ошибка чтения файла universityInfo.xlsx");
            String diagnosticTrace = Arrays.stream(Thread.currentThread().getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            logger.log(Level.WARNING, diagnosticTrace);
            logger.log(Level.WARNING, "--------------");
        }
        return new ArrayList<>();
    }

    private static Sheet getSheet(String sheetName) throws IOException {
        FileInputStream streamExcelFile = new FileInputStream(pathExcelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(streamExcelFile);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        return sheet;
    }
}