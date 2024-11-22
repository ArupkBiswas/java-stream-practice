package org.example.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class PersonStream {
    int age;
    String userName;

    public  PersonStream (String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String getUserName(){
        return userName;
    }

}

class Transaction {
    String date;
    int amount;

    public Transaction(String date, int amount) {
        this.amount = amount;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}

public class StreamPractice {
    public static void main(String[] args) {
        int[] arr = {1,4,2,6,9,3,3,5,7};
        int[] arr2 = {2,3,4,5,5,5,2,6,3,8,5};
        int[] arr3 = {55,33,22,88,77,99};
        String str = "printing the string that has repetitive letters";
        String[] strArr = {"Apple", "Banana", "Guava", "Pineapple", "Watermellone"};
        String[] strArr2 = {"Apple", "Banana", "Guava", "Pineapple", "Guava", "Watermellone", "Banana"};
        longestString(strArr);
        averageAgeOfTheListOfPerson();
        primeNumberCheck();
        margeTwoList(arr,arr2);
        removeDuplicates(arr2);
        sumOfTransactions();
        kthSmallestElement(arr3);
        frequencyOfEachWord(strArr2);
        listPartition();
         //fibonacciSeries();
         //medianOfTheList(arr2);
        longestCommonPrefixInString(strArr2);
        maximumProductOfTwoIntegersInList(arr);
        occurrencesOfGivenCharacter(str);
                twoSumProblem(arr);
                nonDuplicateIntegers(arr2);

        printTheCountOfTheCharsInASting(str);
        firstNonRepetitive(str);
       cubeOfTheElements(arr);

       numberOfDuplicateElementsInIntArray(arr2);



//        margeTwoList(arr,arr2);

        //someList();
    }


    private static void longestCommonPrefixInString(String[] str) {
        List<String> list = Arrays.asList(str);
        String longestCommPrefix = list.stream().reduce(
                (s1,s2) -> {
                    int length = Math.min(s1.length(), s2.length());
                    int i=0;
                    while(i<length && s1.charAt(i) == s2.charAt(i)){
                        i++;
                    }
                    return s1.substring(0,i);
                }
        ).orElse("");

//        String longestCommPostfix = list.stream().reduce(
//                (s1,s2) -> {
//                    int length = Math.min(s1.length(), s2.length());
//                    int i=0;
//                    while(i<length && s1.charAt(i) == s2.charAt(i)){
//                        i++;
//                    }
//                    return s1.substring(0,i);
//                }
//        ).orElse("");

        System.out.println("Longest common prefix : " + longestCommPrefix);
    }


//    private static void medianOfTheList(int[] arr) {
//        int length = arr.length;
//        OptionalDouble median = length%2 == 0 ?
//    }

    private static void sumOfTransactions() {
        List<Transaction> empTransactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, Integer> sumByDate = empTransactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getDate,
                        Collectors.summingInt(Transaction::getAmount)));

        System.out.println(sumByDate);
    }

    private static void maximumProductOfTwoIntegersInList(int[] arr) {
        int maxProduct = IntStream
                .range(0, arr.length)
                .mapToObj(i-> IntStream.range(i+1,arr.length)
                        .map(j->arr[i]*arr[j])
                        .max()
                        .orElse(Integer.MIN_VALUE))
                .max(Integer::compare).orElse(Integer.MIN_VALUE);
        System.out.println("Maximum Product for the given int array :" + maxProduct);

    }
    private static void occurrencesOfGivenCharacter(String str) {
        char givenChar = 't';
        List<Character> charList = str.chars().mapToObj(c -> (char) c).toList();
        Map<Character, Long> occurences = charList
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(n -> n.getKey() == givenChar)
                .collect(Collectors.toMap(n -> n.getKey(), n-> n.getValue()));

        System.out.println(occurences);
    }

    private static void frequencyOfEachWord(String[] str) {
        List<String> words = Arrays.asList(str);
        Map<String, Long> freqMap = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of each word in a list"+freqMap);
    }

    public static void removeDuplicates(int[] nums) {
       List<Integer> integerList = Arrays.stream(nums).boxed().toList();
       System.out.println("List after removing the duplicates : "+integerList
               .stream()
               .distinct()
               .collect(Collectors.toList())
       );

       // Directly collecting the list into the set via collector
//        System.out.println("List after removing the duplicates : "+integerList
//                .stream()
//                .collect(Collectors.toSet())
//        );

//        Set<Integer> newSet = new HashSet<>(intLit);
//        System.out.println("List after removing the duplicates : "+newSet);
    }

    private static void printTheCountOfTheCharsInASting(String str) {
        Map<String, Long> strMap = Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strMap);
        List<String> newLIst = Arrays.stream(str.split("\\s", 0)).toList();
        System.out.println(newLIst);
    }


    private static void firstNonRepetitive(String str) {
        Character newTEst =  str.chars().mapToObj(c-> (char) c).filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch)).findFirst().orElse(null);
        System.out.println("First Non-repeatitive element:");
        System.out.println(newTEst);
    }

    //Java 8 program to perform cube on list elements and filter numbers greater than 50.
    public static void cubeOfTheElements(int[] intArr) {
        List<Integer> newList = Arrays.stream(intArr).boxed().toList();
        System.out.println("Cube of the elements in the array");
        newList.stream().map(i -> i*i*i).filter(i -> i>50).forEach(System.out::println);
    }

    //Find non-duplicate integers using streams
    private static void nonDuplicateIntegers(int[] arr2) {
        List<Integer> newIntList = Arrays.stream(arr2).boxed().toList();
        //Count the occurrences of each number
        Map<Integer, Long> frequencyMap = newIntList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //Filter out non-duplicate numbers
        System.out.println("Non-duplicate elements in the array");
        newIntList.stream().filter(num -> frequencyMap.get(num) == 1).forEach(System.out::print);
    }

    //Frequency of Duplicate elements in an array
    private static void numberOfDuplicateElementsInIntArray(int[] arr2) {
        Map<Integer, Long> repetitiveList = Arrays.stream(arr2).boxed().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("\nFrequency of the repetitive elements in the array: \n" +repetitiveList);
    }

    //Prime number using stream
    public boolean isPrime(int num) {
        if(num <= 1)
            return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i ==0)
                return false;
        }
        return true;
    }

    public void primeNumber() {
        int[] arr = {2,3,4,6,7,2,5};
        boolean primeNum = Arrays.stream(arr).boxed().allMatch(this::isPrime);
        System.out.println("List contains Prime Numbers: " + primeNum);
    }

    private static void primeNumberCheck() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean prime = IntStream.range(2, (num/2)+1).noneMatch(i->num%i == 0);
        if(prime)
            System.out.println("Prime");
        else
            System.out.println("Non Prime");
    }

    //Kth smallest element
    public static void kthSmallestElement(int[] arr){
        int k = 3;
        int kthSmallest = Arrays.stream(arr).sorted().skip(k-1).findFirst().orElse(-1);
        System.out.println(kthSmallest);
    }

    //Implement a method to partition a list into two groups based on a predicate using Java streams
    public static void listPartition() {
        int[] arr = {10,29,3,22,44,55,33,66,77,88};
        List<Integer> newList = Arrays.stream(arr).boxed().toList();
        Map<Boolean, List<Integer>> partitionList = newList.stream().collect(Collectors.partitioningBy(n->n%2==0));

        List<Integer> evenList = partitionList.get(true);
        List<Integer> oddList = partitionList.get(false);

        System.out.println(evenList);
        System.out.println(oddList);

        System.out.println(partitionList);
    }

    //Longest of the strings
    private static void longestString(String[] strArr) {
        List<String> newList = Arrays.asList(strArr);
        String longestString = newList.stream()
                .max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("Longest string in the list is :"+ longestString);
    }

    //Calculate the average age of a list of Person objects using Java streams
    public static void agvAgePerson() {
//        List<Person> person = Arrays.asList(
//                new Person("Alice", 28),
//                new Person("Dan", 30),
//                new Person("Bob", 20)
//        );

        //double averageAge = person.stream().mapToInt(Person::getAge).average().orElse(-1);
        //System.out.println(averageAge);
    }

    //Merge two sorted lists into a single sorted list using Java streams:
    //use .concat() of the stream function
    private  static void margeTwoList(int[] list1, int[] list2) {
        List<Integer> newList1 = Arrays.stream(list1).boxed().toList();
        List<Integer> newList2 = Arrays.stream(list2).boxed().toList();

        List<Integer> mergedList = Stream.concat(newList1.stream(),newList2.stream()).sorted().toList();
        //Set<Integer> set = new HashSet<>();
        List<Integer> filteredList = mergedList.stream().distinct().toList();
        System.out.println("Merged list is :"+mergedList);
        System.out.println("Filtered list is :"+filteredList);


    }


    //Find the intersection of two lists using Java streams:

    //Remove duplicates from a list while preserving the order using Java streams:


    //Given a list of transactions, find the sum of transaction amounts for each day using Java streams:



    //Given a list of integers, find all pairs of numbers that sum up to a given target using Java streams:
    private static void twoSumProblem (int[] arr) {
        List<Integer> newList = Arrays.stream(arr).boxed().toList();
        int target = 7;
        //Taking the set as there could be duplicate pairs
        Set<String> pairs = newList.stream()
                .flatMap(i-> newList.stream().map(j->i+j == target? "("+i+", "+j+")" : ""))
                .filter(s->!s.isEmpty())
                .collect(Collectors.toSet());
        System.out.println("The target : "+target+" Set :"+pairs);
    }

    //Find the common elements in two list
    private static  void someList() {
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = Arrays.asList(2,2,3,4,5,6,7);
        List<Integer> mergeList = list1.stream().filter(list2::contains).toList();
        System.out.println("List Common elements : " + mergeList);

        List<String> strings = Arrays.asList("flower", "flow", "flight");
        String longestCommonPrefix = strings.stream()
                .reduce((s1, s2) -> {
                    int length = Math.min(s1.length(), s2.length());
                    int i = 0;
                    while (i < length && s1.charAt(i) == s2.charAt(i)) {
                        i++;
                    }
                    return s1.substring(0, i);
                })
                .orElse("");


        List<Integer> newList = Arrays.asList(1,2,3,4,5,6,7);
        //Find the integers in the list and print the highest one
        //Correct one
        System.out.println(newList.stream().filter(n->n%2==0).max(Comparator.naturalOrder()));

        //Alternate
        System.out.println(newList.stream().filter(n -> n % 2 == 0).min(Comparator.reverseOrder()).orElse(0));

        //Minimum
        System.out.println(newList.stream().filter(n->n%2==0).mapToInt(Integer::intValue).min());

    }

    private static void averageAgeOfTheListOfPerson() {
        List<PersonStream> personList = Arrays.asList(
                new PersonStream("Alice", 33),
                new PersonStream("Bob", 23),
                new PersonStream("Charles", 30));


        System.out.println("Average Age of the Employees (double datatype): "+personList
                .stream()
                .mapToInt(PersonStream::getAge)
                .average()
        );

        System.out.println("Average Age of the Employees (integer Datatype): "+personList
                .stream()
                .mapToInt(PersonStream::getAge)
                .average()
                .stream()
                .mapToInt(n-> (int)n)
                .findFirst()
        );

    }

}

 //List<Integer> list2 = list.stream().distinct().collect(Collectors.toList())
