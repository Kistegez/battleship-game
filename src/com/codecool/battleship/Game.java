package com.codecool.battleship;

public class Game {
    String playerName = "player UNO";
    private final static ShipType [] ships = {ShipType.CRUISER, ShipType.DESTROYER, ShipType.SUBMARINE, ShipType.BATTLESHIP, ShipType.CARRIER};

    public Game(){
    }

    public void startGame (){
        for (int i = 0; i < 2; i++) {
            Player player = new Player(playerName);
            Board board = new Board(playerName);
            board.createBoard();
            System.out.println(board);
            for (ShipType oneShip : ships){
                Ship ship = new Ship(oneShip);
                player.addShipToPlayer(ship);
            }
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
