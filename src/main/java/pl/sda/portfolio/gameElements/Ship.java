package pl.sda.portfolio.gameElements;

import java.util.ArrayList;

public class Ship {

    private ArrayList<String> fieldPosition;
    private String shipName;
    //TODO: size of ship


    public void setFieldPosition(ArrayList<String> fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String check(String shot){
        String result = "misfire";

        int index = fieldPosition.indexOf(shot);
        if (index>=0){
            fieldPosition.remove(index);

            if (fieldPosition.isEmpty()){
                result = "sunk";
                System.out.println(shipName + " has been sunk!");
            }else {
                result = "hit";
            }

        }

        return result;
    }
}
