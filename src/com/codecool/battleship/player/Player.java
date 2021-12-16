package com.codecool.battleship.player;

import com.codecool.battleship.board.*;
import com.codecool.battleship.util.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Player {
    private final String name;
    private final List<Ship> shipList = new ArrayList<>();
    private Board board;
    BoardFactory boardFactory = new BoardFactory();

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

    public abstract void chooseShipCoordinate(ShipType size, Ship ship, Board board, Player player);

    public abstract void shootingShip(Board enemyBoard);
}
