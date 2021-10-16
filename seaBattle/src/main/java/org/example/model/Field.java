package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private final Cell[][] field = new Cell[10][10];
    private final List<Ship> ships = new ArrayList<>();

    public Field() {
        for (int i = 0; i < 10; ++i){
            for (int j = 0; j < 10; ++j) {
                field[i][j] = new Cell(null);
            }
        }
    }

    public void addShip(Ship ship) throws InvalidShipPlacementException {
        for (var shippic : ships) {
            if (!shippic.canAddShip(ship)) throw new InvalidShipPlacementException("Invalid ship placement");
        }
        ships.add(ship);
        Rectangle rectangle = ship.getRectangle();
        Point topLeft = rectangle.getTopLeft();
        for (int i = 0; i < rectangle.getHeight(); ++i) {
            for (int j = 0; j < rectangle.getWidth(); ++j) {
                field[topLeft.getY() + i][topLeft.getX() + j] = new Cell(ship);
            }
        }
    }

    public void clear() {
        ships.clear();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                field[i][j].clear();
                field[i][j].setShip(null);
            }
        }
    }

    public void fillRandom() {
        clear();
        for (int i = 1; i <= 4; ++i) {
            for (int j = 1; j <= i; ++j) {
                while (true) {
                    Point topLeft = Point.createRandom();
                    ShipDirection shipDirection = ShipDirection.createRandom();
                    int amountDeck = 5 - i;
                    try {
                        Ship ship = new Ship(topLeft, amountDeck, shipDirection);
                        addShip(ship);
                        break;
                    } catch (InvalidDataException | InvalidShipPlacementException ex) {
                    }
                }
            }
        }
    }

    public boolean isEmpty() {
        return ships.isEmpty();
    }

    public Cell getCell(int row, int col) {
        return field[row][col];
    }

}
