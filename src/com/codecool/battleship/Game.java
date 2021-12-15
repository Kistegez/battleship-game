package com.codecool.battleship;

public class Game {
    Player player1;
    Player player2;


    public Game(){
        this.player1 = new Player("player UNO");
        this.player2 = new Player("player DOS");
    }

    public void gameFlow(){
        Player currentPlayer = this.player1;
        Player enemyPlayer = this.player2;
        Boolean exit = false;
        Boolean newGame = false;

        do{

        } while (enemyPlayer.checkAlive() && exit == false && newGame == false);
    }
}
