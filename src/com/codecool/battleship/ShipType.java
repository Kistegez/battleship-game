package com.codecool.battleship;

public enum ShipType {
    CARRIER(5),
    CRUISER(2),
    BATTLESHIP(4),
    SUBMARINE(3),
    DESTROYER(3);
    private int shipSize;

    private ShipType(int size) {
        shipSize = size;
    }

    public int getType(){
        return shipSize;
    }
}
