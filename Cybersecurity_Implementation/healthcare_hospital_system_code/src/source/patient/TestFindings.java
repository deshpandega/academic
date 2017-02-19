/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.patient;

import java.util.Date;

/**
 *
 * @author GaurangDeshpande
 */
public class TestFindings {
    private int tappingCountBefore;
    private int tappingConntAfter;
    private int averageResponseTimeBefore;
    private int averageResponseTimeAfter;
    private Date timeStamp;

    public int getTappingCountBefore() {
        return tappingCountBefore;
    }
    public void setTappingCountBefore(int tappingCountBefore) {
        this.tappingCountBefore = tappingCountBefore;
    }

    public int getTappingConntAfter() {
        return tappingConntAfter;
    }
    public void setTappingConntAfter(int tappingConntAfter) {
        this.tappingConntAfter = tappingConntAfter;
    }

    public int getAverageResponseTimeBefore() {
        return averageResponseTimeBefore;
    }
    public void setAverageResponseTimeBefore(int averageResponseTimeBefore) {
        this.averageResponseTimeBefore = averageResponseTimeBefore;
    }

    public int getAverageResponseTimeAfter() {
        return averageResponseTimeAfter;
    }
    public void setAverageResponseTimeAfter(int averageResponseTimeAfter) {
        this.averageResponseTimeAfter = averageResponseTimeAfter;
    }   

    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}