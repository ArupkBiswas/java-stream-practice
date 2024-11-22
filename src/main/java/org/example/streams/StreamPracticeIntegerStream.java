package org.example.streams;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CheckNumbers {
    public static boolean isPrime(int num) {
        if(num <=1)
            return true;
        for(int i=2; i< Math.sqrt(num); i++)
            if(num%i == 0)
                return false;
        return true;
    }
}

public class StreamPracticeIntegerStream {
    public static void main(String[] args) {
        String[] str = {"flower", "flag", "float", "flat"};
        String strName = "arupkumarbiswas";
       // removeDuplicateElements();
        longCommPrefix(str);
        secondNonRepetitiveCharacter(strName);
    }

//    private static void removeDuplicateElements() {
//        int[] arr = {20,30,40,50,20,40,50,70};
//
//        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(
//              Function.identity(),
//              Collectors.counting()
//        )).forEach((number, count) -> {
//            System.out.println(number +" is present "+count+" times ");
//        });
//
//
//        //List<Integer> integerList = Arrays.asList(20,30,40,50,20,40,50,70);
//        Integer secondLargestInt = IntStream.of(arr).boxed()
//                .distinct()
//                .sorted(Comparator.reverseOrder())
//                .skip(1)
//                .findFirst()
//                .orElse(-1);
//
//        System.out.println("second largest integer : "+secondLargestInt);
//
//        Set<Integer> s = new HashSet<>();
//        List<Integer> remDupNum = Arrays.stream(arr).filter(s::add).boxed().toList();
//
//                //Arrays.stream(arr).distinct().mapToObj(n -> (int) n).toList();
//
//        System.out.println(" Integer array after removing duplicates : "+remDupNum);
//    }

    private static void longCommPrefix(String[] str){
        String longComPre = Arrays.stream(str).reduce((s1,s2) -> {
            int len = Math.min(s1.length(), s2.length());
            int i = 1;
            while(i<len && s1.charAt(i) == s2.charAt(i)) {
                i++;
            }
            return s1.substring(0,i);
        }).orElse("");
        System.out.println("Longest common prefix is "+ longComPre);
    }

    private static void secondNonRepetitiveCharacter(String str) {
        //we will create a frequency map of the characters in the string keeping the sequence .
        // use chars().mapToObj(c-> (char) c) to convert the string into a char stream
        // use LinkedHashMap to
//        Map<Character, Long> freqMap = str
//                .chars()
//                .mapToObj(c->(char)c)
//                .collect(
//                        Collectors.groupingBy(
//                                Function.identity(),
//                                LinkedHashMap::new,
//                                Collectors.counting()
//                        )
//                );
//
//        Character NonRepChar = freqMap
//                .entrySet()
//                .stream()
//                .filter(n -> n.getValue() == 1L)
//                .map(Map.Entry::getKey)
//                .skip(1)
//                .findFirst().get();

        Character NonRepChar = str
                .chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                    )
                )
                .entrySet()
                .stream()
                //.filter(n-> n.getValue() == 1L)
                .map(Map.Entry::getKey)
                .skip(2)
                .findFirst()
                .get();

        System.out.println("2nd non repetitive character : "+ NonRepChar);
    }

}
