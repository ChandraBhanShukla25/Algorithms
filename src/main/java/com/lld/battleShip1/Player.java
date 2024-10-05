package com.lld.battleShip1;

public class Player {
    private String name;
    public Battlefield battlefield;

    public Player(String name, int battlefieldSize) {
        this.name = name;
        this.battlefield = new Battlefield(battlefieldSize);
    }

    public boolean addShip(String id, Ship ship, int x, int y) {
        return battlefield.addShip(id, ship, x, y);
    }

    public boolean fireMissile(Player opponent, int x, int y) {
        return opponent.battlefield.hit(x, y);
    }

    public boolean hasLost() {
        return !battlefield.hasShipsLeft();
    }

    public void viewBattleField() {
        battlefield.display();
    }

    public String getName() {
        return name;
    }
}
