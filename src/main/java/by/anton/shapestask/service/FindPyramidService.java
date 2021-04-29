package by.anton.shapestask.service;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;

public interface FindPyramidService {
    public boolean baseLiesOnXY(Pyramid pyramid) throws ApiException;

    public boolean baseLiesOnXZ(Pyramid pyramid) throws ApiException;

    public boolean baseLiesOnYZ(Pyramid pyramid) throws ApiException;

    public boolean coordinatePlaneXYIntersection(Pyramid pyramid) throws ApiException;

    public boolean coordinatePlaneXZIntersection(Pyramid pyramid) throws ApiException;

    public boolean coordinatePlaneYZIntersection(Pyramid pyramid) throws ApiException;
}