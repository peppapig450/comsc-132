package partslist;

public class Inventory {
    private class Part {
        static short UNUSED = 0;
        static short USED = 1;
        static short DELETED = 2;

        short mark;
        String description;
        String partNumber;
        int quantity;
    }

    private Part[] parts;

    Inventory() {
        this(10);
    }

    Inventory(int s) {
        this.parts = new Part[s];

        for (int i = 0; i < s; ++i) {
            this.parts[i] = new Part();
        }
    }

    public int size() {
        return this.parts.length;
    }

    public void clear() {
        for (Part currentBucket : this.parts) {
            currentBucket.mark = Part.UNUSED;
        }
    }

    public boolean isFull() {
        for (Part currentBucket : this.parts) {
            if (currentBucket.mark != Part.USED) {
                return false;
            }
        }

        return true;
    }

    public boolean isEmpty() {
        for (Part currentBucket : this.parts) {
            if (currentBucket.mark == Part.USED) {
                return false;
            }
        }

        return true;
    }

    public void insert(String partNumber, String description, int quantity) {
        if (!this.isFull()) {
            int hashIndex = hash(partNumber);

            while (this.parts[hashIndex].mark == Part.USED) {
                hashIndex = (hashIndex + 1) % this.size();
            }

            this.parts[hashIndex].partNumber = partNumber;
            this.parts[hashIndex].description = description;
            this.parts[hashIndex].quantity = quantity;
            this.parts[hashIndex].mark = Part.USED;
        }
    }

    private int hash(String key) {
        int sum = 0;

        for (int i = 0; i < key.length(); ++i) {
            sum += key.charAt(i);
        }

        return sum % parts.length;
    }

    public void remove(String partNumber) {
        if (!this.isEmpty()) {
            int hashIndex = hash(partNumber);
            int currentIndex = 0;

            while (currentIndex < this.size() && this.parts[hashIndex].mark != Part.UNUSED) {
                if (this.parts[hashIndex].partNumber.equals(partNumber) && this.parts[hashIndex].mark == Part.USED) {
                    this.parts[hashIndex].mark = Part.DELETED;
                    break;
                }

                ++currentIndex;
                hashIndex = (hashIndex + 1) % this.size();
            }
        }
    }

    public int find(String partNumber) {
        if (!this.isEmpty()) {
            int hashIndex = hash(partNumber);

            int currentIndex = 0;
            while (currentIndex < this.size() && this.parts[hashIndex].mark != Part.UNUSED) {
                if (this.parts[hashIndex].mark == Part.USED && this.parts[hashIndex].partNumber.equals(partNumber)) {
                    return this.parts[hashIndex].quantity;
                }

                hashIndex = (hashIndex + 1) % this.size();
                ++currentIndex;
            }
        }

        return -1;
    }

    public void print() {
        System.out.println("PARTS INVENTORY");
        System.out.printf("%-12s %-10s %6s\n", "Desc.", "Part#", "Qty");

        for (Part currentBucket : this.parts) {
            if (currentBucket.mark == Part.USED) {
                System.out.printf("%-12s %-10s %6d\n", currentBucket.description, currentBucket.partNumber,
                        currentBucket.quantity);
            }
        }
    }
}
