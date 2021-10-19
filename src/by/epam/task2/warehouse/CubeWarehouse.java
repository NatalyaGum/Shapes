package by.epam.task2.warehouse;

import by.epam.task2.entity.CubeParameter;
import by.epam.task2.exception.ShapeException;

public interface CubeWarehouse {

    void putParameters();

    CubeParameter getParameter() throws ShapeException;

    void updateParameter() throws ShapeException;

    void remove(String id);
}
