package by.anton.shapestask.parser;

import by.anton.shapestask.exception.ApiException;

public interface StringPointParser {
    public double[] parsePointsForPyramid(String pointLine) throws ApiException;
}
