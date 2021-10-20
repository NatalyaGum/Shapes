package by.epam.task2.parser;

import java.util.List;

public interface Parser {
    List<Double> parseCoordinate(List<String> linesFromFile);
}
