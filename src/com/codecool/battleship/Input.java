package com.codecool.battleship;
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


    public ArrayList coordinateInputs(){
        ArrayList<Integer> coordinateList = new ArrayList<>();
        ArrayList<Character> abc = new ArrayList<>();

        Scanner coordinateInput = new Scanner(System.in);
        System.out.println("Coordinate input (A1 format):");
        String coordinate = coordinateInput.nextLine();

        char firstCoordinate = coordinate.charAt(0);
        int secoundCoordinate = coordinate.charAt(1);
        int y = secoundCoordinate - 48;

        if (coordinate.length() == 3){
            try{
                char tenDigitsNumberSecoundHalf = coordinate.charAt(2);
                String number2 = String.valueOf(tenDigitsNumberSecoundHalf);
                Integer.parseInt(number2);
                String secoundCoordinate2 = secoundCoordinate - 48 + String.valueOf(tenDigitsNumberSecoundHalf - 48);
                y = Integer.parseInt(secoundCoordinate2);
            }
            catch (Exception e){
                System.out.println("Erreoroereeelooooll");
            }
        }
        else {
        }

        char c;
        for(c = 'A'; c <= 'Z'; ++c) {
            abc.add(c);
        }

        try{
            int i = 0;
            for (Character listLetter : abc) {
                i++;
                if (Character.toString(listLetter).equalsIgnoreCase(Character.toString(firstCoordinate)) ){
                    coordinateList.add(i);
                    coordinateList.add(y);

                    return coordinateList;
                }
                else {
                    System.out.println("INVALID!!");
                }
            }
        }
        catch (Exception e){

        }
        return  coordinateList;
    }

    public String askForUser(String question){
        System.out.println(question);
        return inputScan.nextLine();
    }

}

