package ch.heigvd.amt.services;

import ch.heigvd.amt.model.Fruit;

/**
 * Created by Henrik on 28.09.2016.
 */
//Service
public class FruitManager {
    public Fruit getRandomFruit() {
        return new Fruit("banane", "yellow");
    }
}
