//Second highest in the integer array.
package org.example;

import java.util.*;

public class PalindromeProgram {
    public static void main(String[] args){
        int[] newArr = {1,2,3,4,5,6,2,5,5,6};
//        List<Integer> newIntArr = Arrays.stream(newArr).boxed().toList();
//
//        Optional<Integer> secondLargest = newIntArr.stream().distinct().sorted(Comparator.reverseOrder())
//                .skip(1)
//                .findFirst();
//
//        System.out.println(secondLargest);
        palindromeCheck();
    }

    private static boolean isPalindrome(String str) {
        int len = str.length();
        for(int i=0; i< len/2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    private static void palindromeCheck() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(isPalindrome(str)) {
            System.out.println("String is palindrome : ");
        } else {
            System.out.println("String is not palindrome : ");
        }
    }

}



