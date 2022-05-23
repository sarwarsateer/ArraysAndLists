package list;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println("item " + (i + 1) + ":" + groceryList.get(i));
        }
    }

    public void modifyItem(String currentItem, String newItem) {
        int index = findItem(currentItem);
        if (index >= 0) {
            modifyItem(index, newItem);
        }
    }
    private void modifyItem(int index, String newItem) {
        groceryList.set(index, newItem);
    }

    public void removeGroceryItem(String itemName) {
        int index = findItem(itemName);

        if (index >= 0) {
            removeGroceryItem(index);
        }
    }
    private void removeGroceryItem(int index) {
        groceryList.remove(index);
    }

//    public void findItem(String searchItem) {
//        if (groceryList.contains(searchItem)) {
//            System.out.println("Item found");
//        } else {
//            System.out.println("Item not found");
//        }
//    }
//
//    public void findItem2(String searchItem) {
//        for (String x : groceryList
//        ) {
//            if (x.contains(searchItem)) {
//                System.out.println("Item:" + x + " Found");
//            }
//        }
//    }
//
//    public void findItem3(String searchItem) {
//        for (int i = 0; i < groceryList.size(); i++) {
//            if (groceryList.get(i).contains(searchItem)) {
//                System.out.println(groceryList.get(i) + " found on index " + i);
//            }
//        }
//    }
//
//    public void findItem4(String searchItem) {
//        boolean isExist = groceryList.contains(searchItem);
//
//        if (isExist) {
//            System.out.println("Item is found on index:" + groceryList.indexOf(searchItem));
//            System.out.println("Item:" + groceryList.get(groceryList.indexOf(searchItem)));
//        }
//    }

    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        if (findItem(searchItem) >= 0) {
            return true;
        }
        return false;
    }
}
