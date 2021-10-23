package by.epam.task2.observer.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.CubeParameter;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.filler.WarehouseFiller;
import by.epam.task2.observer.CubeEvent;
import by.epam.task2.observer.Observer;
import by.epam.task2.warehouse.impl.CubeWarehouseImpl;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CubeObserverImplTest {

    private Observer observer;
    private Cube cube;
    private CubeEvent event;
    private CubeWarehouseImpl warehouse;
    private WarehouseFiller warehouseFiller;

    @BeforeMethod
    public void initialize() {
        observer = new CubeObserverImpl();
        warehouse = CubeWarehouseImpl.getInstanceWarehouse();
        cube = new Cube(new Point(10, 25.0, 10), new Point(30.0, 45.0, 30.0));
        cube.attach(observer);
        event = new CubeEvent(cube);
        warehouseFiller = new WarehouseFiller();
        warehouseFiller.fillWarehouse(cube);

    }


    @Test
    public void testParameterChanged() throws ShapeException {
        observer.parameterChanged(event);
        CubeParameter actual = warehouse.getParameter(cube.getCubeId());
        CubeParameter expected = new CubeParameter(240.0, 2400.0, 8000.0, 34.64);
        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void close() {
        observer = null;
        warehouse = null;
        cube = null;
        event = null;
        warehouseFiller = null;
    }
}