package org.wahlzeit.model.beer;

import java.util.ArrayList;
import java.util.List;

public class Beer {
    
    private BeerType beerType;
    private final List<BeerPhoto> photos = new ArrayList<>();

    public Beer() {
    }

    public Beer(BeerType beerType) {
        this.beerType = beerType;
    }
    
    public void addPhoto(BeerPhoto photo) {
        photos.add(photo);
    }
    
    public BeerType getBeerType() {
        return beerType;
    }

    public void setBeerType(BeerType beerType) {
        this.beerType = beerType;
    }

    public List<BeerPhoto> getPhotos() {
        return photos;
    }
}
