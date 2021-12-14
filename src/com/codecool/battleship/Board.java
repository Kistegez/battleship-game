package com.codecool.battleship;

public class Board {
    Square[][] ocean;

    public Board(int boardSize) {
        ocean = new Square[boardSize][boardSize];
        for (int row = 0; row < (boardSize) ; row++) {
            for (int col = 0; col < (boardSize); col++) {
                Square square = new Square(row,col,SquareStatus.EMPTY);
                ocean[row][col] = square;
            }
        }
    }

    public boolean isPlacementOk() {
        return true;
    }

}
