package by.anton.shapestask.parser.impl;


import by.anton.shapestask.entity.Point;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.factory.PointFactory;
import by.anton.shapestask.parser.StringParser;
import by.anton.shapestask.validator.impl.StringValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class StringParserImpl implements StringParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String regexForSplitString = "\\s+";

    public ArrayList<Point> parsePointsForPyramid(ArrayList<String> lines) throws ApiException {
        logger.info("Method parsePointsForPyramid called");
        if (lines.isEmpty()) {
            throw new ApiException("Data is empty");
        }
        ArrayList<Point> pointArrayList = new ArrayList<>();
        StringValidatorImpl stringValidator = new StringValidatorImpl();
        PointFactory pointFactory = new PointFactory();
        for (String string : lines) {
            if (stringValidator.isValidPointsString(string)) {
                String[] elements = string.split(regexForSplitString);
                for (int i = 0; i < elements.length; i += 3) {
                    Point point = pointFactory.getPoint();
                    point.setX(Double.parseDouble(elements[i]));
                    point.setY(Double.parseDouble(elements[i + 1]));
                    point.setZ(Double.parseDouble(elements[i + 2]));
                    pointArrayList.add(point);
                }
            }
        }
        return pointArrayList;
    }
}
