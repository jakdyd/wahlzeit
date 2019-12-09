package org.wahlzeit.model.beer;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

public class BeerPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(BeerPhotoFactory.class.getName());

    private static BeerPhotoFactory instance = null;

    private BeerPhotoFactory() {
    }

    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new BeerPhotoFactory());
        }
        return instance;
    }

    private static synchronized void setInstance(BeerPhotoFactory photoFactory) {
        instance = photoFactory;
    }

    @Override
    public Photo createPhoto() {
        return new BeerPhoto();
    }

    @Override
    public Photo createPhoto(PhotoId id) {
        return new BeerPhoto(id);
    }

}
