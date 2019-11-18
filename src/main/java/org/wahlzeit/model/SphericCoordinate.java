package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

    private double phi;
    private double theta;
    private double radius;

    public SphericCoordinate() {
    }

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return cartesianCoordinate.getDistance(asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate comparison = coordinate.asSphericCoordinate();
        if (compareDoubles(getRadius(), coordinate.asSphericCoordinate().getRadius())) {
            double theta1 = Math.PI / 2 - getTheta();
            double theta2 = Math.PI / 2 - comparison.getTheta();
            double deltaPhi = Math.abs(getPhi() - comparison.getPhi());
            double angle = Math.acos(Math.sin(theta1) * Math.sin(theta2)
                    + Math.cos(theta1) * Math.cos(theta2) * Math.cos(deltaPhi));
            return angle;
        } else {
            throw new RuntimeException("The coordinates do not the same radius, therefore no central angle can be determined!");
        }
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        SphericCoordinate comparison = coordinate.asSphericCoordinate();
        return compareDoubles(getPhi(), comparison.getPhi())
                && compareDoubles(getTheta(), comparison.getTheta())
                && compareDoubles(getRadius(), comparison.getRadius());
    }

}
