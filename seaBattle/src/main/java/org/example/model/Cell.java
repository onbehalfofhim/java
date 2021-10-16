package org.example.model;

public class Cell {
    private Ship ship;
    private boolean shot;

    public Cell(Ship ship) {
        setShip(ship);
        shot = false;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean isShot() {
        return shot;
    }

    public void shoot() {
        shot = true;
    }

    public void clear() {
        shot = false;
    }
}
