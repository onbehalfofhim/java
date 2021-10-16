package org.example.model;

import java.util.Random;

public enum ShipDirection {
    HORIZONTAL,
    VERTICAL;

    private static final Random random = new Random();

    static ShipDirection createRandom(){
        return random.nextInt(1 - 0 + 1) + 0 == 1 ? HORIZONTAL : VERTICAL;
    }
}
