package com.nick.ships;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the name of a ship: ");
        String shipName = input.nextLine();

        System.out.print("Enter the construction year of the ship: ");
        short shipConstruction = input.nextShort();
        Ship ship = new Ship(shipName, shipConstruction);

        input.nextLine();
        System.out.print("Enter the name of a cruise ship: ");
        String cruiseShipName = input.nextLine();

        System.out.print("Enter the construction year of the ship: ");
        short constructionYear = input.nextShort();

        System.out.print("Enter the maximum passengers on the ship: ");
        short passengerCount = input.nextShort();

        CruiseShip cruiseShip = new CruiseShip(cruiseShipName, constructionYear, passengerCount);

        System.out.println(ship.toString() + "\n");
        System.out.println(cruiseShip.toString());
    }
}
