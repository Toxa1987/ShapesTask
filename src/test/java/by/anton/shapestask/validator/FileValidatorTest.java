package by.anton.shapestask.validator;

import by.anton.shapestask.validator.impl.FileValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;


public class FileValidatorTest {
    private FileValidator fileValidator;
    private String rightPath;

    @BeforeClass
    public void setRightParameters() {
        fileValidator = new FileValidatorImpl();
        ClassLoader classLoader = FileValidatorTest.class.getClassLoader();
        URL resource = classLoader.getResource("data/testdataforreader.txt");
        rightPath = new File(resource.getFile()).getAbsolutePath();
    }

    @Test
    public void validPath() {
        boolean actual = fileValidator.validateFilePath(rightPath);
        Assert.assertTrue(actual);
    }

    @Test
    public void inValidPath() {
        String path = "./src/main/resources/datafiele/daqta.txt";
        boolean actual = fileValidator.validateFilePath(path);
        Assert.assertFalse(actual);
    }
}
