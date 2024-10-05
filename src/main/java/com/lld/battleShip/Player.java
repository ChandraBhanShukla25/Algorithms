package com.lld.battleShip;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Ship> ships;

    public Player(String name){
        this.name = name;
        this.ships= new ArrayList<>();
    }

    public void addShip(Ship ship){
        ships.add(ship);
    }

    public String getName(){
        return name;
    }

    public List<Ship> getShips(){
        return ships;
    }
}
