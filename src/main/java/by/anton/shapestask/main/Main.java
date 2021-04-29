package by.anton.shapestask.main;

import by.anton.shapestask.creator.PyramidRepositoryCreator;
import by.anton.shapestask.creator.PyramidWarehouseCreator;
import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.entity.PyramidValues;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.observer.Observer;
import by.anton.shapestask.observer.impl.PyramidObserver;
import by.anton.shapestask.parser.impl.StringPointParserImpl;
import by.anton.shapestask.reader.impl.DataReaderImpl;
import by.anton.shapestask.repository.PyramidRepository;
import by.anton.shapestask.warehouse.PyramidWareHouse;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws ApiException {
        DataReaderImpl dataReader = new DataReaderImpl();
        ArrayList<String> arrayList = null;
        try {
            arrayList = dataReader.readFile("./src/main/resources/data/data.txt");
        } catch (ApiException e) {
            e.printStackTrace();
        }
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        ArrayList<double[]> list = new ArrayList<>();
        for (String s : arrayList
                ) {
            try {
                double[] temp = stringPointParser.parsePointsForPyramid(s);
                list.add(temp);
            } catch (ApiException a) {
                //do nothing
            }

        }
        try {
            PyramidRepositoryCreator.createRepository(list);
        } catch (ApiException e) {
            //do nothing
        }
        PyramidWarehouseCreator.createWarehouse(PyramidRepository.getInstance());
        PyramidWareHouse pyramidWareHouse = PyramidWareHouse.getInstance();
        PyramidRepository pyramidRepository = PyramidRepository.getInstance();
        PyramidValues pyramidValues = pyramidWareHouse.get(1);
        System.out.println(pyramidValues);
        Observer observer = new PyramidObserver();
        Pyramid pyramid = pyramidRepository.getPyramid(0);
        pyramid.attach(observer);
        pyramid.setTopPoint(new Point(0,0,6.0));
        pyramidValues = pyramidWareHouse.get(1);
        System.out.println(pyramidValues);
    }
}
