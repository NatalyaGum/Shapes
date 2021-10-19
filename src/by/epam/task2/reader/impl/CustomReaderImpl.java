package by.epam.task2.reader.impl;

import by.epam.task2.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CustomReaderImpl {
    static Logger logger = LogManager.getLogger();

    public List<String> readFile(String pathToFile) throws ShapeException {
        List<String> lineFromFile = new ArrayList<String>();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(new File(pathToFile), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineFromFile.add(line);
            }
        } catch (
                FileNotFoundException e) {
            logger.error(pathToFile + " - the file was not found, ", e);
            throw new ShapeException(pathToFile + " - the file was not found, ", e);
        } catch (IOException e) {
            logger.error(pathToFile + " I/O error ", e);
            throw new ShapeException(pathToFile + " I/O error ", e);
        }
        return lineFromFile;
    }
}
