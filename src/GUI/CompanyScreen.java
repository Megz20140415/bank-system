package GUI;

import Core.Users.Company;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class CompanyScreen extends UsersMainLayout
{    
    private JLabel emailLabel;
    private JLabel websiteLabel;
    private JLabel employeesNumberLabel;
    private JLabel industryTypeLabel;
    
    private int firstColumnMargin = 100;
    private int secondColumnMargin = 440;
    private int fontSize = 17;
    private String font = "Open sans";
    private int labelWidth = 330;
    private int labelHeight = 22;
    private int labelsMargin = 45;
    
    public CompanyScreen(final Company company)
    {
        //Setting screen info 
        super("User", company.getName(), company.getMoneyBalance());
        
        //Setting layout
        screen = getContentPane();
        screen.setLayout(null);

        //Creating components
        IDLabel = new JLabel("ID: " + company.getCompanyID());
        userNameLabel = new JLabel("Username: " + company.getUserName());
        passwordLabel = new JLabel("Password: " + company.getPassword());
        phoneNumberLabel = new JLabel("Phone number: " + company.getPhoneNumber());
        addressLabel = new JLabel("Adress: " + company.getAddress());
        interestRateLabel = new JLabel("Interest rate: " + company.getInterestRate());
        loanStatusLabel = new JLabel((company.getLoanStatus() == true)? "You have an active loan!" : "You didn't borrowed any loans yet!");
        emailLabel = new JLabel("Email: " + company.getEmail());
        websiteLabel = new JLabel("Website: " + company.getWebsite());
        employeesNumberLabel = new JLabel("Employees Number: " + company.getEmployeeNumber());
        industryTypeLabel = new JLabel("Industry Type: " + company.getIndustryType());
        

        //Setting fonts
        IDLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        userNameLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        passwordLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        phoneNumberLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        addressLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        interestRateLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        loanStatusLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        emailLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        websiteLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        employeesNumberLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        industryTypeLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        

        //Setting positions
        IDLabel.setBounds(firstColumnMargin, 220, labelWidth, labelHeight);
        userNameLabel.setBounds(firstColumnMargin, IDLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        passwordLabel.setBounds(secondColumnMargin, IDLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        phoneNumberLabel.setBounds(firstColumnMargin, userNameLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        addressLabel.setBounds(secondColumnMargin, passwordLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        interestRateLabel.setBounds(firstColumnMargin, phoneNumberLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        loanStatusLabel.setBounds(secondColumnMargin, addressLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        emailLabel.setBounds(firstColumnMargin, interestRateLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        websiteLabel.setBounds(secondColumnMargin, loanStatusLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        employeesNumberLabel.setBounds(firstColumnMargin, emailLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);
        industryTypeLabel.setBounds(secondColumnMargin, websiteLabel.getBounds().y + labelsMargin, labelWidth, labelHeight);

        //Event handling
        showTransactionsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    new TransactionsScreen(company).setVisible(true);
                } catch (IOException | ClassNotFoundException  ex) {
                   // Logger.getLogger(CompanyScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Adding components to the frame
        screen.add(IDLabel);
        screen.add(userNameLabel);
        screen.add(passwordLabel);
        screen.add(phoneNumberLabel);
        screen.add(addressLabel);
        screen.add(interestRateLabel);
        screen.add(loanStatusLabel);
        screen.add(emailLabel);
        screen.add(websiteLabel);
        screen.add(employeesNumberLabel);
        screen.add(industryTypeLabel);
    }
    
        public static void main(String[] args)
    {
        //new CompanyScreen().setVisible(true);
    } 
}
