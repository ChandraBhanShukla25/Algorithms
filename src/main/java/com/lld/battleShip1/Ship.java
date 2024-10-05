package com.lld.battleShip1;

public class Ship {
    private String id;
    private int size;

    public Ship(String id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getId() {
        return id;
    }
}
