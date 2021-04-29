package by.anton.shapestask.creator;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.entity.PyramidValues;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.repository.PyramidRepository;
import by.anton.shapestask.service.impl.CalculatePyramidServiceImpl;
import by.anton.shapestask.warehouse.PyramidWareHouse;

import java.util.ArrayList;

public class PyramidWarehouseCreator {


    public static void createWarehouse(PyramidRepository pyramidRepository) throws ApiException {
        ArrayList<Pyramid> pyramidList = new ArrayList<>(pyramidRepository.getAll());
        PyramidWareHouse pyramidWareHouse = PyramidWareHouse.getInstance();
        CalculatePyramidServiceImpl calculatePyramidService = new CalculatePyramidServiceImpl();
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
