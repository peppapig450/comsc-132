package hw;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = input.nextLine();
        MyString charList = new MyString(inputString);

        System.out.println("Here's the string you entered:" + "\n" + charList);

        charList.toUpperCase();
        System.out.println("Here's the string turned to uppercase:" + "\n" + charList);

        charList.reverse();
        System.out.println("Here's the string reversed:" + "\n" + charList);

        System.out.print("Enter the index of char in the string: ");
        int charIndex = input.nextInt();

        System.out.println("Here's the character:" + "\n" + charList.charAt(charIndex));
    }
}
