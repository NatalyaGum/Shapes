package by.epam.task2.validator.impl;

import by.epam.task2.entity.Point;
import by.epam.task2.exception.ShapeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeValidator {
    static Logger logger = LogManager.getLogger();

    public boolean validatePoints (by.epam.task2.entity.Point firstPoint, Point secondPoint)throws ShapeException {
        boolean isvalid=true;
    if (firstPoint == null || secondPoint == null || firstPoint.equals(secondPoint)) {
        isvalid=false;
        logger.error("Attempt to create cube with null/same arguments");
        throw new ShapeException("Attempt to create cube with null/same arguments");
    }
    return isvalid;
}}
