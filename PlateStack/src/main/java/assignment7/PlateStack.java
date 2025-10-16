package assignment7;

public class PlateStack {
    private class Node {
        private Plate p;
        private Node next;
    }

    private Node top;

    PlateStack() {
        this.top = null;
    }

    public void push(Plate p) {
        Node topPlate = new Node();
        topPlate.p = p;
        topPlate.next = this.top;
        this.top = topPlate;
    }

    public void pop() {
        if (this.top != null) {
            this.top = this.top.next;
        }
    }

    public Plate peek() {
        if (this.top != null) {
            return this.top.p;
        } else {
            return null;
        }
    }

    public Plate bottom() {
        Node curNode;

        if (this.top != null) {
            curNode = this.top;
        } else {
            return null;
        }

        while (curNode.next != null) {
            curNode = curNode.next;
        }

        return curNode.p;
    }

    public short size() {
        Node curNode;
        short plateCount = 0;

        if (this.top != null) {
            curNode = this.top;
        } else {
            return plateCount;
        }

        plateCount = 1;
        while (curNode.next != null) {
            ++plateCount;
            curNode = curNode.next;
        }

        return plateCount;
    }

    public String toString() {
        String stackString;
        Node curNode;

        if (this.top != null) {
            curNode = this.top;
            stackString = "Top";
        } else {
            return null;
        }

        while (curNode != null) {
            stackString = stackString + "->" + curNode.p.getColor();
            curNode = curNode.next;
        }

        stackString = stackString + "->Bottom";
        return stackString;
    }

}
