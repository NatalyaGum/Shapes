package by.epam.task2.factory.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CubeFactoryTest {

        @Test
        public void testCreateShapeListFromPoints() throws ShapeException
        {
            List<Point> points = new ArrayList<>();
            points.add(new Point(1.0, 1.0, 10.0));
            points.add(new Point(1.0, 1.0, -1.0));
            points.add(new Point(2.0, 3.0, 4.0));
            points.add(new Point(2.0, 3.0, 0.1));

            List<Cube> expected = new ArrayList<Cube>();
            expected.add(new Cube(new Point(1.0, 1.0, 10.0), new Point(1.0, 1.0, -1.0)));
            expected.add(new Cube(new Point(2.0, 3.0, 4.0), new Point(2.0, 3.0, 0.1)));

            CubeFactory factory= new CubeFactory();
            List<Cube>actual=factory.createShapeListFromPoints(points);
            Assert.assertEquals(actual, expected);
        }

        @Test(expectedExceptions = ShapeException.class, expectedExceptionsMessageRegExp = ".*Attempt to create cube with null/same arguments.*")
        public void testCreateShape() throws ShapeException {
            Point firstPoint=new Point(100,100,100);
            Point secondPoint=new Point(100,100,100);
            CubeFactory factory= new CubeFactory();
            Cube actual= factory.createShape(firstPoint,secondPoint);

        }
    }