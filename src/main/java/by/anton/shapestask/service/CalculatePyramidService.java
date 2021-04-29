package by.anton.shapestask.service;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;

public interface CalculatePyramidService {
    public double surfaceAreaOfPyramid(Pyramid pyramid) throws ApiException;

    public double baseArea(Pyramid pyramid) throws ApiException;

    public double allArea(Pyramid pyramid) throws ApiException;

    public double volumeOfPyramid(Pyramid pyramid) throws ApiException;

    public double cutOffRatio(Pyramid pyramid) throws ApiException;

    public double pyramidHeight(Pyramid pyramid) throws ApiException;
}