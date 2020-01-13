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
public final class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;

    private static final Map<Integer, CartesianCoordinate> cache = new HashMap<>();

    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public synchronized static CartesianCoordinate create(double x, double y, double z) {
        int hash = calculateHashCode(x, y, z);
        CartesianCoordinate cached = cache.get(hash);
        if (cached != null) {
            return cached;
        }
        CartesianCoordinate created = new CartesianCoordinate(x, y, z);
        cache.put(hash, created);
        return created;
    }

    private static int calculateHashCode(double x, double y, double z) {
        int hash = 7;
        hash = 17 * hash + (int) (Double.doubleToLongBits(x) ^ (Double.doubleToLongBits(x) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(y) ^ (Double.doubleToLongBits(y) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(z) ^ (Double.doubleToLongBits(z) >>> 32));
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
            return SphericCoordinate.create(0, 0, 0);
        }
        double theta = Math.acos(getZ() / radius);
        double phi = getX() == 0 ? Math.signum(getY()) * Math.PI / 2 : Math.atan(getY() / getX());
        return SphericCoordinate.create(phi, theta, radius);
    }

    private double getDistanceToOrigin() {
        double sum = 0;
        sum += Math.pow(getX(), 2.0);
        sum += Math.pow(getY(), 2.0);
        sum += Math.pow(getZ(), 2.0);
        return Math.sqrt(sum);
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
        return calculateHashCode(x, y, z);
    }
}
