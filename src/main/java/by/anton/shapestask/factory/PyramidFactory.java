package by.anton.shapestask.factory;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.validator.impl.PyramidValidatorImpl;

public class PyramidFactory {
    private static int id = 1;

    public static Pyramid getPyramid(Point basePoint1, Point basePoint2, Point basePoint3, Point basePoint4, Point topPoint) throws ApiException {
        PyramidValidatorImpl pyramidValidator = new PyramidValidatorImpl();
        if (!pyramidValidator.isPyramidValid(basePoint1, basePoint2, basePoint3, basePoint4, topPoint)) {
            throw new ApiException("Incorrect data to create pyramid");
        }
        Pyramid pyramid = new Pyramid();
        pyramid.setId(id);
        pyramid.setBasePoint1(basePoint1);
        pyramid.setBasePoint2(basePoint2);
        pyramid.setBasePoint3(basePoint3);
        pyramid.setBasePoint4(basePoint4);
        pyramid.setTopPoint(topPoint);
        id++;
        return pyramid;
    }
}
