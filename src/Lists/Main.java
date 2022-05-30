package Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
//        GroceryList groceryList = new GroceryList();
//        groceryList.addGroceryItem("A");
//        groceryList.addGroceryItem("B");
//        groceryList.addGroceryItem("C");
//        groceryList.addGroceryItem("D");
//        groceryList.printGroceryList();
//        groceryList.replaceGroceryItem(7, "G");
//        groceryList.removeGroceryItem(2);

//        groceryList.findItem("B");//finding item method 1

//        groceryList.findItem2("D");//finding item method 2

//        groceryList.findItem3("D");//finding item method 3

//        groceryList.findItem4("C");//finding item method 4

//        groceryList.findItem5("C");//finding item method 5

        printInstructions();
        boolean quit = false;
        int choice = 0;
        while (!quit) {
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;

            }

        }

    }

    private static void processArrayList() {
        ArrayList<String> newArraylist = new ArrayList<>();
        newArraylist.addAll(groceryList.getGroceryList());

        //another way of doing this
        ArrayList<String> anotherArray = new ArrayList<>(groceryList.getGroceryList());
    }

    private static void searchItem() {
        System.out.print("Item to search for:");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Item:" + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }
    }

    private static void removeItem() {
        System.out.print("Enter Item Name:");
        String itemName = scanner.next();
        groceryList.removeGroceryItem(itemName);
    }

    private static void modifyItem() {
        System.out.print("Enter Item Name:");
        String currentItem = scanner.nextLine();
        System.out.print("Enter replacement item:");
        String newItem = scanner.nextLine();
        groceryList.modifyItem(currentItem, newItem);
    }

    private static void addItem() {
        System.out.print("Enter the new item:");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    private static void printInstructions() {
        System.out.print("Press");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To print the grocery items");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list");
        System.out.println("\t 4 - To remove an item from the list");
        System.out.println("\t 5 - To search an item from the list");
        System.out.println("\t 6 - To print the whole array");
        System.out.println("\t 7 - To quit the application");

    }


}
