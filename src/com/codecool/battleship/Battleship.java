package com.codecool.battleship;
import java.util.Scanner;
public class Battleship {
    public static void main(String[] args) {
        boolean isRunning = true;
        Display menu = new Display("menu");

        do{
            int option = 0;
            menu.displayMenu();
            Input inputMenu = new Input("menu");
            option += inputMenu.menuPointChoosing();

            switch (option){
                case 1: //Start game.
                    System.out.println("Go go gooo!!!");
                    break;
                case 2: //Display high scores.
                    System.out.println("12314223 point");
                    break;
                case 3: //Exit.
                    System.out.println("Good by!");
                    isRunning = false;
                    break;
            }
        }
        while(isRunning);
    }
}
