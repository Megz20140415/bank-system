package GUI;

import Core.Users.Account;
import Core.Users.Individual;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class IndividualScreen extends UsersMainLayout
{
    private JButton showOffersButton;
    private JLabel SSNLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel offerStatusLabel; 
    private JLabel creditCardHeadlineLabel;
    private JLabel creditCardIcon;
    private JLabel creditCardNumberLabel;
    private JLabel expirationDateLabel;
    private JLabel CVCLabel;
    
    private int firstColumnMargin = 100;
    private int secondColumnMargin = 430;
    private int fontSize = 18;
    private String font = "Open sans";
    private int labelWidth = 320;
    private int labelHeight = 17;
    private int labelsMargin = 35;
    
    public IndividualScreen(final Account user)
    {
        //Setting screen info 
        super("Client", user.getFirstName() + " " + user.getLastName(), user.getMoneyBalance());
        
        //Making the latout absolute
        screen = getContentPane();
        screen.setLayout(null);
        
        //Creating components
        Icon card = new ImageIcon(getClass().getResource("Icons\\card.png"));
        showOffersButton = new JButton("Show offers");
        IDLabel = new JLabel("ID: " + user.getAccountID());
        userNameLabel = new JLabel("Username: " + user.getUserName());
        passwordLabel = new JLabel("Password: " + user.getPassword());
        SSNLabel = new JLabel("SSN: " + user.getSSN());
        phoneNumberLabel = new JLabel("Phone number: " + user.getPhoneNumber());
        addressLabel = new JLabel("Address: " + user.getAddress());
        ageLabel = new JLabel("Age: " + user.getAge());
        genderLabel = new JLabel("Gender: " + user.getGender());
        interestRateLabel = new JLabel("Interest rate: " + user.getInterestRate());
        offerStatusLabel = new JLabel((user.getOfferStatus() == true)? "You have an active offer!" : "You don't have and active offers yet!");
        loanStatusLabel = new JLabel((user.getLoanStatus() == true)? "You have an active loan!" : "You didn't borrowed any loans yet!");
        creditCardHeadlineLabel = new JLabel("Credit Card Info");
        creditCardIcon = new JLabel(card);
        creditCardNumberLabel = new JLabel("Credit Card: " + user.getCreditCard().getCreditCardNumber());
        expirationDateLabel = new JLabel("Expiration Date: " + user.getCreditCard().getExpirationDate());
        CVCLabel = new JLabel("CVC: " + user.getCreditCard().getCVC());
        
        //Setting colors
        showOffersButton.setForeground(new Color(63,81,181));
        showOffersButton.setBackground(Color.white);
        
        //Setting fonts
        showOffersButton.setFont(new Font("Open sans", Font.PLAIN, 13));
        IDLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        userNameLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        passwordLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        SSNLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        phoneNumberLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        addressLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        ageLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        genderLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        interestRateLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        offerStatusLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        loanStatusLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        creditCardHeadlineLabel.setFont(new Font("Arial", Font.PLAIN, 35));
        creditCardNumberLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        expirationDateLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        CVCLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        
        //Setting positions
        showOffersButton.setBounds(550, 16, 130, 30);
        IDLabel.setBounds(firstColumnMargin, 180, labelWidth, labelHeight);
        userNameLabel.setBounds(firstColumnMargin, IDLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        passwordLabel.setBounds(secondColumnMargin, IDLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        SSNLabel.setBounds(firstColumnMargin, userNameLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        phoneNumberLabel.setBounds(secondColumnMargin, passwordLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        addressLabel.setBounds(firstColumnMargin, SSNLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        ageLabel.setBounds(secondColumnMargin, phoneNumberLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        genderLabel.setBounds(firstColumnMargin, addressLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        interestRateLabel.setBounds(secondColumnMargin, ageLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        offerStatusLabel.setBounds(firstColumnMargin, genderLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        loanStatusLabel.setBounds(secondColumnMargin, interestRateLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        creditCardHeadlineLabel.setBounds(80, 400, 250, 50);
        creditCardIcon.setBounds(30, 405, 40, 40);
        creditCardNumberLabel.setBounds(firstColumnMargin, 465, labelWidth, labelHeight);
        expirationDateLabel.setBounds(firstColumnMargin, creditCardNumberLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        CVCLabel.setBounds(secondColumnMargin, creditCardNumberLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        
        //Setting borders
        showOffersButton.setBorder(null);    
        
        //Event handling
        showTransactionsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    new TransactionsScreen(user).setVisible(true);
                } catch (IOException | ClassNotFoundException ex) {
                    //Logger.getLogger(IndividualScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });
 
        //Adding components to the frame
        screen.add(showOffersButton);
        screen.add(IDLabel);
        screen.add(userNameLabel);
        screen.add(passwordLabel); 
        screen.add(SSNLabel);
        screen.add(phoneNumberLabel); 
        screen.add(addressLabel); 
        screen.add(ageLabel); 
        screen.add(genderLabel); 
        screen.add(interestRateLabel); 
        screen.add(offerStatusLabel);  
        screen.add(loanStatusLabel); 
        screen.add(creditCardHeadlineLabel); 
        screen.add(creditCardIcon);
        screen.add(creditCardNumberLabel);
        screen.add(expirationDateLabel); 
        screen.add(CVCLabel); 
        
        //Focus handling
        showOffersButton.setFocusPainted(false);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        Account userAccount = new Account();
        Individual user = new Individual();
        userAccount.setUserName("ahmed");
        try
        {
            userAccount = (Account) user.searchAccount(userAccount);
        } catch (IOException ex)
        {
            Logger.getLogger(IndividualScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(IndividualScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        new IndividualScreen(userAccount).setVisible(true);
    }   
}

