package by.epam.task2.comparator;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CubeDiagonalComparatorTest {

    @Test
    public void testCompare() {
        Cube cube1 = new Cube(new Point(10, 25.0, 10), new Point(30.0, 45.0, 30.0));
        Cube cube2 = new Cube(new Point(5, 0, -3), new Point(30, 25.0, -28.0));
        int expected = -1;
        CubeDiagonalComparator c = new CubeDiagonalComparator();
        int actual = c.compare(cube1, cube2);
        Assert.assertEquals(actual, expected);
    }


}