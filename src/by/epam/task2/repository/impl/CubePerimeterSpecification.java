package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.CubeService;

public class CubePerimeterSpecification implements Specification {

    private final double perimeter;

    public CubePerimeterSpecification(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeService service = new CubeService();
        double cubePerimeter = service.findCubePerimeter(cube);
        return cubePerimeter == perimeter;
    }
}
