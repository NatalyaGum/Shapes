package by.epam.task2.service.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PointServiceTest {

    Point firstPoint=new Point(10,25.0,10);
    Point secondPoint=new Point(30.0,55.0,30.0);

    Point thirdPoint=new Point(2.5,-1.0,1.0);
    Point fourthPoint=new Point(5.5,2,4.0);
    Cube cube=new Cube(firstPoint,secondPoint);

    PointService pointService= new PointService();

    @Test
    public void testFindCenterPoint() {
        Point actual=pointService.findCenterPoint(firstPoint,secondPoint);
        Point expected=new Point (10.0,40.0,10.0);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testTestFindCenterPoint() {
        Point actual=pointService.findCenterPoint(cube);
        Point expected=new Point (10.0,40.0,10.0);
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testFindVertexCube() {
        List<Point> expected=new ArrayList<>();
        expected.add(new Point(10,25,10));
        expected.add(new Point(10,55,10));
        expected.add(new Point(3,55,10));
        expected.add(new Point(3,25,10));
        expected.add(new Point(10,25,30));
        expected.add(new Point(10,55,30));
        expected.add(new Point(30,55,30));
        expected.add(new Point(30,25,30));
        List<Point> actual = pointService.findVertexCube(cube);
        Assert.assertEquals(actual, expected);
    }
}