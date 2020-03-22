package org;

import org.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Service
public class Client {

    RestTemplate restTemplate = new RestTemplate();
    Scanner s = new Scanner(System.in);

    final String EMPLOYEE_LIST_URI = "http://localhost:8081/AnnotationSpringMvc/EmployeeController/employeeData";
    final String GET_EMPLOYEE_BY_ID_URI = "http://localhost:8081/AnnotationSpringMvc/EmployeeController/employeeData";
    final String ADD_EMPLOYEE_URI = "http://localhost:8081/AnnotationSpringMvc/EmployeeController/employeeData/add";

    private List<Employee> getEmployeesList(){
        ResponseEntity<Employee[]> response = restTemplate.getForEntity(EMPLOYEE_LIST_URI, Employee[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    private Employee getById(int id) {
        ResponseEntity<Employee> response = restTemplate.getForEntity(GET_EMPLOYEE_BY_ID_URI + "/"+id, Employee.class);
        return response.getBody();
    }

    private HttpStatus addEmployee(Employee employee) {
        ResponseEntity<HttpStatus> response = restTemplate.postForEntity(ADD_EMPLOYEE_URI, employee, HttpStatus.class);
        return response.getBody();
    }

    public void operations(){
        boolean flag = true;
        while(flag){
            System.out.println("1.Get employees list\n2.Get employee by ID\n3.add employee\n4.exit");
            System.out.println("enter te choice");
            int choice = s.nextInt();
            s.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Employee's list: ");
                    for(Employee emp: getEmployeesList()){
                        System.out.println(emp);
                    }
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("enter the id of the employee");
                    int id = s.nextInt();
                    System.out.println(getById(id));
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("enter the id of employee");
                    int empId = s.nextInt();
                    s.nextLine();
                    System.out.println("enter the name");
                    String name = s.nextLine();
                    System.out.println("enter the department");
                    String department = s.nextLine();
                    Employee employee = new Employee(empId, name, department);
                    addEmployee(employee);
                    System.out.println("\n");

                case 4:
                    flag = false;
                    break;
            }
        }
    }


}