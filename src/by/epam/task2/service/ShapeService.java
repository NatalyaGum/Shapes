package by.epam.task2.service;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;

public interface ShapeService {

    public double findVolume(Point firstPoint, Point secondPoint);

    public double findArea(Point firstPoint, Point secondPoint);

    public double findPerimeter(Point firstPoint, Point secondPoint);

    public Point findCenterPoint(Point firstPoint, Point secondPoint);


}
