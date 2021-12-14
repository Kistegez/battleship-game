package com.codecool.battleship;

import java.util.SplittableRandom;

public class Display {

    private String displayType;
    private String[][] board;
    int n;
    private boolean gamed = false;

    public Display (String displayType){
        this.displayType = displayType;
    }

    public Display (String displayType, String[][] board){
        this.displayType = displayType;
        this.board = board;
    }

    public Display(String displayType, Boolean gamed){
        this.gamed = gamed;
        this.displayType = displayType;
    }


    public void displayMenu(){
        if (displayType.equalsIgnoreCase("menu")){
            System.out.println("|----------------------|");
            System.out.println("| BATTLESHIP GAME MENU |");
            System.out.println("|----------------------|");

            if (this.gamed){
                System.out.println(" [1] Try again");
            }
            else {
                System.out.println(" [1] Start game  ");
            }
            System.out.println(" [2] High scores ");
            System.out.println(" [3] Exit");
        }
    }

    public void dispplayBoard(){
        if (displayType.equalsIgnoreCase("board")){
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (board[9][3].equalsIgnoreCase("empty")){

                    }
                }
            }

        }
    }

}
