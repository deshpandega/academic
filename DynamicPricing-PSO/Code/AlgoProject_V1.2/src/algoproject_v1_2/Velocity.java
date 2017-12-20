/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_2;

/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class Velocity {
    private double velocityAlpha;
    private double velocityBeta;
    private double velocityPrice;
    private double velocityEpsilon;

    public Velocity(double velocityAlpha, double velocityBeta, double velocityPrice, double velocityEpsilon) {
        this.velocityAlpha = velocityAlpha;
        this.velocityBeta = velocityBeta;
        this.velocityPrice = velocityPrice;
        this.velocityEpsilon = velocityEpsilon;
    }

    public double getVelocityAlpha() {
        return velocityAlpha;
    }
    public void setVelocityAlpha(double velocityAlpha) {
        this.velocityAlpha = velocityAlpha;
    }

    public double getVelocityBeta() {
        return velocityBeta;
    }
    public void setVelocityBeta(double velocityBeta) {
        this.velocityBeta = velocityBeta;
    }

    public double getVelocityPrice() {
        return velocityPrice;
    }
    public void setVelocityPrice(double velocityPrice) {
        this.velocityPrice = velocityPrice;
    }

    public double getVelocityEpsilon() {
        return velocityEpsilon;
    }
    public void setVelocityEpsilon(double velocityEpsilon) {
        this.velocityEpsilon = velocityEpsilon;
    }   
}