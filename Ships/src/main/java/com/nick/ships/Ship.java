package com.nick.ships;

/**
 *
 * @author nick
 */
public class Ship {
    private String name;
    private short year;

    Ship(String n, short y) {
        this.name = n;
        this.year = y;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void setYear(Short y) {
        this.year = y;
    }

    public short getYear() {
        return this.year;
    }

    public String toString() {
        return "Ship name: " + this.name + "\n" + "Year Built: " + this.year + ".";
    }
}
