package by.anton.shapestask.creator;

import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.entity.PyramidValues;
import by.anton.shapestask.repository.PyramidRepository;
import by.anton.shapestask.service.CalculatePyramidService;
import by.anton.shapestask.warehouse.PyramidWareHouse;

import java.util.ArrayList;
import java.util.List;

public class CreatePyramidWarehouse {
    private PyramidRepository pyramidRepository;
    private List<Pyramid> pyramidList;
    private CalculatePyramidService calculatePyramidService;
    private PyramidWareHouse pyramidWareHouse;

    public CreatePyramidWarehouse() {
        pyramidList= new ArrayList<>();
        pyramidRepository= PyramidRepository.getInstance();
        calculatePyramidService= new CalculatePyramidService();
        pyramidWareHouse= PyramidWareHouse.getInstance();
    }

    public void createPyramidWarehouse(){
        pyramidList.addAll(pyramidRepository.getAll());
        for (Pyramid pyramid: pyramidList
             ) {
            PyramidValues pyramidValues = new PyramidValues();
            pyramidValues.setAllArea(calculatePyramidService.allArea(pyramid));
            pyramidValues.setBaseArea(calculatePyramidService.baseArea(pyramid));
            pyramidValues.setSurfaceAreaOfPyramid(calculatePyramidService.surfaceAreaOfPyramid(pyramid));
            pyramidValues.setVolumeOfPyramid(calculatePyramidService.volumeOfPyramid(pyramid));
            pyramidWareHouse.put(pyramid.getId(),pyramidValues);
        }
    }
}
