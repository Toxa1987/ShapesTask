package by.anton.shapestask.comparator;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.service.impl.CalculatePyramidServiceImpl;

import java.util.Comparator;

public class PyramidBaseAreaComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        CalculatePyramidServiceImpl calculatePyramidService = new CalculatePyramidServiceImpl();
        double baseArea1;
        double baseArea2;
        try {
            baseArea1 = calculatePyramidService.baseArea(o1);
            baseArea2 = calculatePyramidService.baseArea(o2);
        } catch (ApiException e) {
            return o1 == null ? -1 : 1;
        }
        return Double.compare(baseArea1, baseArea2);
    }
}
