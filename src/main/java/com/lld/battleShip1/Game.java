package com.lld.battleShip1;

import java.util.Random;

public class Game {
    private Player playerA;
    private Player playerB;
    private Random random;

    public Game(int size) {
        random = new Random();
        playerA = new Player("PlayerA", size);
        playerB = new Player("PlayerB", size);
    }

    public void initGame(int N) {
        System.out.println("Game initialized with battlefield size: " + N + "x" + N);
    }

    public void addShip(String id, int size, int xA, int yA, int xB, int yB) {
        Ship shipA = new Ship("A-" + id, size);
        Ship shipB = new Ship("B-" + id, size);

        if (playerA.addShip(shipA.getId(), shipA, xA, yA)) {
            System.out.println("Ship " + shipA.getId() + " placed for PlayerA at (" + xA + ", " + yA + ")");
        } else {
            System.out.println("Failed to place Ship " + shipA.getId() + " for PlayerA");
        }

        if (playerB.addShip(shipB.getId(), shipB, xB, yB)) {
            System.out.println("Ship " + shipB.getId() + " placed for PlayerB at (" + xB + ", " + yB + ")");
        } else {
            System.out.println("Failed to place Ship " + shipB.getId() + " for PlayerB");
        }
    }

    public void startGame() {
        System.out.println("Starting the game... PlayerA will fire first!");
        boolean gameOn = true;
        Player currentPlayer = playerA;
        Player opponent = playerB;

        while (gameOn) {
            int x = random.nextInt(currentPlayer.battlefield.size);
            int y = random.nextInt(currentPlayer.battlefield.size);

            System.out.println(currentPlayer.getName() + "'s turn: Missile fired at (" + x + ", " + y + ")");

            if (currentPlayer.fireMissile(opponent, x, y)) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }

            if (opponent.hasLost()) {
                System.out.println(opponent.getName() + " has lost! " + currentPlayer.getName() + " wins!");
                gameOn = false;
            }

            // Switch turns
            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }
    }

    public void viewBattleField() {
        System.out.println("Player A's Battlefield:");
        playerA.viewBattleField();
        System.out.println("Player B's Battlefield:");
        playerB.viewBattleField();
    }
}
