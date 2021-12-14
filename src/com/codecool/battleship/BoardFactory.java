package com.codecool.battleship;

public class BoardFactory {
    private final Board board;
    private final Player player;
    private final int boardSize = 10;
    private Input playerInput = new Input();
    private Display boardDisplay = new Display("board");


    public BoardFactory(Player player) {
        board = new Board(boardSize);
        this.player = player;
        player.setBoard(board);
        placeShips();

    }

    private void placeShips() {
        for (ShipType oneShip : ShipType.values()) {
            Ship ship = new Ship(oneShip);
            Square location = null;
            String placementType = playerInput.askForUser("How do you want to place your " + oneShip + " ships:\n [1] Manually \n [2] Randomly");
            if (placementType.equals("1")) {
                location = placeShipManually(oneShip);
            } else if (placementType.equals("2")) {
                location = placeShipRandomly(oneShip);
            }
            ship.setterShip(location);
            player.addShipToPlayer(ship);
        }
    }

    private Square placeShipRandomly(ShipType oneShip) {

        board.isPlacementOk(oneShip.getShipSize(), direction, row, col);
        Square location = new Square(row, col, SquareStatus.SHIP);
        return location;
    }

    private Square placeShipManually(ShipType oneShip) {

        board.isPlacementOk(oneShip.getShipSize(), direction, row, col);
        Square location = new Square(row, col, SquareStatus.SHIP);
        return location;

    }
}
