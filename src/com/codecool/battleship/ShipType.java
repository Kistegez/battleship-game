package com.codecool.battleship;

public enum ShipType {
    CRUISER(2),
    SUBMARINE(3),
    DESTROYER(3),
    BATTLESHIP(4),
    CARRIER(5);
    private int shipSize;

    private ShipType(int size) {
        shipSize = size;
    }

    public int getShipSize(){
        return shipSize;
    }
}
