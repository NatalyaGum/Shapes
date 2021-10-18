package by.epam.task2.factory.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.filler.RepositoryFiller;
import by.epam.task2.filler.WarehouseFiller;
import by.epam.task2.observer.impl.CubeObserverImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class CubeFactory {
    private static Logger logger = LogManager.getLogger();

    public static List<Cube> createCubeListFromPoints(List<Point> points) throws ShapeException {
        List<Cube> cubes = new ArrayList<Cube>();
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        CubeObserverImpl observer = new CubeObserverImpl();
        RepositoryFiller repositoryFiller = new RepositoryFiller();
        Point firstPoint;
        Point secondPoint;
        for (int i = 0; i < points.size(); i += 2) {
            firstPoint = points.get(i);
            secondPoint = points.get(i + 1);
            Cube cube = createCube(firstPoint, secondPoint);
            cubes.add(cube);
            cube.attach(observer);
            warehouseFiller.fillWarehouse(cube);
            repositoryFiller.fillRepository(cube);
        }
        return cubes;
    }

    public static Cube createCube(Point firstPoint, Point secondPoint) throws ShapeException {
        WarehouseFiller warehouseFiller = new WarehouseFiller();
        CubeObserverImpl observer = new CubeObserverImpl();
        RepositoryFiller repositoryFiller = new RepositoryFiller();
        Cube cube = new Cube(firstPoint, secondPoint);
        logger.info("Cube created" + cube);
        cube.attach(observer);
        warehouseFiller.fillWarehouse(cube);
        repositoryFiller.fillRepository(cube);
        return cube;
    }

}
