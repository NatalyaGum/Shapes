package by.epam.task2.filler;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.impl.CubeRepository;

import java.util.List;

public class RepositoryFiller {

public void fillRepository(List<Cube> cubes){
    CubeRepository repository = CubeRepository.getRepositoryInstance();
    repository.addAll(cubes);
}
    public void fillRepository(Cube cube){
        CubeRepository repository = CubeRepository.getRepositoryInstance();
        repository.add(cube);
    }
}
