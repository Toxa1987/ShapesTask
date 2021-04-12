package by.anton.shapestask.repository;

import by.anton.shapestask.entity.Pyramid;

public interface Specification {
    boolean specified(Pyramid pyramid);
}
