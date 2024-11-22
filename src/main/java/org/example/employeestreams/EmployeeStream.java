package org.example.employeestreams;

import java.util.*;
import java.util.stream.Collectors;


class Company {
    //Add Employees to the Company
    static List<Employee> getEmployeeList() {
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

public class EmployeeStream {

    public static void main(String[] args) {
        //How many employees are there in the organization?
        //numOfEmployees();

        // Sort the List of Employee objects based on salary in Descending order
        //empListSalDesc();

        //How many male and female employees are there in the organization?
        //maleAndFemaleEmployeesCount();

        //Sort the List of Employee objects based on salary in Ascending order
        // empSalAscending();

        //DoubleSummeryStatistics implementation for max,min,avg,total,count
        // employeeStats();

        //All Employees in each Department
        // listOfEmployeesInEachDepartments();

        //Get the name of all the department
        // getAllDeptName();

        //Find the average salary of the male and female employee
        //averageSalInEachEmployee();

        //Highest Paid Employee
        //highestPaidEmployee();

        //Fetch the highest-paid male and female employee
        //highestPaidMaleAndFemaleEmployee();

        //Fetch the lowest-paid male and female employee
        //lowestPaidMaleAndFemaleEmployee();

        //Get the highest-paid employee in each department
        //highestPaidEmployeeInEachDept();

        //Get the details of the highest paid employee in the organization
        //detailsOfHighestPaidEmployeeInOrg();

        //Find the average salary of each department
        //averageSalInEachDept();

        //Get the details of the youngest male employee in the product development department

        youngestMaleEmployeeDetailsInPD();

        //Find who has the most working experience in the organization.
        //mostExperiencedEmpDetails();

        //Who is the oldest employee in the organization
        //oldestEmployee();

        //What is the average salary and total salary of the whole organization?
        /*For this query, we use Collectors.summarizingDouble() on Employee::getSalary which will
        return statistics of the employee salary like max, min, average and total.*/
        // -->

        //List down the names of all employees in each department
        /*For this query, we will be using Collectors.groupingBy() method
        by passing Employee::getDepartment as an argument.*/
        // -->

        //Separate the employees who are younger or equal to 30 years from those older than 30 years.
        /*For this query, we will be using Collectors.partitioningBy() method
        which separates input elements based on supplied Predicate.*/
        // -->

    }


    /*We will use Stream.filter() method to filter male employees in product development
        department and to find youngest among them,use Stream.min() method.*/
    public static void youngestMaleEmployeeDetailsInPD() {
        Optional<Employee> pdEmployees = Company.getEmployeeList()
                .stream()
                .filter(emp -> Objects.equals(emp.getGender(), "Male")
                        && Objects.equals(emp.getDepartment(), "Product Development"))
                .min(Comparator.comparing(Employee::getAge));
        System.out.println("Youngest Employee details :\n" + pdEmployees.get());
    }

    /*For this query, sort employeeList by yearOfJoining in natural order and first employee
        will have most working experience in the organization.
        To solve this query, we will be using sorted() and findFirst() methods of Stream.*/
    private static void mostExperiencedEmpDetails() {
        Optional<Employee> seniorMostEmp = Company.getEmployeeList()
                .stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
        System.out.println("Most experienced Employee details : \n" + seniorMostEmp.get());
    }

    private static void oldestEmployee() {
        Optional<Employee> oldestEmp = Company.getEmployeeList()
                .stream()
                .max(Comparator.comparingInt(Employee::getAge));
        System.out.println("Most aged Employee Details : \n"+ oldestEmp.get());
    }

    /*For counting the employees we can use two methods and both are
    terminal operations and will give the same result.
        Stream.collect(Collectors.counting())
    */
    private static void numOfEmployees() {
        long count = Company.getEmployeeList()
                .stream()
                .collect(Collectors.counting());
        System.out.println("Number of employees in the org :" + count);
    }

    /*Using sorted() method of stream we order the employeeList*/
    private static void empListSalDesc() {
//        List<Double> employeeNewList = Company.getEmployeeList()
//                .stream()
//                .map(Employee::getSalary)
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList());

        List<Employee> employeeNewList = Company.getEmployeeList()
                .stream()
                .sorted((o1,o2) -> (int) (o1.getSalary() - o2.getSalary()))
                .collect(Collectors.toList());

        // To print only the name and the salary
//        Map<String, Double> newList = employeeNewList.stream()
//                        .collect(Collectors.toMap(
//                                Employee::getName, Employee::getSalary
//                        ));

        System.out.println("List of employees in salary desc order : \n"+ employeeNewList);
        //System.out.println("List of employees in salary desc order : \n" + newList);
    }

    /*We utilize the Collectors.groupingBy() method in this query,
        which accepts two inputs. The first argument is Employee::getGender,
        which groups the input components depending on gender,
        and the second argument is Collectors.counting(), which counts the number of entries
        in each group.*/
    private static void maleAndFemaleEmployeesCount() {
        Map<String, Long> genderWiseEmpList = Company.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Employees based on Male female : \n" + genderWiseEmpList);
    }

    /*For fetching the average salary,
    first we will be grouping the employee based on gender using Collectors.groupingBy() method
    then will apply the Collectors.averagingDouble() method on employees salary
     */
    private static void averageSalInEachEmployee() {
        Map<String, Double> avgSalGenderWise = Company.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                            Collectors.averagingDouble(Employee::getSalary)
                        ));
        System.out.println("Gender wise average salary :" + avgSalGenderWise);
    }

    /*For fetching the highest paid male and female employee,
   first we will be grouping the employee based on gender using Collectors.groupingBy() method
   then will apply the Collectors.maxBy() method on employees salary using Comparator*/
    private static void highestPaidMaleAndFemaleEmployee() {
        Map<String, Optional<Employee>> highestPaidEmpMaleAndFemale = Company.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.maxBy((s1,s2) -> (int) (s1.getSalary() - s2.getSalary()))
                ));
        System.out.println("Highest paid male and female employee : \n" + highestPaidEmpMaleAndFemale);
    }

    /*we will apply the Collectors.minBy() method on employees salary using Comparator*/
    private static void lowestPaidMaleAndFemaleEmployee() {
        Map<String, Optional<Employee>> genderWiseLowestPaidEmp = Company.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.minBy((s1,s2) -> (int) (s1.getSalary() - s2.getSalary()))
                ));
        System.out.println("Lowest paid male and female employee : \n"+ genderWiseLowestPaidEmp);
    }

    /*For getting the highest salary,
    first we will be grouping the employee based on department using
    Collectors.groupingBy() method
    then will apply the Collectors.maxBy() method on employees salary using Comparator*/
    private static void highestPaidEmployeeInEachDept() {
        Map<String, Optional<Employee>> deptWiseHighestPaidEmp = Company.getEmployeeList()
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy((d1,d2) -> (int) (d1.getSalary() - d2.getSalary()))
                ));
//                .entrySet()
//                .stream()
//                .collect(Collectors.toMap(k-> k.getKey(), v -> v.getValue()));
        //System.out.println(deptWiseHighestPaidEmp);
        System.out.println("Department wise employee list");
        for(Map.Entry<String, Optional<Employee>> e : deptWiseHighestPaidEmp.entrySet()) {
            System.out.println("----------------------------------------------");
            System.out.println(e.getKey());
            System.out.println(e.getValue().get());
        }

    }
    

    private static void empSalAscending() {
        List<Employee> employeeListSorted = Company.getEmployeeList().stream().sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).collect(Collectors.toList());
        System.out.println(employeeListSorted);
    }

    /*Use Collectors.maxBy() method which returns maximum element
    wrapped in an Optional object based on supplied Comparator.comparingDouble().*/
    private static void detailsOfHighestPaidEmployeeInOrg() {
        Optional<Employee> empDetailsWithMaxSal = Company.getEmployeeList()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Details of the highest paying employee : \n"+ empDetailsWithMaxSal.get());
    }


    //Employee Stats
    private static void employeeStats() {

        //Total Salary of the employees
        DoubleSummaryStatistics salaryStats = Company.getEmployeeList().stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        DoubleSummaryStatistics ageStats = Company.getEmployeeList().stream()
                .collect(Collectors.summarizingDouble(Employee::getAge));

        //Salary
        System.out.println("Average salary of the employees : " + salaryStats.getAverage());
        System.out.println("Total salary of the employees : " + salaryStats.getSum());
        System.out.println("Max salary of the employees : " + salaryStats.getMax());
        System.out.println("Min salary of the employees : " + salaryStats.getMin());

        //Age
        System.out.println("Average age of the employees : " + ageStats.getAverage());
        System.out.println("Total age of the employees : " + ageStats.getSum());
        System.out.println("Max age of the employees : " + ageStats.getMax());
        System.out.println("Min age of the employees : " + ageStats.getMin());

        System.out.println("Total number of the employees : " + ageStats.getCount());
    }

    //List down the names of all employees in each department.
    private static void listOfEmployeesInEachDepartments() {
        Map<String, List<Employee>> empInEachDept = Company.getEmployeeList()
                .stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entrySet = empInEachDept.entrySet();
        for(Map.Entry<String, List<Employee>> entry : entrySet) {
            System.out.println("------------------------------------");
            System.out.println("For the Department : "+entry.getKey());
            System.out.println("------------------------------------");
            List<Employee> empListInDept = entry.getValue();
            for(Employee emp : empListInDept) {
                System.out.println(//"ID : " + emp.getId()+
                        " Name : " + emp.getName()
                        //+", Year of joining : " + emp.getYearOfJoining()
                        //+", Gender : " + emp.getGender()
                );
            }
        }
    }

    /*Here we will be using
    first map() to map the departments in to the stream
    then distinct() method on department
    to get the list of department without consisting duplicate values*/
    private static void getAllDeptName() {
        List<String> deptNames = Company.getEmployeeList()
                .stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List of all department : " + deptNames);
    }

    //Get the details of the highest paid employee in the organization
    /*Use Collectors.maxBy() method which returns maximum element wrapped in
     an Optional object based on supplied Comparator. */
    private static void highestPaidEmployee() {
        Optional<Employee> highestPaidEmp = Company.getEmployeeList().stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        if(highestPaidEmp.isPresent()) {
            Employee highestPaidEmpDetails = highestPaidEmp.get();
            System.out.println(highestPaidEmpDetails);
        } else
            System.out.println("System Error......!!");
    }

    //Find the average salary of each department
    //------------------------------------------------------------------------------------//
    /*For getting the average salary,
    first we will be grouping the employee based on department using Collectors.groupingBy() method
    then will apply the Collectors.averagingDouble() method on employees salary*/
    private static void averageSalInEachDept() {
        Map<String, Double> empSalDeptData =  Company.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        for(Map.Entry<String, Double> entry : empSalDeptData.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

}
