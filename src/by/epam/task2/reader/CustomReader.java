package by.epam.task2.reader;

import by.epam.task2.exception.ShapeException;

import java.util.List;

public interface CustomReader {
    List<String> readFile(String pathToFile) throws ShapeException;
}
