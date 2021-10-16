package org.example.views;

import org.example.model.Field;

public abstract class FieldView {
    private static final String[] letters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    protected Field field;

    public FieldView (Field field) {
        this.field = field;
    }

    public void show() {
        // выводит поле на экран
        String[][] draw_field = new String[22][22];

        for (int i = 0; i < 22; ++i) {
            for( int j = 0; j < 22; ++j) {
                draw_field[i][j] = " ";
            }
        }

        for (int i = 1; i < 22; ++i) {
            if(i % 2 == 0) draw_field[i][0] = Integer.toString(i);
            else draw_field[i][0] = "__";
        }

        for (int j = 1; j < 22; ++j) {
            if (j % 2 == 0) draw_field[0][j] = letters[j/2-1];
            else draw_field[0][j] = "|";
        }

        for (int i = 1; i < 22; ++i) {
            for (int j = 1; j < 22; ++j) {
                if (i % 2 != 0 && j % 2 != 0) draw_field[i][j] = "+";
                else if (i % 2 != 0 && j % 2 == 0) draw_field[i][j] = "-";
                else if (i % 2 == 0 && j % 2 != 0) draw_field[i][j] = "|";
                else draw_field[i][j] = showCell(i,j);
            }
        }

        for(int i = 0; i < 22; ++i) {
            for (int j = 0; j < 22; ++j) {
                System.out.print(draw_field[i][j]);
            }
            System.out.println();
        }
    }

    protected abstract String showCell(int row, int col);

}
