package by.epam.task2.observer.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.filler.WarehouseFiller;
import by.epam.task2.observer.CubeEvent;
import by.epam.task2.observer.Observer;
import by.epam.task2.warehouse.CubeWarehouse;
import by.epam.task2.warehouse.impl.CubeWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeObserverImpl implements Observer {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parameterChanged(CubeEvent event) {
        Cube cube = event.getSource();
        CubeWarehouseImpl warehouse = CubeWarehouseImpl.getInstanceWarehouse();
        try {
            warehouse.updateParameter(cube);
        } catch (ShapeException e) {
            logger.error("Warehouse is not updated", e);
        }
        logger.info("Warehouse was updated"+ cube );
    }
}