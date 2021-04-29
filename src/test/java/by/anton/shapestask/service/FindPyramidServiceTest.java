package by.anton.shapestask.service;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.service.impl.FindPyramidServiceImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FindPyramidServiceTest {
    private ArrayList<Pyramid> list;
    private FindPyramidServiceImpl findPyramidService;

    @BeforeClass
    public void setParameters() {
        findPyramidService = new FindPyramidServiceImpl();
        list = new ArrayList<>();
        Pyramid pyramid1 = new Pyramid(
                new Point(0, 0, 2.0),
                new Point(1.0, 1.0, 0),
                new Point(-1.0, 1.0, 0),
                new Point(-1.0, -1.0, 0),
                new Point(1.0, -1.0, 0));
        list.add(pyramid1);
        Pyramid pyramid2 = new Pyramid(
                new Point(0, 2.0, 0),
                new Point(1.0, 0, 1.0),
                new Point(-1.0, 0, 1.0),
                new Point(-1.0, 0, -1.0),
                new Point(1.0, 0, -1.0));
        list.add(pyramid2);
        Pyramid pyramid3 = new Pyramid(
                new Point(2.0, 0, 0),
                new Point(0, 1.0, 1.0),
                new Point(0, -1.0, 1.0),
                new Point(0, -1.0, -1.0),
                new Point(0, 1.0, -1.0));
        list.add(pyramid3);
    }

    @Test
    public void baseLiesOnXYTest() throws ApiException {
        boolean result = findPyramidService.baseLiesOnXY(list.get(0));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = ApiException.class)
    public void baseLiesOnXYTestWithNull() throws ApiException {
        findPyramidService.baseLiesOnXY(null);
    }
    @Test
    public void baseLiesOnXZTest() throws ApiException {
        boolean result = findPyramidService.baseLiesOnXZ(list.get(1));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = ApiException.class)
    public void baseLiesOnXZTestWithNull() throws ApiException {
        findPyramidService.baseLiesOnXZ(null);
    }
    @Test
    public void baseLiesOnYZTest() throws ApiException {
        boolean result = findPyramidService.baseLiesOnYZ(list.get(2));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = ApiException.class)
    public void baseLiesOnYZTestWithNull() throws ApiException {
        findPyramidService.baseLiesOnXY(null);
    }

    @Test
    public void coordinatePlaneXZIntersectionTest() throws ApiException {
        boolean result = findPyramidService.coordinatePlaneXZIntersection(list.get(0));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = ApiException.class)
    public void coordinatePlaneXZIntersectionTestWithNull() throws ApiException {
        findPyramidService.coordinatePlaneXZIntersection(null);
    }
    @Test
    public void coordinatePlaneYZIntersectionTest() throws ApiException {
        boolean result = findPyramidService.coordinatePlaneYZIntersection(list.get(0));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = ApiException.class)
    public void coordinatePlaneYZIntersectionTestWithNull() throws ApiException {
        findPyramidService.coordinatePlaneYZIntersection(null);
    }
    @Test
    public void coordinatePlaneXYIntersectionTest() throws ApiException {
        boolean result = findPyramidService.coordinatePlaneXYIntersection(list.get(1));
        Assert.assertTrue(result);
    }

    @Test(expectedExceptions = ApiException.class)
    public void coordinatePlaneXYIntersectionTestWithNull() throws ApiException {
        findPyramidService.coordinatePlaneXYIntersection(null);
    }
}