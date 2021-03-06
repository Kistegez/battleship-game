package com.codecool.battleship.board;

import com.codecool.battleship.ClearBoard;
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

    public void placeShips(Player player, Player randomPicker) {
        this.player = player;
        Display display = new Display("board");
        this.board = player.getBoard();
        display.displayBoard(board, "place");
        for (ShipType oneShip : ShipType.values()) {
            Ship ship = new Ship(oneShip);
            if (player.getName().equals("Lil' AI")){
                player.getPlacingCoordinate(oneShip, ship, board, player);
            }else{
                boolean validation = false;
                do{
                    String placementType = playerInput.askForUser(player.getName() +"\n How do you want to place your " + oneShip + " ships:\n [1] Manually \n [2] Randomly");
                    if(placementType.equalsIgnoreCase("1") || placementType.equalsIgnoreCase("2")) {
                        validation = true;
                        if (placementType.equals("1")) {
                            player.getPlacingCoordinate(oneShip, ship, board, player);
                        } else if (placementType.equals("2")) {
                            randomPicker.getPlacingCoordinate(oneShip, ship, board, player);
                        }
                    }
                     else {
                        System.out.println("Invalid direction!");
                    }
                }while(validation == false);

            }
            ClearBoard.clearConsole();
            display.displayBoard(board,"place");
        }
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
