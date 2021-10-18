package by.epam.task2.entity;

import by.epam.task2.exception.ShapeException;
import by.epam.task2.observer.Observer;
import by.epam.task2.observer.Observable;
import by.epam.task2.observer.CubeEvent;
import by.epam.task2.util.CubeIdGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cube implements Cloneable, Observable {
    private static final Logger logger = LogManager.getLogger();
    private String cubeId;
    private Point firstPoint;
    private Point secondPoint;
    private List<Observer> observers = new ArrayList<>();
    // two points of a cube diagonal

    public Cube(Point firstPoint, Point secondPoint) throws ShapeException {
        if (firstPoint == null || secondPoint == null|| firstPoint.equals(secondPoint)) {
            logger.error("Attempt to create cube with null/same arguments");
            throw new ShapeException("Attempt to create cube with null/same arguments");
        }
        this.cubeId = CubeIdGenerator.generateId();
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;

    }


    public String getCubeId() {
        return cubeId;
    }

    public Point getFirstPoint() {
        return firstPoint.clone();
    }

    public void setFirstPoint(Point firstPoint) throws ShapeException {
        if (firstPoint == null) {
            throw new ShapeException("Argument is null");
        }
        this.firstPoint = firstPoint;
        notifyObservers();
    }


    public Point getSecondPoint() {
        return secondPoint.clone();
    }

    public void setSecondPoint(Point secondPoint) throws ShapeException {
        if (secondPoint == null) {
            throw new ShapeException("Argument is null");
        }
        this.secondPoint = secondPoint;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cube cube = (Cube) o;
        return firstPoint.equals(cube.firstPoint) &&
                secondPoint.equals(cube.secondPoint) &&
                cubeId == cube.cubeId;

    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = hash * (firstPoint.hashCode() + secondPoint.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cubeId = ").append(cubeId);
        stringBuilder.append(", first point: ").append(firstPoint);
        stringBuilder.append(", second point: ").append(secondPoint);
        return stringBuilder.toString();
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }

    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (!observers.isEmpty()) {
            CubeEvent cubeEvent = new CubeEvent(this);
            for (Observer observer : observers) {
                observer.parameterChanged(cubeEvent);
            }
        }
    }
}
