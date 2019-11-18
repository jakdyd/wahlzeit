package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {

    private double x;
    private double y;
    private double z;

    public CartesianCoordinate() {
    }

    public CartesianCoordinate(double x, double y, double z) {
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

    public double getDistance(CartesianCoordinate coordinate) {
        double sum = 0;
        sum += Math.pow(getX() - coordinate.getX(), 2.0);
        sum += Math.pow(getY() - coordinate.getY(), 2.0);
        sum += Math.pow(getZ() - coordinate.getZ(), 2.0);
        return Math.sqrt(sum);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Coordinate) ? isEqual((Coordinate) obj) : false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
        return hash;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return getDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = getDistanceToOrigin();
        double theta = Math.acos(getZ() / radius);
        double phi = Math.atan(getY() / getX());
        return new SphericCoordinate(phi, theta, radius);
    }
    
    private double getDistanceToOrigin() {
        double sum = 0;
        sum += Math.pow(getX(), 2.0);
        sum += Math.pow(getY(), 2.0);
        sum += Math.pow(getZ(), 2.0);
        return Math.sqrt(sum);
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        return asSphericCoordinate().getCentralAngle(sphericCoordinate);
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        CartesianCoordinate comparison = coordinate.asCartesianCoordinate();
        return compareDoubles(getX(), comparison.getX())
                && compareDoubles(getY(), comparison.getY())
                && compareDoubles(getZ(), comparison.getZ());
    }

}
