package homework;

import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
        MyList list = new MyList();
        Scanner in = new Scanner(System.in);

        int insertValue;
        for (int i = 0; i < 10; ++i) {
            int displayIndex = i + 1;

            System.out.print("Enter number " + displayIndex + ": ");
            insertValue = in.nextInt();

            list.append(insertValue);
        }

        System.out.println("The numbers stored in the list are:\n" + list);
        System.out.println("The sum of the list numbers is: " + list.sum());

        System.out.print("Enter a number to search for: ");
        int searchValue = in.nextInt();

        if (list.find(searchValue)) {
            System.out.println("The number is in the list.");
        } else {
            System.out.println("The number is not in the list.");
        }

        System.out.print("Enter a number to remove: ");
        int removeValue = in.nextInt();
        list.remove(removeValue);

        System.out.println("The updated list:\n" + list);
    }

}
