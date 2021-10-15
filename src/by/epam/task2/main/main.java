package by.epam.task2.main;

import by.epam.task2.entity.Cube;
import by.epam.task2.entity.Point;
import by.epam.task2.service.CubeService;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.factory.impl.CubeFactory;
import by.epam.task2.parser.impl.ParserImpl;
import by.epam.task2.reader.impl.CustomReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws ShapeException {

        CustomReaderImpl reader = new CustomReaderImpl();
        ParserImpl parser = new ParserImpl();
        CubeFactory factory= new CubeFactory();
        CubeService service= new CubeService();
        try {
            List<String> listOfPoints = reader.readFile("resources/points.txt");
            ArrayList<Point> points= parser.parsePoints(listOfPoints);
            List <Cube> cubes=factory.createCubeListFromPoints(points);
Point firstPoint=new Point(100,100,100);
Point secondPoint=new Point(0,0,0);
            double d=service.findCubeDiagonal(firstPoint, secondPoint);
            double e=service.findCubeEdge(firstPoint, secondPoint);
            double v=service.findCubeVolume(firstPoint, secondPoint);
            logger.info("d "+d +"; e "+e+";  v "+v);
        } catch (ShapeException e) {
            logger.error(e);
            e.printStackTrace();
        }

    }}
