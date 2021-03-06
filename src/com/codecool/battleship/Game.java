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
        this.player1 = new HumanPlayer("Marsellus Wallace ");
        this.player2 = (mode.equals("PvsP")) ? new HumanPlayer("Vincent Vega") : new ComputerPlayer("Lil' AI");
        this.currentPlayer = player2;
        this.enemyPlayer = player1;
    }

    public void gameFlow() {
        createBoard();
        placeShips();
        do {
            changePlayer();
            shootingPhase();
        } while (enemyPlayer.checkAlive());
        printTheWinner();


    }

    private void changePlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
        enemyPlayer = (enemyPlayer == player2) ? player1 : player2;
    }

    private void createBoard() {
        ClearBoard.clearConsole();
        boolean input = false;
        do {
            Input playerInput = new Input();
            String askForBoardSize = playerInput.askForUser("How big board do you want to play on? (10 - 26)");
            try {
                int boardSize = Integer.parseInt(askForBoardSize);
                for (int i = 0; i < 2; i++) {
                    if (boardSize < 27 && boardSize > 9) {
                        Board board = new Board(boardSize);
                        currentPlayer.setBoard(board);
                        changePlayer();
                        input = true;
                    } else {
                        System.out.print("Invalid board size." + "\n");
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        } while (input == false);
    }


    private void placeShips() {
        for (int i = 0; i < 2; i++) {
            BoardFactory boardFactory = new BoardFactory();
            boardFactory.placeShips(currentPlayer, new ComputerPlayer("randomPicker"));
            changePlayer();
        }
        ClearBoard.clearConsole();
    }

    private void shootingPhase(){

        currentPlayer.shootingShip(enemyPlayer.getBoard(), currentPlayer, enemyPlayer);
    }

    private void printTheWinner() {
        ClearBoard.clearConsole();
        System.out.println(currentPlayer.getName() + "you lucky bastard! \n YOU WON THIS GAME!");
    }

}
