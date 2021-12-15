package com.codecool.battleship;
import java.util.Random;
import java.util.ArrayList;

public class BoardFactory {
    private static final Input playerInput = new Input();
    private static final Random pickRandom = new Random();
    private Display boardDisplay = new Display("board");


    public BoardFactory() {
    }

    public void placeShips(Player player) {
        for (ShipType oneShip : ShipType.values()) {
            Ship ship = new Ship(oneShip);
            Square location = null;
            String placementType = playerInput.askForUser("Where do you want to place your " + oneShip + " ships:\n [1] Manually \n [2] Randomly");
            if (placementType.equals("1")) {
                location = placeShipManually(oneShip, player.getBoard());
            } else if (placementType.equals("2")) {
                location = placeShipRandomly(oneShip, player.getBoard());
            }
            ship.setterShip(location);
            player.addShipToPlayer(ship);

        }
    }

    private Square placeShipRandomly(ShipType oneShip, Board board) {
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
        return new Square(row, col, SquareStatus.SHIP);
    }

    private Square placeShipManually(ShipType oneShip, Board board) {
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
        return new Square(row, col, SquareStatus.SHIP);
        }

    }
