package by.anton.shapestask.service;

import by.anton.shapestask.entity.Point;

public class PointService {

    public static double distanceBetweenPoints(Point p1, Point p2) {
        double distanceX = p2.getX() - p1.getX();
        double distanceY = p2.getY() - p1.getY();
        double distanceZ = p2.getZ() - p1.getZ();
        double distanceXYZ = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2) + Math.pow(distanceZ, 2));
        return distanceXYZ;
    }

}
