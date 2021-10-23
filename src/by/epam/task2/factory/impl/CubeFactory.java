package by.epam.task2.factory.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.factory.ShapeFactory;
import by.epam.task2.observer.impl.CubeObserverImpl;
import by.epam.task2.validator.impl.CubeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;


public class CubeFactory implements ShapeFactory {
    private static Logger logger = LogManager.getLogger();

    public List<Cube> createShapeListFromPoints(List<Point> points) throws ShapeException {
        CubeObserverImpl observer = new CubeObserverImpl();
        CubeValidator validator = new CubeValidator();
        List<Cube> cubes = new ArrayList<Cube>();
        Point firstPoint;
        Point secondPoint;

        for (int i = 0; i < points.size(); i += 2) {

            firstPoint = points.get(i);
            secondPoint = points.get(i + 1);
            Cube cube = createShape(firstPoint, secondPoint);
            cubes.add(cube);
            cube.attach(observer);
        }
        return cubes;
    }

    public Cube createShape(Point firstPoint, Point secondPoint) throws ShapeException {
        CubeObserverImpl observer = new CubeObserverImpl();
        CubeValidator validator = new CubeValidator();
        Cube cube = null;
        if (validator.validatePoints(firstPoint, secondPoint)) {
            cube = new Cube(firstPoint, secondPoint);
            cube.attach(observer);
            logger.info("Cube created" + cube);
        }
        return cube;
    }

}
