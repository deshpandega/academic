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
public class Particle {
    private Position position;
    private Velocity velocity;
    private double fitness;
    private Position bestPosition;
    private double bestFitness;

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public Velocity getVelocity() {
        return velocity;
    }
    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public double getFitness() {
        return fitness;
    }
    public void setFitness(Position position) {
        fitness = OptimizationFunction.implementationFunction(position.getPositionAlpha(), position.getPositionBeta(), position.getPositionPrice(), position.getPositionEpsilon());
        this.fitness = fitness;
    }

    public Position getBestPosition() {
        return bestPosition;
    }
    public void setBestPosition(Position bestPosition) {
        this.bestPosition = bestPosition;
    }

    public double getBestFitness() {
        return bestFitness;
    }
    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }
    
}