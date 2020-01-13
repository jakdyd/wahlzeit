package org.wahlzeit.model.beer;

import java.util.logging.Logger;
import org.wahlzeit.model.PhotoManager;
import org.wahlzeit.utils.PatternInstance;

@PatternInstance(
        name = "Singleton",
        participants = {
            "Singleton"
        }
)
public class BeerPhotoManager extends PhotoManager {
    
    protected static final PhotoManager instance = new BeerPhotoManager();

	private static final Logger log = Logger.getLogger(BeerPhotoManager.class.getName());
        
        public BeerPhotoManager() {
		photoTagCollector = BeerPhotoFactory.getInstance().createPhotoTagCollector();
	}
        
    
}
