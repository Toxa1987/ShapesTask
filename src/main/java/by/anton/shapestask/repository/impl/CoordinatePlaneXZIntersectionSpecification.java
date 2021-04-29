package by.anton.shapestask.repository.impl;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.repository.Specification;
import by.anton.shapestask.service.impl.FindPyramidServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoordinatePlaneXZIntersectionSpecification implements Specification {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean specified(Pyramid pyramid) {
        boolean result = false;
        try {
            result = new FindPyramidServiceImpl().coordinatePlaneXZIntersection(pyramid);
        } catch (ApiException e) {
            logger.error(e.getMessage());
        }
        return result;
    }
}
