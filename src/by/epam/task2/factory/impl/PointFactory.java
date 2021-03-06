package by.epam.task2.factory.impl;

import by.epam.task2.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class PointFactory {
    private static Logger logger = LogManager.getLogger();

    public PointFactory() {

    }


    public List<Point> createPoint(List<Double> listOfDouble) {
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < listOfDouble.size(); i += 3) {
            double x = listOfDouble.get(i);
            double y = listOfDouble.get(i + 1);
            double z = listOfDouble.get(i + 2);
            Point point = new Point(x, y, z);
            points.add(point);
        }
        return points;
    }
}
