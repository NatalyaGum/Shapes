package by.epam.task2.filler;

import by.epam.task2.entity.Cube;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.service.CubeService;
import by.epam.task2.warehouse.impl.CubeWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WarehouseFiller {
    private static final Logger logger = LogManager.getLogger();

    public void fillWarehouse(List<Cube> cubes) throws ShapeException {
        CubeService service = new CubeService();
        CubeWarehouseImpl warehouse = CubeWarehouseImpl.getInstanceWarehouse();
        for (Cube cube : cubes) {
            double diagonal = service.findCubeDiagonal(cube);
            double perimeter = service.findCubePerimeter(cube);
            double volume = service.findCubeVolume(cube);
            double area = service.findCubeArea(cube);
            warehouse.putParameters(cube.getCubeId(), perimeter, area, volume, diagonal);

        }
        logger.info("Warehouse filled successfully");
    }


    public void fillWarehouse(Cube cube) {
        CubeService service = new CubeService();
        CubeWarehouseImpl warehouse = CubeWarehouseImpl.getInstanceWarehouse();
        double diagonal = service.findCubeDiagonal(cube);
        double perimeter = service.findCubePerimeter(cube);
        double volume = service.findCubeVolume(cube);
        double area = service.findCubeArea(cube);
        warehouse.putParameters(cube.getCubeId(), perimeter, area, volume, diagonal);
        logger.info("Warehouse filled successfully. " + cube);
    }

}

