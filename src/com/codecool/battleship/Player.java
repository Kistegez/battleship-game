package com.codecool.battleship;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private boolean alive;
    private List<Ship> shipList = new ArrayList<Ship>();

    public Player() {
        this.alive = true;
    }

    public void addShipToPlayer(Ship ship){
        this.shipList.add(ship);
    }

    public boolean checkAlive(){
        return alive;
    }

    public void changeAlive(){
        this.alive = false;
    }
}
