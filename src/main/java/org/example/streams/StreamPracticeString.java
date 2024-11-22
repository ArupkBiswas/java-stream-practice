package org.example.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPracticeString {
    public static void main(String[] args) {
        String str = "Apple is fallen";
        String str2  = "truffle";
        wordCount(str);
        removeDuplicateWords(str2);
    }

    private static void removeDuplicateWords(String str2) {
        System.out.println(str2.toLowerCase().chars().mapToObj(c->(char) c).collect(Collectors.toSet()));
    }

    //Split it into character list
    //replace all space (optional)
    private static void wordCount(String str) {
        Map<Character, Long> wdMap = str
                .replaceAll("\\s", "")
                .chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
        System.out.println(wdMap);
    }
}


