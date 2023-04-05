package Algoritms;

public class Reverse {
    public static void main(String[] args) {

        System.out.println("односвязный список");
        MyList1 myList1 = new MyList1();
        myList1.addHead(2);
        myList1.print();
        myList1.addHead(1);
        myList1.print();
        myList1.addTail(3);
        myList1.print();
        myList1.addTail(4);
        myList1.print();
        System.out.println(myList1.find(3));
        myList1.add(4, myList1.find(3));
        myList1.print();
        myList1.delete(myList1.find(4));
        myList1.print();
        System.out.println(myList1.pop());
        myList1.print();
        myList1.revert();
        myList1.print();

        System.out.println("Двусвязный список");
        MyList2 myList2 = new MyList2();
        myList2.addHead(2);
        myList2.print();
        myList2.addHead(1);
        myList2.print();
        myList2.addTail(3);
        myList2.print();
        myList2.addTail(4);
        myList2.print();
        myList2.addTail(5);
        myList2.print();
        System.out.println(myList2.find(3));
        myList2.add(3, myList2.find(3));
        myList2.print();
        myList2.delete(myList2.find(3));
        myList2.print();
        System.out.println(myList2.peek());
        myList2.print();
        myList2.revert();
        myList2.print();
    }
}

class MyList1 {
    Node head;

    public Node find(int value) { // поиск элемента в списке
        Node currentPosition = head; // начинает с head
        while (currentPosition != null) {
            if (currentPosition.value == value) {
                return currentPosition;
            }
            currentPosition = currentPosition.next;
        }
        return null;
    }

    public void addHead(int value) {// доб. элемента в начало односвязного списка
        Node newPosition = new Node();
        newPosition.value = value;
        newPosition.next = head;
        head = newPosition;
    }

    public void addTail(int value) {// доб. элемента в конец односвязного списка
        Node currentPosition = head;
        Node newPosition = new Node();
        newPosition.value = value;
        while (currentPosition.next != null) { // ищем последний элемент списка
            currentPosition = currentPosition.next;
        }
        currentPosition.next = newPosition;
    }

    public void add(int value, Node position) { // доб. элемента в односвяз. список после определения позиции
        Node newPosition = new Node();
        newPosition.value = value;
        Node next = position.next;
        position.next = newPosition;
        newPosition.next = next;
    }

    public void delete(Node position) { // удаление элемента в списке
        Node currentPosition = head;
        Node next = position.next;
        if (position == head) {
            head = next;
        } else {
            while (currentPosition != null) {
                if (currentPosition.next == position) {
                    currentPosition.next = position.next;
                }
                currentPosition = currentPosition.next;
            }
        }
    }

    private void revert(Node currentPosition, Node previousPosition) { // разворот односвязного списка
        if (currentPosition.next == null) {
            head = currentPosition;
        } else {
            revert(currentPosition.next, currentPosition);
        }
        currentPosition.next = previousPosition;
    }

    public void revert() { // методж разворота односвязного списка
        if (head != null && head.next != null) {
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }

    public Integer pop() {// извлечение с начала списка - LIFO
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    public void print() { // печать
        Node currentPosition = head;
        while (currentPosition != null) {
            System.out.print(currentPosition.value + " ");
            currentPosition = currentPosition.next;
        }
        System.out.println();
    }
}

class MyList2 {
    Node head;
    Node tail;

    public Node find(int value) { // поиск элемента в списке
        Node currentPosition = head;
        while (currentPosition != null) {
            if (currentPosition.value == value) {
                return currentPosition;
            }
            currentPosition = currentPosition.next;
        }
        return null;
    }

    public void addHead(int value) { // доб. элемента в начало в двусвязный список
        Node newPosition = new Node();
        newPosition.value = value;
        if (head == null) {
            head = newPosition;
            tail = newPosition;
        } else {
            head.previous = newPosition;
            newPosition.next = head;
            head = newPosition;
        }
    }

    public void addTail(int value) { // доб. элемента в конец в двусвязный список
        Node newPosition = new Node();
        newPosition.value = value;
        if (head == null) {
            head = newPosition;
            tail = newPosition;
        } else {
            tail.next = newPosition;
            newPosition.previous = tail;
            tail = newPosition;
        }
    }

    public void add(int value, Node position) { // доб. элемента в двусвязный список после определения позиции
        Node newPosition = new Node();
        newPosition.value = value;
        Node next = position.next;
        position.next = newPosition;
        newPosition.previous = position;
        if (next == null) {
            tail = newPosition;
        } else {
            next.previous = newPosition;
            newPosition.next = next;
        }
    }

    public void delete(Node position) { // удаление элемента
        Node previous = position.previous;
        Node next = position.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        } else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    public void revert() { // метод разворота двухсвязного списка
        Node currentPosition = head;
        while (currentPosition != null) {
            Node next = currentPosition.next;
            Node previous = currentPosition.previous;
            currentPosition.next = previous;
            currentPosition.previous = next;
            if (previous == null) {
                tail = currentPosition;
            }
            if (next == null) {
                head = currentPosition;
            }
            currentPosition = next;
        }
    }

    public Integer peek() { // извлечение с конца двусвязного списка -FIFO
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public void print() { // печать
        Node currentPosition = head;
        while (currentPosition != null) {
            System.out.print(currentPosition.value + " ");
            currentPosition = currentPosition.next;
        }
        System.out.println();
    }
}

class Node {
    int value;
    Node next;
    Node previous;
}
