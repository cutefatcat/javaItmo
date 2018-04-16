package lecture11.zachet;

import java.util.NoSuchElementException;

/**
 * задание 2
 * Написать (собственные) LinkedList, Stack, Queue - generic
 *
 * list.add("qwqwq");
 * stack.push("qwqwq");
 */

//class node{
//      int value;
//      node next;
//      public node(int value){
//            this.value = value;
//      }
//}


public class CustomLSQ {
    public static void main(String[] args) {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);
        for (int i = 0; i < list.getSize(); i++){
            System.out.println(list.get(i));
        }

        GenericStack<String> stack = new GenericStack<>();;
        System.out.println(stack.isEmpty());
        stack.push("one");
        stack.push("two");
        stack.push("three");
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());

    }
}

class Node<T>{
    T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
    }
}




class GenericLinkedList<T> {
    //LinkedList односвязный
    private Node<T> head;
    private int size = 0;

    //инициализации
    public GenericLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T value) {
        //создаем новый элемент списка Node
        Node<T> newNode = new Node<>(value);
        //если первого элемента в списке нет, прописываем новый элемент в первом(пустом
        if (head == null) {
            head = newNode;
        } else {
            //если элементы есть, ищем последний элемент (с нулевой ссылкой) переходя по очереди
            // от первого к следующему, от следующего дальше к следующему
            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            //прописываем старому последнему(а теперь предпоследнему) ссылку на новый последний
            currentNode.next = newNode;
        }
        size++;
    }

    //удаление элемента по индексу
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index == 0){
            if (head == null){
                throw new IndexOutOfBoundsException();
            }
            head = head.next;
        } else {
            Node<T> prevNode = find(index - 1);
            if (prevNode.next == null){
                throw new IndexOutOfBoundsException();
            }
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    //получение значения по индексу элемента
    public T get(int index) {
        return find(index).value;
    }

    private Node<T> find(int index){
        int count = 0;
        Node<T> currentNode = head;
        while (count != index) {
            if (currentNode.next == null) {
                throw new IndexOutOfBoundsException();
            }
            count++;
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}




class GenericStack<T> {
    //LinkedList односвязный
    private Node<T> first;
    private int size;

    public GenericStack() {
        first = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //помещение элемента в вершину стека
    public  void push(T value){
        Node<T> newNode = new Node<>(value);
        //все равно есть ли первый элемент или он null,
        //на него в любом случае будет сделана ссылка
        newNode.next = first;
        first = newNode;
    }

    // извлечение верхнего элемента (с удалением его из стека)
    public T pop() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T value = first.value;
        first = first.next;
        size--;
        return value;
    }
}


