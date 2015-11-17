package br.com.cwi.list;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList {

    protected Node last, first;

    public void addFirst(String value) {
        Node node = new Node(value, first);
        if (first == null) {
            last = node;
        }
        first = node;
    }

    public String getFirst() {
        return first.getValue();
    }

    public String getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public List<String> list() {
        ArrayList<String> lista = new ArrayList<String>();
        Node node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    public void removeFirst() {

    }

    public void add(int index, String value) {

    }

    public void remove(int index) {
        Node tmp = getNode(index - 1);
        Node removido = tmp.getNext();
        tmp.setNext(removido.getNext());
    }

    private Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public void add(String value) {
        addLast(value);
    }

    public void addLast(String value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
        }
        last.setNext(node);
        last = node;
    }

    protected class Node {

        private String value;

        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

}