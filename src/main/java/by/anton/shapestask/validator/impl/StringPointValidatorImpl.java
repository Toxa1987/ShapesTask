package by.anton.shapestask.validator.impl;

import by.anton.shapestask.validator.StringPointValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringPointValidatorImpl implements StringPointValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEX_FOR_ELEMENT = "(-?(\\d*\\.)?\\d+)";
    private static final String REGEX_FOR_SPLIT = "\\s+";
    private static final int ELEMENTS_IN_POINT_STRING = 15;

    public boolean isValidPointsString(String str) {
        logger.info("Method validator of points string called with parameters: " + str);
        if (str.isEmpty() || str.trim().isEmpty()) { // My jdk 12 don't compile when i use str.isBlank(). It is cause why i use str.trim().isEmpty() because it is equal isBlank().
            return false;
        }
        boolean isVal = false;
        String[] elements = str.split(REGEX_FOR_SPLIT);
        if (elements.length == ELEMENTS_IN_POINT_STRING) {
            for (String element : elements) {
                if (element.matches(REGEX_FOR_ELEMENT)) {
                    isVal = true;
                } else {
                    isVal = false;
                    break;
                }
            }
        }

        logger.info("String: " + str + " - " + isVal);
        return isVal;
    }
}
