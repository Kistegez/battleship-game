package com.codecool.battleship.player;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;
import com.codecool.battleship.util.Display;
import com.codecool.battleship.util.Input;

import java.util.ArrayList;

public class HumanPlayer extends Player{
    private Display boardDisplay = new Display("board");

    public HumanPlayer(String player) {
        super(player);
    }

    @Override
    public void chooseShipCoordinate(ShipType oneShip, Ship ship, Board board, Player player) {
        String direction;
        int row;
        int col;
        do {
            Input playerInput = new Input();
            ArrayList coordinates = playerInput.coordinateInputs();
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
    public void shootingShip(Board enemyBoard) {
        boardDisplay.dispplayBoard(enemyBoard);
        ArrayList coordinates = getCoordinate();
        int row = (int) coordinates.get(0);
        int col = (int) coordinates.get(1);
        Square location = enemyBoard.getSquare(row, col);
        if (location.getStatus() == SquareStatus.SHIP){
            location.setStatus(SquareStatus.HIT);
            System.out.println("Congrats you HIT a ship");
        }else{
            location.setStatus(SquareStatus.MISSED);
            System.out.println("So sorry but you missed this shoot");
        }
    }
    public ArrayList getCoordinate(){
        Input shootingCoordinate = new Input();
        System.out.println("Choose a coordinate");
        return shootingCoordinate.coordinateInputs();
    }
}

