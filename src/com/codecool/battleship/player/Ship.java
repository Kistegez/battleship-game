package com.codecool.battleship.player;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Square> locations = new ArrayList<>();
    private final ShipType type;

    public Ship(ShipType type) {
        this.type = type;
    }

    public void setterShip(Square locations) {
        this.locations.add(locations);
        locations.setStatus(SquareStatus.SHIP);
    }

    public List<Square> getLocations() {
        return locations;
    }
}
