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
                    System.out.println("One of us is not a stripper.\n One of us is a lyin' b*tch \n who's f***in' Montello, and now she's f***in' all of us!");
                    game = new Game("PvsP");
                    game.gameFlow();
                    break;
                case 2: //Player vs AI.
                    playedGame = true;
                    System.out.println("Prepare to meet your maker - maybe he'll know who the F*** you are!");
                    game = new Game("AI");
                    game.gameFlow();
                    break;
                case 3: //Exit.
                    System.out.println("I just crapped myself!");
                    isRunning = false;
                    break;
            }
        }
        while(isRunning);
    }
}
