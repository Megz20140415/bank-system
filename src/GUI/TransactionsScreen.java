package GUI;

import Core.Users.Account;
import Core.Users.Company;
import Core.Users.Individual;
import Core.Users.Transaction;
import GUI.SecondaryScreenMainLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class TransactionsScreen extends SecondaryScreenMainLayout {

    private JTextArea transactionsLabel;
    JScrollPane sp ;

    private static String iconName = "cloud.png";
    private Transaction record;

    public TransactionsScreen(Object object) throws IOException, ClassNotFoundException {
        super("Transactions", "Your Transactions");
        ArrayList<String> transList;
        try {
            Account user = (Account) object;
            Individual displayTransactions = new Individual();
            
            transList = displayTransactions.displayTransactions(user);
        } catch (ClassCastException e) {
            Company user = (Company) object;
            transList = user.displayTransactions(user);
        }
        //Setting screen titles and size
        setSize(800, 600);
        setLocation(250, 70);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Making the latout absolute
        Container screen = getContentPane();
        screen.setLayout(null);

        //Creating components
        transactionsLabel = new JTextArea();

        //Setting colors
        headlineLabel.setForeground(Color.white);

        //Setting fonts
        transactionsLabel.setFont(new Font("Arial", Font.PLAIN, 19));

        //Setting text alignment
        //transactionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        transactionsLabel.setBackground(null);
        transactionsLabel.setEditable(false);
        sp= new JScrollPane(transactionsLabel);
        //transactionsLabel.getDisabledTextColor(Color.black);
        //Setting positions
        transactionsLabel.setBounds(70, 170, 650, transList.size()*300);
        sp.setBounds(10,60,780,500);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //Adding components to the frame
        screen.add(transactionsLabel);
        screen.add(sp);
        
        int counter = 0;
        for (String x : transList) {
            transactionsLabel.append( x+"\n");
          
        }
    }
    /*public static void main(String[] args) {
        try {
            Account user = new Account();
            user.setUserName("m.kamal275");
            new TransactionsScreen(user).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/
}
