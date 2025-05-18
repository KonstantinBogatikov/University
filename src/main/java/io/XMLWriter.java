package io;

import model.XMLInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class XMLWriter {

    private static final Logger logger = Logger.getLogger(XMLWriter.class.getName());

    private XMLWriter() {
    }

    public static void generateXMLFileReq(XMLInfo xmlInfo) {
        try {

            //Создание  JAXB Marshaller и его настройка
            JAXBContext context = JAXBContext.newInstance(XMLInfo.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Создание каталога xmlReqs
            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Создан каталог xmlReqs");
            } catch (IOException e) {
                logger.log(Level.FINE, "Каталог xmlReqs уже существует", e);
            }

            //Создание файла Req+date.xml и запись данных
            File file = new File("xmlReqs/Req" + new Date().getTime() + ".xml");
            marshaller.marshal(xmlInfo, file);
        } catch (JAXBException e) {
            logger.log(Level.WARNING, "Ошибка создания Marshaller");
            String diagnosticTrace = Arrays.stream(Thread.currentThread().getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining(System.lineSeparator()));
            logger.log(Level.WARNING, diagnosticTrace);
            logger.log(Level.WARNING, "--------------");
        }
        logger.log(Level.INFO, "XML файл Req сформирован");
    }
}
