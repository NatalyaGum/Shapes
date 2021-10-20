package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Specification;
import by.epam.task2.service.impl.CubeServiceImpl;

public class CubeVolumeSpecification implements Specification {

    private final double volume;

    public CubeVolumeSpecification(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeServiceImpl service = new CubeServiceImpl();
        double cubeVolume = service.findVolume(cube);
        return Double.valueOf(cubeVolume).equals(volume) ;
    }
}
