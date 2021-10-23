package by.epam.task2.filler;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.CubeParameter;
import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.observer.CubeEvent;
import by.epam.task2.observer.Observer;
import by.epam.task2.observer.impl.CubeObserverImpl;
import by.epam.task2.warehouse.impl.CubeWarehouseImpl;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class WarehouseFillerTest {

    private CubeWarehouseImpl warehouse;
    private WarehouseFiller warehouseFiller;

    @BeforeMethod
    public void initialize() {
        warehouse = CubeWarehouseImpl.getInstanceWarehouse();
        warehouseFiller = new WarehouseFiller();
    }

    @Test
    public void testFillWarehouse() {

        List<Cube> cubes = new ArrayList<Cube>();
        cubes.add(new Cube(new Point(10.0, 25.0, 10), new Point(30.0, 45.0, 30.0)));
        cubes.add(new Cube(new Point(5, 0, -3), new Point(30, 25.0, -28.0)));
        cubes.get(0).setCubeId("1");
        cubes.get(1).setCubeId("2");

        warehouseFiller.fillWarehouse(cubes);
        Map<String, CubeParameter> actual = warehouse.getWarehouse();
        System.out.println(actual);

        Map<String, CubeParameter> expected = new HashMap<String, CubeParameter>();
        expected.put("1", new CubeParameter(240.0, 2400.0, 8000.0, 34.64));
        expected.put("2", new CubeParameter(300.0, 3750.0, 15625.0, 43.3));

        Assert.assertEqualsDeep(actual, expected);
    }

    @AfterMethod
    public void close() {
        warehouse = null;
    }

}