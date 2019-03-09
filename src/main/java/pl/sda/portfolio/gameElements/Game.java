package pl.sda.portfolio.gameElements;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {


    private ArrayList<Ship> listOfShips = new ArrayList<>();
    private Board board = new Board();


    public void prepareGame() {

        /**
         *Class of ship - Size - number of vessels
         * Battleship - 4sq - 1unit
         * Destroyer - 3sq - 2units
         * Submarine - 2sq - 3units
         * Patrol Boat - 1sq - 4units
         */
        
        Ship battleship = new Ship("Bettleship",4);
        Ship firstDestroyer = new Ship("Destroyer A",3);
        Ship secondDestroyer = new Ship("Destroyer B",3);
        Ship firstSubmarine = new Ship("Submarine A", 2);
        Ship secondSubmarine = new Ship("Submarine B", 2);
        Ship thirdSubmarine = new Ship("Submarine C", 2);
        Ship firstPatrolBoat = new Ship("Patrol Boat A", 1);
        Ship secondPatrolBoat = new Ship("Patrol Boat B", 1);
        Ship thirdPatrolBoat = new Ship("Patrol Boat C", 1);
        Ship fourthPatrolBoat = new Ship("Patrol Boat D", 1);

        listOfShips.add(battleship);
        listOfShips.add(firstDestroyer);
        listOfShips.add(secondDestroyer);
        listOfShips.add(firstSubmarine);
        listOfShips.add(secondSubmarine);
        listOfShips.add(thirdSubmarine);
        listOfShips.add(firstPatrolBoat);
        listOfShips.add(secondPatrolBoat);
        listOfShips.add(thirdPatrolBoat);
        listOfShips.add(fourthPatrolBoat);

        System.out.println("Your objective of the game is to destroy the opposing player's whole fleet");

        for (Ship createdShip: listOfShips){
            ArrayList<String> newPosition = board.addingShipToBoard(createdShip.getShipSize());
            createdShip.setFieldPosition(newPosition);
        }

    }

    public void startGame() {
        while (!listOfShips.isEmpty()) {
            String playersMove = null;
            System.out.print("Choose coordinates: ");
            System.out.println();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                playersMove = bufferedReader.readLine().toUpperCase();
                //TODO: reading movements from window appliccation
                //TODO: permitted data range a1-i10
            } catch (IOException e) {
                e.printStackTrace();
            }

            checkPlayersShot(playersMove);

        }

        endGame();
    }

    private void checkPlayersShot(String shot) {
        String result = "miss";

        for (Ship shipChecked : listOfShips) {
            result = shipChecked.check(shot);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("sunk")) {
                listOfShips.remove(shipChecked);
                break;
            }
        }

        System.out.println(result);
    }

    private void endGame(){
        System.out.println("Congratulation! You destroyed opponent's whole fleet.");
    }

}
