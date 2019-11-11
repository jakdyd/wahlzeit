package org.wahlzeit.model.beer;

import java.util.logging.Logger;
import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

public class BeerPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(BeerPhotoFactory.class.getName());

    private static BeerPhotoFactory instance = null;

    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new BeerPhotoFactory());
        }
        return instance;
    }

    protected static synchronized void setInstance(BeerPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize PhotoFactory twice");
        }
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
