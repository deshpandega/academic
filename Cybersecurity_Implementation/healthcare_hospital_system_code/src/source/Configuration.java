/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import source.employee.Employee;
import source.person.Address;
import source.person.Person;
import source.role.SystemAdminRole;
import source.userAccount.UserAccount;

/**
 *
 * @author GaurangDeshpande
 */
public class Configuration {
    public static EcoSystem configure(){
        EcoSystem ecoSystem = EcoSystem.getInstance();
        
        //Create a network
        
        //create an enterprise
        
        //initialize some organizations
        
        //have some employees 
        
        //create user account
        
        Employee systemAdmin = ecoSystem.getEmployeeDirectory().createEmployee();
        
        Person adminPerson = new Person();
        adminPerson.setFirstName("Gaurang");
        adminPerson.setLastName("Deshpande");
        
        Address adminAddress = new Address();
        systemAdmin.setPerson(adminPerson);
        
        UserAccount userAccount = ecoSystem.getUserAccountDirectory().createUserAccount();
        userAccount.setUsername("sysadmin");
        userAccount.setPassword("sysadmin");
        userAccount.setEmployee(systemAdmin);
        userAccount.setRole(new SystemAdminRole());
        
        return ecoSystem;
    }
}
