package com.codecool.battleship;

public enum SquareStatus {
    EMPTY("\uD83C\uDf0A"),
    SHIP("\uD83D\uDEA3"),
    HIT("\uD83D\uDCA5"),
    MISSED("\uD83D\uDcA6");
    private String status;


    SquareStatus(String type) {
        status = type;
    }

    public String getCharacter() {
        return status;
    }
}
