package adamobrien.vaccineassignment.ADT;

public class LinkedListClient {

    public static void main(String[] args) {

        LinkedList<String> greetings = new LinkedList();

//        greetings.insert(greetings,1);
//        greetings.insert(greetings,4);
        greetings.addElement("hey");

        greetings.addElement("hello"); //head

        greetings.addElement("heya");

        greetings.addElement("hi");

        greetings.addElement("Test Delete");

        greetings.remove(0);

        //greetings.delete(1);


        System.out.println(greetings.printList());

//        for(int i = greetings.listLength() - 1; i >= 0; i--){  //reverse for loop
//
//            System.out.println(greetings.get(i));
//        }



    }

}
