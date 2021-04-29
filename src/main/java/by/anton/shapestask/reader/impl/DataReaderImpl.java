package by.anton.shapestask.reader.impl;

import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.reader.DataReader;
import by.anton.shapestask.validator.impl.FileValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public ArrayList<String> readFile(String path) throws ApiException {
        logger.info("Method readFile called");
        FileValidatorImpl fileValidate = new FileValidatorImpl();
        if (!fileValidate.validateFilePath(path)) {
            throw new ApiException("File is not exist or is empty or incorrect path");
        }
        ArrayList<String> lines;
        Path pathFile = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(pathFile)) {
            lines = lineStream.collect(Collectors.toCollection(ArrayList::new));

        } catch (IOException e) {
            throw new ApiException("Reading file is fail ",e);
        }
        return  lines;
    }
}
