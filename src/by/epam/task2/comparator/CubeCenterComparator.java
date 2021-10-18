package by.epam.task2.comparator;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.service.CubeService;



public class CubeCenterComparator {         //the center of the cube relative to the center of coordinates
    public int compare(Cube cube1, Cube cube2) {
        CubeService service = new CubeService();
        Point center1=service.findCenterPoint(cube1);
        Point center2=service.findCenterPoint(cube2);
        double x1 = center1.getX();
        double y1 = center1.getY();
        double z1 = center1.getZ();
        double x2 = center2.getX();
        double y2 = center2.getY();
        double z2 = center2.getZ();
        return  (int) ((x1+y1+z1)-(x2+y2+z2));
    }


}
