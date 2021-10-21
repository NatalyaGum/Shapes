package by.epam.task2.reader.impl;

import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CustomReaderImplTest {

    CustomReaderImpl reader;
    String pathToFile = "test_resources/test.txt";
    String wrongPathToFile = "wrong/test.txt";
    List<String> expected = Arrays.asList("0,0,0,1.1,1.1,1.1,",
                                        "1, 1, 10, 1, 1, -1,",
                                        "2.0, 3, 4, 2.0, 3, 0.1,",
                                        "1d, 12.1",
                                         "abc",
                                         "a, b",
                                        "1, 9, 12.0, 1, 9, 3,",
                                        "10, 87, 19, 10, 87, 10,",
                                        "0,0,0,1,0,0,");

    @BeforeMethod
    public void setUp() {
        reader = new CustomReaderImpl();
    }

    @Test
    public void testReadFile() throws ShapeException {
        List<String> actual = reader.readFile(pathToFile);
        Assert.assertEquals(actual, expected);
    }

        @Test(expectedExceptions = ShapeException.class, expectedExceptionsMessageRegExp = ".*the file was not found.*")
        public void testReadExceptionFileNotFound() throws ShapeException {
            Point firstPoint=new Point(100,100,100);
            Point secondPoint=new Point(100,100,100);
            reader.readFile(wrongPathToFile);
    }
}