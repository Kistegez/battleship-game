package com.codecool.battleship.player;

import com.codecool.battleship.board.*;
import com.codecool.battleship.util.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Player {
    private final String name;
    private final List<Ship> shipList = new ArrayList<>();
    private Board board;
    public BoardFactory boardFactory = new BoardFactory();
    public Display boardDisplay = new Display("board");

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

    public void cheatMode() {
        for (Ship ship : shipList) {
            for (int i = 0; i < ship.getLocations().size(); i++) {
                if (i < 4) {
                    Square square = ship.getLocations().get(i);
                    square.setStatus(SquareStatus.HIT);
                } else {
                    Square square = ship.getLocations().get(i);
                    int row = square.getXCoordinate() + 1;
                    int col = square.getYCoordinate() + 1;
                    System.out.println("row: " + row + "col: " + col );
                }
            }
        }
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

    public abstract void getPlacingCoordinate(ShipType size, Ship ship, Board board, Player player);

    public abstract void shootingShip(Board enemyBoard, Player currentPlayer, Player enemyPlayer);
}
