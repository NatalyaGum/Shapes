package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.impl.CubeServiceImpl;

public class CubePerimeterSpecification implements Specification {

    private final double perimeter;

    public CubePerimeterSpecification(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeServiceImpl service = new CubeServiceImpl();
        double cubePerimeter = service.findPerimeter(cube);
        return Double.valueOf(cubePerimeter).equals(perimeter);
    }
}
