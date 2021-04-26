package by.anton.shapestask.comparator;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.service.CalculatePyramidService;

import java.util.Comparator;

public class PyramidHeightComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        CalculatePyramidService calculatePyramidService = new CalculatePyramidService();
        double height1;
        double height2;
        try {
            height1 = calculatePyramidService.pyramidHeight(o1);
            height2 = calculatePyramidService.pyramidHeight(o2);
        } catch (ApiException e) {
            return o1 == null ? -1 : 1;
        }
        return Double.compare(height1, height2);
    }
}
