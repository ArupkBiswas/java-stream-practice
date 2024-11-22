package org.example.employeestreams;

import java.net.CookieHandler;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeStreamP1 {
    public static void main(String[] args) {
        //fetchFemaleEmpPerDeptHighestPaid();
        //heighestSalary();
        genderWiseSegregation();
    }

    private static void genderWiseSegregation() {
        Map<Boolean, List<Employee>> newMap =  Company.getEmployeeList().stream()
                .collect(Collectors.partitioningBy(n -> "Male".equals(n.getGender())));

        List<Employee> maleEmp = newMap.get(true);
        List<Employee> femaleEmp = newMap.get(false);

        System.out.println(maleEmp);
        System.out.println(femaleEmp);
    }

    private static void heighestSalary() {
       Optional<Employee> employeeName = Company.getEmployeeList()
               .stream()
               .max((d1,d2) -> (int) (d1.getSalary() - d2.getSalary()));

        System.out.println("Employee with highest salary : "+employeeName.get().getName());

    }

    private static void fetchFemaleEmpPerDeptHighestPaid() {
        List<Employee> listDept = Company.getEmployeeList()
                .stream()
                .filter(n -> Objects.equals(n.getGender(), "Female"))
                .toList();

        Map<String, Optional<Employee>> deptWiseFEMP = listDept.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy((d1,d2) -> (int) (d1.getSalary() - d2.getSalary()))
                ));

        System.out.println("Dept wise highest salaried female employee");
        System.out.println("------------------------------------------");
        for(Map.Entry<String, Optional<Employee>> e : deptWiseFEMP.entrySet()) {
            System.out.println(e.getKey() +" : "+ e.getValue().get().getName());
        }
    }



}
