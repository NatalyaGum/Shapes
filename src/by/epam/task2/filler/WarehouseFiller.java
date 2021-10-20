package by.epam.task2.filler;

import by.epam.task2.entity.Cube;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.service.impl.CubeServiceImpl;
import by.epam.task2.warehouse.impl.CubeWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WarehouseFiller {
    private static final Logger logger = LogManager.getLogger();

    public void fillWarehouse(List<Cube> cubes) throws ShapeException {
        CubeServiceImpl service = new CubeServiceImpl();
        CubeWarehouseImpl warehouse = CubeWarehouseImpl.getInstanceWarehouse();
        for (Cube cube : cubes) {
            double diagonal = service.findCubeDiagonal(cube);
            double perimeter = service.findPerimeter(cube);
            double volume = service.findVolume(cube);
            double area = service.findArea(cube);
            warehouse.putParameters(cube.getCubeId(), perimeter, area, volume, diagonal);

        }
        logger.info("Warehouse filled successfully");
    }


    public void fillWarehouse(Cube cube) {
        CubeServiceImpl service = new CubeServiceImpl();
        CubeWarehouseImpl warehouse = CubeWarehouseImpl.getInstanceWarehouse();
        double diagonal = service.findCubeDiagonal(cube);
        double perimeter = service.findPerimeter(cube);
        double volume = service.findVolume(cube);
        double area = service.findArea(cube);
        warehouse.putParameters(cube.getCubeId(), perimeter, area, volume, diagonal);
        logger.info("Warehouse filled successfully. " + cube);
    }

}

