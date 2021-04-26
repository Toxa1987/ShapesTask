package by.anton.shapestask.service;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class CalculatePyramidServiceTest {
    CalculatePyramidService calculatePyramidService;

    @BeforeClass
    public void setUp(){
        calculatePyramidService = new CalculatePyramidService();
    }
    @DataProvider (name = "pyramid_data")
    public Object[][] buildData(){
        return new Object[][]
    }
}
