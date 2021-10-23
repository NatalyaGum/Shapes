package by.epam.task2.warehouse.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.CubeParameter;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.filler.WarehouseFiller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CubeWarehouseImpl {
    static Logger logger = LogManager.getLogger();
    private static final CubeWarehouseImpl instanceWarehouse = new CubeWarehouseImpl();
    private final Map<String, CubeParameter> cubeParameterMap;

    private CubeWarehouseImpl() {
        cubeParameterMap = new HashMap<String, CubeParameter>();
    }

    public static CubeWarehouseImpl getInstanceWarehouse() {
        return instanceWarehouse;
    }

    public void putParameters(String id, double perimeter, double area, double volume, double diagonal) {
        CubeParameter newCubeParameter = new CubeParameter(perimeter, area, volume, diagonal);
        instanceWarehouse.cubeParameterMap.put(id, newCubeParameter);
    }

    public void putParameters(String id, CubeParameter newCubeParameter) {
        instanceWarehouse.cubeParameterMap.put(id, newCubeParameter);
    }

    public CubeParameter getParameter(String id) throws ShapeException {
        CubeParameter cubeParameter = instanceWarehouse.cubeParameterMap.get(id);
        if (cubeParameter == null) {
            logger.error(" No such parameters in warehouse : ", id);
            throw new ShapeException("No such parameters in warehouse  :" + id);
        }
        return cubeParameterMap.get(id);
    }

    public void updateParameter(String id, double newPerimeter, double newArea, double newVolume, double newDiagonal) throws ShapeException {
        CubeParameter cubeParameter = instanceWarehouse.getParameter(id);
        if (cubeParameter == null) {
            logger.error("wrong id. no such element in warehouse : ", id);
            throw new ShapeException("wrong id. no such element in warehouse :" + id);
        }
        cubeParameter.setPerimeter(newPerimeter);
        cubeParameter.setArea(newArea);
        cubeParameter.setVolume(newVolume);
        cubeParameter.setDiagonal(newDiagonal);
    }

    public void updateParameter(Cube cube) throws ShapeException {
        WarehouseFiller filler = new WarehouseFiller();
        filler.fillWarehouse(cube);
    }

    public Map<String, CubeParameter> getWarehouse() {
        return new HashMap<String, CubeParameter>(cubeParameterMap);
    }

    public CubeParameter remove(String id) {
        return cubeParameterMap.remove(id);
    }


}
