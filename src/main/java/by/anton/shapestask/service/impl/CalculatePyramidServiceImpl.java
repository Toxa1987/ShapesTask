package by.anton.shapestask.service.impl;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.service.CalculatePyramidService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.anton.shapestask.service.impl.PointServiceImpl.distanceBetweenPoints;

public class CalculatePyramidServiceImpl implements CalculatePyramidService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public double surfaceAreaOfPyramid(Pyramid pyramid) throws ApiException {
        logger.info("Method to calculate surface area called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        Point point1 = pyramid.getBasePoint1();
        Point point2 = pyramid.getBasePoint2();
        Point topPoint = pyramid.getTopPoint();
        double edgeLength = distanceBetweenPoints(topPoint, point1);
        double baseEdgeLength = distanceBetweenPoints(point1, point2);
        double apothem = Math.sqrt(Math.pow(edgeLength, 2) - Math.pow(baseEdgeLength, 2) / 4);
        double area = apothem * baseEdgeLength / 2;
        String result = String.format("%.2f", area).replace(",", ".");
        area = Double.parseDouble(result);
        return area;
    }

    @Override
    public double baseArea(Pyramid pyramid) throws ApiException {
        logger.info("Method to calculate base area called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        Point point1 = pyramid.getBasePoint1();
        Point point2 = pyramid.getBasePoint2();
        double area = Math.pow(distanceBetweenPoints(point1, point2), 2);
        String result = String.format("%.2f", area).replace(",", ".");
        area = Double.parseDouble(result);
        return area;
    }

    @Override
    public double allArea(Pyramid pyramid) throws ApiException {
        logger.info("Method to calculate all area called with parameters: " + pyramid);
        String result = String.format("%.2f", baseArea(pyramid) + surfaceAreaOfPyramid(pyramid)).replace(",", ".");
        double allArea = Double.parseDouble(result);
        return allArea;
    }

    @Override
    public double volumeOfPyramid(Pyramid pyramid) throws ApiException {
        logger.info("Method to calculate pyramid volume called with parameters: " + pyramid);
        double volume = baseArea(pyramid) * pyramidHeight(pyramid) / 3;
        String result = String.format("%.2f", volume).replace(",", ".");
        volume = Double.parseDouble(result);
        return volume;
    }

    @Override
    public double cutOffRatio(Pyramid pyramid) throws ApiException {
        logger.info("Method to calculate cut off ratio coordinate plane called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
        double height = pyramidHeight(pyramid);
        double baseLength = distanceBetweenPoints(pyramid.getBasePoint1(), pyramid.getBasePoint2());
        double smallHeight;
        FindPyramidServiceImpl findService = new FindPyramidServiceImpl();
        if (findService.coordinatePlaneXYIntersection(pyramid)) {
            smallHeight = Math.abs(pyramid.getTopPoint().getZ());
        } else if (findService.coordinatePlaneXZIntersection(pyramid)) {
            smallHeight = Math.abs(pyramid.getTopPoint().getY());
        } else if (findService.coordinatePlaneYZIntersection(pyramid)) {
            smallHeight = Math.abs(pyramid.getTopPoint().getX());
        } else {
            throw new ApiException("All coordinate planes are not intersect your pyramid");
        }
        double volumeUp = Math.pow(baseLength, 2) * Math.pow(smallHeight, 3) / (3 * height);
        double volumeDown = volumeOfPyramid(pyramid) - volumeUp;
        return volumeUp / volumeDown;
    }

    @Override
    public double pyramidHeight(Pyramid pyramid) throws ApiException {
        logger.info("Method to calculate pyramid height called with parameters: " + pyramid);
        if (pyramid == null) {
            throw new ApiException("Pyramid must be not null");
        }
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
