package by.anton.shapestask.parser;

import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.parser.impl.StringPointParserImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringPointParserTest {

    @Test
    public void testParsePointsForPyramid() throws ApiException {
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        String actualString = "1.0   1.0   0    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0";
        double[] expected = {1.0, 1.0, 0, -1.0, 1.0, 0, -1.0, -1.0, 0, 1.0, -1.0, 0, 0, 0, 2.0};
        double[] actual = stringPointParser.parsePointsForPyramid(actualString);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ApiException.class)
    public void testParsePointsForPyramidWithInvalidString() throws ApiException {
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        String actualString = "1.c0  1.0   0    -1.0   1.0   0    -1.0  -1.0   0     1.0   -1.0    0      0    0   2.0";
        stringPointParser.parsePointsForPyramid(actualString);
    }

    @Test(expectedExceptions = ApiException.class)
    public void testParsePointsForPyramidWithNullString() throws ApiException {
        StringPointParserImpl stringPointParser = new StringPointParserImpl();
        String actualString = null;
        stringPointParser.parsePointsForPyramid(actualString);
    }
}
