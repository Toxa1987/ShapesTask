package by.anton.shapestask.validator.impl;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.service.PointService;

import java.util.HashSet;
import java.util.Set;

public class PyramidValidatorImpl {

    public boolean isPyramidValid(Point basePoint1, Point basePoint2, Point basePoint3, Point basePoint4, Point topPoint) {
        Set<Point> points = new HashSet<>();
        points.add(basePoint1);
        points.add(basePoint2);
        points.add(basePoint3);
        points.add(basePoint4);
        points.add(topPoint);
        if (points.size() != 5) {
            return false;
        }
        boolean flag = false;
        double distanceBetweenBasePoints1_2 = PointService.distanceBetweenPoints(basePoint1, basePoint2);
        double distanceBetweenBasePoints2_3 = PointService.distanceBetweenPoints(basePoint2, basePoint3);
        double distanceBetweenBasePoints3_4 = PointService.distanceBetweenPoints(basePoint3, basePoint4);
        double distanceBetweenBasePoints1_4 = PointService.distanceBetweenPoints(basePoint1, basePoint4);

        if (basePoint1.getZ() == basePoint2.getZ() && basePoint2.getZ() == basePoint3.getZ() &&
                basePoint3.getZ() == basePoint4.getZ() && basePoint1.getZ() != topPoint.getZ()) {
            if (distanceBetweenBasePoints1_2 == distanceBetweenBasePoints2_3 && distanceBetweenBasePoints2_3 == distanceBetweenBasePoints3_4 &&
                    distanceBetweenBasePoints3_4 == distanceBetweenBasePoints1_4) {
                flag = true;
            }
        }
        if (basePoint1.getY() == basePoint2.getY() && basePoint2.getY() == basePoint3.getY() &&
                basePoint3.getY() == basePoint4.getY() && basePoint1.getY() != topPoint.getY()) {
            if (distanceBetweenBasePoints1_2 == distanceBetweenBasePoints2_3 && distanceBetweenBasePoints2_3 == distanceBetweenBasePoints3_4 &&
                    distanceBetweenBasePoints3_4 == distanceBetweenBasePoints1_4) {
                flag = true;
            }
        }
        if (basePoint1.getX() == basePoint2.getX() && basePoint2.getX() == basePoint3.getX() &&
                basePoint3.getX() == basePoint4.getX() && basePoint1.getX() != topPoint.getX()) {
            if (distanceBetweenBasePoints1_2 == distanceBetweenBasePoints2_3 && distanceBetweenBasePoints2_3 == distanceBetweenBasePoints3_4 &&
                    distanceBetweenBasePoints3_4 == distanceBetweenBasePoints1_4) {
                flag = true;
            }
        }
        return flag;
    }
}
