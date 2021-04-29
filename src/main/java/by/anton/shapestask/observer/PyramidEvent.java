package by.anton.shapestask.observer;

import by.anton.shapestask.entity.Pyramid;

import java.util.EventObject;

public class PyramidEvent extends EventObject {

    public PyramidEvent(Object source) {
        super(source);
    }

    @Override
    public Pyramid getSource() {
        return (Pyramid) super.getSource();
    }
}
