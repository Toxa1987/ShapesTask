package by.anton.shapestask.creator;

import by.anton.shapestask.entity.Point;
import by.anton.shapestask.entity.Pyramid;
import by.anton.shapestask.exception.ApiException;
import by.anton.shapestask.factory.PointFactory;
import by.anton.shapestask.factory.PyramidFactory;
import by.anton.shapestask.repository.PyramidRepository;

import java.util.ArrayList;

public class CreatePyramidRepository {

    public static void createRepository(ArrayList<double[]> listPointsCoordinate) throws ApiException {
        PyramidRepository pyramidRepository = PyramidRepository.getInstance();
        ArrayList<Point> pointArrayList = new ArrayList<>();
        for (double[] temp : listPointsCoordinate
                ) {
            for (int i = 0; i < temp.length; i += 3) {
                Point tempPoint = PointFactory.getPoint(temp[i], temp[i + 1], temp[i + 2]);
                pointArrayList.add(tempPoint);
            }
        }
        for (int i = 0; i < pointArrayList.size(); i += 5) {
            Point basePoint1 = pointArrayList.get(i);
            Point basePoint2 = pointArrayList.get(i + 1);
            Point basePoint3 = pointArrayList.get(i + 2);
            Point basePoint4 = pointArrayList.get(i + 3);
            Point topPoint = pointArrayList.get(i + 4);
            Pyramid pyramid = PyramidFactory.getPyramid(basePoint1, basePoint2, basePoint3, basePoint4, topPoint);
            pyramidRepository.add(pyramid);
        }
    }
}

