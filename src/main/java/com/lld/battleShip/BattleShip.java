package com.lld.battleShip;

import java.util.Arrays;

public class BattleShip {

    private int N;
    private char[][] battleField;
    private Player playerA;
    private Player playerB;
    private boolean gameStarted;

    public BattleShip(){
        this.gameStarted = false;
    }

    public void initGame(int N){
        this.N=N;
        this.battleField = new char[N][N];
        for(char[] row: battleField){
            Arrays.fill(row,'.');
        }
        int half = N/2;
        playerA = new Player("Player A");
        playerB = new Player("Player B");
        gameStarted = false;
    }

    public Player getPlayerA(){
        return playerA;
    }

    public  Player getPlayerB(){
        return playerB;
    }
}
