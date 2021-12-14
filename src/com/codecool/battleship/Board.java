package com.codecool.battleship;

public class Board {
    Square[][] ocean;
    int boardSize = 10;

    public boolean isPlacementOk() {
        return true;
    }

    public void createBoard() {
        ocean = new Square[boardSize][boardSize];
        for (int row = 0; row < (boardSize+1) ; row++) {
            for (int col = 0; col < (boardSize+1); col++) {
                Square square = new Square(row,col,SquareStatus.EMPTY);
                ocean[row][col] = square;
            }
        }
    }
}
