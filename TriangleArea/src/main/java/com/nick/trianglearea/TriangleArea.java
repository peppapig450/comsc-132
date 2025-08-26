/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nick.trianglearea;

import java.util.Scanner;

/**
 *
 * @author nick
 */
public class TriangleArea {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the base of the triangle: ");
        double triangleBase = userInput.nextDouble();

        System.out.print("Enter the height of the triangle: ");
        double triangleHeight = userInput.nextDouble();

        double baseHeightProduct = triangleBase * triangleHeight;
        double triangleArea = baseHeightProduct / 2.0;

        System.out.printf("The area of the triangle is %.3f\n", triangleArea);
    }
}
