package org.wahlzeit.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractCoordinate implements Coordinate {

    private static final Logger log = Logger.getLogger(AbstractCoordinate.class.getName());

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        assert coordinate != null;
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
        assert coordinate != null;
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
        try {
            CartesianCoordinate comparison = coordinate.asCartesianCoordinate();
            return compareDoubles(asCartesianCoordinate().getX(), comparison.getX())
                    && compareDoubles(asCartesianCoordinate().getY(), comparison.getY())
                    && compareDoubles(asCartesianCoordinate().getZ(), comparison.getZ());
        } catch (NullPointerException ex) {
            log.log(Level.WARNING, "Equality check with null returns 'false'", ex);
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return isEqual((Coordinate) obj);
        } catch (ClassCastException ex) {
            log.log(Level.WARNING, "Equality check with different object type returns 'false'", ex);
            return false;
        }
    }

}
