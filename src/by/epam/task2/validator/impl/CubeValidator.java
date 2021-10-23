package by.epam.task2.validator.impl;

import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import by.epam.task2.service.impl.CubeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeValidator {
    static Logger logger = LogManager.getLogger();

    public boolean validatePoints(Point firstPoint, Point secondPoint) throws ShapeException {
        boolean isvalid = true;
        CubeServiceImpl service = new CubeServiceImpl();
        double diagonal = service.findCubeDiagonal(firstPoint, secondPoint);
        double edge = service.findCubeEdge(firstPoint, secondPoint);
        double diagonalExtendEdge = edge * Math.sqrt(3);
        String diagonalStr = String.format("%.3f", diagonal);
        String diagonalExtendEdgeStr = String.format("%.3f", diagonalExtendEdge);
        if (firstPoint == null || secondPoint == null || firstPoint.equals(secondPoint) ||
                diagonalStr == diagonalExtendEdgeStr) {
            isvalid = false;
            logger.error("Attempt to create cube with not suitable arguments");
            // throw new ShapeException("Attempt to create cube with not suitable arguments");
        }
        return isvalid;
    }
}
