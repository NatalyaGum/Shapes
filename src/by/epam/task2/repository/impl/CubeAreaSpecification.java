package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.impl.CubeServiceImpl;

public class CubeAreaSpecification implements Specification {

    private final double area;

    public CubeAreaSpecification(double area) {
        this.area = area;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeServiceImpl service = new CubeServiceImpl();
        double cubeArea = service.findArea(cube);
        return Double.valueOf(cubeArea).equals(area);
    }
}
