package by.epam.task2.warehouse.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.CubeParameter;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class CubeWarehouseImplTest {

    private CubeWarehouseImpl warehouse;
    private Map<String, CubeParameter> expectedMap;
    private CubeParameter expectedParameters;
    private CubeParameter parameters;
    String id;

    @BeforeMethod
    public void initialize() {
        warehouse = CubeWarehouseImpl.getInstanceWarehouse();
        expectedMap = new HashMap<>();
        parameters = new CubeParameter(240.0, 2400.0, 8000.0, 34.64);
        expectedParameters = new CubeParameter(240.0, 2400.0, 8000.0, 34.64);
        id = "1";
        expectedMap.put(id, expectedParameters);
    }


    @Test
    public void testPutParameters() {
        warehouse.putParameters(id, parameters);
        Map<String, CubeParameter> actual = warehouse.getWarehouse();
        Assert.assertEqualsDeep(actual, expectedMap);
    }


    @Test
    public void testGetParameter() throws ShapeException {
        warehouse.putParameters(id, parameters);
        CubeParameter actual = warehouse.getParameter("1");
        Assert.assertEquals(actual, expectedParameters);
    }


    @Test//(enabled = false)
    public void testUpdateParameter() throws ShapeException {
        warehouse.putParameters(id, parameters);
        warehouse.updateParameter("1", 241.0, 2410.0, 8100.0, 35.64);
        expectedParameters = new CubeParameter(241.0, 2410.0, 8100.0, 35.64);
        Map<String, CubeParameter> actual = warehouse.getWarehouse();
        expectedMap.put(id, expectedParameters);
        Assert.assertEqualsDeep(actual, expectedMap);
    }

    @Test
    public void testTestUpdateParameter() throws ShapeException {
        warehouse.putParameters(id, parameters);
        Cube cube = new Cube(new Point(11.0, 26.0, 11), new Point(30.0, 45.0, 30.0));
        cube.setCubeId("1");
        expectedParameters = new CubeParameter(228.0, 2166.0, 6859.0, 32.91);
        warehouse.updateParameter(cube);
        Map<String, CubeParameter> actual = warehouse.getWarehouse();
        expectedMap.put(id, expectedParameters);
        Assert.assertEqualsDeep(actual, expectedMap);
    }


    @Test
    public void testGetWarehouse() {
        warehouse.putParameters(id, parameters);
        Map<String, CubeParameter> actual = warehouse.getWarehouse();
        Assert.assertEquals(expectedMap, actual);

    }

    @Test
    public void testRemove() {
        warehouse.putParameters(id, parameters);
        warehouse.remove(id);
        boolean actual = warehouse.getWarehouse().isEmpty();
        Assert.assertTrue(actual);

    }

}