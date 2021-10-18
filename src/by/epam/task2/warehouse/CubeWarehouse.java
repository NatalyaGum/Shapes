package by.epam.task2.warehouse;

public interface CubeWarehouse {

    void put(String id, double perimeter, double area, double volume,double diagonal);
    void remove(String id);
}
