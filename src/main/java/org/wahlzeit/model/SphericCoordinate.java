package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        name = "Value Object",
        participants = {
            "Value Object"
        }
)
public final class SphericCoordinate extends AbstractCoordinate {

    private final double phi;
    private final double theta;
    private final double radius;

    private static final Map<Integer, SphericCoordinate> cache = new HashMap<>();

    private SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    public synchronized static SphericCoordinate create(double phi, double theta, double radius) {
        int hash = calculateHashCode(phi, theta, radius);
        SphericCoordinate cached = cache.get(hash);
        if (cached != null) {
            return cached;
        }
        SphericCoordinate created = new SphericCoordinate(phi, theta, radius);
        cache.put(hash, created);
        return created;
    }

    private static int calculateHashCode(double phi, double theta, double radius) {
        int hash = 7;
        hash = 47 * hash + (int) (Double.doubleToLongBits(phi) ^ (Double.doubleToLongBits(phi) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(theta) ^ (Double.doubleToLongBits(theta) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(radius) ^ (Double.doubleToLongBits(radius) >>> 32));
        return hash;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        return CartesianCoordinate.create(x, y, z);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public int hashCode() {
        return calculateHashCode(phi, theta, radius);
    }

    public double getPhi() {
        return phi;
    }

    public double getTheta() {
        return theta;
    }

    public double getRadius() {
        return radius;
    }
}
