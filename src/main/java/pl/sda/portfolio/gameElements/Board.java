package pl.sda.portfolio.gameElements;

import java.util.ArrayList;

public class Board {

    private final String axisX = "ABCDEFGHJI";
    private int boardLength = 7;
    private int boardSize = 49;
    private int[] board = new int[boardSize];
    private int numberOfShips = 0;

    public ArrayList addingShipToBoard(int sizeOfShip) {

        ArrayList<String> occupiedFields = new ArrayList<>();

        //TODO: change name
//        String[] coordinatesLnc = new String[sizeOfShip];

        //TODO: change name
        String helper = null; // auxiliary character string

        int[] coordinates = new int[sizeOfShip];
        int attempt = 0;
        boolean success = false;
        int position = 0;

        numberOfShips++;
        int inkr = 1; //determining the increase in row/level
        if ((numberOfShips % 2) !=0) {
            inkr = boardLength;
        }

        /*check if position of ship is available*/

        while (!success & attempt++ < 200) {
            position = (int) (Math.random() * boardSize);
            int x = 0; // n-th segment of ship
            success = true;
            while (success && x < sizeOfShip) {
                if (board[position] == 0) {
                    coordinates[x++] = position;
                    position += inkr;
                    if (position >= boardSize) {
                        success = false;
                    }
                    if (x > 0 & (position % boardLength == 0)) {
                        success = false;
                    }

                    //TODO: ships cannot touch
                } else {
                    success = false;
                }
            }
        }

        /*changing to coordinates*/
        int x = 0;
        int column = 0;
        int row = 0;

        while (x < sizeOfShip){
            board[coordinates[x]] = 1;
            row = (int) (coordinates[x] / boardLength);
            column = coordinates[x] % boardLength;
            helper = String.valueOf(axisX.charAt(column));
            occupiedFields.add(helper.concat(Integer.toString(row)));
            x++;
        }

        return occupiedFields;

    }

}
