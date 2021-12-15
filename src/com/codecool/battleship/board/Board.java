package com.codecool.battleship.board;

import java.util.Objects;

public class Board {
    Square[][] board;
    public int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new Square[boardSize][boardSize];
        for (int row = 0; row < (boardSize) ; row++) {
            for (int col = 0; col < (boardSize); col++) {
                Square square = new Square(row,col, SquareStatus.EMPTY);
                board[row][col] = square;
            }
        }
    }

    public Board(){

    }

    public Square [][] getBoard(){
        return board;
    }


    public Square getSquare(int row, int col){
        return board[row][col];
    }

    public boolean isPlacementOk(int ship, String direction, int row, int col) {
        if (Objects.equals(direction, "h")) {
            return validateHorizontal(ship,row,col);
        }
        else if (Objects.equals(direction, "v")) {
            return validateVertical(ship, row, col);
        }
        return false;
    }

    public boolean validateVertical(int shipSize, int row, int col) {
        if((row + shipSize) > boardSize) {
            return false;
        }
        else {
            for (int i = 0; i < shipSize; i++) {

                if (board[row+i][col].getStatus() != SquareStatus.EMPTY ) { //saját magát, ahova kerülni fog
                    return false;
                }
                if (boardSize > col +1) {
                    if (board[row + i][col + 1].getStatus() != SquareStatus.EMPTY){ // jobb oldalát hacsak nem az utolsó oszlopba kerülne
                        return false;
                    }
                }
                if (col-1 >= 0) {
                    if (board[row + i][col - 1].getStatus() != SquareStatus.EMPTY) { // bal oldalát hacsak nem az első oszlopba kerülne
                        return false;
                    }
                }
                if (boardSize > row+i+1){
                    if (board[row+i+1][col].getStatus() != SquareStatus.EMPTY){ // az alját, hacsak nem az utolsó sorba végződik
                        return false;
                    }
                }

                if (row-1 >= 0){
                    if(board[row-1][col].getStatus() != SquareStatus.EMPTY){ // tetejét, hacsak nem az első sorban kezdődne
                        return false;
                    }
                }

            }
            return true;
        }
    }

    public boolean validateHorizontal(int ship, int row, int col) {
        if((col + ship) > boardSize) {
            return false;
        }
        else {
            for (int i = 0; i < ship; i++) {

                if (board[row][col+i].getStatus() != SquareStatus.EMPTY ) { //saját magát, ahova kerülni fog
                    return false;
                }

                if (boardSize > row + 1) {
                    if (board[row + 1][col + i].getStatus() != SquareStatus.EMPTY){ // alját hacsak nem a legalsó sorba kerülne
                        return false;
                    }
                }

                if (row-1 >= 0) {
                    if (board[row - 1][col + i].getStatus() != SquareStatus.EMPTY) { // tetejét, hacsak nem a legfelső sorba kerülne
                        return false;
                    }
                }

                if (boardSize > col+i+1){
                    if (board[row][col+i+1].getStatus() != SquareStatus.EMPTY){ // legjobboldalát, hacsak nem az utolsó oszlopban végződik
                        return false;
                    }
                }

                if (col-1 >= 0) {
                    if (board[row][col-1].getStatus() != SquareStatus.EMPTY) { // tetejét, hacsak nem az első oszlopban kezdődne
                        return false;
                    }
                }

            }
            return true;
        }
    }
}
