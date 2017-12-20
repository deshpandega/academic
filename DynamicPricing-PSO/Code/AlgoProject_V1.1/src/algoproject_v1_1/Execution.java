/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;
import java.util.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class Execution extends ApplicationFrame implements Runnable {

    //array for swarm points

    private ArrayList<Particle> swarm;

    //Initialize global best fitness value to be infinity or the worst value ever. not even random but just the worst
    private double gBestFitness = Double.MIN_VALUE;
    private Position gBestPosition;
    private Particle gBestParticle;

    //Array to hold best particle after each iteration
    private ArrayList<Particle> globalBestAfterEachItr;

    public Execution(String title) {
        super(title);
    }

    public void execute() throws FileNotFoundException {
        initializeSwamp();
        updateBestFitness();

        //TO capture the position and fitness of the PSO application
        String timestamp = Long.toString(System.currentTimeMillis());

        PrintWriter writer = new PrintWriter(new File("pso_output_" + Util.MAX_ITERATIONS + "_" + timestamp + ".csv"));
        StringBuilder builder = new StringBuilder();
        builder.append("ITERATION");
        builder.append(",");
        builder.append("Global Best Position");
        builder.append(",");
        builder.append("Global Best Fitness");
        builder.append("\n");

        Random generator = new Random();
        int itr = 0;
        
        //Parameter to modify can be
        //alpha / beta / epsilon
        String modifyingValue = "beta";

        //XYSeries dataset = new XYSeries( "Revenue" );
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 1));
        Plotter plotter = new Plotter("PSO Simulation");
        
        TimerTask timerTask = new TimerTaskMgt();
        Timer timer = new Timer(true);
        timer.schedule(timerTask, 00);
                
        while (itr < Util.MAX_ITERATIONS) {
            XYSeries ser = new XYSeries("Particles");
            XYSeries globalSer = new XYSeries("Global Best");
            XYSeriesCollection serDataset = new XYSeriesCollection();

            for (int i = 0; i < Util.SWARM_SIZE; i++) {
                
                //Timertask    
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

            //Store the global best for each iteration
            globalBestAfterEachItr.add(gBestParticle);

            Util.inertiaCoefficient_W = Util.inertiaCoefficient_W * Util.dampingRatioInertiaCoefficient;

            //To colelct data in csv
            builder.append("ITERATION " + itr);
            builder.append(",");
            builder.append(gBestParticle.getBestPosition().getPositionPrice());
            builder.append(",");
            builder.append(gBestParticle.getBestFitness());
            builder.append("\n");

            //to plot the xy series
            //dataset.add(gBestParticle.getBestPosition().getPositionPrice(), gBestParticle.getBestFitness() );
            serDataset.addSeries(globalSer);
            serDataset.addSeries(ser);

            plotter.setSerDataset(serDataset);
            plotter.run();
            //End

            if (itr > 70) {
                switch (modifyingValue) {
                    case "alpha":
                        Util.varAlphaMax = 5.15;
                        break;
                    case "beta":
                        Util.varBetaMax = -0.0396;
                        break;
                    case "epsilon":
                        Util.varEpsilonMax = 2.2;
                        break;
                    default:
                        break;
                }
            }


            itr++;
        }

        writer.write(builder.toString());
        writer.close();
    }

    public void initializeSwamp() {
        //initialize swarm array
        swarm = new ArrayList<Particle>();

        //initialize array holding global best particle after each itiration
        globalBestAfterEachItr = new ArrayList<Particle>();

        //initialize global best particle
        gBestParticle = new Particle();

        Particle particle;
        Position pos, posBest;
        Velocity vel;

        //Random generator
        Random generator = new Random();
        for (int i = 0; i < Util.SWARM_SIZE; i++) {
            particle = new Particle();

            //Generate random number from range -10 to 10
            double alpha = ThreadLocalRandom.current().nextDouble(Util.varAlphaMin, Util.varAlphaMax);
            double beta = ThreadLocalRandom.current().nextDouble(Util.varBetaMin, Util.varBetaMax);
            double price = ThreadLocalRandom.current().nextDouble(Util.varPriceMin, Util.varPriceMax);
            double epsilon = ThreadLocalRandom.current().nextDouble(Util.varEpsilonMin, Util.varEpsilonMax + 1);

            //Initialize the particle with random position
            pos = new Position(alpha, beta, price, epsilon);
            particle.setPosition(pos);

            //Initialize best position for each particle which is current position
            posBest = pos;
            particle.setBestPosition(posBest);

            //Initialize velocity for each particle to be 0 at first
            vel = new Velocity(0, 0, 0, 0);
            particle.setVelocity(vel);

            //Initialize fitness for each particle according to optimization function
            particle.setFitness(pos);
            particle.setBestFitness(particle.getFitness());

            //Initialize the global best position, global best fitness and global best particle
            if (particle.getBestFitness() > gBestFitness) {
                gBestFitness = particle.getBestFitness();
                gBestPosition = particle.getBestPosition();
                gBestParticle.setBestFitness(gBestFitness);
                gBestParticle.setBestPosition(gBestPosition);
            }

            //Add each particle to swarm array
            swarm.add(particle);
        }
    }

    public void updateBestFitness() {
        for (int i = 0; i < Util.SWARM_SIZE; i++) {
            //Update the best fitness of each particle at the initialization
            swarm.get(i).setBestFitness(swarm.get(i).getFitness());
        }
    }

    @Override
    public void run() {

    }

}
