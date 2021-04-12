package by.anton.shapestask;

import by.anton.shapestask.creator.CreatePyramidRepository;
import by.anton.shapestask.creator.CreatePyramidWarehouse;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.entity.PyramidValues;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.repository.PyramidRepository;
import by.anton.shapestask.repository.impl.IdSpecification;
import by.anton.shapestask.warehouse.PyramidWareHouse;

import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CreatePyramidRepository createPyramidCollection = new CreatePyramidRepository();
        try {
            createPyramidCollection.setPyramidRepositoryFromFile("./src/main/resources/data/data.txt");
            PyramidRepository pyramidRepository = PyramidRepository.getInstance();
            List<Pyramid> arrayList = pyramidRepository.query(new IdSpecification(5));
            arrayList.forEach(System.out::println);
            CreatePyramidWarehouse createPyramidWarehouse =new CreatePyramidWarehouse();
            createPyramidWarehouse.createPyramidWarehouse();
            Collection<PyramidValues> pyramidValues = PyramidWareHouse.getInstance().values();
            pyramidValues.forEach(System.out::println);
        } catch (ApiException e) {
            e.printStackTrace();
        }


    }
}
