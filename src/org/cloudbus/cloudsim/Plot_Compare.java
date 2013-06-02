/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cloudbus.cloudsim;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Vector;
import javax.swing.JFrame;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
   import java.awt.*;
import java.applet.*;
/**
 *
 * @author Sabarish
 */

public class Plot_Compare extends Applet {
    Button button1;
    
    public void Plot_Compare() {
        JFrame frame=new JFrame();
        setVisible(true);
        Graphics g = null;
        Button button1 = new Button("Plot");
        add(button1);
        g.setColor(Color.blue);
        g.drawLine(600,0,600,1000);    // x-axis
        g.drawLine(0,350,1400,350);// y-axis
       for (int i=0;i<=1000;i++)
       {
        g.drawLine(i,(int)Math.sin(i),i,(int)Math.sin(i));//Suppose to give me a graph 
                //even tho at random location        
}
           }


}

