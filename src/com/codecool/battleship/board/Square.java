package com.codecool.battleship.board;

public class Square {

    private final int xCoordinate;
    private final int yCoordinate;
    private SquareStatus status;

    public Square(int x, int y, SquareStatus status) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.status = status;
    }

    public SquareStatus getStatus(){
        return this.status;
    }

    public void setStatus(SquareStatus status){
        this.status = status;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }


}
