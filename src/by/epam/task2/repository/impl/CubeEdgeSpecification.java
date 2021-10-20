package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.impl.CubeServiceImpl;

public class CubeEdgeSpecification implements Specification {

    final double minEdge;
    final double maxEdge;

    public CubeEdgeSpecification(double minEdge, double maxEdge) {

        this.minEdge = minEdge;
        this.maxEdge = maxEdge;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeServiceImpl service = new CubeServiceImpl();
        double cubeEdge = service.findCubeEdge(cube);
        return cubeEdge >= minEdge && cubeEdge <= maxEdge;
    }
}
