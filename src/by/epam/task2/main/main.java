package by.epam.task2.main;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.factory.impl.PointFactoryImpl;
import by.epam.task2.filler.WarehouseFiller;
import by.epam.task2.observer.impl.CubeObserverImpl;
import by.epam.task2.repository.impl.CubeRepository;
import by.epam.task2.service.impl.CubeServiceImpl;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.factory.impl.CubeFactory;
import by.epam.task2.parser.impl.ParserImpl;
import by.epam.task2.reader.impl.CustomReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws ShapeException {

        CustomReaderImpl reader = new CustomReaderImpl();
        ParserImpl parser = new ParserImpl();
        PointFactoryImpl pointFactory= new PointFactoryImpl();
        CubeFactory factory= new CubeFactory();
        CubeServiceImpl service= new CubeServiceImpl();
        CubeObserverImpl observer = new CubeObserverImpl();
        CubeRepository repository = CubeRepository.getRepositoryInstance();
        WarehouseFiller filler= new WarehouseFiller();

        try {
            List<String> listOfdata = reader.readFile("resources/listOfDouble.txt");
            List<Double> listOfCoordinate= parser.parseCoordinate(listOfdata);
            List <Point> points=pointFactory.createPoint(listOfCoordinate);
            List <Cube> cubes=factory.createShapeListFromPoints(points);

            Point firstPoint=new Point(100,100,100);
            Point secondPoint=new Point(0,0,0);
            Point thirdPoint=new Point(50,50,50);
            Cube cube= new Cube(firstPoint,secondPoint);
            cube.attach(observer);
            cube.setFirstPoint(thirdPoint);
            filler.fillWarehouse(cube);
            cube.attach(observer);
           filler.fillWarehouse(cube);
            repository.add(cube);
            repository.addAll(cubes);
            double d=service.findCubeDiagonal(firstPoint, secondPoint);
            double e=service.findCubeEdge(firstPoint, secondPoint);
            double v=service.findVolume(firstPoint, secondPoint);
            logger.info("d "+d +"; e "+e+";  v "+v);
            //filler.fillWarehouse(cubes);
           // cubes.get(3).setFirstPoint(thirdPoint);
          //  logger.info(warehouse.getParameter(cubes.get(2).getCubeId()));

            logger.info(repository);


        } catch (ShapeException e) {
            logger.error(e);
            e.printStackTrace();
        }

    }}
