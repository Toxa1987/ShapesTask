package by.anton.shapestask.service.impl;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.service.FindPyramidService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindPyramidServiceImpl implements FindPyramidService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean baseLiesOnXY(Pyramid pyramid) throws ApiException {
        logger.info("Method baseLiesOnXY called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getZ() == 0 & pyramid.getBasePoint2().getZ() == 0 &
                pyramid.getBasePoint3().getZ() == 0 & pyramid.getBasePoint4().getZ() == 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean baseLiesOnXZ(Pyramid pyramid) throws ApiException {
        logger.info("Method baseLiesOnXZ called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getY() == 0 & pyramid.getBasePoint2().getY() == 0 &
                pyramid.getBasePoint3().getY() == 0 & pyramid.getBasePoint4().getY() == 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean baseLiesOnYZ(Pyramid pyramid) throws ApiException {
        logger.info("Method baseLiesOnYZ called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getX() == 0 & pyramid.getBasePoint2().getX() == 0 &
                pyramid.getBasePoint3().getX() == 0 & pyramid.getBasePoint4().getX() == 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean coordinatePlaneXYIntersection(Pyramid pyramid) throws ApiException {
        logger.info("Method coordinatePlaneXYIntersection called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getZ() < 0 && pyramid.getBasePoint3().getZ() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getZ() > 0 && pyramid.getBasePoint3().getZ() < 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean coordinatePlaneXZIntersection(Pyramid pyramid) throws ApiException {
        logger.info("Method coordinatePlaneXZIntersection called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getY() < 0 && pyramid.getBasePoint3().getY() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getY() > 0 && pyramid.getBasePoint3().getY() < 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean coordinatePlaneYZIntersection(Pyramid pyramid) throws ApiException {
        logger.info("Method coordinatePlaneYZIntersection called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        boolean flag = false;
        if (pyramid.getBasePoint1().getX() < 0 && pyramid.getBasePoint3().getX() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getX() > 0 && pyramid.getBasePoint3().getX() < 0) {
            flag = true;
        }
        return flag;
    }
}
