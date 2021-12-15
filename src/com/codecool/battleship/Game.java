package com.codecool.battleship;

public class Game {
    Player player1;
    Player player2;
    Player currentPlayer;
    Player enemyPlayer;


    public Game() {
        this.player1 = new Player("player UNO");
        this.player2 = new Player("player DOS");
        this.currentPlayer = player1;
        this.enemyPlayer = player2;
    }

    public void gameFlow() {
        createBoard();
        placeShips();
        /*Boolean exit = false;
        Boolean newGame = false;*/
        do {


        } while (enemyPlayer.checkAlive() /*&& exit == false && newGame == false*/);
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
            boardFactory.placeShips(currentPlayer);
            changePlayer();
        }
    }
}
