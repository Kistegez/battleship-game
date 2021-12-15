package com.codecool.battleship;
import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;

public class BoardFactory {
    private final Board board;
    private final Player player;
    private static final Input playerInput = new Input();
    private static final Random pickRandom = new Random();
    private Display boardDisplay = new Display("board");


    public BoardFactory(Player player) {
        String askForBoardSize = playerInput.askForUser("How big board do you want to play on?");
        int boardSize = Integer.parseInt(askForBoardSize);
        board = new Board(boardSize);
        this.player = player;
        player.setBoard(board);
        Display printBoard = new Display("board");
        printBoard.dispplayBoard(board);
        placeShips();
    }

    private void placeShips() {
        for (ShipType oneShip : ShipType.values()) {
            Ship ship = new Ship(oneShip);
            Square location = null;
            String placementType = playerInput.askForUser("Where do you want to place your " + oneShip + " ships:\n [1] Manually \n [2] Randomly");
            if (placementType.equals("1")) {
                placeShipManually(oneShip, ship);
            } else if (placementType.equals("2")) {
                placeShipRandomly(oneShip, ship);
            }
        }
    }

    private void placeShipRandomly(ShipType oneShip, Ship ship) {
        int getShipDirection;
        String shipDirection;
        int row;
        int col;
        do {
            getShipDirection = pickRandom.nextInt(2);
            shipDirection = (getShipDirection == 1) ? "h" : "v";
            row = pickRandom.nextInt(board.getBoard().length - oneShip.getShipSize());
            col = pickRandom.nextInt(board.getBoard().length - oneShip.getShipSize());
        }while (!(board.isPlacementOk(oneShip.getShipSize(), shipDirection, row, col)));
        createShipLocations(shipDirection, oneShip.getShipSize(), row, col, ship);
    }

    private void placeShipManually(ShipType oneShip, Ship ship) {
        String direction;
        int row;
        int col;
        do {
            ArrayList coordinates = playerInput.coordinateInputs();
            row = (int) coordinates.get(0);
            col = (int) coordinates.get(1);
            direction = playerInput.askForUser("What direction do you want to place it: \n [v] vertical \n [h] horizontal");
            if (!(board.isPlacementOk(oneShip.getShipSize(), direction, row, col))) {
                System.out.println("Bad choice, you can not place ship there.\n Try again!");
            }
        }while (!(board.isPlacementOk(oneShip.getShipSize(), direction, row, col)));
        createShipLocations(direction, oneShip.getShipSize(), row, col, ship);
        }

    private void createShipLocations(String direction, int shipSize, int row, int col, Ship ship) {
        for (int i = 0; i < shipSize; i++ ) {
            if (Objects.equals(direction, "h")) {
                Square location = new Square(row+i, col, SquareStatus.SHIP);
                ship.setterShip(location);
            }
            else if (Objects.equals(direction, "v")) {
                Square location = new Square(row, col+i, SquareStatus.SHIP);
                ship.setterShip(location);
            }
        }
        player.addShipToPlayer(ship);
    }
}
