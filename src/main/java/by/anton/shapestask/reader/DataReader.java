package by.anton.shapestask.reader;

import by.anton.shapestask.exception.ApiException;

import java.util.ArrayList;

public interface DataReader {
    public ArrayList<String> readFile(String path) throws ApiException;

}
