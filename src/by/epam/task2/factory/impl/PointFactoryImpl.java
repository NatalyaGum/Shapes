package by.epam.task2.factory.impl;

import by.epam.task2.entity.Point;
import by.epam.task2.factory.PointFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointFactoryImpl implements PointFactory {
    private static Logger logger = LogManager.getLogger();

   public PointFactoryImpl() {

   }

    @Override
    public Point createPoint(double x, double y, double z) {

        Point point = new Point(x, y, z);
        logger.info("Point created"+ point);

        return point;
    }

}
