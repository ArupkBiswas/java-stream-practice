package org.example;

import java.util.Arrays;
import java.util.List;

public class testClass {
    public static void main(String[] args)
    {
        // Creating a List of Lists
        String a = "hello";
        a = "world";
        System.out.println(a);

        // Using Stream flatMap(Function mapper)
//        listOfLists.stream()
//                .flatMap(list -> list.stream())
//                .forEach(System.out::println);
    }
}





//String a = 'hello;
//a = 'world';
//        System.out.println(a);
//
//
//String a = 'hello;
//a = 'world';
//        System.out.println(a);
//
//
//
//
//
//1.
//inArr = [2,4,3,6,5,7,5,3,4,5]
//outArr = [2,4,3,6,5,7]
//
//
//List<Integer> removeDupes(inArr){
//    Set<Integer> set = new LinkedHashSet<Integer>() ;
//    List<Integer> list = Arrays.stream(inArr).filter(n -> set.add(n)).collect(Collerctors.toList());
//
//}
//
//
//2.
//shop   cost     item
//1        1        a
//1        4        b
//2        2        a
//2        1        c
//3        1        a
//3        1        b
//
//
//to buy => a,b
//
//output : 3, 2
//
//class costItm {
//    int cost;
//    String item;
//
//    costItem(int cost, String item){
//        this.cost = cost;
//        this.item = item;
//    }
//
//    int getCost() {
//        return cost;
//    }
//
//    String getItem() {
//        return item;
//    }
//
//}
//
//Map<Integer, costItm> shopNew = new HashMap<>();
//
//public int[] costData (String[] arr) {
//
//}





