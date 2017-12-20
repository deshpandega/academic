/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject;

/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class Util {
    
    //Clerc and Kennedy 2002
    public static final int kappa = 1;
    public static final double phi1 = 2.05;
    public static final double phi2 = 2.05;
    public static final double phi = phi1 + phi2 ;
    public static final double chi = 2 * kappa / Math.abs(2 - phi - Math.sqrt( Math.pow(phi,2) - (4 * phi) ));
    
    public static final int MAX_ITERATIONS = 100;
    public static final int SWARM_SIZE = 50;
    public static double inertiaCoefficient_W = chi;
    public static final double personalAccelerationCoefficient_C1 = chi * phi1;
    public static final double globalAccelerationCoefficient_C2 = chi * phi2;
    public static final double dampingRatioInertiaCoefficient = 1;
    
    
    public static final double varAlphaMin = -5;
    public static final double varAlphaMax = 5;
    public static final double maxAlphaVelocity = 0.2 * (varAlphaMax - varAlphaMin);
    public static final double minAlphaVelocity = varAlphaMin;
    
    public static final double varBetaMin = -10.0;
    public static final double varBetaMax = -0.08;
    public static final double maxBetaVelocity = 0.2 * (varBetaMax - varBetaMin);
    public static final double minBetaVelocity = varBetaMax;
    
    public static final double varPriceMin = 0.0001;
    public static final double varPriceMax = 50;
    public static final double maxPriceVelocity = 0.2 * (varPriceMax - varPriceMin);
    public static final double minPriceVelocity = varPriceMin;
    
    public static final double varEpsilonMin = -2;
    public static final double varEpsilonMax = 2;
    public static final double maxEpsilonVelocity = 0.2 * (varEpsilonMax - varEpsilonMin);
    public static final double minEpsilonVelocity = -maxEpsilonVelocity;
    
}
