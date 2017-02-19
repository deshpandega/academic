/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.employee;

import java.util.ArrayList;

/**
 *
 * @author GaurangDeshpande
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(){
        Employee employee = new Employee();
        employeeList.add(employee);
        return employee;
    }
    
    public void deleteEmployee(Employee delEmployee){
        employeeList.remove(delEmployee);
    }
}
