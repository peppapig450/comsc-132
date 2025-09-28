package homework;

public class MyList {
    private class Node {
        int value;
        Node next;
    }

    private Node head;

    MyList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public boolean find(int v) {
        Node p = head;

        while (p != null) {
            if (p.value == v) {
                return true;
            }
            p = p.next;
        }

        return false;
    }

    public void remove(int v) {
        Node p = head;
        Node q = null;

        while (p != null && p.value != v) {
            q = p;
            p = p.next;
        }

        if (p != null) {
            if (q == null) {
                head = head.next;
            } else {
                q.next = p.next;
            }
            p = null;
        }
    }

    public void append(int v) {
        Node n = new Node();
        n.value = v;
        n.next = null;

        if (isEmpty()) {
            head = n;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = n;
        }
    }

    public int sum() {
        int total = 0;
        Node p = head;

        while (p != null) {
            total += p.value;
            p = p.next;
        }

        return total;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;

        while (p != null) {
            sb.append(p.value);
            if (p.next != null) {
                sb.append(" ");
            }

            p = p.next;
        }

        return sb.toString();
    }
}
