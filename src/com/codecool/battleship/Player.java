package com.codecool.battleship;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private final String name;
    private boolean alive;
    private List<Ship> shipList = new ArrayList<>();
    private Board board;

    public Player(String player) {
        this.name = player;
        this.alive = true;
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
        return alive;
    }

    public void playerLost(){
        this.alive = false;
    }
}
