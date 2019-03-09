package pl.sda.portfolio;

import pl.sda.portfolio.gameElements.Game;
import pl.sda.portfolio.gameElements.Ship;

public class AppBootstrapper {

        static void start(){

            Game game = new Game();

            game.prepareGame();
            game.startGame();


        }



}
