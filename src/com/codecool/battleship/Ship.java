package com.codecool.battleship;
import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Square> locations = new ArrayList<Square>();
    private final ShipType type;

    public Ship(ShipType type) {
        this.type = type;
    }

    public void setterShip(Suaqre locations) {
        this.locations.add(locations);
    }
}
