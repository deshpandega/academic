/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoproject;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import javax.swing.JApplet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;


/**
 *
 * @author Gaurang Deshpande
 * <deshpande.ga@husky.neu.edu/gaurangdeshpande89@gmail.com>
 */
public class Plotter extends JApplet{

    static XYSeriesCollection serDataset;

    public Plotter(XYSeriesCollection serDataset) throws HeadlessException {
        this.serDataset = serDataset;
    }
    
    @Override
    public void paint(Graphics g) {
        JFreeChart scatterPlot = createChart();
        scatterPlot.draw( (Graphics2D)g,getBounds()); 
    }
    
//    @Override
//    public void init(){
//        JFreeChart scatterPlot = createChart();
//        
//    }
    
    private static JFreeChart createChart(){
        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                    "Particle Movement",
                    "Price", "Revenue",
                    serDataset,
                    PlotOrientation.VERTICAL ,
                    true , true , false
            );
        
        XYPlot xyPlot = (XYPlot) scatterPlot.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        xyPlot.setBackgroundPaint(Color.lightGray);
        xyPlot.setDomainGridlinePaint(Color.white);
        xyPlot.setRangeGridlinePaint(Color.white);
        xyPlot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesPaint(1, Color.red);
        renderer.setSeriesPaint(0, Color.blue);
        renderer.setSeriesStroke(1, new BasicStroke(1.0f));
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseSeriesVisible(true);
        renderer.setPlot(xyPlot);

        NumberAxis xAxis = (NumberAxis) xyPlot.getDomainAxis();
        xAxis.setRange(Util.varPriceMin, Util.varPriceMax);
        xAxis.setTickUnit(new NumberTickUnit((Util.varPriceMax-Util.varPriceMin)/15));
        xAxis.setVerticalTickLabels(true);
        
        return scatterPlot;
    }
}


//JFreeChart scatterPlot = ChartFactory.createScatterPlot(
//                    "Particle Movement",
//                    "Price", "Revenue",
//                    serDataset,
//                    PlotOrientation.VERTICAL ,
//                    true , true , false
//            );
//               
//            XYPlot xyPlot = (XYPlot) scatterPlot.getPlot();
//            xyPlot.setDomainCrosshairVisible(true);
//            xyPlot.setRangeCrosshairVisible(true);
//            XYItemRenderer renderer = xyPlot.getRenderer();
//            renderer.setSeriesPaint(1, Color.red);
//            renderer.setSeriesPaint(0, Color.blue);
//            
//            renderer.setSeriesStroke(1, new BasicStroke(1.0f));
//            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
//
//            
//            NumberAxis xAxis = (NumberAxis) xyPlot.getDomainAxis();
//            xAxis.setRange(Util.varPriceMin, Util.varPriceMax);
//            xAxis.setTickUnit(new NumberTickUnit(5));
//            xAxis.setVerticalTickLabels(true);
//            
//            
//            ChartPanel panel = new ChartPanel( scatterPlot );
//            panel.setPreferredSize( new java.awt.Dimension( 1080 , 768 ) );
//            final XYPlot plot = scatterPlot.getXYPlot( );
//            
//            plot.setRenderer( renderer ); 
//            setContentPane( panel ); 
//            
//            this.pack( );          
//            RefineryUtilities.centerFrameOnScreen( this );          
//            this.setVisible( true );