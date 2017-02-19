/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.hospital;

import source.department.Department;
import source.department.DepartmentDirectory;
import source.util.StaticVariableCounterCollection;

/**
 *
 * @author GaurangDeshpande
 */
public abstract class Hospital extends Department{
    private String hospitalBranchName;
    private DepartmentDirectory departmentDirectory;
    private StaticVariableCounterCollection collectionCount;

    public Hospital(String name, String hospitalBranchName) {
        super(name);
        this.hospitalBranchName = hospitalBranchName;
        departmentDirectory = new DepartmentDirectory();
        collectionCount = new StaticVariableCounterCollection();
    }

    public String getHospitalBranchName() {
        return hospitalBranchName;
    }

    public DepartmentDirectory getDepartmentDirectory() {
        return departmentDirectory;
    }

    public StaticVariableCounterCollection getCollectionCount() {
        return collectionCount;
    }
    public void setCollectionCount(StaticVariableCounterCollection collectionCount) {
        this.collectionCount = collectionCount;
    }
    
    @Override
    public String toString() {
        return hospitalBranchName;
    }
}