package org.wahlzeit.model.beer;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class BeerPhoto extends Photo {
    
    private BeerCategory beerCategory;
    
    public BeerPhoto() {
        id = PhotoId.getNextId();
        incWriteCount();
    }

    public BeerPhoto(PhotoId myId) {
        id = myId;
        incWriteCount();
    }

    public BeerCategory getBeerCategory() {
        return beerCategory;
    }

    public void setBeerCategory(BeerCategory beerCategory) {
        this.beerCategory = beerCategory;
    }
    
}
