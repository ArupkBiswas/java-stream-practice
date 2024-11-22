//class A {
//    void m1 () {
//        System.out.println("A");
//    }
//}
//
//class B extends A {
//    void m2() {
//        System.out.println("B");
//    }
//}
//
//class c {
//    void m3() {
//        try {
//            System.out.println("Print try");
//        } catch(Exception ex) {
//            System.out.println("Print catch "+ex);
//        } finally {
//            System.out.println("Print finally");
//        }
//    }
//}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> newMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            newMap.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++) {
            int complement = target-nums[i];
            if(newMap.containsKey(complement) && newMap.get(complement) != i) {
                return new int[] {i, newMap.get(complement)};
            }
        }
        return null;
    }
}


class Main {

    public static void main(String[] args) {
//        B ne = new B();
//        ne.m1();
        int[] arr = {2,3,4,1};
        int target = 5;
        int[] nuArr = Solution.twoSum(arr, target);
        System.out.println(Arrays.toString(nuArr));
    }
}











