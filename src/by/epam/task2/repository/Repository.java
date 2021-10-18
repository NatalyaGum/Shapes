package by.epam.task2.repository;

import by.epam.task2.entity.Cube;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository {

    boolean add(Cube cube);

    boolean remove(Cube cube);

    boolean addAll(List<Cube> cube);

    boolean removeAll(List<Cube> cube);

    void clear();

    List<Cube> query(Specification specification);

    List<Cube> queryStream(Specification specification);

    List<Cube> sort(Comparator<Cube> comparator);
}
