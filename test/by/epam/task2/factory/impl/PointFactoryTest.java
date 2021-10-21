package by.epam.task2.factory.impl;

import by.epam.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;



public class PointFactoryTest {


    @Test
    public void testCreatePoint() {
        List<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(1.0);
        list.add(10.0);
        list.add(1.0);
        list.add(1.0);
        list.add(-1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);
        list.add(2.0);
        list.add(3.0);
        list.add(0.1);

        List<Point> expected = new ArrayList<Point>();
        expected.add(new Point(1.0,1.0,10.0));
        expected.add(new Point(1.0,1.0,-1.0));
        expected.add(new Point(2.0,3.0,4.0));
        expected.add(new Point(2.0,3.0,0.1));

        PointFactory pointFactory= new PointFactory();
        List<Point> actual= pointFactory.createPoint(list);

        Assert.assertEquals(actual, expected);
    }


}