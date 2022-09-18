package cz.fku.udemy.dataStructureAlgo.linkedlist.ch2;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
        if (head == null || head.getValue() > value) {
            addToFront(value);
            return;
        }

        IntegerNode current = head.getNext();
        while (current.getNext() != null && value >= current.getNext().getValue()) {
            current = current.getNext();
        }
        // add after
        IntegerNode newNode = new IntegerNode(value);
        if (current.getNext() == null) {
            current.setNext(newNode);
        } else {
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;

    }
//    public void insertSorted(Integer value) {
//        if (head == null) {
//            addToFront(value);
//            return;
//        }
//        IntegerNode current = head;
////        IntegerNode previous;
//        while (current.getNext() != null && value > current.getValue()) {
////            previous = current;
//            current = current.getNext();
//        }
//        // insert value after current
//        System.out.println("Inserting: " + value + " after: " + current);
//
//        IntegerNode newNode = new IntegerNode(value);
//        if (current.getNext() == null) {
//            if (value > current.getValue()) {
//                current.setNext(newNode);
//                size++;
//
//            } else {
//                addToFront(value);
//            }
//        } else {
//            newNode.setNext(current.getNext());
//            current.setNext(newNode);
//            size++;
//        }
//    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
