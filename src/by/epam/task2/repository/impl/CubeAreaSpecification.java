package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.CubeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeAreaSpecification implements Specification {

    private final double area;

    public CubeAreaSpecification(double area) {
        this.area = area;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeService service = new CubeService();
        double cubeArea = service.findCubeArea(cube);
        return cubeArea == area;
    }
}
