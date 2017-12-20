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
public class OptimizationFunction {
    
    //Optimization Function to be implemented
    public static double implementationFunction(double alpha, double beta, double price, double epsilon){
        double power = alpha + price * beta + epsilon;
        double output = Math.pow(Math.E, power);
        output = output*price;
        return output;
    }
}

/*
// pricing model
Kalyanam’s log-linear demand model
d = e^(alpha+(p*beta)+epsilon)

d = demand quantity
p = price for demand d
epsilon = noise
aplha = random value from 1 to 10
beta = random value from 0 to -10


revenue r = pd
*/