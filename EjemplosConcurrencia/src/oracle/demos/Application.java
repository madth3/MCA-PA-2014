/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.demos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JApplet;
import javax.swing.JFrame;

/**
 *
 * @author PCEL
 */
public class Application {

    private static final int WIDTH = 250;
    private static final int HEIGHT = 250;
    
    public static void cargarApplets() {
        final JFrame frame = new JFrame("SortAlgorithms Demo");
        frame.setSize(3*WIDTH+50, HEIGHT+50);
        frame.setPreferredSize(new Dimension(3*WIDTH+50, HEIGHT+50));
        frame.setLayout(new FlowLayout());

        final JApplet bubbleApplet = new SortItem("oracle.demos.BubbleSort");
        bubbleApplet.setSize(WIDTH, HEIGHT);
        bubbleApplet.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        final JApplet bdBubbleApplet = new SortItem("oracle.demos.BidirBubbleSort");
        bdBubbleApplet.setSize(WIDTH, HEIGHT);
        bdBubbleApplet.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        final JApplet qSortApplet = new SortItem("oracle.demos.QSort");
        qSortApplet.setSize(WIDTH, HEIGHT);
        qSortApplet.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                bubbleApplet.stop();
                bdBubbleApplet.stop();
                qSortApplet.stop();
                bubbleApplet.destroy();
                bdBubbleApplet.destroy();
                qSortApplet.destroy();
                System.exit(0);
            }
        });

        frame.add(bubbleApplet);
        frame.add(bdBubbleApplet);
        frame.add(qSortApplet);
        bubbleApplet.init();
        bdBubbleApplet.init();
        qSortApplet.init();
        frame.validate();
        frame.setVisible(true);
        bubbleApplet.start();
        bdBubbleApplet.start();
        qSortApplet.start();
    }
    
    public static void main(String[] args) {
        Application.cargarApplets();
    }
}
