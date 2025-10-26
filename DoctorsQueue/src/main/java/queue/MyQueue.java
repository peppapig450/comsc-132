package queue;

public class MyQueue {
    private class Node {
        private short num;
        private Node next;
    }

    private Node front;
    private Node back;
    private short counter;

    MyQueue() {
        this.front = null;
        this.back = null;
        this.counter = 1;
    }

    public void enqueue() {
        Node newNode = new Node();
        newNode.num = this.counter;
        newNode.next = null;

        if (this.front == null) {
            this.front = newNode;
            this.back = newNode;
        } else {
            this.back.next = newNode;
            this.back = this.back.next;
        }

        this.counter += 1;
    }

    public void dequeue() {
        if (this.front != null) {
            this.front = this.front.next;

            if (this.front == null) {
                this.back = null;
            }
        }
    }

    public short peek() throws Exception {
        if (this.front != null) {
            return this.front.num;
        }

        throw new Exception("ERROR - EMPTY QUEUE");
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public short getCounter() {
        return this.counter;
    }
}
