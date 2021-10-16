package org.example.views;

import org.example.model.Field;

public class PlayerFieldView extends FieldView {
    public PlayerFieldView(Field field) {
        super(field);
    }

    @Override
    protected String showCell(int row, int col) {
        if (field.getCell(row, col).getShip() != null) return "#";
        if (field.getCell(row, col).isShot()) return "/";
        else return " ";
    }
}
