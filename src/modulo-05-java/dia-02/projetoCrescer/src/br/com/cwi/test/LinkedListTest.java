package br.com.cwi.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.list.LinkedList;

public class LinkedListTest {

    @Test
    public void adicionaPrimeiroNaLista() throws Exception {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");

        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

}