package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.player.ComputerPlayer;
import com.codecool.battleship.player.HumanPlayer;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.util.Input;

public class Game {
    Player player1;
    Player player2;
    Player currentPlayer;
    Player enemyPlayer;


    public Game(String mode) {
        this.player1 = new HumanPlayer("player UNO");
        this.player2 = (mode.equals("PvsP")) ? new HumanPlayer("player DOS") : new ComputerPlayer("Lil' AI");
        this.currentPlayer = player1;
        this.enemyPlayer = player2;
    }

    public void gameFlow() {
        createBoard();
        placeShips();
        //Boolean exit = false;
        do {
            shootingPhase();
            changePlayer();
        } while (enemyPlayer.checkAlive() /*&& exit == false*/);
    }




    private void changePlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        enemyPlayer = (enemyPlayer == player2) ? player1 : player2;
    }

    private void createBoard() {
        Input playerInput = new Input();
        String askForBoardSize = playerInput.askForUser("How big board do you want to play on?");
        int boardSize = Integer.parseInt(askForBoardSize);
        for (int i = 0; i < 2; i++) {
            Board board = new Board(boardSize);
            currentPlayer.setBoard(board);
            changePlayer();
        }
    }

    private void placeShips() {
        for (int i = 0; i < 2; i++) {
            BoardFactory boardFactory = new BoardFactory();
            boardFactory.placeShips(currentPlayer, new ComputerPlayer("randomPicker"));
            changePlayer();
        }
    }

    private void shootingPhase(){
        currentPlayer.shootingShip(enemyPlayer.getBoard(), currentPlayer);
    }

}
