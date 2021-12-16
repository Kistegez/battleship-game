package com.codecool.battleship.util;

import com.codecool.battleship.ClearBoard;
import com.codecool.battleship.board.*;

import java.util.ArrayList;
import java.util.Objects;

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
                System.out.println(" [1] Player vs. Player  ");
            }
            System.out.println(" [2] Player vs. Lil' AI ");
            System.out.println(" [3] Exit");
        }
    }


    public void displayBoard(Board board, String mode){

        ArrayList<Character> abc = new ArrayList<>();
        char c;
        for(c = 'A'; c <= 'Z'; ++c) {
            abc.add(c);
        }
        System.out.println("\t");
        for (int i = 0; i < board.boardSize + 1; i++){
            if(i == 0){
                System.out.println(" ");
            }
            else {
                System.out.print(i);
            }
            System.out.print("\t");
        }
        System.out.println("\n");
        for (int i = 0; i < board.boardSize; i++) {
            System.out.print(abc.get(i));
            for (int j = 0; j < board.boardSize; j++) {
                if (Objects.equals(mode, "shooting")) {
                    String slot = board.getSquare(i, j).getStatus().getCharacter();
                    if (board.getSquare(i,j).getStatus() == SquareStatus.SHIP) {
                        System.out.print("\t");
                        System.out.print(SquareStatus.EMPTY.getCharacter());
                    }
                    else {
                        System.out.print("\t");
                        System.out.print(slot);
                    }
                }
                else {
                    String slot = board.getSquare(i, j).getStatus().getCharacter();
                    System.out.print("\t");
                    System.out.print(slot);
                }
            }

            System.out.println("\n");
        }
    }
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
