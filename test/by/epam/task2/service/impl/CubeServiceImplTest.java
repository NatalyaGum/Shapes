package by.epam.task2.service.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeServiceImplTest {

    Point point1=new Point(10.0,25.0,10);
    Point point2 =new Point(30.0,45.0,30.0);
    Point point3 =new Point(5,0,-3);
    Point point4=new Point(30,25.0,-28.0);
    Point point5 =new Point(-20,40,5);
    Point point6=new Point(10,10.0,35.0);
    Cube cube=new Cube(point1, point2);
    Cube cube2=new Cube(point3,point4);
    Cube crossingCube=new Cube(point5,point6);
    CubeServiceImpl service=new CubeServiceImpl();

    @Test
    public void testFindCubeDiagonal() {
        double actual= service.findCubeDiagonal(point1, point2);
        double expected=34.64;
        Assert.assertEquals(actual, expected,0.01);


    }

    @Test
    public void testTestFindCubeDiagonal() {
        double actual= service.findCubeDiagonal(cube);
        double expected=34.64;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testFindCubeEdge() {
        double actual= service.findCubeEdge(cube);
        double expected=20;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testTestFindCubeEdge() {
        double actual= service.findCubeEdge(point1, point2);
        double expected=20;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testFindVolume() {
        double actual= service.findVolume(point1, point2);
        double expected=8000;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testTestFindVolume() {
        double actual= service.findVolume(cube);
        double expected=8000;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testFindArea() {
        double actual= service.findArea(cube);
        double expected=2400;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testTestFindArea() {
        double actual= service.findArea(point1, point2);
        double expected=2400;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testFindPerimeter() {
        double actual= service.findPerimeter(point1, point2);
        double expected=240;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testTestFindPerimeter() {
        double actual= service.findPerimeter(cube);
        double expected=240;
        Assert.assertEquals(actual, expected,0.01);
    }

    @Test
    public void testFindCenterPoint() {
        Point actual= service.findCenterPoint(cube);
        Point expected=new Point (20.0,35.0,20.0);;
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void testIsShapeOnTheAxis( ) {
        boolean actual= service.isShapeOnTheAxis(cube2);
        boolean expected=true;
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testVolumeRatio() {
        double actual= service.volumeRatio(crossingCube);
        double expected=2;
        Assert.assertEquals(actual, expected,0.01);

    }
}