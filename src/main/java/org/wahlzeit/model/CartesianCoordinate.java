package org.wahlzeit.model;

public final class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
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
    public SphericCoordinate asSphericCoordinate() {
        double radius = getDistanceToOrigin();
        if (radius == 0) {
            return new SphericCoordinate(0, 0, 0);
        }
        double theta = Math.acos(getZ() / radius);
        double phi = getX() == 0 ? Math.signum(getY()) * Math.PI / 2 : Math.atan(getY() / getX());
        return new SphericCoordinate(phi, theta, radius);
    }

    private double getDistanceToOrigin() {
        double sum = 0;
        sum += Math.pow(getX(), 2.0);
        sum += Math.pow(getY(), 2.0);
        sum += Math.pow(getZ(), 2.0);
        return Math.sqrt(sum);
    }

}
