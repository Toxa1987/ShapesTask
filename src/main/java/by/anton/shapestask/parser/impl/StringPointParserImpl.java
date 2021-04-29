package by.anton.shapestask.parser.impl;

import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.parser.StringPointParser;
import by.anton.shapestask.validator.impl.StringPointValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringPointParserImpl implements StringPointParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_SPLIT = "\\s+";

    public double[] parsePointsForPyramid(String pointLine) throws ApiException {
        logger.info("Method parsePointsForPyramid called with parameters: " + pointLine);
        if (pointLine.isEmpty() || pointLine.trim().isEmpty()) {
            throw new ApiException("Data is empty");
        }
        StringPointValidatorImpl stringValidator = new StringPointValidatorImpl();
        double pointsCoordinate[] = null;
        if (stringValidator.isValidPointsString(pointLine)) {
            String[] elements = pointLine.split(REGEX_FOR_SPLIT);
            pointsCoordinate = new double[elements.length];
            for (int i = 0; i < elements.length; i++) {
                pointsCoordinate[i] = Double.parseDouble(elements[i]);
            }
        }
        if (pointsCoordinate == null) {
            throw new ApiException("Invalid string of point coordinates");
        }
        return pointsCoordinate;
    }
}
