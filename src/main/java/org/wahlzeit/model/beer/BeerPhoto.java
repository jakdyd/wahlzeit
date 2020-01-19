package org.wahlzeit.model.beer;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class BeerPhoto extends Photo {
    
    private Beer beer;
    
    public BeerPhoto() {
        id = PhotoId.getNextId();
        incWriteCount();
    }

    public BeerPhoto(PhotoId myId) {
        id = myId;
        incWriteCount();
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }
}
