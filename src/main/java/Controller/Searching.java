/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Controller;

/**
 *
 * @author DAO
 */
import common.Algorithm;
import common.Library;
import Model.Element;
import view.Menu;

public class Searching extends Menu<String> {

    static String[] mc = {"Search", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public Searching(Element element) {
        super("Searching programming", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }

    @Override
    public void execute(int n) {
        
             switch (n) {
            case 1:
                search();
                break;
            
                
            case 2:
                System.exit(0);
                break;
             default:
                 System.out.println("Try again");
                 break;
            }
        
       
    }

    public void search() {
        final String[] mcSearch = {"Binary Search", "Linear Search", "Exit"};
        class SearchMenu extends Menu<String> {

            public SearchMenu() {
                super("Search Option", mcSearch);
            }

            @Override
            public void execute(int n) {
                switch (n) {
                    case 1 -> {
                        System.out.println("Unsorted array: ");
                        library.display(array);
                        algorithm.bubbleSort(array);

                        System.out.println("\nSorted array by Bubble Sort: ");
                        library.display(array);
                        int x = library.getInteger("Enter a number that You want to search: ");
                        int result = algorithm.binarySearch(array, x, 0, array.length - 1);
                        if (result != -1) {
                            System.out.println("The element you want to find in the index: " + result);
                        } else {
                            System.out.println(
                                    "Element is not present in array");
                        }
                        break;
                    }
                    case 2 -> {
                        library.display(array);
                        int x = library.getInteger("Enter a number that You want to search: ");
                        int result=algorithm.LinearSearch(array, x);
                       if (result != -1) {
                            System.out.println("The element you want to find in the index: " + result);
                        } else {
                            System.out.println(
                                    "Element is not present in array");
                        }
                       break;
                    }
                   
                    case 3 ->{
                        break;
                    }
                        
                        
                }
            }
        }
        SearchMenu sm = new SearchMenu();
        sm.run2();
    }
}
