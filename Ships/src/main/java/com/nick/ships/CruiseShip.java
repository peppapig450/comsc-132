package com.nick.ships;

public class CruiseShip extends Ship {
    private short maxPassengers;

    CruiseShip(String n, short y, short m) {
        super(n, y);
        this.maxPassengers = m;
    }

    public void setMaxPassengers(short s) {
        this.maxPassengers = s;
    }

    public short getMaxPassengers() {
        return this.maxPassengers;
    }

    public String toString() {
        return "Ship Name: " + this.getName() + "\n" + "Max Passengers: " + this.maxPassengers + ".";
    }
}
