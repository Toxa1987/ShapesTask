package by.anton.shapestask.entity;

public class Pyramid {
    private int id;
    private Point topPoint;
    private Point basePoint1;
    private Point basePoint2;
    private Point basePoint3;
    private Point basePoint4;

    public Pyramid() {
    }

    public Pyramid(Point topPoint, Point basePoint1, Point basePoint2, Point basePoint3, Point basePoint4) {
        this.topPoint = topPoint;
        this.basePoint1 = basePoint1;
        this.basePoint2 = basePoint2;
        this.basePoint3 = basePoint3;
        this.basePoint4 = basePoint4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getTopPoint() {
        return topPoint;
    }

    public void setTopPoint(Point topPoint) {
        this.topPoint = topPoint;
    }

    public Point getBasePoint1() {
        return basePoint1;
    }

    public void setBasePoint1(Point basePoint1) {
        this.basePoint1 = basePoint1;
    }

    public Point getBasePoint2() {
        return basePoint2;
    }

    public void setBasePoint2(Point basePoint2) {
        this.basePoint2 = basePoint2;
    }

    public Point getBasePoint3() {
        return basePoint3;
    }

    public void setBasePoint3(Point basePoint3) {
        this.basePoint3 = basePoint3;
    }

    public Point getBasePoint4() {
        return basePoint4;
    }

    public void setBasePoint4(Point basePoint4) {
        this.basePoint4 = basePoint4;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "id=" + id +
                ", topPoint=" + topPoint +
                ", basePoint1=" + basePoint1 +
                ", basePoint2=" + basePoint2 +
                ", basePoint3=" + basePoint3 +
                ", basePoint4=" + basePoint4 +
                '}';
    }
}


