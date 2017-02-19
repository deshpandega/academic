/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.patient;

import java.text.DecimalFormat;
import java.util.Date;
import source.employee.Employee;

/**
 *
 * @author GaurangDeshpande
 */
public class Procedure extends Visit{
    private String procedureType;
    private String procedureDescription;
    private Employee requestedBy;
    private Employee completedBy;
    private Patient performedOn;
    private String status;
    private Date requestDate;
    private Date completionDate;
    private String procedureID;
    private static int count = 0;

    public Procedure() {
        DecimalFormat format = new DecimalFormat("000");
        procedureID="PROS"+format.format(++count);
    }

    public String getProcedureID() {
        return procedureID;
    }
    public void setProcedureID(String procedureID) {
        this.procedureID = procedureID;
    }

    public String getProcedureType() {
        return procedureType;
    }
    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String getProcedureDescription() {
        return procedureDescription;
    }
    public void setProcedureDescription(String procedureDescription) {
        this.procedureDescription = procedureDescription;
    }

    public Employee getRequestedBy() {
        return requestedBy;
    }
    public void setRequestedBy(Employee requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Employee getCompletedBy() {
        return completedBy;
    }
    public void setCompletedBy(Employee completedBy) {
        this.completedBy = completedBy;
    }

    public Patient getPerformedOn() {
        return performedOn;
    }
    public void setPerformedOn(Patient performedOn) {
        this.performedOn = performedOn;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }
    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}