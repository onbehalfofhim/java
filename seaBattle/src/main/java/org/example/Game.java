package org.example;

import org.example.controllers.Controller;
import org.example.controllers.ShipPlacementController;
import org.example.model.Field;

public class Game {
    private final Field playerField = new Field();
    private final Field opponentField = new Field();
    private Controller currentController = new ShipPlacementController(this);

    public void setController(Controller controller) {
        currentController = controller;
        currentController.start();
    }

    public void start() {
        currentController.start();
    }

    public Field getPlayerField() {
        return playerField;
    }

    public Field getOpponentField() {
        return opponentField;
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
