package GUI;

import Core.Human;
import Core.Staff.Staff;
import Core.Staff.accountManager;
import Core.Users.Account;
import Core.Users.Company;
import Core.Users.creditCard;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AccountManagerScreen extends StaffMainLayout
{  
    //Main things
    private JLabel userNameLabel;
    private JTextField userNameField;
    private JLabel userNameErrorSign;
    
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel passwordErrorSign;
    
    private JLabel passwordConfirmLabel;
    private JPasswordField passwordConfirmField;
    private JLabel passwordConfirmErrorSign;
    
    private JLabel phoneNumberLabel;
    private JTextField phoneNumberField;
    private JLabel phoneNumberErrorSign;
    
    private JLabel addressLabel;
    private JTextField addressField;
    private JLabel addressErrorSign;
    
    private JLabel moneyBalanceLabel;
    private JTextField moneyBalanceField;
    private JLabel moneyBalanceErrorSign;
    
    private JLabel interestRateLabel;
    private JTextField interestRateField;
    private JLabel interestRateErrorSign;
    
    private JLabel loanStatusLabel;;
    private JRadioButton activeLoan;
    private JRadioButton unActiveLoan;
    
    private JButton saveButton;
    private JButton choosePictureButton;
    private JFileChooser profilePictureChooser;
    private FileNameExtensionFilter filter;  
    
    private int fieldWidth = 160;
    private int fieldHeight = 25;
    
    private int labelWidth = 90;
    private int labelHeight = 40;
    
    private int margin = 50;
    
    private int iconSize = 20;
    
    private int firstColumnMargin = 70;
    private int secondColumnMargin = 470;
    
    private int labelFontSize = 14;
    private int fieldFontSize = 12;
    
    private String font = "Arial";
    
    private Icon error;
    private Icon checked;
    private Icon unchecked;
    
    //Individual things
    private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JLabel firstNameErrorSign;
    
    private JLabel lastNameLabel;
    private JTextField lastNameField;
    private JLabel lastNameErrorSign;
    
    private JLabel SSNLabel;
    private JTextField SSNField;
    private JLabel SSNErrorSign;
    
    private JLabel ageLabel;
    private JTextField ageField;
    private JLabel ageErrorSign;
    
    private JLabel genderLabel;
    private JRadioButton male;
    private JRadioButton female;
    
    //Company Things
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel nameErrorSign;
    
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel emailErrorSign;
    
    private JLabel websiteLabel;
    private JTextField websiteField;
    private JLabel websiteErrorSign;
    
    private JLabel employeesNumberLabel;
    private JTextField employeesNumberField;
    private JLabel employeesNumberErrorSign;
    
    private JLabel industryTypeLabel;
    private JComboBox industryTypeComboBox;
      
    private JPanel IndividualPanel;
    private JPanel CompanyPanel;
    
    private JLabel individualLabel;
    private JLabel companyLabel;
    
    private JButton cancelButton;
    private JLabel confirmationLabel;

    public AccountManagerScreen(Staff user)
    {
        //Calling tha mian screen
        super("Account Manager", user.getFirstName() + " " + user.getLastName());

        //Setting layout
        screen = getContentPane();
        screen.setLayout(null);
        
        //Creating panels        
        IndividualPanel = new JPanel();
        IndividualPanel.setLayout(null);
        IndividualPanel.setBounds(0, 170, 800, 430);
        
        CompanyPanel = new JPanel();
        CompanyPanel.setLayout(null);
        CompanyPanel.setBounds(0, 170, 800, 430);
        
        //Creating components
        error = new ImageIcon(getClass().getResource("Icons\\error.png"));
        checked = new ImageIcon(getClass().getResource("Icons\\checked.png"));
        unchecked = new ImageIcon(getClass().getResource("Icons\\unchecked.png"));
        
        userNameLabel = new JLabel("<html><b>Username:</b></html>");
        userNameField = new JTextField();
        userNameErrorSign = new JLabel(error);
        
        passwordLabel = new JLabel("<html><b>Password:</b></html>");
        passwordField = new JPasswordField();
        passwordErrorSign = new JLabel(error);
        
        passwordConfirmLabel = new JLabel("<html><b>Confirm your password:</b></html>");
        passwordConfirmField = new JPasswordField();
        passwordConfirmErrorSign = new JLabel(error);
        
        phoneNumberLabel = new JLabel("<html><b>Phone Number:</b></html>");
        phoneNumberField = new JTextField();
        phoneNumberErrorSign = new JLabel(error);
        
        addressLabel = new JLabel("<html><b>Address:</b></html>");
        addressField = new JTextField();
        addressErrorSign = new JLabel(error);
        
        moneyBalanceLabel = new JLabel("<html><b>Money:</b></html>");
        moneyBalanceField = new JTextField();
        moneyBalanceErrorSign = new JLabel(error);
        
        interestRateLabel = new JLabel("<html><b>Interest Rate:</b></html>");
        interestRateField = new JTextField();
        interestRateErrorSign = new JLabel(error);
        
        loanStatusLabel = new JLabel("<html><b>loan Status:</b></html>");
        activeLoan = new JRadioButton("Active");
        unActiveLoan = new JRadioButton("Unactive");
        
        saveButton = new JButton("  ");
        cancelButton = new JButton("Cancel");
        confirmationLabel = new JLabel();
        choosePictureButton = new JButton("Choose picture");
        
        //Grouping the radioboxes
        ButtonGroup loanStatus = new ButtonGroup();
        loanStatus.add(activeLoan);
        loanStatus.add(unActiveLoan);
        
        //Setting colors
        userNameLabel.setForeground(new Color(63,81,181));
        passwordLabel.setForeground(new Color(63,81,181));
        passwordConfirmLabel.setForeground(new Color(63,81,181));
        phoneNumberLabel.setForeground(new Color(63,81,181));  
        addressLabel.setForeground(new Color(63,81,181));
        interestRateLabel.setForeground(new Color(63,81,181));
        moneyBalanceLabel.setForeground(new Color(63,81,181)); 
        loanStatusLabel.setForeground(new Color(63,81,181));
        
        saveButton.setBackground(new Color(63,81,181));
        saveButton.setForeground(Color.white);
        
        cancelButton.setBackground(Color.white);
        cancelButton.setForeground(new Color(63,81,181));
        
        confirmationLabel.setForeground(Color.black);
        
        choosePictureButton.setBackground(new Color(63,81,181));
        choosePictureButton.setForeground(Color.white);
        
        //Setting icons
        activeLoan.setIcon(checked);
        unActiveLoan.setIcon(unchecked);
        
        //Setting fonts
        userNameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        userNameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
       
        passwordLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        passwordField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
       
        passwordConfirmLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        passwordConfirmField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
      
        phoneNumberLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        phoneNumberField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
     
        addressLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        addressField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
      
        moneyBalanceLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        moneyBalanceField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        interestRateLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        interestRateField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
      
        loanStatusLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        
        saveButton.setFont(new Font("Arial", Font.PLAIN, 18));
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmationLabel.setFont(new Font(font, Font.PLAIN, 19));
        choosePictureButton.setFont(new Font("Arial", Font.PLAIN, 13));
        
        //Setting text alignment
        userNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        phoneNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        moneyBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        interestRateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        loanStatusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        confirmationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Setting positions
        userNameLabel.setBounds(firstColumnMargin, 15, labelWidth, labelHeight);
        userNameField.setBounds(userNameLabel.getBounds().x + labelWidth + 10, userNameLabel.getBounds().y + 9, fieldWidth - 30, fieldHeight);
        userNameErrorSign.setBounds(userNameField.getBounds().x - 30+ fieldWidth - 30 + 5, userNameField.getBounds().y + 3, iconSize, iconSize);
        
        passwordLabel.setBounds(firstColumnMargin, userNameLabel.getBounds().y + margin, labelWidth, labelHeight);
        passwordField.setBounds(passwordLabel.getBounds().x + labelWidth + 10, passwordLabel.getBounds().y + 9, fieldWidth, fieldHeight);
        passwordErrorSign.setBounds(passwordField.getBounds().x + fieldWidth + 5, passwordField.getBounds().y + 3, iconSize, iconSize);
        
        passwordConfirmLabel.setBounds(secondColumnMargin - 80, userNameLabel.getBounds().y + margin, labelWidth + 80, labelHeight);
        passwordConfirmField.setBounds(passwordConfirmLabel.getBounds().x + labelWidth + 90, passwordConfirmLabel.getBounds().y + 9, fieldWidth, fieldHeight);
        passwordConfirmErrorSign.setBounds(passwordConfirmField.getBounds().x + fieldWidth + 5, passwordConfirmField.getBounds().y + 3, iconSize, iconSize);
             
        phoneNumberLabel.setBounds(firstColumnMargin - 20, passwordLabel.getBounds().y + margin, labelWidth + 20, labelHeight);
        phoneNumberField.setBounds(phoneNumberLabel.getBounds().x + labelWidth + 30, phoneNumberLabel.getBounds().y + 9, fieldWidth, fieldHeight);
        phoneNumberErrorSign.setBounds(phoneNumberField.getBounds().x + fieldWidth + 5, phoneNumberField.getBounds().y + 3, iconSize, iconSize);
        
        addressLabel.setBounds(secondColumnMargin, passwordLabel.getBounds().y + margin, labelWidth, labelHeight);
        addressField.setBounds(addressLabel.getBounds().x + labelWidth + 10, addressLabel.getBounds().y + 9, fieldWidth, fieldHeight);
        addressErrorSign.setBounds(addressField.getBounds().x + fieldWidth + 5, addressField.getBounds().y + 3, iconSize, iconSize);
        
        moneyBalanceLabel.setBounds(firstColumnMargin, phoneNumberLabel.getBounds().y + margin, labelWidth, labelHeight);
        moneyBalanceField.setBounds(moneyBalanceLabel.getBounds().x + labelWidth + 10, moneyBalanceLabel.getBounds().y + 9, fieldWidth - 90, fieldHeight);
        moneyBalanceErrorSign.setBounds(moneyBalanceField.getBounds().x + fieldWidth - 90 + 5, moneyBalanceField.getBounds().y + 3, iconSize, iconSize);
        
        interestRateLabel.setBounds(firstColumnMargin + 200, phoneNumberLabel.getBounds().y + margin, labelWidth + 10, labelHeight);
        interestRateField.setBounds(interestRateLabel.getBounds().x + labelWidth + 20, interestRateLabel.getBounds().y + 9, fieldWidth - 120, fieldHeight);
        interestRateErrorSign.setBounds(interestRateField.getBounds().x + fieldWidth - 120 + 5, interestRateField.getBounds().y + 3, iconSize, iconSize);
        
        loanStatusLabel.setBounds(secondColumnMargin, addressLabel.getBounds().y + margin, labelWidth, labelHeight);
        activeLoan.setBounds(secondColumnMargin + 95, addressLabel.getBounds().y + margin + 5, 90, labelHeight - 5);
        unActiveLoan.setBounds(secondColumnMargin + 180, addressLabel.getBounds().y + margin + 5, 90, labelHeight - 5);
        
        saveButton.setBounds(235, 330, 200, 40);
        confirmationLabel.setBounds(200, 330, 400, 40);
        cancelButton.setBounds(440, 330, 100, 40);
        choosePictureButton.setBounds(firstColumnMargin + 480, loanStatusLabel.getBounds().y + (2* margin), labelWidth + 60, labelHeight - 5);
        
        //Controlling visiblity options
        userNameErrorSign.setVisible(false);
        passwordErrorSign.setVisible(false);
        passwordConfirmErrorSign.setVisible(false);
        phoneNumberErrorSign.setVisible(false);
        addressErrorSign.setVisible(false);
        moneyBalanceErrorSign.setVisible(false);
        interestRateErrorSign.setVisible(false);
        interestRateLabel.setVisible(false);
        interestRateField.setVisible(false);
        
        //Setting borders
        userNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        phoneNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        moneyBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        interestRateField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        //Adding components to the frame
         addCommonThings(1);
        
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
                userNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        passwordField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        passwordConfirmField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        passwordConfirmField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        phoneNumberField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                phoneNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                phoneNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        addressField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        moneyBalanceField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                moneyBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                moneyBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        //Controlling radiobutton icon
        activeLoan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (activeLoan.getIcon() == unchecked && unActiveLoan.getIcon() == checked) 
                {
                    activeLoan.setIcon(checked);
                    unActiveLoan.setIcon(unchecked);
                }
            
                else 
                {
                    activeLoan.setIcon(unchecked);
                    unActiveLoan.setIcon(checked);
                }               
            }
        });
        
        unActiveLoan.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (unActiveLoan.getIcon() == unchecked && activeLoan.getIcon() == checked) 
                {
                    unActiveLoan.setIcon(checked);
                    activeLoan.setIcon(unchecked);
                }        
                    
                else 
                {
                    unActiveLoan.setIcon(unchecked);
                    activeLoan.setIcon(checked);
                }       
            }
        });
        
        activeLoan.setFocusPainted(false);
        unActiveLoan.setFocusPainted(false);
        saveButton.setFocusPainted(false);
        cancelButton.setFocusPainted(false);
        
        //Event Handling
        userNameField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                try
                {
                    if (Human.checkUserName(userNameField.getText()) == false)
                        userNameErrorSign.setVisible(false);
                    
                    else
                        userNameErrorSign.setVisible(true);
                } 
                catch (ClassNotFoundException | IOException ex)
                {
                    Logger.getLogger(AccountManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
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
        
        passwordConfirmField.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {        
                if (!Arrays.equals(passwordField.getPassword(), passwordConfirmField.getPassword()))
                    passwordConfirmErrorSign.setVisible(true);
                else
                    passwordConfirmErrorSign.setVisible(false);
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                //NOTHING TODO
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                //NOTHING TODO
            }       
        });
        
        //Creating components
        firstNameLabel = new JLabel("<html><b>First Name:</b></html>");
        firstNameField = new JTextField();
        firstNameErrorSign = new JLabel(error);
        
        lastNameLabel = new JLabel("<html><b>Last Name:</b></html>");
        lastNameField = new JTextField();
        lastNameErrorSign = new JLabel(error);
        
        SSNLabel = new JLabel("<html><b>SSN:</b></html>");
        SSNField = new JTextField();
        SSNErrorSign = new JLabel(error);
        
        ageLabel = new JLabel("<html><b>Age:</b></html>");
        ageField = new JTextField();
        ageErrorSign = new JLabel(error);
        
        genderLabel = new JLabel("<html><b>Gender:</b></html>");
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        
        //Grouping the radioboxes
        ButtonGroup Gender = new ButtonGroup();
        Gender.add(male);
        Gender.add(female);
        
        //Setting colors
        firstNameLabel.setForeground(new Color(63,81,181));
        lastNameLabel.setForeground(new Color(63,81,181));  
        SSNLabel.setForeground(new Color(63,81,181));
        ageLabel.setForeground(new Color(63,81,181));
        genderLabel.setForeground(new Color(63,81,181));
        
        //Setting icons
        male.setIcon(checked);
        female.setIcon(unchecked);
        
        //Setting fonts
        firstNameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        firstNameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        lastNameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        lastNameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        SSNLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        SSNField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        ageLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        ageField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        genderLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        
        //Setting text alignment
        firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        SSNLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        ageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        genderLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        //Setting positions
        firstNameLabel.setBounds(firstColumnMargin + 260, 10, labelWidth, labelHeight);
        firstNameField.setBounds(firstNameLabel.getBounds().x + labelWidth + 10, firstNameLabel.getBounds().y + 9, fieldWidth - 60, fieldHeight);
        firstNameErrorSign.setBounds(firstNameField.getBounds().x + fieldWidth - 60 + 5, firstNameField.getBounds().y + 3, iconSize, iconSize);
        
        lastNameLabel.setBounds(firstColumnMargin + 490, 10, labelWidth, labelHeight);
        lastNameField.setBounds(lastNameLabel.getBounds().x + labelWidth + 10, lastNameLabel.getBounds().y + 9, fieldWidth - 60, fieldHeight);
        lastNameErrorSign.setBounds(lastNameField.getBounds().x + fieldWidth - 60 + 5, lastNameField.getBounds().y + 3, iconSize, iconSize);
    
        SSNLabel.setBounds(firstColumnMargin, moneyBalanceLabel.getBounds().y + margin, labelWidth, labelHeight);
        SSNField.setBounds(SSNLabel.getBounds().x + labelWidth + 10, SSNLabel.getBounds().y + 9, fieldWidth, fieldHeight);
        SSNErrorSign.setBounds(SSNField.getBounds().x + fieldWidth + 5, SSNField.getBounds().y + 3, iconSize, iconSize);
        
        ageLabel.setBounds(secondColumnMargin, loanStatusLabel.getBounds().y + margin, labelWidth, labelHeight);
        ageField.setBounds(ageLabel.getBounds().x + labelWidth + 10, ageLabel.getBounds().y + 9, fieldWidth - 120, fieldHeight);
        ageErrorSign.setBounds(ageField.getBounds().x + fieldWidth - 120 + 5, ageField.getBounds().y + 3, iconSize, iconSize);
        
        genderLabel.setBounds(firstColumnMargin, SSNLabel.getBounds().y + margin, labelWidth, labelHeight);
        male.setBounds(firstColumnMargin + 95, SSNLabel.getBounds().y + margin + 5, 90, labelHeight - 5);
        female.setBounds(firstColumnMargin + 180, SSNLabel.getBounds().y + margin + 5, 90, labelHeight - 5);
        
        //Controlling visiblity options
        firstNameErrorSign.setVisible(false);
        lastNameErrorSign.setVisible(false);
        SSNErrorSign.setVisible(false);
        ageErrorSign.setVisible(false);
        
        //Setting borders
        firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        SSNField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        //Adding components to the frame
        IndividualPanel.add(firstNameLabel);
        IndividualPanel.add(firstNameField);
        IndividualPanel.add(firstNameErrorSign);
        
        IndividualPanel.add(lastNameLabel);
        IndividualPanel.add(lastNameField);
        IndividualPanel.add(lastNameErrorSign);
        
        IndividualPanel.add(SSNLabel);
        IndividualPanel.add(SSNField);
        IndividualPanel.add(SSNErrorSign);
        
        IndividualPanel.add(ageLabel);
        IndividualPanel.add(ageField);
        IndividualPanel.add(ageErrorSign);
        
        IndividualPanel.add(genderLabel);
        IndividualPanel.add(male);
        IndividualPanel.add(female);
        
        //Controlling radiobutton icon
        male.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (male.getIcon() == unchecked && female.getIcon() == checked) 
                {
                    male.setIcon(checked);
                    female.setIcon(unchecked);
                }
            
                else 
                {
                    male.setIcon(unchecked);
                    female.setIcon(checked);
                }               
            }
        });
        
        female.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if (female.getIcon() == unchecked && male.getIcon() == checked) 
                {
                    female.setIcon(checked);
                    male.setIcon(unchecked);
                }        
                    
                else 
                {
                    female.setIcon(unchecked);
                    male.setIcon(checked);
                }       
            }
        });
        
        male.setFocusPainted(false);
        female.setFocusPainted(false);
         
        //Focus handling
        firstNameField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        lastNameField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        SSNField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                SSNField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                SSNField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        ageField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                ageField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        //Creating components        
        nameLabel = new JLabel("<html><b>Name:</b></html>");
        nameField = new JTextField();
        nameErrorSign = new JLabel(error);
        
        emailLabel = new JLabel("<html><b>Email:</b></html>");
        emailField = new JTextField();
        emailErrorSign = new JLabel(error);
        
        websiteLabel = new JLabel("<html><b>Website:</b></html>");
        websiteField = new JTextField();
        websiteErrorSign = new JLabel(error);
        
        employeesNumberLabel = new JLabel("<html><b>Employees Number:</b></html>");
        employeesNumberField = new JTextField();
        employeesNumberErrorSign = new JLabel(error);
        
        industryTypeLabel = new JLabel("<html><b>Industry Type:</b></html>");
        industryTypeComboBox = new JComboBox();
        
        //Adding items to the combp box
        industryTypeComboBox.addItem("Technology");
        industryTypeComboBox.addItem("Medical");
        industryTypeComboBox.addItem("Business");
        industryTypeComboBox.addItem("Software");
        
        //Setting colors
        nameLabel.setForeground(new Color(63,81,181));

        emailLabel.setForeground(new Color(63,81,181));
        
        
        websiteLabel.setForeground(new Color(63,81,181));
        
        
        employeesNumberLabel.setForeground(new Color(63,81,181));
        
        
        industryTypeLabel.setForeground(new Color(63,81,181));
        
        
        //Setting fonts
        nameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        nameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        emailLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        emailField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        websiteLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        websiteField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        employeesNumberLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        employeesNumberField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        industryTypeLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        industryTypeComboBox.setFont(new Font(font, Font.PLAIN, fieldFontSize));
        
        //Setting text alignment
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        websiteLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        employeesNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        industryTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
        //Setting positions
        nameLabel.setBounds(secondColumnMargin, 15, labelWidth, labelHeight);
        nameField.setBounds(nameLabel.getBounds().x + labelWidth + 10, nameLabel.getBounds().y + 9, fieldWidth - 30, fieldHeight);
        nameErrorSign.setBounds(nameField.getBounds().x + fieldWidth - 30 + 5, nameField.getBounds().y + 3, iconSize, iconSize);
        
        emailLabel.setBounds(firstColumnMargin, moneyBalanceLabel.getBounds().y + margin, labelWidth, labelHeight);
        emailField.setBounds(emailLabel.getBounds().x + labelWidth + 10, emailLabel.getBounds().y + 9, fieldWidth , fieldHeight);
        emailErrorSign.setBounds(emailField.getBounds().x + fieldWidth + 5, nameField.getBounds().y + 3, iconSize, iconSize);
        
        websiteLabel.setBounds(secondColumnMargin, loanStatusLabel.getBounds().y + margin, labelWidth, labelHeight);
        websiteField.setBounds(websiteLabel.getBounds().x + labelWidth + 10, websiteLabel.getBounds().y + 9, fieldWidth, fieldHeight);
        websiteErrorSign.setBounds(websiteField.getBounds().x + fieldWidth + 5, websiteField.getBounds().y + 3, iconSize, iconSize);
        
        employeesNumberLabel.setBounds(firstColumnMargin - 50, emailLabel.getBounds().y + margin, labelWidth + 50, labelHeight);
        employeesNumberField.setBounds(employeesNumberLabel.getBounds().x + labelWidth + 60, employeesNumberLabel.getBounds().y + 9, fieldWidth - 120, fieldHeight);
        employeesNumberErrorSign.setBounds(employeesNumberField.getBounds().x + fieldWidth - 120 + 5, employeesNumberField.getBounds().y + 3, iconSize, iconSize);
        
        industryTypeLabel.setBounds(firstColumnMargin + 140, emailLabel.getBounds().y + margin, labelWidth + 50 , labelHeight);
        industryTypeComboBox.setBounds(industryTypeLabel.getBounds().x + labelWidth + 60, industryTypeLabel.getBounds().y + 9, fieldWidth - 40, fieldHeight);
        
        //Controlling visiblity options
        nameErrorSign.setVisible(false);
        emailErrorSign.setVisible(false);
        websiteErrorSign.setVisible(false);
        employeesNumberErrorSign.setVisible(false);
        
        //Setting borders
        nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        websiteField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        employeesNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        industryTypeComboBox.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        //Adding components to the frame        
        CompanyPanel.add(nameLabel);
        CompanyPanel.add(nameField);
        CompanyPanel.add(nameErrorSign);
        
        CompanyPanel.add(emailLabel);
        CompanyPanel.add(emailField);
        CompanyPanel.add(emailErrorSign);
        
        CompanyPanel.add(websiteLabel);
        CompanyPanel.add(websiteField);
        CompanyPanel.add(websiteErrorSign);
        
        CompanyPanel.add(employeesNumberLabel);
        CompanyPanel.add(employeesNumberField);
        CompanyPanel.add(employeesNumberErrorSign);
        
        CompanyPanel.add(industryTypeLabel);
        CompanyPanel.add(industryTypeComboBox);
        
        //Focus handling
        nameField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        emailField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        websiteField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                websiteField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                websiteField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        employeesNumberField.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusLost(FocusEvent arg0)
            {
                employeesNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                employeesNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });

        setFieldsBackground();
        disableFields(1);
        saveButton.setVisible(false);
        cancelButton.setVisible(false);
        confirmationLabel.setVisible(false);
        IndividualPanel.setVisible(true);
        screen.add(IndividualPanel);
        CompanyPanel.setVisible(false);
        screen.add(CompanyPanel);
        
        //Creating components
        individualLabel = new JLabel("Indiviual");
        companyLabel = new JLabel("Company");
        
        //Setting colors
        individualLabel.setForeground(new Color(63,81,181));
        companyLabel.setForeground(Color.gray);
        
        //Setting fonts
        individualLabel.setFont(new Font("<html><b>Open sans</b><html>", Font.PLAIN, 27));
        companyLabel.setFont(new Font("<html><b>Open sans</b><html>", Font.PLAIN, 27));
        
        //Setting cursor
        individualLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        companyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        //Setting positions
        individualLabel.setBounds(50, 100, 100, 40);
        companyLabel.setBounds(170, 100, 125, 40);
        
        //Adding components to the frame
        screen.add(individualLabel);
        screen.add(companyLabel);
        
        
        
        individualLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                individualLabel.setForeground(new Color(63,81,181));
                companyLabel.setForeground(Color.gray);
                
                IndividualPanel.setVisible(true);
                CompanyPanel.setVisible(false);
                
                searchField.setText("Search");
                
                
                addCommonThings(1);
                clearFields(2);
            }
        });
        
        companyLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                individualLabel.setForeground(Color.gray);
                companyLabel.setForeground(new Color(63,81,181));
                
                IndividualPanel.setVisible(false);
                CompanyPanel.setVisible(true);
                
                searchField.setText("Search");

                addCommonThings(2);
                clearFields(1);
            }
        });
        
        //Event handling
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)
            {
                accountManager staff = new accountManager();
                setFieldsBackground();
                
                saveButton.setVisible(false);
                cancelButton.setVisible(false);
                confirmationLabel.setVisible(false);
    
                if (IndividualPanel.isVisible())
                {
                    Account clientAccount = new Account();
                    clientAccount.setUserName(searchField.getText());
                    disableFields(1);
                    
                    try
                    {
                        clientAccount = (Account) staff.searchAccount(clientAccount);
                        
                        if (clientAccount.getUserName() != null)
                        {
                            interestRateLabel.setVisible(true);
                            interestRateField.setVisible(true);
                
                            //Filling fields
                            fillIndividualFields(clientAccount);                            
                            
                            //Disabling editing 
                            disableFields(1);
                        }   
                    }
                    catch (ClassNotFoundException | IOException ex)
                    {
                        //NOTTHING TODO
                    }
                }
                else
                {
                    Company company = new Company();
                    company.setUserName(searchField.getText());
                    disableFields(2);
                    
                    try
                    {
                        interestRateLabel.setVisible(true);
                        interestRateField.setVisible(true);
                
                        company = (Company) staff.searchAccount(company);
                        
                        if (company.getUserName() != null)
                        {
                            //Filling fields
                            fillCompanyFields(company);

                            //Disabling editing 
                            disableFields(2);
                        }
                    } 
                    catch (ClassNotFoundException | IOException ex)
                    {
                        //NOTHING TODO
                    }      
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                //NOTHING TODO
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                //NOTHING TODO
            }
        });
        
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                confirmationLabel.setVisible(false);
                saveButton.setText("Create Account");
                searchField.setText("Search");
                interestRateLabel.setVisible(false);
                interestRateField.setVisible(false);
                
                if (IndividualPanel.isVisible())
                {
                    enableAllFields(1);
                    setFieldsBackground();
                    clearFields(1);
                }
                else
                {
                    enableAllFields(2);
                    setFieldsBackground();
                    clearFields(2);   
                }    
                
                saveButton.setVisible(true);
                cancelButton.setVisible(true);
            }   
        });
        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saveButton.setVisible(true);
                cancelButton.setVisible(true);
                confirmationLabel.setVisible(false);
                saveButton.setText("Update Account");
                interestRateLabel.setVisible(true);
                interestRateField.setVisible(true);
                
                if (IndividualPanel.isVisible())
                {
                    enableFields(1);
                    setFieldsBackground();
                }  
                else
                {
                    enableFields(2);
                    setFieldsBackground();
                }
                   
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saveButton.setVisible(true);
                cancelButton.setVisible(true);
                confirmationLabel.setVisible(false);
                saveButton.setText("Delete Account");
                interestRateLabel.setVisible(true);
                interestRateField.setVisible(true);
                
                if (IndividualPanel.isVisible())
                {
                    disableFields(1);
                    setFieldsBackground();
                }   
                else
                {
                    disableFields(2);
                    setFieldsBackground();
                }
                    
            }
        });
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (saveButton.getText() == "Create Account")
                {
                    accountManager staff = new accountManager();
                    
                    if (IndividualPanel.isVisible())
                    {
                        Account clientAccount = new Account();
                        creditCard card = new creditCard();
                        card.setCreditCardNumber(0);
                        card.setCVC(0);
                        card.setExpirationDate(null);
                        
                        clientAccount.setCreditCard(card);
                        
                        clientAccount = readAllIndividualFields(clientAccount);

                        try
                        {
                            staff.createAccount(clientAccount);
                            saveButton.setVisible(false);
                            cancelButton.setVisible(false);
                            confirmationLabel.setText("Account created successfully!");
                            confirmationLabel.setVisible(true);
                            interestRateLabel.setVisible(true);
                            interestRateField.setVisible(true);
                            fillIndividualFields(clientAccount);
                            disableFields(1);
                        } 
                        catch (ClassNotFoundException | IOException ex)
                        {
                            Logger.getLogger(AccountManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        Company company = new Company();
                        company = readAllCompanyFields(company);

                        try
                        {
                            staff.createAccount(company);
                            saveButton.setVisible(false);
                            cancelButton.setVisible(false);
                            confirmationLabel.setText("Account created successfully!");
                            confirmationLabel.setVisible(true);
                            interestRateLabel.setVisible(true);
                            interestRateField.setVisible(true);
                            fillCompanyFields(company);
                            disableFields(1);
                        } 
                        catch (ClassNotFoundException | IOException ex)
                        {
                            Logger.getLogger(AccountManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else if (saveButton.getText() == "Update Account")
                {
                    accountManager staff = new accountManager();
                    
                    if (IndividualPanel.isVisible())
                    {
                        Account clientAccount = new Account();
                        clientAccount = readAllIndividualFields(clientAccount);

                        try
                        {
                            staff.updateAccount(clientAccount);
                            saveButton.setVisible(false);
                            cancelButton.setVisible(false);
                            confirmationLabel.setText("Account updated successfully!");
                            confirmationLabel.setVisible(true);
                            fillIndividualFields(clientAccount);
                            disableFields(1);
                        } 
                        catch (ClassNotFoundException | IOException ex)
                        {
                            Logger.getLogger(AccountManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        Company company = new Company();
                        company = readAllCompanyFields(company);

                        try
                        {
                            staff.updateAccount(company);
                            saveButton.setVisible(false);
                            cancelButton.setVisible(false);
                            confirmationLabel.setText("Account updated successfully!");
                            confirmationLabel.setVisible(true);
                            fillCompanyFields(company);
                            disableFields(1);
                        }
                        catch (ClassNotFoundException | IOException ex)
                        {
                            Logger.getLogger(AccountManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else
                {
                    accountManager staff = new accountManager();
                    
                    if (IndividualPanel.isVisible())
                    {
                        Account clientAccount = new Account();
                        clientAccount = readAllIndividualFields(clientAccount);

                        try
                        {
                            staff.deleteAccount(clientAccount);
                            saveButton.setVisible(false);
                            cancelButton.setVisible(false);
                            confirmationLabel.setText("Account deleted successfully!");
                            confirmationLabel.setVisible(true);
                            clearFields(1);
                        } 
                        catch (ClassNotFoundException | IOException ex)
                        {
                            Logger.getLogger(AccountManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        Company company = new Company();
                        company = readAllCompanyFields(company);

                        try
                        {
                            staff.deleteAccount(company);
                            saveButton.setVisible(false);
                            cancelButton.setVisible(false);
                            confirmationLabel.setText("Account deleted successfully!");
                            confirmationLabel.setVisible(true);
                            clearFields(2);
                        }
                        catch (ClassNotFoundException | IOException ex)
                        {
                            Logger.getLogger(AccountManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                saveButton.setVisible(false);
                cancelButton.setVisible(false);

                searchField.setText("Search");

                if (IndividualPanel.isVisible())
                {
                    clearFields(1);
                    disableFields(1);
                }
                else
                {
                    clearFields(2);
                    disableFields(2);
                }
            }
        });
    }
    
    private void clearFields(int panel)
    {
        //Individual Panel
        if (panel == 1)
        {
            userNameField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            passwordField.setText("");
            passwordConfirmField.setText("");
            phoneNumberField.setText("");
            addressField.setText("");
            moneyBalanceField.setText("");
            interestRateField.setText("");
            activeLoan.setSelected(true);
            SSNField.setText("");
            ageField.setText("");
            male.setSelected(true);
        }
        else
        {
            userNameField.setText("");
            nameField.setText("");
            passwordField.setText("");
            passwordConfirmField.setText("");
            phoneNumberField.setText("");
            addressField.setText("");
            emailField.setText("");
            websiteField.setText("");
            employeesNumberField.setText("");
            moneyBalanceField.setText("");
            interestRateField.setText("");
            activeLoan.setSelected(true);
        }
    }
    
    private void addCommonThings(int panel)
    {
        if (panel == 1)
        {
            IndividualPanel.add(userNameLabel);
            IndividualPanel.add(userNameField);
            IndividualPanel.add(userNameErrorSign);

            IndividualPanel.add(passwordLabel);
            IndividualPanel.add(passwordField);
            IndividualPanel.add(passwordErrorSign);

            IndividualPanel.add(passwordConfirmLabel);
            IndividualPanel.add(passwordConfirmField);
            IndividualPanel.add(passwordConfirmErrorSign);

            IndividualPanel.add(addressLabel);
            IndividualPanel.add(addressField);
            IndividualPanel.add(addressErrorSign);

            IndividualPanel.add(phoneNumberLabel);
            IndividualPanel.add(phoneNumberField);
            IndividualPanel.add(phoneNumberErrorSign);

            IndividualPanel.add(moneyBalanceLabel);
            IndividualPanel.add(moneyBalanceField);
            IndividualPanel.add(moneyBalanceErrorSign);

            IndividualPanel.add(interestRateLabel);
            IndividualPanel.add(interestRateField);
            IndividualPanel.add(interestRateErrorSign);

            IndividualPanel.add(loanStatusLabel);
            IndividualPanel.add(activeLoan);
            IndividualPanel.add(unActiveLoan);

            IndividualPanel.add(saveButton);
            IndividualPanel.add(cancelButton);
            IndividualPanel.add(confirmationLabel);
            IndividualPanel.add(choosePictureButton);
        }
        else
        {
            CompanyPanel.add(userNameLabel);
            CompanyPanel.add(userNameField);
            CompanyPanel.add(userNameErrorSign);

            CompanyPanel.add(passwordLabel);
            CompanyPanel.add(passwordField);
            CompanyPanel.add(passwordErrorSign);

            CompanyPanel.add(passwordConfirmLabel);
            CompanyPanel.add(passwordConfirmField);
            CompanyPanel.add(passwordConfirmErrorSign);

            CompanyPanel.add(addressLabel);
            CompanyPanel.add(addressField);
            CompanyPanel.add(addressErrorSign);

            CompanyPanel.add(phoneNumberLabel);
            CompanyPanel.add(phoneNumberField);
            CompanyPanel.add(phoneNumberErrorSign);

            CompanyPanel.add(moneyBalanceLabel);
            CompanyPanel.add(moneyBalanceField);
            CompanyPanel.add(moneyBalanceErrorSign);

            CompanyPanel.add(interestRateLabel);
            CompanyPanel.add(interestRateField);
            CompanyPanel.add(interestRateErrorSign);

            CompanyPanel.add(loanStatusLabel);
            CompanyPanel.add(activeLoan);
            CompanyPanel.add(unActiveLoan);

            CompanyPanel.add(saveButton);
            CompanyPanel.add(cancelButton);
            CompanyPanel.add(confirmationLabel);
            CompanyPanel.add(choosePictureButton);
        }
    }
    
    private Account readAllIndividualFields(Account clientAccount)
    {
        clientAccount.setUserName(userNameField.getText());
        clientAccount.setPassword(passwordField.getText());
        clientAccount.setFirstName(firstNameField.getText());
        clientAccount.setLastName(lastNameField.getText());
        clientAccount.setSSN(SSNField.getText());
        clientAccount.setPhoneNumber(phoneNumberField.getText());
        clientAccount.setAddress(addressField.getText());
        clientAccount.setAge(Integer.parseInt(ageField.getText()));
        if (male.isSelected())
            clientAccount.setGender("Male");
        else
            clientAccount.setGender("Female");
        clientAccount.setMoneyBalance(Double.parseDouble(moneyBalanceField.getText()));
        if (activeLoan.isSelected())
            clientAccount.setLoanStatus(true);
        else
            clientAccount.setLoanStatus(false);
        
        return clientAccount;
    }
    
    private Company readAllCompanyFields(Company company)
    {
        company.setUserName(userNameField.getText());
        company.setPassword(passwordField.getText());
        company.setName(nameField.getText());
        company.setPhoneNumber(phoneNumberField.getText());
        company.setAddress(addressField.getText());
        company.setEmail(emailField.getText());
        company.setWebsite(websiteField.getText());
        company.setEmployeeNumber(Integer.parseInt(employeesNumberField.getText()));
        company.setIndustryType((String) industryTypeComboBox.getSelectedItem());
        company.setMoneyBalance(Double.parseDouble(moneyBalanceField.getText()));
        if (activeLoan.isSelected())
            company.setLoanStatus(true);
        else
            company.setLoanStatus(false);
        
        return company;
    }
    
    private void disableFields(int panel)
    {
        userNameField.setEditable(false);
        passwordField.setEditable(false);
        passwordConfirmField.setEditable(false);
        phoneNumberField.setEditable(false);
        addressField.setEditable(false);
        moneyBalanceField.setEditable(false);
        interestRateField.setEditable(false);
        activeLoan.setEnabled(false);
        unActiveLoan.setEnabled(false);
        
        if (panel == 1)
        {
            firstNameField.setEditable(false);
            lastNameField.setEditable(false);
            SSNField.setEditable(false);
            ageField.setEditable(false);
            male.setEnabled(false);
            female.setEnabled(false);
        }
        else  
        {
            nameField.setEditable(false); 
            emailField.setEditable(false); 
            websiteField.setEditable(false); 
            employeesNumberField.setEditable(false); 
            industryTypeComboBox.setEnabled(false); 
        }     
    }
    
    private void enableFields(int panel)
    {
        passwordField.setEditable(true);
        passwordConfirmField.setEditable(true);
        phoneNumberField.setEditable(true);
        addressField.setEditable(true);
        
        if (panel == 1)
            ageField.setEditable(true);
        else
            employeesNumberField.setEditable(true);
    }
    
    private void enableAllFields(int panel)
    {
        userNameField.setEditable(true);
        passwordField.setEditable(true);
        passwordConfirmField.setEditable(true);
        phoneNumberField.setEditable(true);
        addressField.setEditable(true);
        moneyBalanceField.setEditable(true);
        activeLoan.setEnabled(true);
        unActiveLoan.setEnabled(true);
        
        if (panel == 1)
        {
            firstNameField.setEditable(true);
            lastNameField.setEditable(true);
            SSNField.setEditable(true);
            ageField.setEditable(true);
            male.setEnabled(true);
            female.setEnabled(true);
        }
        else  
        {
            nameField.setEditable(true);
            emailField.setEditable(true);
            websiteField.setEditable(true);
            employeesNumberField.setEditable(true);
            industryTypeComboBox.setEnabled(true);
        }
            
    }
    
    private void setFieldsBackground()
    {
        userNameField.setBackground(null);
        passwordField.setBackground(null);
        passwordConfirmField.setBackground(null);
        phoneNumberField.setBackground(null);
        addressField.setBackground(null);
        addressField.setBackground(null);
        interestRateField.setBackground(null);
        moneyBalanceField.setBackground(null);
        firstNameField.setBackground(null);
        lastNameField.setBackground(null);
        SSNField.setBackground(null);
        ageField.setBackground(null);
        nameField.setBackground(null);
        emailField.setBackground(null);
        websiteField.setBackground(null);
        employeesNumberField.setBackground(null);
        industryTypeComboBox.setBackground(null);
    }
    
    private void fillIndividualFields(Account clientAccount)
    {
        userNameField.setText((clientAccount.getUserName() != null)? clientAccount.getUserName() : "");
        firstNameField.setText(clientAccount.getFirstName());
        lastNameField.setText(clientAccount.getLastName());
        passwordField.setText(clientAccount.getPassword());
        passwordConfirmField.setText(clientAccount.getPassword());
        phoneNumberField.setText(clientAccount.getPhoneNumber());
        addressField.setText(clientAccount.getAddress());
        moneyBalanceField.setText(Double.toString(clientAccount.getMoneyBalance()));
        interestRateField.setText((Float.toString(clientAccount.getInterestRate())));

        if (clientAccount.getLoanStatus() == true)
        {
            activeLoan.setSelected(true);
        } else
        {
            unActiveLoan.setSelected(true);
        }

        SSNField.setText(clientAccount.getSSN());
        ageField.setText(Integer.toString(clientAccount.getAge()));

        try
        {
            if ((clientAccount.getGender().equals("Male")))
            {
                male.setSelected(true);
            } else
            {
                female.setSelected(true);
            }
        } catch (NullPointerException ex)
        {
            //NOTHING TODO
        }
    }
    
    private void fillCompanyFields(Company company)
    {
        userNameField.setText((company.getUserName() != null)? company.getUserName() : "");
        nameField.setText(company.getName());
        passwordField.setText(company.getPassword());
        passwordConfirmField.setText(company.getPassword());
        phoneNumberField.setText(company.getPhoneNumber());
        addressField.setText(company.getAddress());
        emailField.setText(company.getEmail());
        websiteField.setText(company.getWebsite());
        employeesNumberField.setText(Integer.toString(company.getEmployeeNumber()));
        moneyBalanceField.setText(Double.toString(company.getMoneyBalance()));
        interestRateField.setText((Float.toString(company.getInterestRate())));

        if (company.getLoanStatus() == true)
        {
            activeLoan.setSelected(true);
        } else
        {
            unActiveLoan.setSelected(true);
        }
    }
}
