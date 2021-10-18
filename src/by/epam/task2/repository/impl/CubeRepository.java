package by.epam.task2.repository.impl;

import by.epam.task2.entity.Cube;
import by.epam.task2.repository.Repository;
import by.epam.task2.repository.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepository implements Repository {

    private static final CubeRepository instanceRepository = new CubeRepository();
    private final List<Cube> cubes;

    private CubeRepository() {
        cubes = new ArrayList<>();
    }

    public static CubeRepository getRepositoryInstance() {
        return instanceRepository;
    }

    @Override
    public boolean add(Cube cube) {
        boolean added = false;
        if (!cubes.contains(cube)) {
            added = cubes.add(cube);
        }
        return added;
    }

    @Override
    public boolean remove(Cube cube) {
        return cubes.remove(cube);
    }

    @Override
    public boolean addAll(List<Cube> listOfCube) {
        boolean added = false;
        if (!cubes.containsAll(listOfCube)) {
            added = cubes.addAll(listOfCube);
        }
        return added;
    }

    @Override
    public boolean removeAll(List<Cube> listOfCube) {
        return cubes.removeAll(listOfCube);
    }

    @Override
    public void clear() {
        cubes.clear();
    }

    @Override
    public List<Cube> query(Specification specification) {
        List<Cube> queryResult = new ArrayList<>();
        for (Cube cube : cubes) {
            if (specification.specify(cube)) {
                queryResult.add(cube);
            }
        }
        return queryResult;
    }

    @Override
    public List<Cube> queryStream(Specification specification) {
        return cubes.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cube> sort(Comparator<Cube> comparator) {
        return cubes.stream()
                .sorted(comparator)
                .toList();
    }

    @Override
    public String toString() {
        return "CubeRepository size - " + cubes.size() + " ," + cubes;

    }
}
