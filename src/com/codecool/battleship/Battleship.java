package com.codecool.battleship;

import com.codecool.battleship.util.*;

public class Battleship {
    public static void main(String[] args) {
        boolean isRunning = true;
        Display menu = new Display("menu");
        Display gamed = new Display("menu", true);
        Game game;
        boolean playedGame = false;



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
                case 1: //Player vs. Player.
                    playedGame = true;
                    System.out.println("Let's see who is better!");
                    game = new Game("PvsP");
                    game.gameFlow();
                    break;
                case 2: //Player vs AI.
                    playedGame = true;
                    System.out.println("Good luck");
                    game = new Game("AI");
                    game.gameFlow();
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
