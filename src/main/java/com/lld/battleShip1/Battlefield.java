package com.lld.battleShip1;

import java.util.HashMap;
import java.util.Map;

public class Battlefield {
    public int size;
    private String[][] grid;
    private Map<String, Ship> ships;

    public Battlefield(int size) {
        this.size = size;
        this.grid = new String[size][size];
        this.ships = new HashMap<>();
    }

    public boolean addShip(String id, Ship ship, int x, int y) {
        if (isValidPosition(ship.getSize(), x, y)) {
            ships.put(id, ship);
            markShipOnGrid(id, ship, x, y);
            return true;
        }
        return false;
    }

    private void markShipOnGrid(String id, Ship ship, int x, int y) {
        for (int i = 0; i < ship.getSize(); i++) {
            for (int j = 0; j < ship.getSize(); j++) {
                grid[x + i][y + j] = id;
            }
        }
    }

    private boolean isValidPosition(int size, int x, int y) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (x + i >= this.size || y + j >= this.size || grid[x + i][y + j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hit(int x, int y) {
        if (grid[x][y] != null) {
            System.out.println("Hit on " + grid[x][y]);
            ships.remove(grid[x][y]);
            grid[x][y] = null;
            return true;
        }
        return false;
    }

    public boolean hasShipsLeft() {
        return !ships.isEmpty();
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
