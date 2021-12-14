package com.codecool.battleship;

public class BoardFactory {
    private final Board board;
    private final Player player;
    private final int boardSize = 10;
    private final static ShipType [] ships = {ShipType.CRUISER, ShipType.DESTROYER, ShipType.SUBMARINE, ShipType.BATTLESHIP, ShipType.CARRIER};


    public BoardFactory(Player player) {
        board = new Board(boardSize);
        this.player = player;
        player.setBoard(board);
        placeShips();

    }

    private void placeShips() {
        for (ShipType oneShip : ships){
            Ship ship = new Ship(oneShip);

            ship.setterShip(location);
            player.addShipToPlayer(ship);
        }
    }
}
