package contacts;

public class Contacts {

    private class Contact {
        String lastName;
        String firstName;
        String phoneNumber;

        Contact left;
        Contact right;
    }

    private Contact root;

    Contacts() {
        this.root = null;
    }

    public void clear() {
        this.root = null;
    }

    private Contact add(Contact p, Contact n) {
        if (p == null) {
            return n;
        } else if (n.lastName.compareTo(p.lastName) < 0) {
            p.left = add(p.left, n);
        } else {
            p.right = add(p.right, n);
        }

        return p;
    }

    public void add(String last, String first, String phone) {
        Contact newContact = new Contact();
        newContact.lastName = last;
        newContact.firstName = first;
        newContact.phoneNumber = phone;

        Contact newContactReference = add(this.root, newContact);
        this.root = newContactReference;
    }

    public void print() {
        print(this.root);
    }

    private void print(Contact p) {
        if (p == null) {
            return;
        }

        print(p.left);
        System.out.println("Name: " + p.lastName + ", " + p.firstName + ", " + "Phone#: " + p.phoneNumber + ".");
        print(p.right);
    }

    public void remove(String last) {
        this.root = remove(this.root, last);
    }

    private Contact remove(Contact p, String last) {
        if (p == null) {
            return null;
        } else if (last.compareTo(p.lastName) < 0) {
            p.left = remove(p.left, last);
            return p;
        } else if (last.compareTo(p.lastName) > 0) {
            p.right = remove(p.right, last);
            return p;
        } else {
            if (p.left == null && p.right == null) {
                return null;
            } else if (p.left == null && p.right != null) {
                return p.right;
            } else if (p.left != null && p.right == null) {
                return p.left;
            } else {
                Contact successor = p.right;

                while (successor.left != null) {
                    successor = successor.left;
                }

                p.lastName = successor.lastName;
                p.firstName = successor.firstName;
                p.phoneNumber = successor.phoneNumber;

                p.right = remove(p.right, successor.lastName);

                return p;
            }
        }
    }

    public String search(String last) {
        return search(this.root, last);
    }

    private String search(Contact p, String last) {
        if (p == null) {
            return "Name not found";
        } else if (last.equals(p.lastName)) {
            return p.phoneNumber;
        } else if (last.compareTo(p.lastName) < 0) {
            return search(p.left, last);
        } else {
            return search(p.right, last);
        }
    }
}
