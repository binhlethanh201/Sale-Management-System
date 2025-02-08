package asm;
public class MyList<E extends Comparable<E>> {
    public void myList() {head = tail = null;}
    public boolean isEmpty() {return (head == null);}
    public void clear() {head = tail = null;}
    public void addToHead(E x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
        }
    }
    public void addToTail(E x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }
    public void traverse() {
        Node<E> p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
        System.out.println("");
    }
    public E search(E x) {
        if (isEmpty()) {
            System.out.println("Empty.");
        }
        boolean check = false;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.info.equals(x)) {
                check = true;
                break;
            }
            currentNode = currentNode.next;
        }
        if (!check) {
            System.out.println("Not Found");
            return null;
        }
        return currentNode.info;
    }
    public void sort(Product saled) {
        sorted = null;
        Node<E> currentNode = head;

        while (currentNode != null) {
            Node<E> next = currentNode.next;
            sortInsert(currentNode);
            currentNode = next;
        }
        head = sorted;
    }

    void sortInsert(Node<E> newNode) {
        if (sorted == null || sorted.info.compareTo(newNode.info) <= 0) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node<E> currentNode = sorted;
            while (currentNode.next != null && currentNode.next.info.compareTo(newNode.info) > 0) { 
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }
    public void delete(E x) {
        if (head == null) {
            System.out.println("Empty.");
            return;
        }

        Node<E> currentNode = head;
        Node<E> pre_Node = new Node();
        while (!currentNode.info.equals(x) && currentNode.next != null) {
            pre_Node = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            System.out.println("Not Found.");
            return;
        }
        pre_Node.next = currentNode.next;
    }

    public void addAfterPosition(int position, E x) {
        Node<E> newNode = new Node(x);
        int d = 0;
        Node<E> currentNode = head;
        while (currentNode != null && d < position) {
            currentNode = currentNode.next;
            d++;
        }
        if (currentNode == null && d < position) {
            System.out.println("Position is higher than size of linked list.");
            return;
        }
        Node<E> preNode = currentNode.next;
        newNode.next = preNode;
        currentNode.next = newNode;
    }

    public void deleteAfterNode(E x) {
        if (isEmpty()) {
            System.out.println("Empty.");
        }
        boolean check = false;
        Node<E> currentNode = head;
        Node<E> deletedNode = new Node();
        while (currentNode != null) {
            if (currentNode.info.equals(x)) {
                check = true;
                break;
            }
            currentNode = currentNode.next;
        }
        if (!check) {
            System.out.println("Not Found.");
            return;
        }
        if (currentNode.next == null) {
            System.out.println("Tail of linked list is null.");
            return;
        }
        deletedNode = currentNode.next;
        currentNode.next = deletedNode.next;
        System.out.println("Delete sucessfully!");
    }
    private static class Node<E> {
        private E info;
        private Node<E> next;
        public Node() {
        }
        public Node(E info, Node<E> next) {
            this.info = info;
            this.next = next;
        }
        public Node(E info) {
            this.info = info;
            this.next = null;
        }
        public E getInfo() {
            return info;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setInfo(E info) {
            this.info = info;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
            Node<E> head, tail;
    Node<E> sorted;
    }
    Node<E> head, tail;
    Node<E> sorted;
}

