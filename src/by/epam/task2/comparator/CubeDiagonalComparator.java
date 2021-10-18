package by.epam.task2.comparator;

import by.epam.task2.entity.Cube;
import by.epam.task2.service.CubeService;

import java.util.Comparator;

public class CubeDiagonalComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube cube1, Cube cube2) {
        CubeService service = new CubeService();
        double diagonal1=service.findCubeDiagonal(cube1);
        double diagonal2=service.findCubeDiagonal(cube2);
        return    (int) (diagonal1-diagonal2);
        }
}
