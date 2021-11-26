package adamobrien.vaccineassignment.ADT;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    public LinkedNode<E> head=null;


      /*-Work on
           search()
           once that's done LinkedLists are basically finished
     */

    public E get(int e){
        LinkedNode<E> node = head;
        for (int i = 0; i < e; i++){
            node = node.next;
        }
     return node.getContents();
    }

    public void addElement(E e) { //Add element to top of list
        LinkedNode<E> node=new LinkedNode<>(); //DONE
        node.setContents(e);
        node.next=head;
        head=node;
    }
    public void deleteList() {
        head = null;  // if the head of the list is null it falls apart
    }



    public void remove(int index) {
        index = listLength() - index - 1;
        if (index == 0) {
            // removing the first element must be handled specially
            head = head.next;
        } else {
            // removing some element further down in the list;
            // traverse to the node before the one we want to remove
            LinkedNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // change its next pointer to skip past the offending node
            current.next = current.next.next;
        }
    }

        public LinkedList<E> getList(){
        return this;
    }

    public LinkedList<E> setList(){
        return this;
    }

    public String printList(){
        String theList = "";
        LinkedNode<E> currentNode = head;

        while(currentNode != null){  // while there is still a node after the current node
            theList = theList + currentNode.getContents() + "\n";  // get the contents of it and add it to theList
            currentNode = currentNode.next;
        }
        return theList;  // return the string list
    }

    public int listLength()
    {
        LinkedNode temp = head; // make a copy of the head
        int counter = 0;
        while (temp != null)  //while there is a node after the head
        {
            counter++; //the counter will start counting
            temp = temp.next; //then when the head
        }
        return counter;  // when there is nothing in front of the head it returns how many nodes were counted
    }


    public LinkedNode<E> getHead() {
        return head;
    }

    public void setHead(LinkedNode<E> head) {
        this.head = head;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private LinkedNode<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;  // if the current head does not have an element to go to return true
            }

            @Override
            public E next() {
                LinkedNode<E> placeholder = current; // makes a copy of current
                current = current.next; //makes the current go to the next element
                return placeholder.getContents();  // prints the placeholder
            }
        };

    }


    public boolean isEmpty(){

        if(listLength() <= 0){
            return false;
        }
        else{
            return true;
        }
    }



}
