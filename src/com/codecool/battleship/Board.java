package com.codecool.battleship;

public class Board {
    Square[][] ocean;
    int boardSize = 10;
    String owner;

    public Board(String owner) {
        this.owner = owner;
    }

    public boolean isPlacementOk() {
        return true;
    }

    public void createBoard() {
        ocean = new Square[boardSize][boardSize];
        for (int row = 0; row < (boardSize) ; row++) {
            for (int col = 0; col < (boardSize); col++) {
                Square square = new Square(row,col,SquareStatus.EMPTY);
                ocean[row][col] = square;
            }
        }
    }
}
