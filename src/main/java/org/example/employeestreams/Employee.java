package org.example.employeestreams;

//Define Employee Class
public class Employee {
        int id;
        String name;
        int age;
        String gender;
        String department;
        int yearOfJoining;
        double salary;

        Employee(int id,
                        String name,
                        int age,
                        String gender,
                        String department,
                        int yearOfJoining,
                        double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.department = department;
            this.yearOfJoining = yearOfJoining;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }
        public int getAge() {
            return age;
        }
        public String getName() {
            return name;
        }
        public String  getGender() {
            return gender;
        }
        public String getDepartment() {
            return department;
        }
        public int getYearOfJoining() {
            return yearOfJoining;
        }
        public double getSalary() {
            return salary;
        }

        //We need to override the method or else stream will return objects rather then values
        @Override
        public String toString()
        {
            return "Id : "+id
                    +", Name : "+name
                    +", age : "+age
                    +", Gender : "+gender
                    +", Department : "+department
                    +", Year Of Joining : "+yearOfJoining
                    +", Salary : "+salary;
        }
}
