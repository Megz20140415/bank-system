package GUI;

import GUI.MainLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

public class UsersMainLayout extends MainLayout
{
    protected JLabel moneyBalanceLabel;
    protected JButton showTransactionsButton;
    protected JLabel accountIcon;
    protected JLabel headlineLabel;
    
    protected JLabel IDLabel;
    protected JLabel userNameLabel;
    protected JLabel passwordLabel;
    protected JLabel phoneNumberLabel;
    protected JLabel addressLabel;
    protected JLabel interestRateLabel;
    protected JLabel loanStatusLabel;
    
    private static double moneyBalance = 1500;
  
    public UsersMainLayout(String screenTitle, String name, double moneyBalance)
    {
        //Setting screen title
        super(screenTitle, name);
        
        //Making the latout absolute
        Container screen = getContentPane();
        screen.setLayout(null);
        
        //Creating components
        Icon account = new ImageIcon(getClass().getResource("Icons//account.png"));
        moneyBalanceLabel = new JLabel("<html><b>Money Balance: </b>" + moneyBalance + "</html>");
        showTransactionsButton = new JButton("Display Transactions");
        accountIcon = new JLabel(account);
        headlineLabel = new JLabel("Account Info");
        
        //Setting colors
        showTransactionsButton.setBackground(new Color(63,81,181));
        showTransactionsButton.setForeground(Color.white);
        accountIcon.setForeground(new Color(63,81,181));
        accountIcon.setOpaque(true); //To paint the label
        
        //Setting fonts
        moneyBalanceLabel.setFont(new Font("Open sans", Font.PLAIN, 20));
        headlineLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        
        //Setting positions
        moneyBalanceLabel.setBounds(510, 80, 250, 50);
        showTransactionsButton.setBounds(525, 130, 200, 30);
        accountIcon.setBounds(30, 105, 40, 40);
        headlineLabel.setBounds(80, 100, 200, 50);
        
        //Setting borders
        showTransactionsButton.setBorder(null);
        
        //Setting border focus
        showTransactionsButton.setFocusPainted(false);
        
        //Adding components to the frame
        screen.add(moneyBalanceLabel);
        screen.add(showTransactionsButton);
        screen.add(accountIcon);
        screen.add(headlineLabel);         
    }
    
    public static void main(String[] args)
    {
        new UsersMainLayout(screenTitle, name, moneyBalance).setVisible(true);
    }
}

