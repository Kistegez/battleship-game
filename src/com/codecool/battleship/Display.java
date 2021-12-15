package com.codecool.battleship;

import java.lang.reflect.Array;
import java.util.SplittableRandom;

public class Display {

    private String displayType;
    private boolean gamed = false;
    private Board board;
    public Display (String displayType){
        this.displayType = displayType;
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


    public void dispplayBoard(Board board){

        for (int i = 0; i < board.boardSize; i++) {
            for (int j = 0; j < board.boardSize; j++) {
                System.out.print("\t");
                System.out.print(board.getSquare(i, j).getStatus().getCharacter());
            }
            System.out.println("\n");
        }




        }

}
