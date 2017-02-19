/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.workQueue;

import java.util.Date;
import source.employee.Employee;
import source.userAccount.UserAccount;

/**
 *
 * @author GaurangDeshpande
 */
public class WorkRequest {
    private String message;
    private Employee requestCreator;
    private Employee requestAssignee;
    private String status;
    private Date requestCreationDate;
    private Date resuestResolutionDate;
    private String requestOutcome;

    public WorkRequest() {
        requestCreationDate = new Date();
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Employee getRequestCreator() {
        return requestCreator;
    }
    public void setRequestCreator(Employee requestCreator) {
        this.requestCreator = requestCreator;
    }

    public Employee getRequestAssignee() {
        return requestAssignee;
    }
    public void setRequestAssignee(Employee requestAssignee) {
        this.requestAssignee = requestAssignee;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestCreationDate() {
        return requestCreationDate;
    }
    public void setRequestCreationDate(Date requestCreationDate) {
        this.requestCreationDate = requestCreationDate;
    }

    public Date getResuestResolutionDate() {
        return resuestResolutionDate;
    }
    public void setResuestResolutionDate(Date resuestResolutionDate) {
        this.resuestResolutionDate = resuestResolutionDate;
    }   

    public String getRequestOutcome() {
        return requestOutcome;
    }
    public void setRequestOutcome(String requestOutcome) {
        this.requestOutcome = requestOutcome;
    }
    
    public String toString(){
        return message;
    }
}