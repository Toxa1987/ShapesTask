package by.anton.shapestask.service;

import by.anton.shapestask.entity.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindPyramidService {
    private static final Logger logger = LogManager.getLogger();

    public boolean baseLiesOnXY(Pyramid pyramid) {
        logger.info("Method baseLiesOnXY called with parameters: " + pyramid);

        boolean flag = false;
        if (pyramid.getBasePoint1().getZ() == 0 & pyramid.getBasePoint2().getZ() == 0 &
                pyramid.getBasePoint3().getZ() == 0 & pyramid.getBasePoint4().getZ() == 0) {
            flag = true;
        }
        return flag;
    }

    public boolean baseLiesOnXZ(Pyramid pyramid) {
        logger.info("Method baseLiesOnXZ called with parameters: " + pyramid);
        boolean flag = false;
        if (pyramid.getBasePoint1().getY() == 0 & pyramid.getBasePoint2().getY() == 0 &
                pyramid.getBasePoint3().getY() == 0 & pyramid.getBasePoint4().getY() == 0) {
            flag = true;
        }
        return flag;
    }

    public boolean baseLiesOnYZ(Pyramid pyramid) {
        logger.info("Method baseLiesOnYZ called with parameters: " + pyramid);
        boolean flag = false;
        if (pyramid.getBasePoint1().getX() == 0 & pyramid.getBasePoint2().getX() == 0 &
                pyramid.getBasePoint3().getX() == 0 & pyramid.getBasePoint4().getX() == 0) {
            flag = true;
        }
        return flag;
    }

    public boolean coordinatePlaneXYIntersection(Pyramid pyramid) {
        logger.info("Method coordinatePlaneXYIntersection called with parameters: " + pyramid);
        boolean flag = false;
        if (pyramid.getBasePoint1().getZ() < 0 && pyramid.getTopPoint().getZ() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getZ() > 0 && pyramid.getTopPoint().getZ() < 0) {
            flag = true;
        }
        return flag;
    }

    public boolean coordinatePlaneXZIntersection(Pyramid pyramid) {
        logger.info("Method coordinatePlaneXZIntersection called with parameters: " + pyramid);
        boolean flag = false;
        if (pyramid.getBasePoint1().getY() < 0 && pyramid.getTopPoint().getY() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getY() > 0 && pyramid.getTopPoint().getY() < 0) {
            flag = true;
        }
        return flag;
    }

    public boolean coordinatePlaneYZIntersection(Pyramid pyramid) {
        logger.info("Method coordinatePlaneYZIntersection called with parameters: " + pyramid);
        boolean flag = false;
        if (pyramid.getBasePoint1().getX() < 0 && pyramid.getTopPoint().getX() > 0) {
            flag = true;
        }
        if (pyramid.getBasePoint1().getX() > 0 && pyramid.getTopPoint().getX() < 0) {
            flag = true;
        }
        return flag;
    }
}
