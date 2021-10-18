package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.CubeService;

public class CubeIdSpecification implements Specification {

    private final String cubeId;

    public CubeIdSpecification(String cubeId) {
        this.cubeId = cubeId;
    }

    @Override
    public boolean specify(Cube cube) {
        return cube.getCubeId() == cubeId;
    }
}
