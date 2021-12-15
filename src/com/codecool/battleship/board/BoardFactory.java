package com.codecool.battleship.board;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.player.Ship;
import com.codecool.battleship.player.ShipType;
import com.codecool.battleship.util.Display;
import com.codecool.battleship.util.Input;

import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;

public class BoardFactory {
    private static final Input playerInput = new Input();
    private static final Random pickRandom = new Random();
    private Display boardDisplay = new Display("board");
    private Player player;
    private Board board;

    public BoardFactory() {
    }

    public void placeShips(Player player) {
        this.player = player;
        this.board = player.getBoard();
        boardDisplay.dispplayBoard(board);
        for (ShipType oneShip : ShipType.values()) {
            Ship ship = new Ship(oneShip);
            String placementType = playerInput.askForUser("Where do you want to place your " + oneShip + " ships:\n [1] Manually \n [2] Randomly");
            if (placementType.equals("1")) {
                placeShipManually(oneShip, ship);
            } else if (placementType.equals("2")) {
                placeShipRandomly(oneShip, ship);
            }
            boardDisplay.dispplayBoard(board);
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
            if (shipDirection.equals("h")){
                row = pickRandom.nextInt(board.getBoard().length);
                col = pickRandom.nextInt(board.getBoard().length - oneShip.getShipSize());
            }else {
                row = pickRandom.nextInt(board.getBoard().length - oneShip.getShipSize());
                col = pickRandom.nextInt(board.getBoard().length);
            }
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
                Square location = board.getSquare(row, col+i);
                location.setStatus(SquareStatus.SHIP);
                ship.setterShip(location);

            }
            else if (Objects.equals(direction, "v")) {
                Square location = board.getSquare(row+i, col);
                location.setStatus(SquareStatus.SHIP);
                ship.setterShip(location);
            }
        }
        player.addShipToPlayer(ship);
    }
}
