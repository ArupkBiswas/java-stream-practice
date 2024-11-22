package org.example;

import javax.crypto.spec.PSource;

@FunctionalInterface
interface Operation<T> {
    T performOperation(T t, T d);
}

public class GenericsImpl {
    public static void main(String[] args) {
        int a = 2, b = 3;
        Operation<Integer> op1 = Integer::sum;
        Operation<Integer> op2 = (Integer x, Integer y) -> x - y;
        int nas = op1.performOperation(a,b);
        int ans2 = op2.performOperation(a,b);
        System.out.println("Answer of op 1 : " + nas + "\n" +"Answer of op 2 : "+ ans2);
    }
}
