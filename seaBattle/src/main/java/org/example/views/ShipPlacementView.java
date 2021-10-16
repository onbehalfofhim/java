package org.example.views;


import org.example.events.Event;
import org.example.model.*;

import java.util.Arrays;
import java.util.Scanner;

public class ShipPlacementView {
    private final Field field;
    private FieldView fieldView;
    private final Scanner input = new Scanner(System.in);

    public final Event generateRandomSelected = new Event();
    public final Event startGameSelected = new Event();

    public ShipPlacementView (Field field) {
        this.field = field;
        fieldView = new PlayerFieldView(field);
    }

    public void showMenu() {
        // 1. генерация рандомом (показать поле после генерации)
        // 2. генерация ручечками (показать поле на каждой итерации)
        // 3. начать игру (не дать начать игру, если не расставлены корабли)

        System.out.print("\n1. Генерация рандомом \n" +
                "2. Генерация ручечками \n" +
                "3. Начать игру \n" +
                ">");
        int menuItem = input.nextInt();
        input.nextLine();

        //добавить цикл
        switch (menuItem) {
            case 1 :
                generateRandomSelected.trigger();
                //fieldView = new PlayerFieldView(field);
                //fieldView.show();
                //оппонент всегда рандом или руками тоже?
                break;
            case 2:
                fillManually();
                //fieldView = new PlayerFieldView(field);
                //fieldView.show();
                break;
            case 3:
                if(field.isEmpty()){
                    System.out.println("Вы не заполнили игровое поле");
                    showMenu();
                } else {
                    startGameSelected.trigger();
                }
                break;
        }
    }

    public void fillManually() {
        field.clear();
        int[] amountDecks = {4, 3, 2, 1};
        while (Arrays.stream(amountDecks).allMatch(x -> x == 0)) {
            System.out.println("Введите корабль в формате: Координата(A7) Кол-во_палуб Направление(H/V):");
            String ans = input.nextLine();
            String[] answer = ans.split(" ");
            ShipDirection shipDirection = answer[2].equals("H") ? ShipDirection.HORIZONTAL : ShipDirection.VERTICAL;
            int amountDeck = Integer.parseInt(answer[1]);
            try {
                if (amountDecks[amountDeck - 1] > 0) {
                    field.addShip(new Ship(answer[0], amountDeck, shipDirection));
                    --amountDecks[amountDeck - 1];
                } else {
                    System.out.println("Таких корабликов уже достаточно");
                }
            } catch (InvalidDataException | InvalidShipPlacementException exception) {
                System.out.println("Что-то не так с данными, чувак");
            }
        }
    }

    //Добавить метод "показать поле"
}
