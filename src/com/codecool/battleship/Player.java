package com.codecool.battleship;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private final String name;
    private boolean alive;
    private List<Ship> shipList = new ArrayList<>();

    public Player(String player) {
        this.name = player;
        this.alive = true;
    }

    public void addShipToPlayer(Ship ship){
        this.shipList.add(ship);
    }

    public boolean checkAlive(){
        return alive;
    }

    public void playerLost(){
        this.alive = false;
    }
}
