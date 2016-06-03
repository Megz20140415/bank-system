package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainLayout extends JFrame
{
    protected JLabel welcomeLabel;
    protected JLabel headerBackground;
    protected JLabel personalPicture;
    protected JButton LogoutButton;
   
    protected static String screenTitle; 
    protected static String name; 

    protected int rightMargin = 30;
    protected int topMargin = 5;
    
    protected Container screen;
    
    public MainLayout(String screenTitle, String name)
    {
        //Setting the screen title and size
        setTitle(screenTitle);
        setSize(800, 600);
        setResizable(false);
        setLocation(250, 70);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting layout
        screen = getContentPane();
        screen.setLayout(null);
        
        //Creating components
        Icon logout = new ImageIcon(getClass().getResource("Icons\\exit.png"));
        headerBackground = new JLabel();
        welcomeLabel = new JLabel("<html>Welcome,<b> " + name + "</b></html>");
        personalPicture = new JLabel();
        LogoutButton = new JButton(logout);
        
        //Setting colors
        headerBackground.setBackground(new Color(63,81,181));
        headerBackground.setOpaque(true); //To paint the label
        welcomeLabel.setForeground(Color.WHITE);
        personalPicture.setBackground(Color.GRAY);
        personalPicture.setOpaque(true); //To paint the label
        LogoutButton.setBackground(new Color(63,81,181));
        
        //Setting fonts
        welcomeLabel.setFont(new Font("Open sans", Font.PLAIN, 18));
        
        //Setting border
        LogoutButton.setBorder(null);
        
        //Removing focus
        LogoutButton.setFocusPainted(false);
        
        //Setting positions
        headerBackground.setBounds(0, 0, 800, 60);
        welcomeLabel.setBounds(rightMargin, topMargin, 450, 55);
        personalPicture.setBounds(690, topMargin + 10, 30, 30);
        LogoutButton.setBounds(730, topMargin + 10, 30, 30);
        
        //Adding components to the 
        screen.add(headerBackground);
        headerBackground.add(welcomeLabel);
        headerBackground.add(personalPicture);
        screen.add(LogoutButton);
        
        //Event handling
        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new LoginScreen().setVisible(true);
            }
        });
    }
    
    public static void main(String[] args)
    {
        new MainLayout(screenTitle, name).setVisible(true);
    } 
}
