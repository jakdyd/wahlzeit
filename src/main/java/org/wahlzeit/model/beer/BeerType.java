package org.wahlzeit.model.beer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BeerType {

    private final String name;
    protected BeerType superType;
    protected Set<BeerType> subTypes = new HashSet<>();

    public BeerType(String name) {
        this.name = name;
    }

    public boolean hasInstance(Beer beer) {
        if (beer != null) {
            if (beer.getBeerType() == this) {
                return true;
            }
            return subTypes.stream().anyMatch(type -> type.hasInstance(beer));
        }
        return false;
    }

    public Beer createInstance() {
        return new Beer(this);
    }

    public String getName() {
        return name;
    }

    public BeerType getSuperType() {
        return superType;
    }

    public void setSuperType(BeerType beerType) {
        if (isSubType(beerType)) {
            throw new BeerTypeHierarchyException("Assigned supertype is already subtype! Type: " + beerType.getName());
        } else {
            this.superType = beerType;
            beerType.addSubType(this);
        }
    }

    public Set<BeerType> getSubTypes() {
        return subTypes;
    }

    public Iterator<BeerType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(BeerType beerType) {
        if (beerType != null) {
            if (isSuperType(beerType)) {
                throw new BeerTypeHierarchyException("Assigned subtype is already supertype! Type: " + beerType.getName());
            } else {
                if (beerType.getSuperType() != null) {
                    beerType.getSuperType().removeSubType(beerType);
                }
                beerType.setSuperType(this);
                subTypes.add(beerType);
            }
        }
    }

    private void removeSubType(BeerType beerType) {
        Iterator<BeerType> it = getSubTypeIterator();
        while (it.hasNext()) {
            BeerType type = it.next();
            if (type.equals(beerType)) {
                it.remove();
            }
        }
    }

    public boolean isSubType(BeerType beerType) {
        if (subTypes.contains(beerType)) {
            return true;
        }
        return subTypes.stream().anyMatch(type -> type.isSubType(beerType));
    }

    public boolean isSuperType(BeerType beerType) {
        if (superType == beerType) {
            return true;
        }
        if (superType != null) {
            return superType.isSuperType(beerType);
        }
        return false;
    }

}
