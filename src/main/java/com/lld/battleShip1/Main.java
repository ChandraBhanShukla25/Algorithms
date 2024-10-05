package com.lld.battleShip1;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(10); // Battlefield size N = 10
        game.initGame(10);

        // Adding ships for both players
        game.addShip("SH1", 2, 1, 1, 6, 6);
        game.addShip("SH2", 3, 3, 3, 8, 8);

        // Display battlefield before starting the game
        game.viewBattleField();

        // Start the game
        game.startGame();
    }
}
