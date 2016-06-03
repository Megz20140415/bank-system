package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SecondaryScreenMainLayout extends JFrame
{
    protected JLabel headlineLabel;
    protected JLabel headerBackground;
    protected JLabel headlineIcon;
    protected Container screen ;
    public SecondaryScreenMainLayout(String screenTitle, String headline)
    {
        //Setting screen titles and size
        setTitle(screenTitle);
        setSize(800, 600);
        setLocation(250, 70);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Making the latout absolute
        screen = getContentPane();
        screen.setLayout(null);
        
        //Creating components
        headlineLabel = new JLabel(headline);
        headerBackground = new JLabel();
        
        //Setting colors
        headerBackground.setBackground(new Color(63,81,181));
        headerBackground.setOpaque(true); //To paint the label
        headlineLabel.setForeground(Color.white);
        
        //Setting fonts
        headlineLabel.setFont(new Font("Open Sans", Font.PLAIN, 30));
        
        //Setting positions
        headerBackground.setBounds(0, 0, 800, 150);
        headlineLabel.setBounds(270, 50, 370, 70);
        
        //Adding components to the frame
        headerBackground.add(headlineLabel);
        screen.add(headerBackground);
        
    }
    
    public static void main(String[] args)
    {
        new SecondaryScreenMainLayout("Transactions", "Transactions").setVisible(true);
    } 
}
