package io;

import model.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.StatisticsUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class XlsWriter {

    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());

    private XlsWriter() {
    }

    public static void createXlsFileWithStatistics(List<Statistics> statisticsList, String pathExcelFile) {
        //Создаем книгу
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Создаем лист
        XSSFSheet sheet = workbook.createSheet("Статистика по университетам");

        //Создаем шрифт для заголовков таблицы
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        //Создаем стиль для заголовков таблицы и передаем шрифт
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int rowN = 0;
        //Заполняем ячейки строки заголовка
        Row headerRow = sheet.createRow(rowN++);
        //Ячейка для профиля института
        Cell mainProfileCellHeader = headerRow.createCell(0);
        mainProfileCellHeader.setCellValue("Профиль обучения");
        mainProfileCellHeader.setCellStyle(headerStyle);

        //Ячейка для среднего бала студентов
        Cell avgExamScoreCellHeader = headerRow.createCell(1);
        avgExamScoreCellHeader.setCellValue("Средний балл");
        avgExamScoreCellHeader.setCellStyle(headerStyle);

        //Ячейка для количества студентов
        Cell countOfStudentsCellHeader = headerRow.createCell(2);
        countOfStudentsCellHeader.setCellValue("Количество студентов");
        countOfStudentsCellHeader.setCellStyle(headerStyle);

        //Ячейка для количества университетов
        Cell countOfUniversitiesCellHeader = headerRow.createCell(3);
        countOfUniversitiesCellHeader.setCellValue("Количество университетов");
        countOfUniversitiesCellHeader.setCellStyle(headerStyle);

        //Ячейка для списка университетов
        Cell universitiesCellHeader = headerRow.createCell(4);
        universitiesCellHeader.setCellValue("Список университетов");
        universitiesCellHeader.setCellStyle(headerStyle);

        for (Statistics statistics : statisticsList) {
            Row dataRow = sheet.createRow(rowN++);

            //Ячейка для значения профиля
            Cell mainProfileCell = dataRow.createCell(0);
            mainProfileCell.setCellValue(statistics.getMainProfile().getProfileName());

            //Ячейка для значения среднего бала
            Cell avgExamScoreCell = dataRow.createCell(1);
            avgExamScoreCell.setCellValue(statistics.getAvgExamScore());

            //Ячейка для значения количества студентов
            Cell countOfStudentsCell = dataRow.createCell(2);
            countOfStudentsCell.setCellValue(statistics.getCountOfStudents());

            //Ячейка для значения количества университетов
            Cell countOfUniversitiesCell = dataRow.createCell(3);
            countOfUniversitiesCell.setCellValue(statistics.getCountOfUniversities());

            //Ячейка для списка университетов
            Cell universitiesCell = dataRow.createCell(4);
            universitiesCell.setCellValue(statistics.getNameOfUniversities());
        }

        try (FileOutputStream outputStream = new FileOutputStream(pathExcelFile)) {
            workbook.write(outputStream);
            logger.log(Level.INFO, "Создан файл статистики");
        } catch (IOException e){
            logger.log(Level.WARNING, "Ошибка создания файла статистики");
            String diagnosticTrace = Arrays.stream(Thread.currentThread().getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            logger.log(Level.WARNING, diagnosticTrace);
            logger.log(Level.WARNING, "--------------");
        }
    }
}