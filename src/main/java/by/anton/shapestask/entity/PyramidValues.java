package by.anton.shapestask.entity;

public class PyramidValues {
    private double surfaceAreaOfPyramid;
    private double baseArea;
    private double allArea;
    private double volumeOfPyramid;

    public double getSurfaceAreaOfPyramid() {
        return surfaceAreaOfPyramid;
    }

    public void setSurfaceAreaOfPyramid(double surfaceAreaOfPyramid) {
        this.surfaceAreaOfPyramid = surfaceAreaOfPyramid;
    }

    public double getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(double baseArea) {
        this.baseArea = baseArea;
    }

    public double getAllArea() {
        return allArea;
    }

    public void setAllArea(double allArea) {
        this.allArea = allArea;
    }

    public double getVolumeOfPyramid() {
        return volumeOfPyramid;
    }

    public void setVolumeOfPyramid(double volumeOfPyramid) {
        this.volumeOfPyramid = volumeOfPyramid;
    }

    @Override
    public String toString() {
        return "PyramidValues{" +
                "surfaceAreaOfPyramid=" + surfaceAreaOfPyramid +
                ", baseArea=" + baseArea +
                ", allArea=" + allArea +
                ", volumeOfPyramid=" + volumeOfPyramid +
                '}';
    }
}
