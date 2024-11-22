package org.example;

/*
Write a Java static function which will accept a list of Integer,
and it will return only non-repeatable numbers from the given a list of Integer.

        INPUT - 2,1,2,4,1,2,3,2
OUTPUT - 4,3 */

class Singleton {
    private static Singleton new_instance = null;

    public String newString;

    private Singleton() {
        newString = "This is a singleton class";
    }

    public static Singleton getInstance(){
        if (new_instance == null) {
            synchronized (Singleton.class){
                if (new_instance == null)
                    new_instance = new Singleton();
            }
        }
        return new_instance;
    }

}

class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton.getInstance();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton.getInstance();
            }
        });

        t1.start();
        t2.start();
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();

        System.out.println("Hashcode of x is " + x.hashCode());
        System.out.println("Hashcode of y is " + y.hashCode());
    }
}