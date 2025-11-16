package heap;

public class HeapQueue {
    private int heap[];
    private int bottom;

    HeapQueue(int s) {
        this.heap = new int[s];
        this.bottom = -1;
    }

    public int enqueue(int i) {
        if (this.bottom < this.heap.length - 1) {
            ++this.bottom;
            this.heap[this.bottom] = i;
            this.ReHeapUp();

            return 0;
        }

        return -1;
    }

    public int dequeue() {
        if (this.bottom != -1) {
            this.heap[0] = this.heap[bottom];

            --this.bottom;

            this.ReHeapDown();

            return 0;
        }

        return -1;
    }

    public int top() {
        if (this.bottom != -1) {
            return this.heap[0];
        }

        return -1;
    }

    public void clear() {
        this.bottom = -1;
    }

    private void ReHeapUp() {
        int childIndex = this.bottom;

        while (childIndex != 0) {
            int parentIndex = (childIndex - 1) / 2;

            if (this.heap[childIndex] < this.heap[parentIndex]) {
                int temp = this.heap[parentIndex];
                this.heap[parentIndex] = this.heap[childIndex];
                this.heap[childIndex] = temp;
            }

            childIndex = parentIndex;
        }
    }

    private void ReHeapDown() {
        int parent = 0;

        while (parent < this.bottom) {
            int leftChild = (2 * parent) + 1;
            int rightChild = (2 * parent) + 2;
            int minChild;

            if (leftChild <= this.bottom) {
                minChild = (leftChild == this.bottom) ? leftChild
                        : (this.heap[leftChild] < this.heap[rightChild] ? leftChild : rightChild);
            } else {
                break;
            }

            if (this.heap[parent] > this.heap[minChild]) {
                int temp = this.heap[parent];
                this.heap[parent] = this.heap[minChild];
                this.heap[minChild] = temp;

                parent = minChild;
            } else {
                break;
            }
        }
    }
}
