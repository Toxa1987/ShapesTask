package by.anton.shapestask.creator;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.entity.PyramidValues;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.repository.PyramidRepository;
import by.anton.shapestask.service.CalculatePyramidService;
import by.anton.shapestask.warehouse.PyramidWareHouse;

import java.util.ArrayList;

public class CreatePyramidWarehouse {


    public static void createWarehouse() throws ApiException {
        PyramidRepository pyramidRepository = PyramidRepository.getInstance();
        ArrayList<Pyramid> pyramidList = new ArrayList<>(pyramidRepository.getAll());
        PyramidWareHouse pyramidWareHouse = PyramidWareHouse.getInstance();
        CalculatePyramidService calculatePyramidService = new CalculatePyramidService();
        for (Pyramid pyramid : pyramidList
                ) {
            PyramidValues pyramidValues = new PyramidValues();
            pyramidValues.setAllArea(calculatePyramidService.allArea(pyramid));
            pyramidValues.setBaseArea(calculatePyramidService.baseArea(pyramid));
            pyramidValues.setSurfaceAreaOfPyramid(calculatePyramidService.surfaceAreaOfPyramid(pyramid));
            pyramidValues.setVolumeOfPyramid(calculatePyramidService.volumeOfPyramid(pyramid));
            pyramidWareHouse.put(pyramid.getId(), pyramidValues);
        }
    }
}
