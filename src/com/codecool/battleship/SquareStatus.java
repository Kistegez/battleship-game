package com.codecool.battleship;

public enum SquareStatus {
    EMPTY('O'),
    SHIP('S'),
    HIT('H'),
    MISSED('M');
    private char status;


    SquareStatus(char type) {
        status = type;
    }

    public char getCharacter() {
        return status;
    }
}
