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
Kalyanam’s log-linear pricing model
d = e^(alpha+(p*beta)+epsilon)

d = demand quantity
p = price for demand d
epsilon = noise
aplha/beta = random numbers

revenue r = pd
*/