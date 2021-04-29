package by.anton.shapestask;

import by.anton.shapestask.creator.PyramidRepositoryCreator;
import by.anton.shapestask.creator.PyramidWarehouseCreator;
import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.entity.PyramidValues;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.observer.Observer;
import by.anton.shapestask.observer.impl.PyramidObserver;
import by.anton.shapestask.parser.impl.StringPointParserImpl;
import by.anton.shapestask.reader.DataReader;
import by.anton.shapestask.reader.DataReaderTest;
import by.anton.shapestask.reader.impl.DataReaderImpl;
import by.anton.shapestask.repository.PyramidRepository;
import by.anton.shapestask.warehouse.PyramidWareHouse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class TestApi {
    private ArrayList<String> expectedAfterReaderList;
    private ArrayList<double[]> expectedAfterParserList;
    private ArrayList<Pyramid> expectedRepository;
    private Collection<PyramidValues> expectedWarehouseValues;
    private ArrayList<String> tempListAfterReaderList;
    private ArrayList<double[]> tempListAfterParserList;
    private String path;

    @BeforeClass
    public void setRightParameters() {
        ClassLoader classLoader = DataReaderTest.class.getClassLoader();
        URL resource = classLoader.getResource("data/testdatawithrightparameters.txt");
        path = new File(resource.getFile()).getAbsolutePath();

        tempListAfterReaderList = new ArrayList<>();
        tempListAfterParserList = new ArrayList<>();

        expectedAfterReaderList = new ArrayList<>();
        expectedAfterReaderList.add("1.0   1.0   0    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0");
        expectedAfterReaderList.add("2.0   2.0   0    -2.0   2.0   0    -2.0  -2.0   0     2.0   -2.0    0      0    0   4.0");

        expectedAfterParserList = new ArrayList<>();
        expectedAfterParserList.add(new double[]{1.0, 1.0, 0, -1.0, 1.0, 0, -1.0, -1.0, 0, 1.0, -1.0, 0, 0, 0, 2.0});
        expectedAfterParserList.add(new double[]{2.0, 2.0, 0, -2.0, 2.0, 0, -2.0, -2.0, 0, 2.0, -2.0, 0, 0, 0, 4.0});

        expectedRepository = new ArrayList<>();
        Pyramid pyramid1 = new Pyramid(
                new Point(0, 0, 2.0),
                new Point(1.0, 1.0, 0),
                new Point(-1.0, 1.0, 0),
                new Point(-1.0, -1.0, 0),
                new Point(1.0, -1.0, 0));
        pyramid1.setId(1);

        Pyramid pyramid2 = new Pyramid(
                new Point(0, 0, 4.0),
                new Point(2.0, 2.0, 0),
                new Point(-2.0, 2.0, 0),
                new Point(-2.0, -2.0, 0),
                new Point(2.0, -2.0, 0));
        pyramid2.setId(2);
        expectedRepository.add(pyramid1);
        expectedRepository.add(pyramid2);

        expectedWarehouseValues = new ArrayList<>();
        PyramidValues pyramidValues1 = new PyramidValues();
        pyramidValues1.setSurfaceAreaOfPyramid(2.24);
        pyramidValues1.setBaseArea(4.0);
        pyramidValues1.setAllArea(6.24);
        pyramidValues1.setVolumeOfPyramid(2.67);
        expectedWarehouseValues.add(pyramidValues1);
        PyramidValues pyramidValues2 = new PyramidValues();
        pyramidValues2.setSurfaceAreaOfPyramid(8.94);
        pyramidValues2.setBaseArea(16.0);
        pyramidValues2.setAllArea(24.94);
        pyramidValues2.setVolumeOfPyramid(21.33);
        expectedWarehouseValues.add(pyramidValues2);
    }

    @Test(priority = 1)
    public void readFileTestWithPath() throws ApiException {
        DataReader dataReader = new DataReaderImpl();
        ArrayList<String> actualList = dataReader.readFile(path);
        tempListAfterReaderList.addAll(actualList);
        Assert.assertEquals(actualList, expectedAfterReaderList);
    }

    @Test(dependsOnMethods = "readFileTestWithPath", priority = 2)
    public void testParsePointsForPyramid() throws ApiException {
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        ArrayList<double[]> actualArraysList = new ArrayList<>();
        for (String s : tempListAfterReaderList
                ) {
            double[] temp = stringPointParser.parsePointsForPyramid(s);
            actualArraysList.add(temp);
        }
        tempListAfterParserList.addAll(actualArraysList);
        for (int i = 0; i < actualArraysList.toArray().length; i++) {
            Assert.assertEquals(actualArraysList.get(i), expectedAfterParserList.get(i));
        }
    }

    @Test(dependsOnMethods = "testParsePointsForPyramid", priority = 3)
    public void testCreateRepository() throws ApiException {
        PyramidRepositoryCreator.createRepository(tempListAfterParserList);
        ArrayList<Pyramid> actualList = new ArrayList<>(PyramidRepository.getInstance().getAll());
        Assert.assertEquals(actualList, expectedRepository);
    }

    @Test(dependsOnMethods = "testCreateRepository", priority = 4)
    public void testCreateWarehouse() throws ApiException {
        PyramidWarehouseCreator.createWarehouse(PyramidRepository.getInstance());
        Collection<PyramidValues> actual = PyramidWareHouse.getInstance().values();
        Assert.assertEquals(actual, expectedWarehouseValues);
    }

    @Test(dependsOnMethods = "testCreateWarehouse", priority = 5)
    public void testObserverWork() {
        Observer observer = new PyramidObserver();
        Pyramid tempPyramid = PyramidRepository.getInstance().getPyramid(0);
        Integer id = tempPyramid.getId();
        tempPyramid.attach(observer);
        PyramidValues pyramidValuesBeforeChange = PyramidWareHouse.getInstance().get(id);
        double surfaceArea = pyramidValuesBeforeChange.getSurfaceAreaOfPyramid();
        double volume = pyramidValuesBeforeChange.getVolumeOfPyramid();
        double allArea = pyramidValuesBeforeChange.getAllArea();
        tempPyramid.setTopPoint(new Point(0, 0, 3.0));
        PyramidValues pyramidValuesAfterChange = PyramidWareHouse.getInstance().get(id);
        boolean result = false;
        if (pyramidValuesAfterChange.getAllArea() != allArea & pyramidValuesAfterChange.getSurfaceAreaOfPyramid() != surfaceArea &
                pyramidValuesAfterChange.getVolumeOfPyramid() != volume) {
            result = true;
        }
        Assert.assertTrue(result);
    }
}
