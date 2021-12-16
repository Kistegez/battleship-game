package com.codecool.battleship.player;

import com.codecool.battleship.ClearBoard;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;
import com.codecool.battleship.util.Input;

import java.util.ArrayList;

public class HumanPlayer extends Player{


    public HumanPlayer(String player) {
        super(player);
    }

    @Override
    public void getPlacingCoordinate(ShipType oneShip, Ship ship, Board board, Player player) {
        String direction;
        int row;
        int col;
        do {
            Input playerInput = new Input();
            ArrayList coordinates = playerInput.coordinateInputs(board);
            row = (int) coordinates.get(0);
            col = (int) coordinates.get(1);
            direction = playerInput.askForUser("What direction do you want to place it: \n [v] vertical \n [h] horizontal");
            if (!(board.isPlacementOk(oneShip.getShipSize(), direction, row, col))) {
                System.out.println("Bad choice, you can not place ship there.\n Try again!");
            }
        }while (!(board.isPlacementOk(oneShip.getShipSize(), direction, row, col)));
        boardFactory.createShipLocations(direction, oneShip.getShipSize(), row, col, ship, board, player);
    }


    @Override
    public void shootingShip(Board enemyBoard, Player currentPlayer) {
        boardDisplay.displayBoard(enemyBoard,"shooting");
        ArrayList coordinates = getShootCoordinate(currentPlayer, enemyBoard);
        int row = (int) coordinates.get(0);
        int col = (int) coordinates.get(1);
        Square location = enemyBoard.getSquare(row, col);
        if (location.getStatus() == SquareStatus.SHIP){
            location.setStatus(SquareStatus.HIT);
            ClearBoard.clearConsole();
            System.out.println("Vincent... We happy?! YES WE HAPPY");
            boardDisplay.displayBoard(enemyBoard,"shooting");
            boardDisplay.wait(3000);

        }else{
            location.setStatus(SquareStatus.MISSED);
            ClearBoard.clearConsole();
            System.out.println("Vincent... We happy?!  NOPE, NOT THIS TIME ");
            boardDisplay.displayBoard(enemyBoard,"shooting");
            boardDisplay.wait(3000);

        }
    }
    public ArrayList getShootCoordinate(Player currentPlayer, Board board){
        Input shootingCoordinate = new Input();
        System.out.println(currentPlayer.getName() + " Let's do some BANG BANG");
        return shootingCoordinate.coordinateInputs(board);
    }
}

