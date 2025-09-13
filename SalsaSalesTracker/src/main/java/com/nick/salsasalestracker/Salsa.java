package com.nick.salsasalestracker;

class Salsa {
    private String name;
    private short sold;

    public Salsa() {
        this.name = "";
        this.sold = 0;
    }

    public Salsa(String name) {
        this.name = name;
        this.sold = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSold(short sold) {
        if (sold > 0) {
            this.sold = sold;
        }
    }

    public String getName() {
        return this.name;
    }

    public short getSold() {
        return this.sold;
    }

    public String toString() {
        return this.name;
    }

    public short compareTo(Salsa that) {
        return (short) (this.sold < that.sold ? -1 : this.sold > that.sold ? 1 : 0);
    }
}
