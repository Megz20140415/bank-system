/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author mohamed
 */
public class ChartPanel extends JPanel {
      private int[] values;
    private String[] names;
    private String title;
    
    public ChartPanel(int [] v,String[] n,String t)
    {
        names=n;
        values=v;
        title=t;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(values==null||values.length==0)
            return;
        double minValue=0;
        double maxValue=0;
        for(int i=0;i<values.length;i++)
        {
            if(minValue>values[i])
                minValue=values[i];
            if(maxValue<values[i])
                maxValue=values[i];
        }
        
        Dimension d = getSize();
        int clientWidth = d.width;
        int clientHeight = d.height;
        int barWidth = clientWidth/values.length;
        
        Font titleFont = new Font("SansSerif",Font.BOLD,25);
        FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
        Font labelFont = new Font("SansSerif",Font.PLAIN,25);
        FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);
        
        int titleWidth = titleFontMetrics.stringWidth(title);
        int y = titleFontMetrics.getAscent();
        int x = (clientWidth-titleWidth)/2;
        g.setFont(titleFont);
        g.drawString(title, x, y);
        
        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if(maxValue==minValue)
            return;
        double scale = (clientHeight-top-bottom)/(maxValue-minValue);
        y=clientHeight-labelFontMetrics.getDescent();
        g.setFont(labelFont);
        
        for (int i = 0; i < values.length; i++) 
        {
            int valueX = i * barWidth + 1;
            int valueY = top;
            int height = (int) (values[i] * scale);
            if (values[i] >= 0) {
                valueY += (int) ((maxValue - values[i]) * scale);
            } else {
                valueY += (int) (maxValue * scale);
                height = -height;
            }

            if(values[i]>=3)
                g.setColor(Color.GREEN);
            else if (values[i]>=1)
                g.setColor(Color.BLUE);
            else
                g.setColor(Color.RED);
            
            g.fillRect(valueX, valueY, barWidth - 6, height);
            g.setColor(Color.BLACK);
            g.drawRect(valueX, valueY, barWidth - 6, height);
            int labelWidth = labelFontMetrics.stringWidth(names[i]);
            x = i * barWidth + (barWidth - labelWidth) / 2;
            g.drawString(names[i], x, y);
        }
        
        
    }
}
