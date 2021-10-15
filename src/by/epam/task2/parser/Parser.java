package by.epam.task2.parser;

import by.epam.task2.entity.Point;

import java.util.ArrayList;
import java.util.List;

public interface Parser {
    ArrayList<Point> parsePoints(List<String> linesFromFile);
}
