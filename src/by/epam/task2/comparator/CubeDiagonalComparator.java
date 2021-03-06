package by.epam.task2.comparator;

import by.epam.task2.entity.Cube;
import by.epam.task2.service.impl.CubeServiceImpl;

import java.util.Comparator;

public class CubeDiagonalComparator implements Comparator<Cube> {

    public int compare(Cube cube1, Cube cube2) {
        CubeServiceImpl service = new CubeServiceImpl();
        double diagonal1 = service.findCubeDiagonal(cube1);
        double diagonal2 = service.findCubeDiagonal(cube2);
        return Double.compare(diagonal1, diagonal2);
    }
}
