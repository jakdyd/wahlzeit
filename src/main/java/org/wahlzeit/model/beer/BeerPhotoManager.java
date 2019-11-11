package org.wahlzeit.model.beer;

import java.util.logging.Logger;
import org.wahlzeit.model.PhotoManager;

public class BeerPhotoManager extends PhotoManager {
    
    protected static final PhotoManager instance = new BeerPhotoManager();

	private static final Logger log = Logger.getLogger(BeerPhotoManager.class.getName());
        
        public BeerPhotoManager() {
		photoTagCollector = BeerPhotoFactory.getInstance().createPhotoTagCollector();
	}
        
    
}
