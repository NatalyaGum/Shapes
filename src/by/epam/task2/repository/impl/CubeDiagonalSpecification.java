package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.impl.CubeServiceImpl;

public class CubeDiagonalSpecification implements Specification {

    private final double diagonal;

    public CubeDiagonalSpecification(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeServiceImpl service = new CubeServiceImpl();
        double cubeDiagonal = service.findCubeDiagonal(cube);
        return Double.valueOf(cubeDiagonal).equals(diagonal);
    }
}
