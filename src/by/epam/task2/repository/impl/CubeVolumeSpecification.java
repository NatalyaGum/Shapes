package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.CubeService;

public class CubeVolumeSpecification implements Specification {

    private final double volume;

    public CubeVolumeSpecification(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeService service = new CubeService();
        double cubeVolume = service.findCubeVolume(cube);
        return cubeVolume == volume;
    }
}
