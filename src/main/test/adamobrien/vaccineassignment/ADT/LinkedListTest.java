package adamobrien.vaccineassignment.ADT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList validList;

    @BeforeEach
    void setUp() {
        validList = new LinkedList();
    }


    @Test
    void addElement() {
        validList.addElement(2);
        validList.addElement(7);
        assertEquals(2,validList.listLength());

    }



    @Test
    void deleteList() {
        validList.addElement(1);
        validList.addElement(2);
        validList.addElement(3);
        validList.addElement(4);
        assertEquals(4,validList.listLength());
        validList.deleteList();

        assertEquals(0,validList.listLength());
    }

    @Test
    void delete() {
        validList.addElement(1);
        validList.addElement(2);
        validList.addElement(3);
        validList.addElement(4);
        validList.remove(0);
        assertEquals(3,validList.listLength());
    }



    @Test
    void listLength() {
        validList.addElement(1);
        assertEquals(1,validList.listLength());
    }


    @Test
    void searchElement() {
    }
}