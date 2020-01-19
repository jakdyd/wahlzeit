package org.wahlzeit.model.beer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class BeerManager {

    private final Map<BeerType, Set<Beer>> beerMap = new HashMap<>();

    public Beer createBeer(String typeName) {
        BeerType beerType = getBeerType(typeName);
        Beer beer = beerType.createInstance();
        beerMap.get(beerType).add(beer);
        return beer;
    }

    private BeerType getBeerType(String typeName) {
        Optional<BeerType> result = beerMap.keySet().stream().filter(type -> type.getName().equals(typeName)).findAny();
        if (result.isPresent()) {
            return result.get();
        } else {
            BeerType beerType = new BeerType(typeName);
            beerMap.put(beerType, Collections.EMPTY_SET);
            return beerType;
        }
    }
    
    public Map<BeerType, Set<Beer>> getBeerMap() {
        return beerMap;
    }
}
