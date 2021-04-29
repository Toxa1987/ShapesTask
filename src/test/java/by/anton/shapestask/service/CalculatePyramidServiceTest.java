package by.anton.shapestask.service;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.service.impl.CalculatePyramidServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatePyramidServiceTest {
    CalculatePyramidServiceImpl calculatePyramidService;

    @BeforeClass
    public void setUp() {
        calculatePyramidService = new CalculatePyramidServiceImpl();
    }

    @Test(expectedExceptions = ApiException.class)
    public void surfaceAreaOfPyramidTestWithNull() throws ApiException {
        calculatePyramidService.surfaceAreaOfPyramid(null);
    }

    @Test(expectedExceptions = ApiException.class)
    public void baseAreaOfPyramidTestWithNull() throws ApiException {
        calculatePyramidService.baseArea(null);
    }

    @Test(expectedExceptions = ApiException.class)
    public void allAreaOfPyramidTestWithNull() throws ApiException {
        calculatePyramidService.allArea(null);
    }

    @Test(expectedExceptions = ApiException.class)
    public void volumeOfPyramidTestWithNull() throws ApiException {
        calculatePyramidService.volumeOfPyramid(null);
    }

    @Test(expectedExceptions = ApiException.class)
    public void cutOffRatioTestWithNull() throws ApiException {
        calculatePyramidService.cutOffRatio(null);
    }

    @Test(expectedExceptions = ApiException.class)
    public void cutOffRatioTestWithNonIntersectParameters() throws ApiException {
        Pyramid pyramid = new Pyramid();
        pyramid.setTopPoint(new Point(4.0, 4.0, 5.0));
        pyramid.setBasePoint1(new Point(6.0, 6.0, 1.0));
        pyramid.setBasePoint2(new Point(2.0, 6.0, 1.0));
        pyramid.setBasePoint3(new Point(2.0, 2.0, 1.0));
        pyramid.setBasePoint4(new Point(6.0, 2.0, 1.0));
        calculatePyramidService.cutOffRatio(pyramid);
    }

    @Test(expectedExceptions = ApiException.class)
    public void pyramidHeightTestWithNull() throws ApiException {
        calculatePyramidService.pyramidHeight(null);
    }
}
