package by.epam.task2.observer;

import by.epam.task2.entity.Cube;

import java.util.EventObject;

public class CubeEvent extends EventObject {

    public CubeEvent(Cube source) {
        super(source);
    }

    @Override
    public Cube getSource() {
        return (Cube) super.getSource();
    }

}