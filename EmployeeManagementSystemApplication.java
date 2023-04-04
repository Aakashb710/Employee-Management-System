package com.example.test;

import com.example.test.dao.EmployeeRepository;
import com.example.test.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.awt.desktop.SystemEventListener;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeeManagementSystemApplication.class, args);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        Scanner sc= new Scanner(System.in);


        while (true)
        {
            System.out.println("Enter a number to perform an operation");
            System.out.println("1. Add an employee");
            System.out.println("2. Update an employee");
            System.out.println("3. Delete a particular employee");
            System.out.println("4. Delete all employee records");
            System.out.println("5. Show all the employee records");
            System.out.println("6. Exit");
            System.out.println();

            System.out.println("Enter your choice");
            int choice = sc.nextInt();


            switch (choice)
            {
                case 1:
                    addUser(employeeRepository);
                    break;

                case 2:
                    updateRecord(employeeRepository);
                    break;

                case 3:
                    deleteEmployee(employeeRepository);
                    break;

                case 4:
                    deleteAll(employeeRepository);
                    break;

                case 5:
                    showAll(employeeRepository);
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid choid, enter a valid choice");
                    break;
            }

        }

    }

    private static void addUser(EmployeeRepository emp)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter firstname of employee");
        String firstName=sc.nextLine();

        System.out.println("Enter middlename of employee");
        String middleName=sc.nextLine();

        System.out.println("Enter lastname of employee");
        String lastName=sc.nextLine();

        System.out.println("Enter address of employee");
        String address=sc.nextLine();

        System.out.println("Enter jobrole of employee");
        String jobrole=sc.nextLine();

        System.out.println("Enter gender of employee");
        String gender=sc.nextLine();

        System.out.println("Enter phoneNo of employee");
        String phoneNo=sc.nextLine();

        System.out.println("Enter marital status of employee");
        String maritalStatus=sc.nextLine();

        Employee employee = new Employee();
        employee.setFirstname(firstName);
        employee.setMiddlename(middleName);
        employee.setAddress(address);
        employee.setJobrole(jobrole);
        employee.setGender(gender);
        employee.setPhoneNo(phoneNo);
        employee.setMaritalStatus(maritalStatus);


        Employee e1 = emp.save(employee);
        System.out.println("User Added");
        System.out.println("-------------------------------");
        System.out.println("\n");
    }


    private static void updateRecord(EmployeeRepository emp)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id");
        int id = sc.nextInt();
       Optional<Employee> it = emp.findById(id);

       if(it.isPresent())
       {
           Employee e1 = it.get();

           System.out.println("Enter what you want to update");
           String s = sc.nextLine();

           if(s.equalsIgnoreCase("firstname"))
           {
               System.out.println("Enter Firstname");
               String firstname = sc.nextLine();
               e1.setFirstname(firstname);
           }

           if(s.equalsIgnoreCase("middlename"))
           {
               System.out.println("Enter middlename");
               String middlename = sc.nextLine();
               e1.setMiddlename(middlename);
           }

           if(s.equalsIgnoreCase("lastname"))
           {
               System.out.println("Enter lastname");
               String lastname = sc.nextLine();
               e1.setLastname(lastname);
           }

           if(s.equalsIgnoreCase("address"))
           {
               System.out.println("Enter new address");
               String address = sc.nextLine();
               e1.setAddress(address);
           }

           if(s.equalsIgnoreCase("jobrole"))
           {
               System.out.println("Enter new jobrole");
               String jobrole = sc.nextLine();
               e1.setJobrole(jobrole);
           }

           if(s.equalsIgnoreCase("gender"))
           {
               System.out.println("Enter gender");
               String gender = sc.nextLine();
               e1.setGender(gender);
           }

           if(s.equalsIgnoreCase("phoneno"))
           {
               System.out.println("Enter new phone no");
               String phoneno = sc.nextLine();
               e1.setPhoneNo(phoneno);
           }

           if(s.equalsIgnoreCase("maritalstatus"))
           {
               System.out.println("Enter maritalstatus");
               String maritalstatus = sc.nextLine();
               e1.setGender(maritalstatus);
           }
           Employee e2 = emp.save(e1);
           System.out.println("Record Updated");
       }
       else
       {
           System.out.println("No record found with these id");
       }

        System.out.println("--------------------------------------------------");
        System.out.println();
    }


    private static void deleteEmployee(EmployeeRepository emp)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to delete");
        int id = sc.nextInt();

       if (emp.existsById(id))
       {
           emp.deleteById(id);
           System.out.println("Record with this id has been deleted");
       }
       else
       {
           System.out.println("No record found to delete");
       }
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

    private static void deleteAll(EmployeeRepository emp)
    {
        Iterable<Employee> it = emp.findAll();
        emp.deleteAll(it);
        System.out.println("All record has been deleted");
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

    private static void showAll(EmployeeRepository emp)
    {
        Iterable<Employee> list = emp.findAll();
        System.out.println("All employee records");
        list.forEach(ll-> System.out.println(ll));
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

}
