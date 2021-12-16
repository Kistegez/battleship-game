package com.codecool.battleship.board;

import com.codecool.battleship.player.*;
import com.codecool.battleship.util.*;
import java.util.Objects;
import java.util.Random;

public class BoardFactory {
    private static final Input playerInput = new Input();
    private static final Random pickRandom = new Random();
    private Player player;
    private Board board;

    public BoardFactory() {
    }

    public void placeShips(Player player) {
        this.player = player;
        Display display = new Display("board");
        this.board = player.getBoard();
        display.dispplayBoard(board);
        for (ShipType oneShip : ShipType.values()) {
            Ship ship = new Ship(oneShip);
            if (player.getName().equals("Lil' AI")){
                player.chooseShipCoordinate(oneShip, ship, board, player);
            }else{
                String placementType = playerInput.askForUser("Where do you want to place your " + oneShip + " ships:\n [1] Manually \n [2] Randomly");
                if (placementType.equals("1")) {
                    player.chooseShipCoordinate(oneShip, ship, board, player);
                } else if (placementType.equals("2")) {
                    placeShipRandomly(oneShip, ship);
                }
            }
            display.dispplayBoard(board);
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
        createShipLocations(shipDirection, oneShip.getShipSize(), row, col, ship, board, player);
    }


    public void createShipLocations(String direction, int shipSize, int row, int col, Ship ship, Board board, Player player) {
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
