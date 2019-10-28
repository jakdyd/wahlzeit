package org.wahlzeit.model;

public class Coordinate {

    private final double THRESHOLD = .0001;
    
    private double x;
    private double y;
    private double z;

    public Coordinate() {
    }

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDistance(Coordinate coordinate) {
        double sum = 0;
        sum += Math.pow(getX() - coordinate.getX(), 2.0);
        sum += Math.pow(getY() - coordinate.getY(), 2.0);
        sum += Math.pow(getZ() - coordinate.getZ(), 2.0);
        return Math.sqrt(sum);
    }

    public boolean isEqual(Coordinate coordinate) {
        return compareDoubles(getX(), coordinate.getX())
                && compareDoubles(getY(), coordinate.getY())
                && compareDoubles(getZ(), coordinate.getZ());
    }
    
    private boolean compareDoubles(double x, double y) {
        return Math.abs(x - y) < THRESHOLD;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Coordinate) ? isEqual((Coordinate) obj) : false;
    }

}
