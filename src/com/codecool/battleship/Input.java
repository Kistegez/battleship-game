package com.codecool.battleship;

import java.util.Scanner;

public class Input {

    private String menuChoosingNumber;

    public Input (String inputType){
        this.menuChoosingNumber = inputType;
    }

    public int menuPointChoosing(){
        if (menuChoosingNumber.equalsIgnoreCase("menu")){
            Scanner battleshipObject = new Scanner(System.in);
            System.out.println("User input:");
            String userInput = battleshipObject.nextLine();
            try {
                int inputNumber = Integer.parseInt(userInput);
                return inputNumber;
            }
            catch(Exception e) {
                System.out.println("Error! Invalid input, try again!");
            }
        }
        return 0;
    }



}
