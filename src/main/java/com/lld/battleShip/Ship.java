package com.lld.battleShip;

import java.util.HashSet;
import java.util.Set;

public class Ship {

    private int size;
    private String name;
    private int x;
    private int y;
    private Set<String> cordinates;

    public Ship(String name, int size, int x, int y){
        this.name = name;
        this.size = size;
        this.x=x;
        this.y=y;
        this.cordinates = new HashSet<>();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                cordinates.add((x+i) + ","+ (y+j));
            }
        }
    }

    public Set<String> getCordinates(){
        return cordinates;
    }

    public String getName(){
        return name;
    }
}
