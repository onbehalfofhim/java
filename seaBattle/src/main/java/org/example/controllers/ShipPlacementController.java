package org.example.controllers;

import org.example.Game;
import org.example.model.Field;
import org.example.views.ShipPlacementView;

public class ShipPlacementController implements Controller {
    private final Game game;
    private final ShipPlacementView shipPlacementView;
    private final Field field;

    public ShipPlacementController(Game game) {
        this.game = game;
        field = game.getPlayerField();
        shipPlacementView = new ShipPlacementView(field);
        shipPlacementView.generateRandomSelected.subscribe(this::generateRandom);
        shipPlacementView.startGameSelected.subscribe(this::startGame);
    }

    public void generateRandom() {
        field.fillRandom();
    }

    public void startGame() {
        game.setController(new GameController());
    }

    @Override
    public void start() {
        shipPlacementView.showMenu();
    }
}
