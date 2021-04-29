package by.anton.shapestask.service.impl;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.exception.ApiException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointServiceImpl {
    private static final Logger logger = LogManager.getLogger();

    public static double distanceBetweenPoints(Point point1, Point point2) throws ApiException {
        logger.info("Method to find distance between points called with parameters: point1:" + point1 + " point2: " + point2);
        if (point1 == null || point2 == null) {
            throw new ApiException("Points must be not null");
        }
        double distanceX = point2.getX() - point1.getX();
        double distanceY = point2.getY() - point1.getY();
        double distanceZ = point2.getZ() - point1.getZ();
        double distanceXYZ = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2) + Math.pow(distanceZ, 2));
        return distanceXYZ;
    }

}
