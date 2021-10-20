package by.epam.task2.service.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.service.ShapeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeServiceImpl implements ShapeService {
    static Logger logger = LogManager.getLogger();

    public double findCubeDiagonal(Point firstPoint, Point secondPoint) {
        double x1 = firstPoint.getX();
        double y1 = firstPoint.getY();
        double z1 = firstPoint.getZ();
        double x2 = secondPoint.getX();
        double y2 = secondPoint.getY();
        double z2 = secondPoint.getZ();
        double diagonal = Math.sqrt((Math.pow((x1 - x2), 2.0)) + (Math.pow((y1 - y2), 2.0)) + (Math.pow((z1 - z2), 2.0)));
        return diagonal;
    }

    public double findCubeDiagonal(Cube cube) {
        double diagonal = findCubeDiagonal(cube.getFirstPoint(), cube.getSecondPoint());
        return diagonal;
    }

    public double findCubeEdge(Point firstPoint, Point secondPoint) {
        double d = findCubeDiagonal(firstPoint, secondPoint);
        double edge = d / Math.sqrt(3);
        return edge;
    }

    public double findCubeEdge(Cube cube) {
        double edge = findCubeEdge(cube.getFirstPoint(), cube.getSecondPoint());
        return edge;
    }

    public double findVolume(Point firstPoint, Point secondPoint) {
        double edge = findCubeEdge(firstPoint, secondPoint);
        double v = Math.pow(edge, 3.0);
        return v;
    }

    public double findVolume(Cube cube) {
        double volume = findVolume(cube.getFirstPoint(), cube.getSecondPoint());
        return volume;
    }

    public double findArea(Point firstPoint, Point secondPoint) {
        double edge = findCubeEdge(firstPoint, secondPoint);
        double area = 6 * Math.pow(edge, 2.0);
        return area;
    }

    public double findArea(Cube cube) {
        double area = findArea(cube.getFirstPoint(), cube.getSecondPoint());
        return area;
    }

    public double findPerimeter(Point firstPoint, Point secondPoint) {
        double edge = findCubeEdge(firstPoint, secondPoint);
        double perimeter = 12 * edge;
        return perimeter;
    }

    public double findPerimeter(Cube cube) {
        double perimeter = findPerimeter(cube.getFirstPoint(), cube.getSecondPoint());
        return perimeter;
    }

    public Point findCenterPoint(Point firstPoint, Point secondPoint) {
        double x1 = firstPoint.getX();
        double y1 = firstPoint.getY();
        double z1 = firstPoint.getZ();
        double x2 = secondPoint.getX();
        double y2 = secondPoint.getY();
        double z2 = secondPoint.getZ();
        Point center = new Point((x1 + x2) / 2, (y1 + y2) / 2, (z1 + z2) / 2);
        return center;
    }

    public Point findCenterPoint(Cube cube) {
        Point center = findCenterPoint(cube.getFirstPoint(), cube.getSecondPoint());
        return center;
    }


    public boolean isShapeOnTheAxis(Cube cube)  {
        Point centerPoint = findCenterPoint(cube);
        double halfEdge = findCubeEdge(cube)/2;
        double x = centerPoint.getX();
        double y = centerPoint.getY();
        double z = centerPoint.getZ();
        if (x - halfEdge == 0 || y - halfEdge == 0 || z - halfEdge == 0||
                x + halfEdge == 0 || y + halfEdge == 0 || z + halfEdge == 0) {
            return true;
        }
        return false;
    }


    public double volumeRatio(Cube cube) {   //one parallel plane
        Point firstPoint = cube.getFirstPoint();
        Point secondPoint = cube.getSecondPoint();
        double x1 = firstPoint.getX();
        double y1 = firstPoint.getY();
        double z1 = firstPoint.getZ();
        double x2 = secondPoint.getX();
        double y2 = secondPoint.getY();
        double z2 = secondPoint.getZ();

        if ((x1 > 0 & 0 > x2) || (x1 < 0 & 0 < x2)) {
            double ratio = Math.abs(x1) / Math.abs(x2);
            return ratio;
        }
        if ((y1 > 0 & 0 > y2) || (y1 < 0 & 0 < y2)) {
            double ratio = Math.abs(y1) / Math.abs(y2);
            return ratio;
        }
        if ((z1 > 0 & 0 > z2) || (z1 < 0 & 0 < z2)) {
            double ratio = Math.abs(z1) / Math.abs(z2);
            return ratio;
        } else {
            logger.info("Cube does not cross coordinate plane.");
            return 0;

        }


    }}
