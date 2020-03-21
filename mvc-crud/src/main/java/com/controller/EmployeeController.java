package com.controller;

import com.dataobject.EmployeeDao;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.util.List;

@RequestMapping("/EmployeeController")
@RestController
public class EmployeeController {


    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ModelAndView readStudent(ModelAndView model) throws IOException {

        List<Employee> listEmployee = employeeDao.getEmployees();
        model.addObject("listEmployee", listEmployee);
        model.setViewName("read");
        return model;
    }

    @PostMapping(value = "/create")
    public ModelAndView createEmployee(@RequestBody Employee employee, ModelAndView mv) {



        int performed = employeeDao.save(employee);

        if (performed > 0) {
            mv.addObject("msg", "Employee registration successful.");
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("create");

        return mv;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@RequestBody Employee employee,  ModelAndView mv) {


        int performed = employeeDao.update(employee);

        if (performed > 0) {
            mv.addObject("msg", "Employee records updated against Employee Id: " + employee.getId());
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("update");

        return mv;
    }

    @RequestMapping(value = "/delete/{employeeId}")
    public ModelAndView deleteStudentById(ModelAndView mv, @PathVariable("employeeId") int employeeId)
            throws IOException {

        int performed = employeeDao.delete(employeeId);

        if (performed > 0) {
            mv.addObject("msg", "Employee records deleted against Employee Id: " + employeeId);
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("delete");

        return mv;
    }

}