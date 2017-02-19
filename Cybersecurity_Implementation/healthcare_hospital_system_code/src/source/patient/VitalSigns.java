/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.patient;

/**
 *
 * @author GaurangDeshpande
 */
public class VitalSigns extends Visit{
    private int bloodPressure;
    private int pulseRate;
    private int weight;
    private int respirationRate;
    private int bloodGlucoseLevel;
    private int height;
    private int temperature;

    public int getBloodPressure() {
        return bloodPressure;
    }
    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getPulseRate() {
        return pulseRate;
    }
    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRespirationRate() {
        return respirationRate;
    }
    public void setRespirationRate(int respirationRate) {
        this.respirationRate = respirationRate;
    }

    public int getBloodGlucoseLevel() {
        return bloodGlucoseLevel;
    }
    public void setBloodGlucoseLevel(int bloodGlucoseLevel) {
        this.bloodGlucoseLevel = bloodGlucoseLevel;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}