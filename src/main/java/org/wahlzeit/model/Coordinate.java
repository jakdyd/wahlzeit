package org.wahlzeit.model;

public interface Coordinate {
    
    final double THRESHOLD = .0001;
    
    default boolean compareDoubles(double x, double y) {
        return Math.abs(x - y) < THRESHOLD;
    }
    
    public CartesianCoordinate asCartesianCoordinate();
    
    public double getCartesianDistance(Coordinate coordinate);
    
    public SphericCoordinate asSphericCoordinate();
    
    public double getCentralAngle(Coordinate coordinate);
    
    public boolean isEqual(Coordinate coordinate);
}
