package com.nick.salsasalestracker;

import java.util.Scanner;

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
        if (this.sold < that.sold) {
            return -1;
        } else if (this.sold > that.sold) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Salsa[] salsas = {
                new Salsa("mild"), new Salsa("medium"), new Salsa("sweet"),
                new Salsa("hot"), new Salsa("zesty")
        };

        for (Salsa salsa : salsas) {
            System.out.print("Enter jars of " + salsa.getName() + ": ");
            short salsaCount = input.nextShort();
            salsa.setSold(salsaCount);
        }

        System.out.printf("\n\n%-15s%10s\n", "Salsa", "Sold");

        short totalSales = 0;
        Salsa bestSelling = salsas[0];
        for (Salsa salsa : salsas) {
            short currentSales = salsa.getSold();

            System.out.printf("%-15s%7d\n", salsa.getName(), currentSales);

            totalSales += currentSales;

            if (salsa.compareTo(bestSelling) > 0) {
                bestSelling = salsa;
            }
        }

        System.out.println();
        System.out.println("Total sales: " + totalSales + ".");
        System.out.println("Best selling salsa: " + bestSelling.getName() + ".");
    }
}
