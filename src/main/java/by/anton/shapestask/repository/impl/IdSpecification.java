package by.anton.shapestask.repository.impl;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.repository.Specification;

public class IdSpecification implements Specification {
    private int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(Pyramid pyramid) {
        boolean result = pyramid.getId()==id;
        return result;
    }
}
