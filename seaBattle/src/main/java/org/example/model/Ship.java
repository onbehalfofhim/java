package org.example.model;

public class Ship {
    private int amountDeck;
    private Rectangle rectangle;

    public Ship(String coordinate, int amountDeck, ShipDirection shipDirection) throws InvalidDataException {
        this(Point.fromString(coordinate), amountDeck, shipDirection);
    }

    public Ship(Point topLeft, int amountDeck, ShipDirection shipDirection) throws InvalidDataException {
        setAmountDeck(amountDeck);
        int height = 1, width = 1;
        if (shipDirection == ShipDirection.HORIZONTAL) {
            width = amountDeck;
        } else {
            height = amountDeck;
        }
        setRectangle(topLeft, height, width);
    }

    public int getAmountDeck() {
        return amountDeck;
    }

    public void setAmountDeck(int amountDesc) throws InvalidDataException {
        if (amountDesc > 4 || amountDesc < 0) {
            throw new InvalidDataException("Invalid deck's value");
        }
        this.amountDeck = amountDesc;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(String coordinate, int height, int width) throws InvalidDataException {
        Point p = Point.fromString(coordinate);
        setRectangle(p, height, width);
    }

    public void setRectangle(Point topLeft, int height, int width) throws InvalidDataException {
        this.rectangle = new Rectangle(topLeft.getX(), topLeft.getY(), height, width);
    }

    public boolean canAddShip(Ship other) {
        try {
            return this.getRectangle().expand().checkCrossing(other.getRectangle());
        } catch (InvalidDataException ide) {
            return false;
        }
    }
}
