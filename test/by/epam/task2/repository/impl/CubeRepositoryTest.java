package by.epam.task2.repository.impl;

import by.epam.task2.comparator.CubeCenterFromOriginComparator;
import by.epam.task2.comparator.CubeDiagonalComparator;
import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.filler.WarehouseFiller;
import by.epam.task2.observer.CubeEvent;
import by.epam.task2.observer.Observer;
import by.epam.task2.observer.impl.CubeObserverImpl;
import by.epam.task2.repository.Specification;
import by.epam.task2.warehouse.impl.CubeWarehouseImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.*;

public class CubeRepositoryTest {

    CubeRepository repository;
    Cube cube1=new Cube(new Point(10, 25.0, 10), new Point(30.0, 45.0, 30.0));
    Cube cube2=new Cube(new Point(5, 0, -3), new Point(30.0, 25.0, -28.0));
    Cube cube3=new Cube(new Point(-20,40,5), new Point(10,10.0,35.0));
    Cube cube4=new Cube(new Point(1.0, 2.0, 3.0), new Point(5.0, 8.0, 4.0));
    String id="123abc";

    @BeforeClass
    public void initialize() {
        repository=CubeRepository.getRepositoryInstance();
        repository.add(cube1);
        repository.add(cube2);
        repository.add(cube3);
        repository.add(cube4);
        cube4.setCubeId(id);
    }

    @DataProvider(name = "providerSort")
    public Object[][] createDataForSorting (){
        return new Object[][]{
                {new CubeCenterFromOriginComparator(), Arrays.asList(cube4,cube2,cube3,cube1)},

                {new CubeDiagonalComparator(),Arrays.asList(cube4,cube1,cube2,cube3)
        }};}


    @DataProvider(name = "providerQuery")
    public Object[][] createDataForQuery (){
        return new Object[][]{
                {new CubeAreaSpecification(2400), Arrays.asList(cube1)},
                {new CubeDiagonalSpecification(34.64),Arrays.asList(cube1)},
                {new CubeEdgeSpecification(20,34.64),Arrays.asList(cube1,cube2,cube3)},
                {new CubePerimeterSpecification(240),Arrays.asList(cube1)},
                {new CubeVolumeSpecification (8000),Arrays.asList(cube1)},
                {new CubeIdSpecification ("123abc"),Arrays.asList(cube4)},
                };
        }




        @Test(dataProvider = "providerQuery")
    public void testQuery(Specification specification, List<Cube> expected) {
            List<Cube> actual = repository.query(specification);
            Assert.assertEquals(actual, expected);

    }

    @Test(dataProvider = "providerQuery")
    public void testQueryStream(Specification specification, List<Cube> expected) {
        List<Cube> actual = repository.queryStream(specification);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "providerSort")
    public void testSort(Comparator<Cube> comparator, List<Cube> expected) {
        List<Cube> actual = repository.sort(comparator);
        Assert.assertEquals(actual, expected);

    }

   }