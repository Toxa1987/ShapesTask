package by.anton.shapestask.factory;

import by.anton.shapestask.entity.Point;

public class PointFactory {

    public static Point getPoint(double xCoordinate, double yCoordinate, double zCoordinate) {
        Point point = new Point(xCoordinate, yCoordinate, zCoordinate);
        return point;
    }
}
