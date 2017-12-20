/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject_v1_2;

import static algoproject_v1_2.TimerTaskMgt.a;
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
public class Execution {

    //array for swarm points
    private ArrayList<Particle> swarm;

    //Initialize global best fitness value to be infinity or the worst value ever. not even random but just the worst
    private double gBestFitness = Double.MIN_VALUE;
    private Position gBestPosition;
    private Particle gBestParticle;

    //Array to hold best particle after each iteration
    private ArrayList<Particle> globalBestAfterEachItr;


    public void execute() throws FileNotFoundException {
        initializeSwamp();
        updateBestFitness();

        //TO capture the position and fitness of the PSO application in csv file as backup
        String timestamp = Long.toString(System.currentTimeMillis());

        PrintWriter writer = new PrintWriter(new File("pso_output_" + Util.MAX_ITERATIONS + "_" + timestamp + ".csv"));
        StringBuilder builder = new StringBuilder();
        builder.append("ITERATION");
        builder.append(",");
        builder.append("Global Best Position");
        builder.append(",");
        builder.append("Global Best Fitness");
        builder.append("\n");

        int itr = 0;

        //Parameter to modify can be
        //alpha / beta / epsilon
        String modifyingValue = "beta";
        Plotter plotter = new Plotter("PSO Simulation");

        while (itr < Util.MAX_ITERATIONS) {
            TimerTask timerTask = new TimerTaskMgt(swarm, gBestParticle, builder);
            Timer timer = new Timer(true);
            timer.schedule(timerTask, 10);

            plotter.run();

            //Modifying dependent variables in cost function at runtime
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

}
