package hw;

public class MyString {
    private class Node {
        char x;
        Node next;
        Node prev;
    }

    private Node head;
    private Node tail;

    MyString() {
        this.head = null;
        this.tail = null;
    }

    MyString(String str) {
        for (char c : str.toCharArray()) {
            append(c);
        }
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void append(char c) {
        Node newNode = new Node();
        newNode.x = c;
        newNode.next = null;
        newNode.prev = null;

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public char charAt(int index) {
        int i = 0;
        Node currentNode = this.head;

        while (currentNode != null) {
            if (i == index) {
                return currentNode.x;
            }

            ++i;
            currentNode = currentNode.next;
        }

        /*
         * the textbook only mentions throwing exceptions in Chapter 17, which we
         * haven't looked at, but without it here this technically is an invalid
         * function since it doesn't guarantee a char on all paths. String.charAt throws
         * IndexOutOfBounds as well if the index is out of bounds. but since we haven't
         * technically learned it, I'm not sure if i can include it and I'm doing this
         * kind of late so i cant email and ask.
         * so we just return a null character as a default value.
         */
        return '\0';
    }

    public void toUpperCase() {
        Node currentNode = this.head;

        while (currentNode != null) {
            char currentChar = currentNode.x;
            currentNode.x = Character.toUpperCase(currentChar);

            currentNode = currentNode.next;
        }
    }

    public void reverse() {
        Node currentNode = this.head;
        Node tempNode = null;

        while (currentNode != null) {
            tempNode = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = tempNode;

            currentNode = currentNode.prev;
        }

        if (tempNode != null) {
            this.head = tempNode.prev;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = this.head;

        while (currentNode != null) {
            sb.append(currentNode.x);

            currentNode = currentNode.next;
        }

        return sb.toString();
    }
}
