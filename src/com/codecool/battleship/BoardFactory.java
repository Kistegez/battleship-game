package com.codecool.battleship;
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
                location = placeShipManually(oneShip);
            } else if (placementType.equals("2")) {
                location = placeShipRandomly(oneShip);
            }
            ship.setterShip(location);
            player.addShipToPlayer(ship);
            //display
        }
    }

    private Square placeShipRandomly(ShipType oneShip) {
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

    private Square placeShipManually(ShipType oneShip) {
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
