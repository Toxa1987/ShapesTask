package by.anton.shapestask.service;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.service.impl.PointServiceImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointServiceTest {
    @Test
    public void distanceBetweenPointsTest() throws ApiException {
        Point point1 = new Point(1.0, 1.0, 0);
        Point point2 = new Point(2.0, 1.0, 0);
        double actual = PointServiceImpl.distanceBetweenPoints(point1, point2);
        double expected = 1.0;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void distanceBetweenPointsTestWithNull() throws ApiException {
        PointServiceImpl.distanceBetweenPoints(null,new Point());
    }
}
