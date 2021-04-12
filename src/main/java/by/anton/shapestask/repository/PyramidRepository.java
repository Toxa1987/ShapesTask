package by.anton.shapestask.repository;

import by.anton.shapestask.entity.Pyramid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PyramidRepository {
    private List<Pyramid> pyramidList;
    private static PyramidRepository instance;

    private PyramidRepository() {
        pyramidList = new ArrayList<>();
    }

    public static PyramidRepository getInstance() {
        if (instance == null) {
            instance = new PyramidRepository();
        }
        return instance;
    }

    public boolean add(Pyramid pyramid) {
        return pyramidList.add(pyramid);
    }

    public boolean addAll(Collection<? extends Pyramid> c) {
        return pyramidList.addAll(c);
    }

    public boolean remove(Object o) {
        return pyramidList.remove(o);
    }

    public boolean removeAll(Collection<?> c) {
        return pyramidList.removeAll(c);
    }

    public Pyramid getPyramid(int index) {
        return pyramidList.get(index);
    }

    public List<Pyramid> getAll() {
        return pyramidList;
    }

    public void setPyramid(int index, Pyramid pyramid) {
        pyramidList.set(index, pyramid);
    }

    public List<Pyramid> query(Specification specification) {
        List<Pyramid> list = pyramidList.stream().filter(o -> specification.specified(o)).collect(Collectors.toList());
        return list;
    }
}
