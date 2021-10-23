package by.epam.task2.service;


import by.epam.task2.entity.Point;

public interface ShapeService {

     double findVolume(Point firstPoint, Point secondPoint);

     double findArea(Point firstPoint, Point secondPoint);

     double findPerimeter(Point firstPoint, Point secondPoint);

}
