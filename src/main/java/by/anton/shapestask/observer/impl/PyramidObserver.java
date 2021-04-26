package by.anton.shapestask.observer.impl;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.entity.PyramidValues;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.observer.Observer;
import by.anton.shapestask.observer.PyramidEvent;
import by.anton.shapestask.service.CalculatePyramidService;
import by.anton.shapestask.warehouse.PyramidWareHouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidObserver implements Observer {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public void updatePyramidValues(PyramidEvent pyramidEvent) {
        Pyramid pyramid = pyramidEvent.getSource();
        int id = pyramid.getId();
        PyramidWareHouse pyramidWareHouse = PyramidWareHouse.getInstance();
        PyramidValues pyramidValues = pyramidWareHouse.get(id);
        CalculatePyramidService calculatePyramidService = new CalculatePyramidService();
        try {
            pyramidValues.setVolumeOfPyramid(calculatePyramidService.volumeOfPyramid(pyramid));
            pyramidValues.setSurfaceAreaOfPyramid(calculatePyramidService.surfaceAreaOfPyramid(pyramid));
            pyramidValues.setBaseArea(calculatePyramidService.baseArea(pyramid));
            pyramidValues.setAllArea(calculatePyramidService.allArea(pyramid));
        } catch (ApiException e) {
            logger.error("Exception in update pyramid method: " + e);
        }
    }
}
