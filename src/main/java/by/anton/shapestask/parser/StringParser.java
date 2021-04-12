package by.anton.shapestask.parser;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.exception.ApiException;

import java.util.ArrayList;

public interface StringParser {
    public ArrayList<Point> parsePointsForPyramid(ArrayList<String> lines) throws ApiException;
}
