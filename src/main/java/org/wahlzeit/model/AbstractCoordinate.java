package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

    final static double THRESHOLD = .0001;

    protected boolean compareDoubles(double x, double y) {
        return Math.abs(x - y) < THRESHOLD;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate thisCoordinate = asCartesianCoordinate();
        CartesianCoordinate otherCoordiante = coordinate.asCartesianCoordinate();
        double sum = 0;
        sum += Math.pow(thisCoordinate.getX() - otherCoordiante.getX(), 2.0);
        sum += Math.pow(thisCoordinate.getY() - otherCoordiante.getY(), 2.0);
        sum += Math.pow(thisCoordinate.getZ() - otherCoordiante.getZ(), 2.0);
        return Math.sqrt(sum);
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate thisCoordinate = asSphericCoordinate();
        SphericCoordinate otherCoordiante = coordinate.asSphericCoordinate();
        double theta1 = Math.PI / 2 - thisCoordinate.getTheta();
        double theta2 = Math.PI / 2 - otherCoordiante.getTheta();
        double deltaPhi = Math.abs(thisCoordinate.getPhi() - otherCoordiante.getPhi());
        double angle = Math.acos(Math.sin(theta1) * Math.sin(theta2)
                + Math.cos(theta1) * Math.cos(theta2) * Math.cos(deltaPhi));
        return angle;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if (coordinate != null) {
            CartesianCoordinate comparison = coordinate.asCartesianCoordinate();
            return compareDoubles(asCartesianCoordinate().getX(), comparison.getX())
                    && compareDoubles(asCartesianCoordinate().getY(), comparison.getY())
                    && compareDoubles(asCartesianCoordinate().getZ(), comparison.getZ());
        }
        return false;
    }
    
}
