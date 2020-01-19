package org.wahlzeit.model.beer;

public class Beer {
    
    protected BeerType beerType;

    public Beer() {
    }

    public Beer(BeerType beerType) {
        this.beerType = beerType;
    }
    
    public BeerType getBeerType() {
        return beerType;
    }

    public void setBeerType(BeerType beerType) {
        this.beerType = beerType;
    }
    
}
