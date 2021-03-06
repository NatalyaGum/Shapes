package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;

public class CubeIdSpecification implements Specification {

    private final String cubeId;

    public CubeIdSpecification(String cubeId) {
        this.cubeId = cubeId;
    }

    @Override
    public boolean specify(Cube cube) {

        return 0 == cube.getCubeId().compareTo(cubeId);
    }
}
