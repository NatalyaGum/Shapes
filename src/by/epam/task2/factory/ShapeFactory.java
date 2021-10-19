package by.epam.task2.factory;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;

import java.util.List;

public interface ShapeFactory {
    List<Cube> createCubeListFromPoints(List<Point> points) throws ShapeException;

    Cube createCube(Point firstPoint, Point secondPoint) throws ShapeException;

}
