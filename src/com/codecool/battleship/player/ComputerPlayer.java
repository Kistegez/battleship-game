package com.codecool.battleship.player;

import com.codecool.battleship.ClearBoard;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player{
    private static final Random pickRandom = new Random();

    public ComputerPlayer(String player) {
        super(player);
    }

    @Override
    public void getPlacingCoordinate(ShipType oneShip, Ship ship, Board board, Player player) {
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
    public void shootingShip(Board enemyBoard, Player currentPlayer, Player enemyPlayer) {
        boardDisplay.displayBoard(enemyBoard,"shooting");
        int row = pickRandom.nextInt(enemyBoard.boardSize);
        int col = pickRandom.nextInt(enemyBoard.boardSize);
        Square location = enemyBoard.getSquare(row, col);
        if (location.getStatus() == SquareStatus.SHIP){
            location.setStatus(SquareStatus.HIT);
            ClearBoard.clearConsole();
            System.out.println("BIATCH Lil' AI HIT your ship");
            boardDisplay.displayBoard(enemyBoard,"shooting");
            boardDisplay.wait(3000);
            ClearBoard.clearConsole();
        }else{
            location.setStatus(SquareStatus.MISSED);
            ClearBoard.clearConsole();
            System.out.println("Lil' AI MISSED your ship this time");
            boardDisplay.displayBoard(enemyBoard,"shooting");
            boardDisplay.wait(3000);
            ClearBoard.clearConsole();
        }
    }

}
