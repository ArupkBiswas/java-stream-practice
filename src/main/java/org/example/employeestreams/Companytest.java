package org.example.employeestreams;

import java.util.ArrayList;
import java.util.List;

public class Companytest {
    //Add Employees to the Company
    public static List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jeniffer", 22, "Female", "HR", 2020, 30000));
        employeeList.add(new Employee(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
        employeeList.add(new Employee(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
        employeeList.add(new Employee(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
        employeeList.add(new Employee(115, "Prashant",40,"Male","HR",2023,30000));
        employeeList.add(new Employee(115, "Molly",55,"Female","Tech",2022,45000));
        employeeList.add(new Employee(115, "Darshan",45,"Male","HR",2023,40000));
        employeeList.add(new Employee(115, "Rahul",50,"Male","Board Members",2010,70000));

        return employeeList;
    }
}
