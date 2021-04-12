package by.anton.shapestask.service;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;

import static by.anton.shapestask.service.PointService.distanceBetweenPoints;

public class CalculatePyramidService {

    public double surfaceAreaOfPyramid(Pyramid pyramid) {
        Point point1 = pyramid.getBasePoint1();
        Point point2 = pyramid.getBasePoint2();
        Point topPoint = pyramid.getTopPoint();
        double edgeLength = distanceBetweenPoints(topPoint, point1);
        double baseEdgeLength = distanceBetweenPoints(point1, point2);
        double apothem = Math.sqrt(Math.pow(edgeLength, 2) - Math.pow(baseEdgeLength, 2) / 4);
        double area = apothem * baseEdgeLength / 2;
        return area;
    }

    public double baseArea(Pyramid pyramid) {
        Point point1 = pyramid.getBasePoint1();
        Point point2 = pyramid.getBasePoint2();
        double area = Math.pow(distanceBetweenPoints(point1, point2), 2);
        return area;
    }

    public double allArea(Pyramid pyramid) {
        return baseArea(pyramid) + surfaceAreaOfPyramid(pyramid);
    }

    public double volumeOfPyramid(Pyramid pyramid) {
        Point point1 = pyramid.getBasePoint1();

        double volume = baseArea(pyramid) * pyramidHeight(pyramid) / 3;
        return volume;
    }

    public double cutOffRatio(Pyramid pyramid) throws ApiException {
        double height = pyramidHeight(pyramid);
        double baseLength = distanceBetweenPoints(pyramid.getBasePoint1(), pyramid.getBasePoint2());
        double smallHeight;
        FindPyramidService findService = new FindPyramidService();
        if (findService.coordinatePlaneXYIntersection(pyramid)) {
            smallHeight = Math.abs(pyramid.getTopPoint().getZ());
        } else if (findService.coordinatePlaneXZIntersection(pyramid)) {
            smallHeight = Math.abs(pyramid.getTopPoint().getY());
        } else if (findService.coordinatePlaneYZIntersection(pyramid)) {
            smallHeight = Math.abs(pyramid.getTopPoint().getX());
        }else {
            throw new ApiException("All coordinate planes are not intersect your pyramid");
        }
        double volumeUp= Math.pow(baseLength,2)*Math.pow(smallHeight,3)/(3*height);
        double volumeDown= volumeOfPyramid(pyramid)-volumeUp;
        return  volumeUp/volumeDown;
    }

    private double pyramidHeight(Pyramid pyramid) {
        double height = -1;
        Point top = pyramid.getTopPoint();
        Point basePoint1 = pyramid.getBasePoint1();
        Point basePoint2 = pyramid.getBasePoint2();
        Point basePoint3 = pyramid.getBasePoint3();
        if (basePoint1.getX() == basePoint2.getX() && basePoint2.getX() == basePoint3.getX()) {
            height = Math.abs(top.getX() - basePoint1.getX());
        }
        if (basePoint1.getY() == basePoint2.getY() && basePoint2.getY() == basePoint3.getY()) {
            height = Math.abs(top.getY() - basePoint1.getY());
        }
        if (basePoint1.getZ() == basePoint2.getZ() && basePoint2.getZ() == basePoint3.getZ()) {
            height = Math.abs(top.getZ() - basePoint1.getZ());
        }

        return height;
    }
}
