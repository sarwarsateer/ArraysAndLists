package LinkLists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> citiesToVisit = new LinkedList<>();
        citiesToVisit.add("Kabul");
        citiesToVisit.add("Herat");
        citiesToVisit.add("Mazar");
        citiesToVisit.add("Helmand");

        printList(citiesToVisit);

        //to add items
        citiesToVisit.add(1, "Faryab");
        printList(citiesToVisit);

        //to delete items
        citiesToVisit.remove(2);
        printList(citiesToVisit);

    }

    private static void printList(LinkedList<String> citiesToVisit) {
        Iterator<String> i = citiesToVisit.iterator();

        while(i.hasNext()) {
            System.out.println("You are visiting:" + i.next());
        }
        System.out.println("+++++++++++++++++++++++");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                //equal, do not add
                System.out.println(newCity + " already added as a destination");
            } else if (comparison > 0) {
                //the new city should be added before this one
                //Kabul -> Baghlan
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                
            }
        }
        stringListIterator.add(newCity);
        return true;
    }
}
