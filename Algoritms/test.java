package Algoritms;

public class test {
    public static void main(String[] args) {

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

    public Node find(int value) {// поиск элемента в списке
        Node currentPosition = head;// Начинаем поиск с головы
        while (currentPosition != null) {// до тех пор пока текущая позиция не равна null
            if (currentPosition.value == value) {// проверяем позиции на искомое значение
                return currentPosition;// возвращаем найденую позицию
            }
            currentPosition = currentPosition.next;// если проверка не прошла, то проверяем следующую позицию
        }
        return null;// если искомого значния нет в списке, возращаем null
    }

    public void addHead(int value) {// добавление элемента в начало односвязного списка
        Node newPosition = new Node();// создаем новую позицию(добавляемую позицию)
        newPosition.value = value;// присваеваем ей значение
        newPosition.next = head;// присваиваем нов.эл. ссылку на начало списка
        head = newPosition;// делаем нов.эл. началом списка
    }

    public void addTail(int value) {// добавление элемента в конец односвязного списка
        Node currentPosition = head;
        Node newPosition = new Node();// создаем новую позицию(добавляемую позицию)
        newPosition.value = value;// присваеваем ей значение
        while (currentPosition.next != null) {// ищем последний элемент списка
            currentPosition = currentPosition.next;
        }
        currentPosition.next = newPosition;// присваиваем послед.эл. ссылку на нов. эл., делая нов.эл. последним
    }

    public void add(int value, Node position) {// добавление элемента в двусвязный список после определенной позиции
        Node newPosition = new Node();// создаем новую позицию (добавляемую позицию)
        newPosition.value = value;// присваеваем ей значение
        Node next = position.next;// запоминаем следующее после определенной позиции значение
        position.next = newPosition;// следующее после определенной позиции значение это новая позиция
        newPosition.next = next;// след. знач. новой позиции - это след. после опред. поз. знач.
    }

    public void delete(Node position) {// удаление элемента
        Node currentPosition = head;
        Node next = position.next;// запоминаем ссылки у удоляемой позиции
        if (position == head) {// если удаляемая позиция это head
            head = next;// сдвигаем начало списка на следующую позицию после удаляемой
        } else {
            while (currentPosition != null) {// пробегаемся по всему списку
                if (currentPosition.next == position) {// ищем позицию, которая ссылается на удаляемую
                    currentPosition.next = position.next;// присваеваем ей ссылку на след. после удаляемой позицию
                }
                currentPosition = currentPosition.next;
            }
        }
    }

    private void revert(Node currentPosition, Node previousPosition) {// рекурсия разворота односвязного списка
        if (currentPosition.next == null) {// если у текущей позиции нет ссылки - это последняя позиция
            head = currentPosition;// и она должна стать первой
        } else {
            revert(currentPosition.next, currentPosition);// запускаем рекурсию передавая след.знач.-> как
                                                          // текущ.знач
                                                          // тек.зн.-> как пред.зн.
        }
        currentPosition.next = previousPosition;// меняем ссылку у текущей поз. на предыдущую поз.
    }

    public void revert() {// управление рекурсией разворота односвязного списка
        if (head != null && head.next != null) {// проверка что в списке больше одного значения
            Node temp = head;
            revert(head.next, head);// разворот начинается со второго эл. и после разворота бывший head должен
            temp.next = null;// стать концом на него уже ссылаются, а его ссылка должна стать null
        }
    }

    public Integer pop() {// извлечение с начала списка LIFO
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    public void print() {
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

    public Node find(int value) {// поиск элемента в списке
        Node currentPosition = head;// Начинаем поиск с головы
        while (currentPosition != null) {// до тех пор пока текущая позиция не равна null
            if (currentPosition.value == value) {// проверяем позиции на искомое значение
                return currentPosition;// возвращаем найденую позицию
            }
            currentPosition = currentPosition.next;// если проверка не прошла, то проверяем следующую позицию
        }
        return null;// если искомого значния нет в списке, возращаем null
    }

    public void addHead(int value) {// добавление элемента в начало в двусвязный список
        Node newPosition = new Node();// создаем новую позицию (добавляемую позицию)
        newPosition.value = value;// присваеваем ей значение
        if (head == null) {// проверяем список, если он пуст, то присваеваем head и tail добавляемую
                           // позицию
            head = newPosition;
            tail = newPosition;
        } else {
            head.previous = newPosition;// присваиваем пред. ссылку первого.эл. на новую позицию
            newPosition.next = head;// присваиваем след.ссылку новой позиции на первый эл.
            head = newPosition;// делаем новую позицию первым элементом списка
        }
    }

    public void addTail(int value) {// добавление элемента в конец в двусвязный список
        Node newPosition = new Node();// создаем новую позицию (добавляемую позицию)
        newPosition.value = value;// присваеваем ей значение
        if (head == null) {// проверяем список, если он пуст, то присваеваем head и tail добавляемую
                           // позицию
            head = newPosition;
            tail = newPosition;
        } else {
            tail.next = newPosition;// присваиваем след. ссылку послед.эл. на новую позицию
            newPosition.previous = tail;// присваиваем пред.ссылку новой позиции на послед.эл.
            tail = newPosition;// делаем новую позицию последним элементом списка
        }
    }

    public void add(int value, Node position) {// добавление элемента в двусвязный список после определенной позиции
        Node newPosition = new Node();// создаем новую позицию (добавляемую позицию)
        newPosition.value = value;// присваеваем ей значение
        Node next = position.next;// запоминаем следующее после определенной позиции значение
        position.next = newPosition;// следующее после определенной позиции значение это новая позиция
        newPosition.previous = position;// предыдущее значение новой позиции - это определенная позиция
        if (next == null) {// если определенная позиция была последней,
            tail = newPosition;// то новая позиция - это tail
        } else {
            next.previous = newPosition;// предыдущее знач. от след. после опред. поз. знач. это новая позиция
            newPosition.next = next;// след. знач. новой позиции - это след. после опред. поз. знач.
        }
    }

    public void delete(Node position) {// удаление элемента
        Node previous = position.previous;// запоминаем ссылки у удоляемой позиции
        Node next = position.next;// запоминаем ссылки у удоляемой позиции
        if (previous == null) {// если предыдущее значение null, то удаляемая позиция это head
            next.previous = null;// предыдущее значение у следующей позиции после удаляемой равно null
            head = next;// сдвигаем начало списка на следующую позицию после удаляемой
        } else {
            if (next == null) {// если следующее значение null, то удаляемая позиция это tail
                previous.next = null;// следующее значение у предыдущей позиции перед удаляемой равно null
                tail = previous;// сдвигаем конец списка на предыдущую позицию перед удаляемой
            } else {
                previous.next = next;// если удаляемая позиция в середине списка,то меняем ссылки
                next.previous = previous;// у предыдущего и следующего элементов
            }
        }
    }

    public void revert() {// разворот двухсвязного списка
        Node currentPosition = head;// назначаем текущую позицию с головы
        while (currentPosition != null) {
            Node next = currentPosition.next;// запоминаем следующее и
            Node previous = currentPosition.previous;// предыдущее значения позиций от текущей позиции
            currentPosition.next = previous;// меняем следующее и предыдущее значения
            currentPosition.previous = next;// позиций от текущей позиции местами
            if (previous == null) {// проверка на конец списка
                tail = currentPosition;
            }
            if (next == null) {// проверка на начало списка
                head = currentPosition;
            }
            currentPosition = next;// обновляем текущее значение на следующее и продолжаем цикл
        }
    }

    public Integer peek() {// извлечение с конца двусвязного списка FIFO
        Integer result = null;// создаем результат
        if (tail != null) {// проверяем существует ли список
            result = tail.value;// записываем значение в результат
            tail.previous.next = null;// обнуляем ссылку на tail
            tail = tail.previous;// присваеваем tail предыдущему значению
        }
        return result;// возвращаем результат
    }

    public void print() {
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
