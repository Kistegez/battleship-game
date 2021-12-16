package com.codecool.battleship;

public class ClearBoard {

    public final static void clearConsole()
    {
            System.out.println("\033[H\033[2J");
            System.out.flush();
        }
    }
