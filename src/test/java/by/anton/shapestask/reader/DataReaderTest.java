package by.anton.shapestask.reader;

import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.reader.impl.DataReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class DataReaderTest {
    private ArrayList<String> expectedList;
    private String path;

    @BeforeClass
    public void setRightParameters() {
        expectedList = new ArrayList<>();
        expectedList.add("1.0   1.0   0    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0");
        expectedList.add("2.0   2.0   0    -2.0   2.0   0    -2.0  -2.0   0     2.0   -2.0    0      0    0   4.0");
        expectedList.add("1.c0  1.0   0    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0");
        ClassLoader classLoader = DataReaderTest.class.getClassLoader();
        URL resource = classLoader.getResource("data/testdataforreader.txt");
        path = new File(resource.getFile()).getAbsolutePath();
    }

    @Test
    public void readFileTestWithRightPath() throws ApiException {
        DataReader dataReader = new DataReaderImpl();
        ArrayList<String> actualList = dataReader.readFile(path);
        Assert.assertEquals(actualList, expectedList);
    }

    @Test(expectedExceptions = ApiException.class)
    public void readFileTestWithWrongPath() throws ApiException {
        DataReader dataReader = new DataReaderImpl();
        dataReader.readFile("wrong path");
    }
}
