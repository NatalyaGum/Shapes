package by.epam.task2.parser.impl;


import by.epam.task2.parser.Parser;
import by.epam.task2.validator.impl.PointValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    static Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_SPLIT = ",";

    public List<Double> parseCoordinate(List<String> linesFromFile) {
        PointValidatorImpl validator = new PointValidatorImpl();
        List<Double> points = new ArrayList<>();

        if (!linesFromFile.isEmpty()) {
            for (String line : linesFromFile) {
                if (validator.validateCoordinate(line)) {
                    String[] pointsLine = line.split(REGEX_FOR_SPLIT);
                    for (int i = 0; i < pointsLine.length; i ++) {
                        double x = Double.parseDouble(pointsLine[i]);
                        points.add(x);}
                } else {
                    logger.info("Validaion was failed for: " + line);
                }
            }
        }
        return points;
    }
}




