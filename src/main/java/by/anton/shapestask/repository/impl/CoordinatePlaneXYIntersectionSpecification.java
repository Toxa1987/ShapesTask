package by.anton.shapestask.repository.impl;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.repository.Specification;
import by.anton.shapestask.service.FindPyramidService;

public class CoordinatePlaneXYIntersectionSpecification implements Specification {

    @Override
    public boolean specified(Pyramid pyramid) {
        boolean result = new FindPyramidService().coordinatePlaneXYIntersection(pyramid);
        return result;
    }
}