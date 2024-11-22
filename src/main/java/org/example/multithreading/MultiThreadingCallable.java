package org.example.multithreading;

import java.util.concurrent.*;

/*
* public interface Callable<V> {
*   V call() throws Exception
* }
* */

class CallableDemo {
    int num;

    CallableDemo (int num) {
        this.num = num;
    }

    //

//    @Override
//    public Long call() throws Exception {
//        long fact = 1;
//        for(int i = num; i > 1; i--) {
//            fact *= i;
//        }
//        return fact;
//    }
}

public class MultiThreadingCallable {
    public static void main(String[] args) throws Exception {

    }
}
