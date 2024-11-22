package org.example.java8feat;

@java.lang.FunctionalInterface
interface Square<T> {
    default void print(){
        System.out.println("print this output...!!");
    }
    T calculate(int x);
}

public class FunctionalInterface{

    public static void main(String[] args){
        int a = 2;
        Square<Integer> sq = (int x) -> x*x;
        int ans = sq.calculate(a);
        sq.print();
        System.out.println(ans);
    }

}
