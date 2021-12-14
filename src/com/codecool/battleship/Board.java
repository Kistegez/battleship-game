package com.codecool.battleship;

import java.util.Objects;

public class Board {
    Square[][] board;
    int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new Square[boardSize][boardSize];
        for (int row = 0; row < (boardSize) ; row++) {
            for (int col = 0; col < (boardSize); col++) {
                Square square = new Square(row,col,SquareStatus.EMPTY);
                board[row][col] = square;
            }
        }
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

    public boolean validateVertical(int ship, int row, int col) {
        if((row + ship) > boardSize) {
            return false;
        }
        else {
            for (int i = 0; i < ship; i++) {
                if (boardSize-1 > col +(i+1) && board[row+i][col+1].getStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                else if (boardSize-1 > row+i && board[row+i][col].getStatus() != SquareStatus.EMPTY ) {
                    return false;
                }
                else if (boardSize-1 > row+1 && board[row+1][col].getStatus() != SquareStatus.EMPTY ) {
                    return false;
                }
                else if (col-i > 0 && board[row+i][col-1].getStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                else if (row-1 > 0 && board[row-1][col].getStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                return true;

            }

        }

        return false;
    }

    public boolean validateHorizontal(int ship, int row, int col) {
        if((col + ship) > boardSize) {
            return false;
        }
        else {
            for (int i = 0; i < ship; i++) {
                if (board[row][col+i].getStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                else if (boardSize-1 > row && board[row+1][col+i].getStatus() != SquareStatus.EMPTY ) {
                    return false;
                }
                else if (boardSize-1 > col+i+1 && board[row][col+(i+1)].getStatus() != SquareStatus.EMPTY ) {
                    return false;
                }
                else if (row-1 >= 0 && board[row-1][col+i].getStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                else if (col-i > 0 && board[row][col-1].getStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                return true;

            }

        }
        return false;
    }
}
