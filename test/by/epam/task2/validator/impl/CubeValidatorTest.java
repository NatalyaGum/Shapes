package by.epam.task2.validator.impl;

import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class CubeValidatorTest {

    CubeValidator cubeValidator;
    Point firstPoint=new Point(100,100,100);
    Point secondPoint=new Point(0,0,0);

    @BeforeMethod
    public void initialize() {
        cubeValidator =new CubeValidator();
    }
    @Test
    public void testValidatePoints() throws ShapeException {
        boolean actual = cubeValidator.validatePoints(firstPoint,secondPoint);
        boolean expected=true;
        Assert.assertEquals(actual, expected);

    }

    }

