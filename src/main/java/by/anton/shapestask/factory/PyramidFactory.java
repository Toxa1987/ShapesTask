package by.anton.shapestask.factory;

import by.anton.shapestask.entity.Pyramid;

public class PyramidFactory {
    private int id = 1;
    public Pyramid getPyramid()    {
        Pyramid pyramid = new Pyramid();
        pyramid.setId(id);
        id++;
        return pyramid;
    }
}
