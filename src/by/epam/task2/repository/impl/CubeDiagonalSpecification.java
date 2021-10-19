package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.CubeService;

public class CubeDiagonalSpecification implements Specification {

    private final double diagonal;

    public CubeDiagonalSpecification(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeService service = new CubeService();
        double cubeDiagonal = service.findCubeDiagonal(cube);
        return cubeDiagonal == diagonal;
    }
}
