package com.controller;

import com.model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/EmployeeController")
@RestController
public class EmployeeController {



    private List<Employee> employeeList;

    @PostConstruct
    private void loadData(){
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "nikhita", "ISE"));
        employeeList.add(new Employee(2, "nikhil", "ISE"));

    }

    @GetMapping("employeeData")
    public List<Employee> getEmployeeList(){

        return employeeList;

    }

    @PostMapping(value = "employeeData/add")
    public void  createEmployee(@RequestBody Employee employee){

        employeeList.add(employee);

    }

    @GetMapping("/employeeData/{studentId}")
    public Employee getEmployeeById(@PathVariable int studentId){
        for(Employee employee: employeeList){
            if(employee.getId() == studentId)
                return employee;
        }
        return null;
    }

}
