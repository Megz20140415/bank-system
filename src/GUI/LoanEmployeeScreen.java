//package GUI;
//import Core.Human;
//import java.awt.event.MouseAdapter;
//import Core.Staff.Staff;
//import Core.Staff.loanEmployee;
//import Core.Users.companyType;
//import Core.Users.individualType;
//import java.awt.Color;
//import java.awt.Cursor;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.awt.event.MouseEvent;
//import java.io.IOException;
//import javax.swing.BorderFactory;
//import javax.swing.ButtonGroup;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JRadioButton;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//
//public class LoanEmployeeScreen extends StaffMainLayout {
//
//    //Main things
//    private JLabel accountStatusLabel;
//    private JRadioButton activeLoan;
//    private JRadioButton unActiveLoan;
//
//    private JLabel phoneNumberLabel;
//    private JTextField phoneNumberField;
//    private JLabel phoneNumberErrorSign;
//
//    private JLabel addressLabel;
//    private JTextField addressField;
//    private JLabel addressErrorSign;
//
//    private JLabel loanBalanceLabel;
//    private JTextField laonBalanceField;
//    private JLabel laonBalanceErrorSign;
//
//    private JLabel interestRateLabel;
//    private JTextField interestRateField;
//    private JLabel interestRateErrorSign;
//
//    private JButton saveButton;
//    
//    
//    private int fieldWidth = 160;
//    private int fieldHeight = 25;
//
//    private int labelWidth = 90;
//    private int labelHeight = 40;
//
//    private int margin = 50;
//
//    private int iconSize = 20;
//
//    private int firstColumnMargin = 70;
//    private int secondColumnMargin = 470;
//
//    private int labelFontSize = 14;
//    private int fieldFontSize = 12;
//
//    private String font = "Arial";
//
//    private Icon error;
//    private Icon checked;
//    private Icon unchecked;
//
////Individual things
//    private JLabel firstNameLabel;
//    private JTextField firstNameField;
//    private JLabel firstNameErrorSign;
//
//    private JLabel lastNameLabel;
//    private JTextField lastNameField;
//    private JLabel lastNameErrorSign;
//
//    private JLabel SSNLabel;
//    private JTextField SSNField;
//    private JLabel SSNErrorSign;
//
//    private JLabel SalaryLabel;
//    private JTextField SalaryField;
//    private JLabel SalaryErrorSign;
//
////Company Things
//    private JLabel CapitalLabel;
//    private JTextField CapitalField;
//    private JLabel CapitalErrorSign;
//
//    private JLabel NameLabel;
//    private JTextField NameField;
//    private JLabel NameErrorSign;
//
//    
//    
//    private JPanel IndividualPanel;
//    private JPanel CompanyPanel;
//    
//    private JLabel individualLabel;
//    private JLabel companyLabel;
//    
//    private JButton cancelButton;
//    
//
//    public LoanEmployeeScreen(Staff user) {
//        
//    //Calling tha mian screen
//        super("Loan Employee", user.getFirstName() + user.getLastName());
//    
//    //Setting layout
//        screen = getContentPane();
//        screen.setLayout(null);
//        
//    //Creating panels        
//        IndividualPanel = new JPanel();
//        IndividualPanel.setLayout(null);
//        IndividualPanel.setBounds(0, 170, 800, 430);
//        
//        CompanyPanel = new JPanel();
//        CompanyPanel.setLayout(null);
//        CompanyPanel.setBounds(0, 170, 800, 430);
//        
//    //Creating components
//        error = new ImageIcon(getClass().getResource("Icons\\error.png"));
//        checked = new ImageIcon(getClass().getResource("Icons\\checked.png"));
//        unchecked = new ImageIcon(getClass().getResource("Icons\\unchecked.png"));
//        
//        phoneNumberLabel = new JLabel("<html><b>Phone Number:</b></html>");
//        phoneNumberField = new JTextField();
//        phoneNumberErrorSign = new JLabel(error);
//        
//        addressLabel = new JLabel("<html><b>Address:</b></html>");
//        addressField = new JTextField();
//        addressErrorSign = new JLabel(error);
//        
//        accountStatusLabel = new JLabel("<html><b>account Status:</b></html>");
//        activeLoan = new JRadioButton("Active");
//        unActiveLoan = new JRadioButton("Unactive");
//        
//        loanBalanceLabel = new JLabel("<html><b>balance:</b></html>");
//        laonBalanceField = new JTextField();
//        laonBalanceErrorSign = new JLabel(error);
//        
//        interestRateLabel = new JLabel("<html><b>Interest Rate:</b></html>");
//        interestRateField = new JTextField();
//        interestRateErrorSign = new JLabel(error);
//        
//        saveButton = new JButton("  ");
//        cancelButton = new JButton("Cancel");
//        
//        //Grouping the radioboxes
//        ButtonGroup accountStatus = new ButtonGroup();
//        accountStatus.add(activeLoan);
//        accountStatus.add(unActiveLoan);
//        
//        
//        //Setting colors
//        phoneNumberLabel.setForeground(new Color(63,81,181));  
//        addressLabel.setForeground(new Color(63,81,181));
//        interestRateLabel.setForeground(new Color(63,81,181));
//        loanBalanceLabel.setForeground(new Color(63,81,181));
//        accountStatusLabel.setForeground(new Color(63,81,181));
//        
//        saveButton.setBackground(new Color(63,81,181));
//        saveButton.setForeground(Color.white);
//        
//        cancelButton.setBackground(Color.white);
//        cancelButton.setForeground(new Color(63,81,181));
//        
//    //Setting icons
//        activeLoan.setIcon(checked);
//        unActiveLoan.setIcon(unchecked);
//        
//    //Setting fonts    
//        phoneNumberLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        phoneNumberField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//     
//        addressLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        addressField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//        
//        interestRateLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        interestRateField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//        
//        accountStatusLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        
//        loanBalanceLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        loanBalanceLabel.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//        
//        
//        saveButton.setFont(new Font("Arial", Font.PLAIN, 18));
//        cancelButton.setFont(new Font("Arial", Font.PLAIN, 18));
//        
//    //Setting text alignment
//        phoneNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        loanBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        interestRateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        accountStatusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        
//    //Setting positions
//    /*
//        1
//        1
//        1
//        1
//        1
//        1
//        1
//        1
//        1
//        1
//        11
//        1
//        
//        */
//        
//        saveButton.setBounds(235, 330, 200, 40);
//        cancelButton.setBounds(440, 330, 100, 40);
//        
//    //Controlling visiblity options
//        phoneNumberErrorSign.setVisible(false);
//        addressErrorSign.setVisible(false);
//        loanBalanceLabel.setVisible(false);
//        interestRateErrorSign.setVisible(false);
//        interestRateLabel.setVisible(false);
//        interestRateField.setVisible(false);
//    
//    //Setting borders
//        phoneNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        loanBalanceLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        interestRateField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//    
//    //Adding components to the frame
//         //addCommonThings(1);
//        
//    //Focus handling
//        phoneNumberField.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                phoneNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                phoneNumberField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//        
//        addressField.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//        
//        loanBalanceLabel.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                loanBalanceLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                loanBalanceLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//        
//        
//    //Controlling radiobutton icon
//        activeLoan.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent ae)
//            {
//                if (activeLoan.getIcon() == unchecked && unActiveLoan.getIcon() == checked) 
//                {
//                    activeLoan.setIcon(checked);
//                    unActiveLoan.setIcon(unchecked);
//                }
//            
//                else 
//                {
//                    activeLoan.setIcon(unchecked);
//                    unActiveLoan.setIcon(checked);
//                }               
//            }
//        });
//        
//        unActiveLoan.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent ae)
//            {
//                if (unActiveLoan.getIcon() == unchecked && activeLoan.getIcon() == checked) 
//                {
//                    unActiveLoan.setIcon(checked);
//                    activeLoan.setIcon(unchecked);
//                }        
//                    
//                else 
//                {
//                    unActiveLoan.setIcon(unchecked);
//                    activeLoan.setIcon(checked);
//                }       
//            }
//        });
//        
//        activeLoan.setFocusPainted(false);
//        unActiveLoan.setFocusPainted(false);
//        saveButton.setFocusPainted(false);
//        cancelButton.setFocusPainted(false);
//        
//        
//    //Event Handling
//    /*
//        1
//        1
//        1
//        1
//        1
//        1
//        11
//        1
//        1
//        1
//        1
//        */
//        
//     //Creating components
//        firstNameLabel = new JLabel("<html><b>First Name:</b></html>");
//        firstNameField = new JTextField();
//        firstNameErrorSign = new JLabel(error);
//        
//        lastNameLabel = new JLabel("<html><b>Last Name:</b></html>");
//        lastNameField = new JTextField();
//        lastNameErrorSign = new JLabel(error);
//        
//        SSNLabel = new JLabel("<html><b>SSN:</b></html>");
//        SSNField = new JTextField();
//        SSNErrorSign = new JLabel(error);
//        
//        SalaryLabel = new JLabel("<html><b>Salary:</b></html>");
//        SalaryField = new JTextField();
//        SalaryErrorSign = new JLabel(error);
//        
//        
//    //Setting colors
//        firstNameLabel.setForeground(new Color(63,81,181));
//        lastNameLabel.setForeground(new Color(63,81,181));  
//        SSNLabel.setForeground(new Color(63,81,181));
//        SalaryLabel.setForeground(new Color(63,81,181));
//        
//    //Setting fonts
//        firstNameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        firstNameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//        
//        lastNameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        lastNameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//        
//        SSNLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        SSNField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//        
//        SalaryLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        SalaryField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//        
//    //Setting text alignment
//        firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        SSNLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        SalaryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        
//    //Setting positions
//        /*
//        1
//        1
//        1
//        1
//        1
//        */
//        
//     //Controlling visiblity options
//        firstNameErrorSign.setVisible(false);
//        lastNameErrorSign.setVisible(false);
//        SSNErrorSign.setVisible(false);
//        SalaryErrorSign.setVisible(false);
//       
//    //Setting borders
//        firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        SSNField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        SalaryLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        
//        
//    //Adding components to the frame
//        IndividualPanel.add(firstNameLabel);
//        IndividualPanel.add(firstNameField);
//        IndividualPanel.add(firstNameErrorSign);
//        
//        IndividualPanel.add(lastNameLabel);
//        IndividualPanel.add(lastNameField);
//        IndividualPanel.add(lastNameErrorSign);
//        
//        IndividualPanel.add(SSNLabel);
//        IndividualPanel.add(SSNField);
//        IndividualPanel.add(SSNErrorSign);
//        
//        IndividualPanel.add(SalaryLabel);
//        IndividualPanel.add(SalaryField);
//        IndividualPanel.add(SalaryErrorSign);
//        
//    
//    //Focus handling
//        firstNameField.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//        
//       lastNameField.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//       
//       SSNField.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                SSNField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                SSNField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//       
//       SalaryField.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                SalaryField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                SalaryField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//       
//       
//    //Creating components 
//        NameLabel = new JLabel("<html><b>Name:</b></html>");
//        NameField = new JTextField();
//        NameErrorSign = new JLabel(error);
//        
//        CapitalLabel = new JLabel("<html><b>Capital:</b></html>");
//        CapitalField = new JTextField();
//        CapitalErrorSign = new JLabel(error);
//        
//        
//    //Setting colors
//        NameLabel.setForeground(new Color(63,81,181));
//        CapitalLabel.setForeground(new Color(63,81,181));
//    
//    //Setting fonts
//        NameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        NameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//        
//        CapitalLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
//        CapitalField.setFont(new Font(font, Font.PLAIN, fieldFontSize));
//    
//    //Setting text alignment
//        NameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        CapitalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        
//    //Setting positions
//        /*
//        1
//        1
//        1
//        1
//        1
//        1
//        1
//        1
//        */
//    
//    //Controlling visiblity options
//        NameErrorSign.setVisible(false);
//        CapitalErrorSign.setVisible(false);
//        
//    //Setting borders
//        NameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        CapitalField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//        
//    //Adding components to the frame        
//        CompanyPanel.add(NameLabel);
//        CompanyPanel.add(NameField);
//        CompanyPanel.add(NameErrorSign);
//        
//        CompanyPanel.add(CapitalLabel);
//        CompanyPanel.add(CapitalField);
//        CompanyPanel.add(CapitalErrorSign);
//        
//    //Focus handling
//        NameField.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                NameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                NameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//        CapitalField.addFocusListener(new FocusListener() 
//        {
//            @Override
//            public void focusLost(FocusEvent arg0)
//            {
//                CapitalField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
//            }
//
//            @Override
//            public void focusGained(FocusEvent arg0)
//            { 
//                CapitalField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
//            }
//        });
//        
//        
//        //setFieldsBackground();
//        //disableFields(1);
//        saveButton.setVisible(false);
//        cancelButton.setVisible(false);
//        IndividualPanel.setVisible(true);
//        screen.add(IndividualPanel);
//        CompanyPanel.setVisible(false);
//        screen.add(CompanyPanel);
//        
//    //Creating components
//        individualLabel = new JLabel("Indiviual");
//        companyLabel = new JLabel("Company");
//        
//    //Setting colors
//        individualLabel.setForeground(new Color(63,81,181));
//        companyLabel.setForeground(Color.gray);
//        
//    //Setting fonts
//        individualLabel.setFont(new Font("<html><b>Open sans</b><html>", Font.PLAIN, 27));
//        companyLabel.setFont(new Font("<html><b>Open sans</b><html>", Font.PLAIN, 27));
//        
//    //Setting cursor
//        individualLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        companyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        
//    //Setting positions
//        individualLabel.setBounds(50, 100, 100, 40);
//        companyLabel.setBounds(170, 100, 125, 40);
//    
//    //Adding components to the frame
//        screen.add(individualLabel);
//        screen.add(companyLabel);
//        
//        
//    individualLabel.addMouseListener(new MouseAdapter()
//        {
//            public void mouseClicked(MouseEvent e)
//            {
//                individualLabel.setForeground(new Color(63,81,181));
//                companyLabel.setForeground(Color.gray);
//                
//                IndividualPanel.setVisible(true);
//                CompanyPanel.setVisible(false);
//                
//                searchField.setText("Search");
//                
//                
//                //addCommonThings(1);
//                //clearFields(2);
//            }
//        });
//    companyLabel.addMouseListener(new MouseAdapter()
//        {
//            public void mouseClicked(MouseEvent e)
//            {
//                individualLabel.setForeground(Color.gray);
//                companyLabel.setForeground(new Color(63,81,181));
//                
//                IndividualPanel.setVisible(false);
//                CompanyPanel.setVisible(true);
//                
//                searchField.setText("Search");
//
//                //addCommonThings(2);
//                //clearFields(1);
//            }
//        });
//    
//    
//    //Event handling
//        searchField.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e)
//            {
//                loanEmployee staff = new loanEmployee();
//                setFieldsBackground();
//                
//                saveButton.setVisible(false);
//                cancelButton.setVisible(false);
//                confirmationLabel.setVisible(false);
//    
//                if (IndividualPanel.isVisible())
//                {
//                    individualType clientAccount = new individualType();
//                    clientAccount.setSSN(searchField.getText());
//                    disableFields(1);
//                    
//                    try
//                    {
//                        clientAccount = (individualType) staff.searchAccount(clientAccount);
//                        
//                        if (clientAccount.getFirstName()!= null)
//                        {
//                            interestRateLabel.setVisible(true);
//                            interestRateField.setVisible(true);
//                
//                            //Filling fields
//                            fillIndividualFields(clientAccount);                            
//                            
//                            //Disabling editing 
//                            disableFields(1);
//                        }   
//                    }
//                    catch (ClassNotFoundException | IOException ex)
//                    {
//                        //NOTTHING TODO
//                    }
//                }
//                else
//                {
//                    companyType company = new companyType();
//                    company.setName(searchField.getText());
//                    disableFields(2);
//                    
//                    try
//                    {
//                        interestRateLabel.setVisible(true);
//                        interestRateField.setVisible(true);
//                
//                        company = (companyType) staff.searchAccount(company);
//                        
//                        if (company.getAddress()!= null)
//                        {
//                            //Filling fields
//                            fillCompanyFields(company);
//
//                            //Disabling editing 
//                            disableFields(2);
//                        }
//                    } 
//                    catch (ClassNotFoundException | IOException ex)
//                    {
//                        //NOTHING TODO
//                    }      
//                }
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e)
//            {
//                //NOTHING TODO
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e)
//            {
//                //NOTHING TODO
//            }
//        });
//        
//        
//     createButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                confirmationLabel.setVisible(false);
//                saveButton.setText("Create Account");
//                searchField.setText("Search");
//                interestRateLabel.setVisible(false);
//                interestRateField.setVisible(false);
//                
//                if (IndividualPanel.isVisible())
//                {
//                    enableAllFields(1);
//                    setFieldsBackground();
//                    clearFields(1);
//                }
//                else
//                {
//                    enableAllFields(2);
//                    setFieldsBackground();
//                    clearFields(2);   
//                }    
//                
//                saveButton.setVisible(true);
//                cancelButton.setVisible(true);
//            }   
//        });
//     
//     updateButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                saveButton.setVisible(true);
//                cancelButton.setVisible(true);
//                confirmationLabel.setVisible(false);
//                saveButton.setText("Update Account");
//                interestRateLabel.setVisible(true);
//                interestRateField.setVisible(true);
//                
//                if (IndividualPanel.isVisible())
//                {
//                    enableFields(1);
//                    setFieldsBackground();
//                }  
//                else
//                {
//                    enableFields(2);
//                    setFieldsBackground();
//                }
//                   
//            }
//        });
//     
//     deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e)
//            {
//                saveButton.setVisible(true);
//                cancelButton.setVisible(true);
//                confirmationLabel.setVisible(false);
//                saveButton.setText("Delete Account");
//                interestRateLabel.setVisible(true);
//                interestRateField.setVisible(true);
//                
//                if (IndividualPanel.isVisible())
//                {
//                    disableFields(1);
//                    setFieldsBackground();
//                }   
//                else
//                {
//                    disableFields(2);
//                    setFieldsBackground();
//                }
//                    
//            }
//        });
//       
//    
//    }
//
//    public static void main(String[] args) {
//        //new LoanEmployeeScreen().setVisible(true);
//    }
//}
