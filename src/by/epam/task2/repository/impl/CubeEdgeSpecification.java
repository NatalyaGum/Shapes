package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.CubeService;

public class CubeEdgeSpecification implements Specification {

    private final double edge;

    public CubeEdgeSpecification(double edge) {
        this.edge = edge;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeService service = new CubeService();
        double cubeEdge = service.findCubeEdge(cube);
        return cubeEdge == edge;
    }
}
