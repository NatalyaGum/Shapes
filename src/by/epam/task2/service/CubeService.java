package by.epam.task2.service;

import by.epam.task2.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeService {
    static Logger logger = LogManager.getLogger();

    public double findCubeDiagonal(Point firstPoint, Point secondPoint) {
        double x1 = firstPoint.getX();
        double y1 = firstPoint.getY();
        double z1 = firstPoint.getZ();
        double x2 = secondPoint.getX();
        double y2 = secondPoint.getY();
        double z2 = secondPoint.getZ();
        double diagonal = Math.sqrt((Math.pow((x1-x2),2.0))+(Math.pow((y1-y2),2.0))+(Math.pow((z1-z2),2.0)));

        return diagonal;
    }

    public double findCubeEdge(Point firstPoint, Point secondPoint) {
        double d=findCubeDiagonal(firstPoint, secondPoint);
        double edge=d/Math.sqrt(3);
        return edge;
    }

    public double findCubeVolume(Point firstPoint, Point secondPoint) {
        double edge=findCubeEdge(firstPoint, secondPoint);
        double v=Math.pow(edge,3.0);
        return v;
    }

    public double findCubeSquare(Point firstPoint, Point secondPoint) {
        double edge=findCubeEdge(firstPoint, secondPoint);
        double s=6*Math.pow(edge,2.0);
        return s;
    }
    public double findCubePerimeter(Point firstPoint, Point secondPoint) {
        double edge=findCubeEdge(firstPoint, secondPoint);
        double p=12*edge;
        return p;
    }


}
