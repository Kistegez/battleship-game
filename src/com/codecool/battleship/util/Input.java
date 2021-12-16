package com.codecool.battleship.util;
import com.codecool.battleship.board.Board;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

public class Input {

    private String menuChoosingNumber;
    private Scanner inputScan = new Scanner(System.in);

    public Input (String inputType){
        this.menuChoosingNumber = inputType;
    }

    public Input(){
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


    public ArrayList coordinateInputs(Board board){
        ArrayList<Integer> coordinateList = new ArrayList<>();
        ArrayList<Character> abc = new ArrayList<>();

        char c;
        for(c = 'A'; c <= 'Z'; ++c) {
            abc.add(c);
        }

        boolean coordinateValidate = false;

        do{
            String errorMessage = "";
            try {
                String coordinate = this.validateCoordinateInput();

                char firstCoordinate = coordinate.charAt(0);
                int secoundCoordinate = coordinate.charAt(1);
                int y = secoundCoordinate - 48;
                if(coordinate.length() == 2 || coordinate.length() == 3){
                    if (coordinate.length() == 3){
                        try{
                            char tenDigitsNumberSecoundHalf = coordinate.charAt(2);
                            String number2 = String.valueOf(tenDigitsNumberSecoundHalf);
                            Integer.parseInt(number2);
                            String secoundCoordinate2 = (secoundCoordinate - 48) + String.valueOf(tenDigitsNumberSecoundHalf - 48);
                            y = Integer.parseInt(secoundCoordinate2);
                        }
                        catch (Exception e){
                            errorMessage = "Invalid input, try again!(1)";
                        }
                    }
                    int x = -1;
                    try{
                        for (Character listLetter : abc) {
                            x++;
                            if (Character.toString(listLetter).equalsIgnoreCase(Character.toString(firstCoordinate)) && board.boardSize >= x && board.boardSize >= y){

                                coordinateList.add(x);
                                coordinateList.add(y - 1);
                                coordinateValidate = true;
                                return coordinateList;
                            }
                            else {
                                errorMessage = "Invalid input (2)";
                            }
                        }
                    }
                    catch (Exception e){
                        System.out.println("Invalid input, try again!(3)");
                    }
                }
            } catch (Error e){
                System.out.println("Invalid input (5)");
            }
            System.out.println(errorMessage);
        }while (coordinateValidate == false);

        return coordinateList;
    }

    public String askForUser(String question){
        System.out.println(question);
        return inputScan.nextLine();
    }

    public String validateCoordinateInput(){
        boolean validation = false;
        do{
            String coordinate = this.askForUser("Coordinate input (A1 format):");
            if (coordinate.length() < 4 && coordinate.length() > 1){
                validation = true;
                return coordinate;
            }
            else {
                System.out.println("Invalid coordinate length!");
            }
        }while(validation == false);
        return null;
    }
}



