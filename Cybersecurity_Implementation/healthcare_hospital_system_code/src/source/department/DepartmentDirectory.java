/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.department;

import java.util.ArrayList;
import source.department.Department.DepartmentType;

/**
 *
 * @author GaurangDeshpande
 */
public class DepartmentDirectory {
    private ArrayList<Department> departmentList;

    public DepartmentDirectory() {
        departmentList = new ArrayList<>();
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }
    
    public Department createDepartment(DepartmentType departmentType){
        Department department = null;
        if(departmentType.getValue().equals(DepartmentType.Admission.getValue())){
            department = new AdmissionDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Anesthesia.getValue())){
            department = new AnesthesiaDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Emergency.getValue())){
            department = new EmergencyDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Gynecology.getValue())){
            department = new GynecologyDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Laboratory.getValue())){
            department = new LaboratoryDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Nursing.getValue())){
            department = new NursingDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Neurology.getValue())){
            department = new NeurologyDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Pediatrics.getValue())){
            department = new PediatricsDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Security.getValue())){
            department = new SecurityDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.Surgery.getValue())){
            department = new SurgeryDepartment();
            departmentList.add(department);
        }
        else if(departmentType.getValue().equals(DepartmentType.XRay.getValue())){
            department = new XRayDepartment();
            departmentList.add(department);
        }
        return department;
    }
    
    public void deleteDepartment(Department department){
        departmentList.remove(department);
    }
}
