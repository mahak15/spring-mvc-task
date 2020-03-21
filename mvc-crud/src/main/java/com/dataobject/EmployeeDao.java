package com.dataobject;


import com.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {

    JdbcTemplate template;


    public EmployeeDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int save(Employee emp){
        String sql="INSERT INTO employee11 (id, name, department)"
                + " VALUES (?, ?, ?)";
        return template.update(sql, emp.getId(), emp.getName(), emp.getDepartment());
    }
    public int update(Employee emp){
        String sql="update employee11 set name=?, department=? where id=?";
        return template.update(sql, emp.getName(), emp.getDepartment(), emp.getId());
    }
    public int delete(int id){
        String sql="delete from employee11 where id="+id+"";
        return template.update(sql);
    }
    public Employee getEmpById(int id){
        String sql="select * from employee11 where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
    }
    public List<Employee> getEmployees(){

        return template.query("select * from employee11", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee employee = new Employee();

                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));

                return employee;
            }

        });
    }
}