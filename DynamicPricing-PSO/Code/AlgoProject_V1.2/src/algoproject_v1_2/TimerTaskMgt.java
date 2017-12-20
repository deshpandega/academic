/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_2;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class TimerTaskMgt extends TimerTask {
    static int a = 0;
    
    //array for swarm points
    private ArrayList<Particle> swarm = new ArrayList<Particle>();

    //Initialize global best fitness value to be infinity or the worst value ever. not even random but just the worst
    private double gBestFitness = Double.MIN_VALUE;
    private Position gBestPosition;
    private Particle gBestParticle = new Particle();

    Random generator = new Random();
    StringBuilder builder;
    Plotter plotter = new Plotter("PSO Simulation");

    public TimerTaskMgt(ArrayList<Particle> swarm, Particle gBestParticle, StringBuilder builder) {
        this.swarm = swarm;
        this.gBestParticle = gBestParticle;
        this.builder = builder;
    }

    @Override
    public void run() {
        XYSeries ser = new XYSeries("Particles");
        XYSeries globalSer = new XYSeries("Global Best");
        XYSeriesCollection serDataset = new XYSeriesCollection();

        for (int i = 0; i < Util.SWARM_SIZE; i++) {
            Particle par = swarm.get(i);
            double r1 = generator.nextDouble();
            double r2 = generator.nextDouble();

            //Calculate new velocity for alpha
            double velocityAlpha = par.getVelocity().getVelocityAlpha() * Util.inertiaCoefficient_W
                    + Util.personalAccelerationCoefficient_C1 * r1 * (par.getBestPosition().getPositionAlpha() - par.getPosition().getPositionAlpha())
                    + Util.globalAccelerationCoefficient_C2 * r2 * (gBestParticle.getBestPosition().getPositionAlpha() - par.getPosition().getPositionAlpha());

            //Calculate new velocity for beta
            double velocityBeta = par.getVelocity().getVelocityBeta() * Util.inertiaCoefficient_W
                    + Util.personalAccelerationCoefficient_C1 * r1 * (par.getBestPosition().getPositionBeta() - par.getPosition().getPositionBeta())
                    + Util.globalAccelerationCoefficient_C2 * r2 * (gBestParticle.getBestPosition().getPositionBeta() - par.getPosition().getPositionBeta());

            //Calculate new velocity for price
            double velocityPrice = par.getVelocity().getVelocityPrice() * Util.inertiaCoefficient_W
                    + Util.personalAccelerationCoefficient_C1 * r1 * (par.getBestPosition().getPositionPrice() - par.getPosition().getPositionPrice())
                    + Util.globalAccelerationCoefficient_C2 * r2 * (gBestParticle.getBestPosition().getPositionPrice() - par.getPosition().getPositionPrice());

            //Calculate new velocity for epsilon
            double velocityEpsilon = par.getVelocity().getVelocityEpsilon() * Util.inertiaCoefficient_W
                    + Util.personalAccelerationCoefficient_C1 * r1 * (par.getBestPosition().getPositionEpsilon() - par.getPosition().getPositionEpsilon())
                    + Util.globalAccelerationCoefficient_C2 * r2 * (gBestParticle.getBestPosition().getPositionEpsilon() - par.getPosition().getPositionEpsilon());

            //Applying lower and upper bound limits to velocity
            if (velocityAlpha < Util.minAlphaVelocity) {
                velocityAlpha = Util.minAlphaVelocity;
            }
            if (velocityAlpha > Util.maxAlphaVelocity) {
                velocityAlpha = Util.maxAlphaVelocity;
            }

            //Applying lower and upper bound limits to velocity
            if (velocityBeta < Util.minBetaVelocity) {
                velocityBeta = Util.minBetaVelocity;
            }
            if (velocityBeta > Util.maxBetaVelocity) {
                velocityBeta = Util.maxBetaVelocity;
            }

            //Applying lower and upper bound limits to velocity
            if (velocityEpsilon < Util.minEpsilonVelocity) {
                velocityEpsilon = Util.minEpsilonVelocity;
            }
            if (velocityEpsilon > Util.maxEpsilonVelocity) {
                velocityEpsilon = Util.maxEpsilonVelocity;
            }

            //Calculate new position for aplha
            double positionAlpha = par.getPosition().getPositionAlpha() + velocityAlpha;

            //Calculate new position for beta
            double positionBeta = par.getPosition().getPositionBeta() + velocityBeta;

            //Calculate new position for price
            double positionPrice = par.getPosition().getPositionPrice() + velocityPrice;

            //Calculate new position for epsilon
            double positionEpsilon = par.getPosition().getPositionEpsilon() + velocityEpsilon;

            //Applying lower and upper bound limits to position
            if (positionAlpha < Util.varAlphaMin) {
                positionAlpha = Util.varAlphaMin;
            }
            if (positionAlpha > Util.varAlphaMax) {
                positionAlpha = Util.varAlphaMax;
            }

            //Applying lower and upper bound limits to position
            if (positionBeta < Util.varBetaMin) {
                positionBeta = Util.varBetaMin;
            }
            if (positionBeta > Util.varBetaMax) {
                positionBeta = Util.varBetaMax;
            }

            //Applying lower and upper bound limits to position
            if (positionPrice < Util.varPriceMin) {
                positionPrice = Util.varPriceMin;
            }
            if (positionPrice > Util.varPriceMax) {
                positionPrice = Util.varPriceMax;
            }

            //Applying lower and upper bound limits to position
            if (positionEpsilon < Util.varEpsilonMin) {
                positionEpsilon = Util.varEpsilonMin;
            }
            if (positionEpsilon > Util.varEpsilonMax) {
                positionEpsilon = Util.varEpsilonMax;
            }

            Velocity vel = new Velocity(velocityAlpha, velocityBeta, velocityPrice, velocityEpsilon);
            Position pos = new Position(positionAlpha, positionBeta, positionPrice, positionEpsilon);
            par.setVelocity(vel);
            par.setPosition(pos);

            par.setFitness(pos);

            if (par.getFitness() > par.getBestFitness()) {
                par.setBestPosition(par.getPosition());
                par.setBestFitness(par.getFitness());

                if (par.getBestFitness() > gBestFitness) {
                    gBestFitness = par.getBestFitness();
                    gBestPosition = par.getBestPosition();
                    gBestParticle.setBestFitness(gBestFitness);
                    gBestParticle.setBestPosition(gBestPosition);
                }
            }

            //Adding all particles in series to plot their position in xy plane
            ser.add(0 + par.getPosition().getPositionPrice(), par.getFitness());
        }

        //Adding global best particle position in seriese to plot its position in xy plane (one per swarm size)
        globalSer.add(0 + gBestParticle.getBestPosition().getPositionPrice(), gBestParticle.getBestFitness());

        Util.inertiaCoefficient_W = Util.inertiaCoefficient_W * Util.dampingRatioInertiaCoefficient;

        //To colelct data in csv
        builder.append("ITERATION " + a);
        builder.append(",");
        builder.append(gBestParticle.getBestPosition().getPositionPrice());
        builder.append(",");
        builder.append(gBestParticle.getBestFitness());
        builder.append("\n");

        //to plot the xy series
        serDataset.addSeries(globalSer);
        serDataset.addSeries(ser);

        plotter.setSerDataset(serDataset);
        a++;
    }
}
