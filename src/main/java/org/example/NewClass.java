package org.example;

import java.util.*;

class Mobile {
    private String mobile_num;

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobileNum) {
        this.mobile_num = mobileNum;
    }
}

class Person {
    private String name;
    List<Mobile> numbers;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Mobile> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Mobile> numbers) {
        this.numbers = numbers;
    }

}

public class NewClass {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Paul Jackson");
        Mobile mobNumb1 = new Mobile();
        mobNumb1.setMobile_num("987654321");
        Mobile mobNumb2 = new Mobile();
        mobNumb2.setMobile_num("1234567899");

        List<Mobile> numList = new ArrayList<Mobile>();
        numList.add(mobNumb1);
        numList.add(mobNumb2);

        person.setNumbers(numList);

        System.out.println("Person Numbers :" +person.getNumbers()+ "\n" +"Person Name :"+person.getName());
    }
}
