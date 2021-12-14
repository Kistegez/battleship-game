package com.codecool.battleship;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private boolean alive;
    private List<Ship> shipList = new ArrayList<>();

    public Player() {
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
