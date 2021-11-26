package adamobrien.vaccineassignment.ADT;

public class LinkedListClient {
    /**
     *
     * THIS CLASS SERVES NO PURPOSE TO THE RUNNING OF THE VACCINE CENTER
     *
     * It is simply a playground for me to use my linked list in to make sure certain methods are working
     * the way I intend them to work
     *
     * Yes I could always just use the test class and I DID implement one
     * I just prefer this way for testing as it is more practical
     *
     * Thanks -Adam O'Brien
     */

    public static void main(String[] args) {

        LinkedList<String> greetings = new LinkedList();

        greetings.addElement("hey");

        greetings.addElement("hello");

        greetings.addElement("heya");

        greetings.addElement("hi");

        greetings.addElement("Test Delete");

        greetings.remove(0);

        System.out.println(greetings.printList());



    }

}
