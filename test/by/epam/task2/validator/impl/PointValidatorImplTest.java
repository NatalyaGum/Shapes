package by.epam.task2.validator.impl;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointValidatorImplTest {

    PointValidatorImpl validator = new PointValidatorImpl();

    @DataProvider(name = "testValidation")
    public Object[][] createData() {
        return new Object[][]{
                {"2.0, 3, 4, 2.0, 3, 0.1,", true},
                {" 1d, 12.1", false},
                {"k.lk, abc", false},
                {"2.2", false}};
    }
    @Test(dataProvider = "testValidation")
    public void testValidateCoordinate(String line, boolean expected) {
        boolean actual = validator.validateCoordinate(line);
        Assert.assertEquals(actual, expected);
    }

}

