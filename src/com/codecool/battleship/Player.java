package com.codecool.battleship;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private final String name;
    private List<Ship> shipList = new ArrayList<>();
    private Board board;

    public Player(String player) {
        this.name = player;
        BoardFactory boardFactory = new BoardFactory(this);
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
                if (square.getStatus() == SquareStatus.EMPTY){
                    return true;
                }
            }
        }
        return false;
    }

}
