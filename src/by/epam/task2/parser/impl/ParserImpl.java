package by.epam.task2.parser.impl;

import by.epam.task2.entity.Point;
import by.epam.task2.factory.impl.PointFactoryImpl;
import by.epam.task2.parser.Parser;
import by.epam.task2.validator.impl.PointValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    static Logger logger = LogManager.getLogger();

    private static final String REGEX_FOR_SPLIT = ",";

    public ArrayList<Point> parsePoints(List<String> linesFromFile) {
        PointValidatorImpl validator = new PointValidatorImpl();
        ArrayList<Point> points = new ArrayList<>();
        PointFactoryImpl pointFactory = new PointFactoryImpl();

        if (!linesFromFile.isEmpty()) {
            for (String line : linesFromFile) {
                if (validator.validatePoints(line)) {
                    String[] pointsLine = line.split(REGEX_FOR_SPLIT);
                    for (int i = 0; i < pointsLine.length; i += 3) {
                        double x = Double.parseDouble(pointsLine[i]);
                        double y = Double.parseDouble(pointsLine[i + 1]);
                        double z = Double.parseDouble(pointsLine[i + 2]);
                        Point point = pointFactory.createPoint(x, y, z);
                        points.add(point);
                    }
                } else {
                    logger.info("Validaion was failed for: " + line);
                }
            }
        }
        return points;
    }
}




