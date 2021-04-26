package by.anton.shapestask.service;

import by.anton.shapestask.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointService {
    private static final Logger logger = LogManager.getLogger();

    public static double distanceBetweenPoints(Point p1, Point p2) {
        logger.info("Method to find distance between points called with parameters: point1:" + p1 + " point2: " + p2);
        double distanceX = p2.getX() - p1.getX();
        double distanceY = p2.getY() - p1.getY();
        double distanceZ = p2.getZ() - p1.getZ();
        double distanceXYZ = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2) + Math.pow(distanceZ, 2));
        return distanceXYZ;
    }

}
