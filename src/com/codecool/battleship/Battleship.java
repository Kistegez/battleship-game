
package com.codecool.battleship;
import java.util.Scanner;
public class Battleship {
    public static void main(String[] args) {
        boolean isRunning = true;
        Display menu = new Display("menu");
        Display gamed = new Display("menu", true);
        boolean playedGame = false;

        Input coordinate = new Input("menu");
        System.out.println(coordinate.coordinateInputs());


        do{
            int option = 0;

             if (playedGame == true){
                gamed.displayMenu();
            }
            else {
                menu.displayMenu();
            }

            Input inputMenu = new Input("menu");
            option += inputMenu.menuPointChoosing();

            switch (option){
                case 1: //Start game.
                    playedGame = true;
                    System.out.println("Go go gooo!!!");

                    Game game = new Game();
                    game.startGame();
                    game.shootingGame();
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
