package com.codecool.battleship.player;

import com.codecool.battleship.board.Board;
import java.util.Random;

public class ComputerPlayer extends Player{
    private static final Random pickRandom = new Random();

    public ComputerPlayer(String player) {
        super(player);
    }

    @Override
    public void chooseShipCoordinate(ShipType oneShip, Ship ship, Board board, Player player) {
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
        boardFactory.createShipLocations(shipDirection, oneShip.getShipSize(), row, col, ship, board, player);

    }

    @Override
    public void shootingShip(Board enemyBoard) {

    }


}
