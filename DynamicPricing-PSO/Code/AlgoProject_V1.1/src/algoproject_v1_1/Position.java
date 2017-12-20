/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_1;

/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class Position {
    private double positionAlpha;
    private double positionBeta;
    private double positionPrice;
    private double positionEpsilon;
    
    public double getPositionAlpha() {
        return positionAlpha;
    }
    public void setPositionAlpha(double positionAlpha) {
        this.positionAlpha = positionAlpha;
    }

    public double getPositionBeta() {
        return positionBeta;
    }
    public void setPositionBeta(double positionBeta) {
        this.positionBeta = positionBeta;
    }

    public double getPositionPrice() {
        return positionPrice;
    }
    public void setPositionPrice(double positionPrice) {
        this.positionPrice = positionPrice;
    }

    public double getPositionEpsilon() {
        return positionEpsilon;
    }
    public void setPositionEpsilon(double positionEpsilon) {    
        this.positionEpsilon = positionEpsilon;
    }

//    public Position(double position) {
//        this.position = position;
//    }
//
//    public double getPosition() {
//        return position;
//    }
    

    public Position(double positionAlpha, double positionBeta, double positionPrice, double positionEpsilon) {
        this.positionAlpha = positionAlpha;
        this.positionBeta = positionBeta;
        this.positionPrice = positionPrice;
        this.positionEpsilon = positionEpsilon;
    }   
}