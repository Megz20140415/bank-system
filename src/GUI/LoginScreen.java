package GUI;

import Core.Human;
import Core.Staff.Manager;
import Core.Staff.Staff;
import Core.Staff.humanResources;
import Core.Users.Account;
import Core.Users.Company;
import Core.Users.Individual;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginScreen extends JFrame
{
    private final JLabel welcomeLabel;
    private final JLabel welcomeLabelBackground;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameField;
    private JLabel userNameErrorSign;
    private JPasswordField passwordField;
    private final JLabel passwordErrorSign;
    private JButton LoginButton;   
    private final JLabel l2;
    
    private final int leftMargin = 300;
    
    public LoginScreen()
    {
        //Setting screen titles and size
        setTitle("Login");
        setSize(800, 600);
        setLocation(250, 70);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Making the latout absolute
        Container screen = getContentPane();
        screen.setLayout(null); 
        
        //Creating components
        Icon error = new ImageIcon(getClass().getResource("Icons\\error.png"));
        welcomeLabelBackground = new JLabel();
        welcomeLabel = new JLabel();
        l2 = new JLabel();
        userNameLabel = new JLabel("<html><b>Username</b></html>");
        userNameField = new JTextField();   
        userNameErrorSign = new JLabel(error);
        passwordLabel = new JLabel("<html><b>Password</b></html>");
        passwordField = new JPasswordField();
        passwordErrorSign = new JLabel(error);
        LoginButton = new JButton("Login");
      
        
        
        //Setting colors
        welcomeLabelBackground.setBackground(new Color(63,81,181));
        welcomeLabelBackground.setOpaque(true); //To paint the label
        welcomeLabel.setForeground(Color.white);
        l2.setForeground(Color.white);
        userNameLabel.setForeground(new Color(63,81,181));
        userNameField.setBackground(null);
        passwordLabel.setForeground(new Color(63,81,181));
        passwordField.setBackground(null);
        LoginButton.setBackground(new Color(63,81,181));
        LoginButton.setForeground(Color.white);
        
        //Setting fonts
        welcomeLabel.setFont(new Font("Open Sans", Font.PLAIN, 40));
        l2.setFont(new Font("Open Sans", Font.PLAIN, 20));
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userNameField.setFont(new Font("Arial", Font.PLAIN, 13));
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 13));
        LoginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        
        //Setting positions
        welcomeLabelBackground.setBounds(0, 0, 800, 200);
        welcomeLabel.setBounds(320, 65, 390, 100);
        l2.setBounds(370, 65, 390, 240);
        userNameLabel.setBounds(leftMargin, 250, 120, 30);
        userNameField.setBounds(leftMargin , userNameLabel.getBounds().y + 30, 200,30);
        userNameErrorSign.setBounds(505, userNameLabel.getBounds().y + 35, 20, 20);
        passwordLabel.setBounds(leftMargin, userNameField.getBounds().y + 40, 120, 30);           
        passwordField.setBounds(leftMargin,  passwordLabel.getBounds().y + 30, 200, 30);
        passwordErrorSign.setBounds(505, passwordLabel.getBounds().y + 35, 20, 20);
        LoginButton.setBounds(300, passwordField.getBounds().y + 50, 200, 40);
                
        //Controlling visiblity options
        userNameLabel.setVisible(false);
        userNameErrorSign.setVisible(false);
        passwordLabel.setVisible(false);
        passwordField.setEnabled(false);
        passwordErrorSign.setVisible(false);
        LoginButton.setEnabled(false);
        
        //Setting borders
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));       
        
        //Adding components to the frame
        screen.add(welcomeLabelBackground);
        welcomeLabelBackground.add(welcomeLabel); //Making the text above the background 
        welcomeLabelBackground.add(l2);
        screen.add(userNameLabel);
        screen.add(userNameField);
        screen.add(userNameErrorSign);
        screen.add(passwordLabel);
        screen.add(passwordField);
        screen.add(passwordErrorSign);
        screen.add(LoginButton);
       
        //screen.add(l2);
        
        //Focus handling
        userNameField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                userNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                userNameLabel.setVisible(true);
                userNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        if (passwordErrorSign.isVisible() == false)
        {
            passwordField.setEchoChar((char) 0);
            passwordField.setText("Password");
        }
        
        passwordField.addFocusListener(new FocusListener() 
        {
            int Counter = 0;
            
            @Override
            public void focusLost(FocusEvent arg0)
            {     
               passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            {
                if (Counter == 0)
                    passwordField.setText("");
                
                Counter++;
                passwordField.setEchoChar('*');
                passwordLabel.setVisible(true);
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        LoginButton.setFocusPainted(false);
       
        //Events handling
        //When the user enters the username
        userNameField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {       
                try
                {
                    if (Human.checkUserName(userNameField.getText()) == true)
                    {
                        passwordField.setEnabled(true);
                        passwordField.setBackground(null);
                        LoginButton.setEnabled(true);
                        userNameErrorSign.setVisible(false);
                    } 
                    else
                        userNameErrorSign.setVisible(true);
                } catch (ClassNotFoundException | IOException ex)
                {
                    userNameErrorSign.setVisible(true);
                    passwordErrorSign.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                userNameErrorSign.setVisible(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                userNameErrorSign.setVisible(false);
            }       
        });
  
        //When the user enters the password
        passwordField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {   
                passwordField.setBackground(null);
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
                passwordLabel.setVisible(true);          
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                //TODO
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                passwordField.setBackground(null);
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
                passwordLabel.setVisible(true);
            }       
        });         
        
        //When the user press checkUserName button
        LoginButton.addActionListener(new Login());
        String userName, password;
        userName = userNameField.getText();
        password = passwordField.getText();
        
        //Thread
        Thread t = new Thread() {
            @Override
            public void run() {
                String word = "C I B Bank";
               
                for (int i = 0; i < word.length(); i++) {             
                    
                        welcomeLabel.setText(welcomeLabel.getText()+ Character.toString(word.charAt(i)));
                    
                    try {
                        Thread.sleep(350);
                    } catch (Exception e) {
                    }

                }
            }
        };
        
        Thread t2 = new Thread() {
            @Override
            public void run() {
                String word = "Trust in Us";
                for (int i = 0; i < word.length(); i++) {
                    l2.setText(l2.getText()+ Character.toString(word.charAt(i)));
                    try {
                        Thread.sleep(400);
                    } catch (Exception e) {
                    }

                }
            }

        };
        
        t2.start();
        t.start();
    }
    
    private class Login implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Manager manager = new Manager();
            try
            {  
                switch (Human.Login(userNameField.getText(), passwordField.getText()))
                {     
                    case 1:
                        Staff HR = new Staff();
                        HR.setUserName(userNameField.getText());
                        HR = (Staff) manager.searchAccount(HR);
                        new HumanResourcesScreen(HR).setVisible(true);
                        break;
                    
                    case 2:
                        Staff LE = new Staff();
                        LE.setUserName(userNameField.getText());
                        LE = (Staff) manager.searchAccount(LE);
                        new LoanEmployeeScreen(LE).setVisible(true);
                        break;
                    
                    case 3:
                        Staff AM = new Staff();
                        AM.setUserName(userNameField.getText());
                        AM = (Staff) manager.searchAccount(AM);
                        new AccountManagerScreen(AM).setVisible(true);
                        break;
                    
                    case 4:
                        Staff T = new Staff();
                        T.setUserName(userNameField.getText());
                        T = (Staff) manager.searchAccount(T);
                        new TellerScreen(/*T*/).setVisible(true);
                        break;
                    
                    case 5:
                        Account userAccount = new Account();
                        Individual user = new Individual();
                        userAccount.setUserName(userNameField.getText());
                        userAccount = (Account) user.searchAccount(userAccount);
                        new IndividualScreen(userAccount).setVisible(true);
                        break;
                    
                    case 6:
                        Company company = new Company();
                        company.setUserName(userNameField.getText());
                        company = (Company) company.searchAccount(company);
                        new CompanyScreen(company).setVisible(true);
                        break;
                    
                    case 7:
                        new ManagerScreen().setVisible(true);
                        break;
                    
                    default:
                        passwordErrorSign.setVisible(true);
                        break;
                }
                
                if (Human.Login(userNameField.getText(), passwordField.getText()) > 0)
                {
                    dispose();
                }      
            } 
            catch (IOException | ClassNotFoundException ex)
            {
                userNameErrorSign.setVisible(true);
                passwordErrorSign.setVisible(true);
            }    
        }
    }
    
    public static void main(String[] args)
    {
        
        new LoginScreen().setVisible(true);
    } 
}