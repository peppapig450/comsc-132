package assignment7;

import java.util.Scanner;

public class Assignment7 {
    public static void main(String[] args) {
        PlateStack stack = new PlateStack();

        System.out.println("Let's stack some dishes.");

        String currentColor = "";
        Scanner input = new Scanner(System.in);

        for (;;) {
            System.out.print("Enter a dish color or 'done' when finished: ");
            currentColor = input.nextLine();

            if (currentColor.equalsIgnoreCase("done")) {
                break;
            }

            Plate newPlate = new Plate(currentColor);
            stack.push(newPlate);
        }

        if (stack.size() == 0) {
            System.out.println("There are no plates on the stack.");
            return;
        }

        System.out.println("The size of the stack is " + stack.size());
        System.out.println("The color of the top dish is " + stack.peek().getColor());
        System.out.println("The color of the bottom dish is " + stack.bottom().getColor());

        stack.pop();
        System.out.println("The size of the stack is " + stack.size());

        System.out.println("The color of the new top dish is " + stack.peek().getColor());
        System.out.println(stack);
    }

}
