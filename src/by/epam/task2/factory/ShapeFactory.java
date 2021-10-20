package by.epam.task2.factory;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;

import java.util.List;

public interface ShapeFactory {
    List<Cube> createShapeListFromPoints(List<Point> points) throws ShapeException;

    Cube createShape(Point firstPoint, Point secondPoint) throws ShapeException;

}
