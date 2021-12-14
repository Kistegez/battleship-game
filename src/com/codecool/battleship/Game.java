package com.codecool.battleship;

public class Game {
    String playerName = "player UNO";
    ShipType [] ships = {ShipType.valueOf("CRUISER"), ShipType.valueOf("DESTROYER"), ShipType.valueOf("SUBMARINE"), ShipType.valueOf("BATTLESHIP"), ShipType.valueOf("CARRIER")};

    public Game(){
    }

    public void startGame (){
        for (int i = 0; i < 2; i++) {
            Player player = new Player(playerName);
            Board board = new Board(playerName);
            board.createBoard();
            for (ShipType oneShip : ships){
                Ship ship = new Ship(oneShip);
                player.addShipToPlayer(ship);
            }
            System.out.println(board);

        }

    }

    public void shootingGame(){
        Boolean win = false;
        Boolean loose = false;
        Boolean exit = false;
        Boolean newGame = false;

        do{
        } while (win == false && loose == false && exit == false && newGame == false);
    }
}
