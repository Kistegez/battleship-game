package com.codecool.battleship;

public class Game {
    String playerName = "player UNO";

    public Game(){
    }

    public void startGame (){
        for (int i = 0; i < 2; i++) {
            Player player = new Player(playerName);
        }
    }

    public void shootingGame(){
        Boolean win = false;
        Boolean loose = false;
        Boolean exit = false;
        Boolean newGame = false;

        do{
            loose = true;
        } while (win == false && loose == false && exit == false && newGame == false);
    }
}
