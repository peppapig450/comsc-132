package com.nick.salsasalestracker;

import java.util.Scanner;

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

        System.out.printf("\n%-15s%10s\n", "Salsa", "Sold");

        short totalSales = 0;
        Salsa bestSelling = salsas[0];
        for (Salsa salsa : salsas) {
            short currentSales = salsa.getSold();

            // "Sold" ends at column 25 when printed with %10s (S starts at 22).
            // To align numbers under the 'S' (column 22), use %7d (10 - 3 = 7).
            System.out.printf("%-15s%7d\n", salsa.toString(), currentSales);

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
