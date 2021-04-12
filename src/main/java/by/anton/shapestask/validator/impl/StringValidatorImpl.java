package by.anton.shapestask.validator.impl;

import by.anton.shapestask.validator.StringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringValidatorImpl implements StringValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final String regexForElement = "(-?(\\d*\\.)?\\d+)";
    private static final String regexForSplit = "\\s+";


    public boolean isValidPointsString(String str) {
        logger.info("Method validator of points string called");
        if (str.isEmpty() || str.trim().isEmpty()) { // My jdk 12 don't compile when i use str.isBlank(). It is cause why i use str.trim().isEmpty() because it is equal isBlank().
            return false;
        }
        boolean isVal = false;
        String[] elements = str.split(regexForSplit);
        if (elements.length == 15) {
            for (String element : elements) {
                if (element.matches(regexForElement)) {
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
