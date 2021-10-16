package org.example.views;

import org.example.model.Field;

public class OpponentFieldView extends FieldView {

    public OpponentFieldView(Field field) {
        super(field);
    }

    @Override
    protected String showCell(int row, int col) {
        //Так, а где проверять, что корабль мертв?
        if (field.getCell(row, col).getShip() != null && field.getCell(row, col).isShot()) return "/";
        if (field.getCell(row, col).getShip() == null && field.getCell(row, col).isShot()) return "*";
        else return " ";
    }
}
