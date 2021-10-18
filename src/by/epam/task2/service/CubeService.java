package by.epam.task2.service;

import by.epam.task2.entity.Cube;
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

    public double findCubeVolume(Point firstPoint, Point secondPoint) {
        double edge = findCubeEdge(firstPoint, secondPoint);
        double v = Math.pow(edge, 3.0);
        return v;
    }

    public double findCubeVolume(Cube cube) {
        double volume = findCubeVolume(cube.getFirstPoint(), cube.getSecondPoint());
        return volume;
    }

    public double findCubeArea(Point firstPoint, Point secondPoint) {
        double edge = findCubeEdge(firstPoint, secondPoint);
        double area = 6 * Math.pow(edge, 2.0);
        return area;
    }

    public double findCubeArea(Cube cube) {
        double area = findCubeArea(cube.getFirstPoint(), cube.getSecondPoint());
        return area;
    }

    public double findCubePerimeter(Point firstPoint, Point secondPoint) {
        double edge = findCubeEdge(firstPoint, secondPoint);
        double perimeter = 12 * edge;
        return perimeter;
    }

    public double findCubePerimeter(Cube cube) {
        double perimeter = findCubePerimeter(cube.getFirstPoint(), cube.getSecondPoint());
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

    public boolean isCubeOnTheAxis(Cube cube) {

        PointService service = new PointService();
        Point centerPoint = service.findCenterPoint(cube);
        double halfEdge = findCubeEdge(cube) / 2;
        double x = centerPoint.getX();
        double y = centerPoint.getY();
        double z = centerPoint.getZ();
        if (x - halfEdge == 0 || y - halfEdge == 0 || z - halfEdge == 0 ||
                x + halfEdge == 0 || y + halfEdge == 0 || z + halfEdge == 0) {
            return true;
        }
        return false;
    }

}
