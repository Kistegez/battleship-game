package com.codecool.battleship;

public class Square {

    private final int xCoordinate;
    private final int yCoordinate;
    private SquareStatus status;

    public Square(int x, int y, SquareStatus status) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.status = status;
    }



}
