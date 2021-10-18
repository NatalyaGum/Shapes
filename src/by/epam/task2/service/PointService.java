package by.epam.task2.service;

import by.epam.task2.entity.Point;
import by.epam.task2.entity.Cube;
import java.util.ArrayList;
import java.util.List;

public class PointService {

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

    public List<Point> findVertexCube(Cube cube) {
        List<Point> vertexPoints = new ArrayList<>();
        CubeService service= new CubeService();
        double halfEdge = service.findCubeEdge(cube) / 2;
        Point centerPoint=findCenterPoint(cube);

        // 4 points below of center point
        double zLow = centerPoint.getZ() - halfEdge;
        Point point1 = findFirstPoint(centerPoint, halfEdge, zLow);
        Point point2 = findSecondPoint(centerPoint, halfEdge, zLow);
        Point point3 = findThirdPoint(centerPoint, halfEdge, zLow);
        Point point4 = findFourthPoint(centerPoint, halfEdge, zLow);

        vertexPoints.add(point1);
        vertexPoints.add(point2);
        vertexPoints.add(point3);
        vertexPoints.add(point4);

        // 4 points above of center point
        double zHigh = centerPoint.getZ() + halfEdge;
        Point point5 = findFirstPoint(centerPoint, halfEdge, zHigh);
        Point point6 = findSecondPoint(centerPoint, halfEdge, zHigh);
        Point point7 = findThirdPoint(centerPoint, halfEdge, zHigh);
        Point point8 = findFourthPoint(centerPoint, halfEdge, zHigh);

        vertexPoints.add(point5);
        vertexPoints.add(point6);
        vertexPoints.add(point7);
        vertexPoints.add(point8);

        return vertexPoints;
    }

    private Point findFirstPoint(Point centerPoint, double halfSideLength, double z) {
        double x = centerPoint.getX() - halfSideLength;
        double y = centerPoint.getY() - halfSideLength;
        return new Point(x, y, z);
    }

    private Point findSecondPoint(Point centerPoint, double halfSideLength, double z) {
        double x = centerPoint.getX() + halfSideLength;
        double y = centerPoint.getY() - halfSideLength;
        return new Point(x, y, z);
    }

    private Point findThirdPoint(Point centerPoint, double halfSideLength, double z) {
        double x = centerPoint.getX() - halfSideLength;
        double y = centerPoint.getY() + halfSideLength;
        return new Point(x, y, z);
    }

    private Point findFourthPoint(Point centerPoint, double halfSideLength, double z) {
        double x = centerPoint.getX() + halfSideLength;
        double y = centerPoint.getY() + halfSideLength;
        return new Point(x, y, z);
    }
}
