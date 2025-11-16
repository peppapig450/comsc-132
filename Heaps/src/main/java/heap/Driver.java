package heap;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int queueSize = 10;
        Scanner input = new Scanner(System.in);
        HeapQueue queue = new HeapQueue(queueSize);

        for (int i = 1; i <= queueSize; ++i) {
            System.out.print("Enter number " + i + ": ");
            int newValue = input.nextInt();

            queue.enqueue(newValue);
        }

        System.out.println("HeapQueue contents:");

        while (queue.top() != -1) {
            int currentValue = queue.top();
            System.out.print(currentValue + " ");
            queue.dequeue();
        }

        input.close();
    }
}
