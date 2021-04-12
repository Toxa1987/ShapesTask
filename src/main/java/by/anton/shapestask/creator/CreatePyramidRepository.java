package by.anton.shapestask.creator;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.factory.PyramidFactory;
import by.anton.shapestask.parser.StringParser;
import by.anton.shapestask.parser.impl.StringParserImpl;
import by.anton.shapestask.reader.DataReader;
import by.anton.shapestask.reader.impl.DataReaderImpl;
import by.anton.shapestask.repository.PyramidRepository;
import by.anton.shapestask.validator.impl.PyramidValidatorImpl;

import java.util.ArrayList;

public class CreatePyramidRepository {
    private PyramidRepository pyramidRepository;
    private DataReader dataReader;
    private PyramidFactory pyramidFactory;
    private StringParser stringParser;

    public CreatePyramidRepository() {
        pyramidRepository = PyramidRepository.getInstance();
        dataReader = new DataReaderImpl();
        stringParser = new StringParserImpl();
        pyramidFactory = new PyramidFactory();
    }

    public void setPyramidRepositoryFromFile(String path) throws ApiException {
        ArrayList<Point> pointArrayList = stringParser.parsePointsForPyramid(dataReader.readFile(path));
        for (int i = 0; i < pointArrayList.size(); i += 5) {
            Point basePoint1 = pointArrayList.get(i);
            Point basePoint2 = pointArrayList.get(i + 1);
            Point basePoint3 = pointArrayList.get(i + 2);
            Point basePoint4 = pointArrayList.get(i + 3);
            Point topPoint = pointArrayList.get(i + 4);
            PyramidValidatorImpl pyramidValidator = new PyramidValidatorImpl();
            if (pyramidValidator.isPyramidValid(basePoint1, basePoint2, basePoint3, basePoint4, topPoint)) {
                Pyramid pyramid = pyramidFactory.getPyramid();
                pyramid.setBasePoint1(basePoint1);
                pyramid.setBasePoint2(basePoint2);
                pyramid.setBasePoint3(basePoint3);
                pyramid.setBasePoint4(basePoint4);
                pyramid.setTopPoint(topPoint);
                pyramidRepository.add(pyramid);
            }
        }
    }
}
