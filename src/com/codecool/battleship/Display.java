package com.codecool.battleship;

public class Display {

    private String displayType;

    public Display (String displayType){
        this.displayType = displayType;
    }

    public void displayMenu(){
        if (displayType.equalsIgnoreCase(displayType)){
            System.out.println("|-----------|");
            System.out.println("| GAME MENU |");
            System.out.println("|-----------|");
            System.out.println(" [1] Start game  ");
            System.out.println(" [2] High scores ");
            System.out.println(" [3] Exit");
        }


    }

}
