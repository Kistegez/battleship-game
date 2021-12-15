package com.codecool.battleship;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private final String name;
    private final List<Ship> shipList = new ArrayList<>();
    private Board board;
    private Display boardDisplay = new Display("board");

    public Player(String player) {
        this.name = player;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public void addShipToPlayer(Ship ship){
        this.shipList.add(ship);
    }

    public String getName(){
        return this.name;
    }

    public Board getBoard(){
        return this.board;
    }

    public boolean checkAlive(){
        for (Ship ship: shipList){
            for (Square square: ship.getLocations()){
                if (square.getStatus() == SquareStatus.SHIP){
                    return true;
                }
            }
        }
        return false;
    }

    public void shootingShip(Board enemyBoard) {
        boardDisplay.dispplayBoard(enemyBoard);
        ArrayList coordinates = getCoordinate();
        int row = (int) coordinates.get(0);
        int col = (int) coordinates.get(1);
        Square location = enemyBoard.getSquare(row, col);
        if (location.getStatus() == SquareStatus.SHIP){
            location.setStatus(SquareStatus.HIT);
            System.out.println("Congrats you HIT a ship");
        }else{
            location.setStatus(SquareStatus.MISSED);
            System.out.println("So sorry but you missed this shoot");
        }
    }
    public ArrayList getCoordinate(){
        Input shootingCoordinate = new Input();
        System.out.println("Choose a coordinate");
        return shootingCoordinate.coordinateInputs();
    }
}
