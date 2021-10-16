package org.example.model;

public class Rectangle {
    private Point topLeft;
    private int height;
    private int width;

    public Rectangle(int x, int y, int height, int width) throws InvalidDataException {
        setTopLeft(x, y);
        setHeight(height);
        setWidth(width);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(int x, int y) throws InvalidDataException {
        this.topLeft = new Point(x, y);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws InvalidDataException {
        if (height < 1 || height > 4 || (topLeft.getY() + height <= 10)) {
            throw new InvalidDataException("Invalid height's value");
        }
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws InvalidDataException {
        if (width < 1 || width > 4 || (topLeft.getX() + width <= 10)) {
            throw new InvalidDataException("Invalid width's value");
        }
        this.width = width;
    }

    public boolean checkCrossing(Rectangle other){
        if(this.getTopLeft().getY() + this.getHeight()< other.getTopLeft().getY()
            || this.getTopLeft().getY() > other.getTopLeft().getY() + other.getHeight()){
            return false;
        }

        if(this.getTopLeft().getX() + this.getWidth() < other.getTopLeft().getX()
            || this.getTopLeft().getX() > other.getTopLeft().getX() + other.getWidth()){
            return false;
        }
        return true;
    }

    public Rectangle expand() throws InvalidDataException {
        if(topLeft.getX() == 0) {
            if(topLeft.getY() == 0) {
                return this;
            } else {
                return new Rectangle(topLeft.getX(), topLeft.getY() - 1, this.getHeight()+1,
                        this.getWidth());
            }
        } else if (topLeft.getY() == 0) {
            return new Rectangle(topLeft.getX() - 1, topLeft.getY(), this.getHeight(),
                    this.getWidth() + 1);
        } else {
            return new Rectangle(topLeft.getX() - 1, topLeft.getY() - 1, this.getHeight() + 1,
                    this.getWidth() + 1);
        }
    }

    public static void main(String[] args) throws InvalidDataException {
        Rectangle rec1 = new Rectangle(1,1, 2, 1);
        Rectangle rec2 = new Rectangle(0,4, 1, 4);
        System.out.println(rec1.checkCrossing(rec2)); //false

        Rectangle rec3 = new Rectangle(3,0, 3,1);
        System.out.println(rec1.checkCrossing(rec3)); //false

        Rectangle rec4 = new Rectangle(1,5, 1,1);
        Rectangle rec5 = new Rectangle(9,5, 3,1);
        System.out.println(rec2.checkCrossing(rec4)); //true
        System.out.println(rec2.checkCrossing(rec5)); //true

        Rectangle rec1_1 = rec1.expand();
        System.out.println(rec1_1.getTopLeft().getX() + ", " + rec1_1.getTopLeft().getY() + "; " +
                rec1_1.getHeight() + ", " + rec1_1.getWidth()); //0, 0; 3, 2
        Rectangle rec2_1 = rec2.expand();
        System.out.println(rec2_1.getTopLeft().getX() + ", " + rec2_1.getTopLeft().getY() + "; " +
                rec2_1.getHeight() + ", " + rec2_1.getWidth()); //0, 3; 2, 4
        Rectangle rec3_1 = rec3.expand();
        System.out.println(rec3_1.getTopLeft().getX() + ", " + rec3_1.getTopLeft().getY() + "; " +
                rec3_1.getHeight() + ", " + rec3_1.getWidth()); //2, 0; 3, 2
        Rectangle rec4_1 = rec4.expand();
        System.out.println(rec4_1.getTopLeft().getX() + ", " + rec4_1.getTopLeft().getY() + "; " +
                rec4_1.getHeight() + ", " + rec4_1.getWidth()); //0, 4; 2, 2

    }
}
