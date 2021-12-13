package com.codecool.battleship;

public class Board {
    Square[][] ocean;
    int boardSize = 10;

    public boolean isPlacementOk() {
        return true;
    }

    public void createBoard() {
        ocean = new Square[n][n];
        for (int row = 0; row < (n+1) ; row++) {
            for (int col = 0; col < (n+1); col++) {
                Square square = new Square(row,col);
                ocean[row][col] = square;
            }
        }
    }
}
