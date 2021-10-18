package by.epam.task2.main;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.CubeParameter;
import by.epam.task2.entity.Point;
import by.epam.task2.filler.WarehouseFiller;
import by.epam.task2.observer.impl.CubeObserverImpl;
import by.epam.task2.repository.impl.CubeRepository;
import by.epam.task2.service.CubeService;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.factory.impl.CubeFactory;
import by.epam.task2.parser.impl.ParserImpl;
import by.epam.task2.reader.impl.CustomReaderImpl;
import by.epam.task2.warehouse.impl.CubeWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws ShapeException {

        CustomReaderImpl reader = new CustomReaderImpl();
        ParserImpl parser = new ParserImpl();
        CubeFactory factory= new CubeFactory();
        CubeService service= new CubeService();
       // CubeWarehouseImpl warehouse=CubeWarehouseImpl.getInstanceWarehouse();
        WarehouseFiller filler= new WarehouseFiller();
        CubeObserverImpl observer= new CubeObserverImpl();
        CubeRepository repository = new CubeRepository();
        try {
            List<String> listOfPoints = reader.readFile("resources/points.txt");
            ArrayList<Point> points= parser.parsePoints(listOfPoints);
            List <Cube> cubes=factory.createCubeListFromPoints(points);

            Point firstPoint=new Point(100,100,100);
            Point secondPoint=new Point(0,0,0);
            Point thirdPoint=new Point(50,50,50);
            Cube cube= new Cube(firstPoint,secondPoint);
            cube.attach(observer);
            cube.setFirstPoint(thirdPoint);
            filler.fillWarehouse(cube);
            double d=service.findCubeDiagonal(firstPoint, secondPoint);
            double e=service.findCubeEdge(firstPoint, secondPoint);
            double v=service.findCubeVolume(firstPoint, secondPoint);
            logger.info("d "+d +"; e "+e+";  v "+v);
            //filler.fillWarehouse(cubes);
            cubes.get(3).setFirstPoint(thirdPoint);
          //  logger.info(warehouse.getParameter(cubes.get(2).getCubeId()));
            //repository.addAll(cubes);
            logger.info(repository);

          // for(Map.Entry<String, CubeParameter>pair:CubeWarehouseImpl.cubeParameterMap.entrySet());

        } catch (ShapeException e) {
            logger.error(e);
            e.printStackTrace();
        }

    }}
