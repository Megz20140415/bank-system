package GUI;

import Core.Staff.Staff;
import Core.Staff.Teller;
import Core.Users.Account;
import Core.Users.Company;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TellerScreen extends MainLayout {
    
    private JLabel depositLabel;
    private JLabel withdrawLabel;
    private JLabel transferLabel;
    
    private JTextField searchField;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel SSNLabel;
    private JLabel websiteLabel;
    
    private JLabel moneyBalanceLabel;
    private JLabel actionLabel;
    private JTextField actionBalanceField;
    private JLabel actionBalanceErrorSign;
    
    private JButton actionButton;
    
    private JLabel individualLabel;
    private JLabel companyLabel;
    
    private JPanel actionPanel;
    private JPanel transferPanel;
    
    private JPanel individualPanel;
    private JPanel companyPanel;
    
    private JLabel fromLabel;
    private JLabel toLabel;
    private JTextField fromSearchField;
    private JTextField toSearchField;
    private JLabel fromNameLabel;
    private JLabel toNameLabel;
    private JLabel fromMoneyBalanceLabel;
    private JLabel toMoneyBalanceLabel;
    private JLabel transferBalanceLabel;
    private JTextField transferBalanceField;
    private JLabel transferBalanceErrorSign;
    
    private int firstColumn = 120;
    private int secondColumn = 420;
    
    private int fontSize = 16;
    private String font = "Arial";
    private int labelWidth = 320;
    private int labelHeight = 17;
    private int margin = 60;
    
    private int actionType = 1;
    private int clientType = 1;
    
    public TellerScreen(/*Staff user*/) {
        super("Teller", /*user.getFirstName() + user.getLastName()*/ " Muhammad Tarek");

        //Creating panles
        individualPanel = new JPanel();
        individualPanel.setLayout(null);
        individualPanel.setBounds(50, 0, 700, 380);
        
        companyPanel = new JPanel();
        companyPanel.setLayout(null);
        companyPanel.setBounds(50, 0, 700, 380);
        
        actionPanel = new JPanel();
        actionPanel.setLayout(null);
        actionPanel.setBounds(0, 200, 800, 430);
        
        transferPanel = new JPanel();
        transferPanel.setLayout(null);
        transferPanel.setBounds(0, 200, 800, 430);

        //Creating components
        Icon error = new ImageIcon(getClass().getResource("Icons//error.png"));
        individualLabel = new JLabel("Indiviual");
        companyLabel = new JLabel("Company");
        
        depositLabel = new JLabel("<html><b>Deposit</b></html>");
        withdrawLabel = new JLabel("<html><b>Withdraw</b></html>");
        transferLabel = new JLabel("<html><b>Transfer</b></html>");
        
        searchField = new JTextField("Search");
        nameLabel = new JLabel("Name: ");
        addressLabel = new JLabel("Address: ");
        SSNLabel = new JLabel("SSN: ");
        websiteLabel = new JLabel("Website: ");
        
        moneyBalanceLabel = new JLabel("Money Balance: ");
        actionLabel = new JLabel("Deposit: ");
        actionBalanceField = new JTextField();
        actionBalanceErrorSign = new JLabel(error);
        
        fromLabel = new JLabel("From: ");
        toLabel = new JLabel("To: ");
        fromSearchField = new JTextField("Search");
        toSearchField = new JTextField("Search");
        fromNameLabel = new JLabel("Name: ");
        toNameLabel = new JLabel("Name: ");
        fromMoneyBalanceLabel = new JLabel("Money Balance: ");
        toMoneyBalanceLabel = new JLabel("Money Balance: ");
        transferBalanceLabel = new JLabel("Transfer balance:");
        transferBalanceField = new JTextField();
        transferBalanceErrorSign = new JLabel(error);
        
        actionButton = new JButton("Confirm Operation");

        //Setting colors
        searchField.setBackground(null);
        individualLabel.setForeground(new Color(63, 81, 181));
        companyLabel.setForeground(Color.gray);
        depositLabel.setForeground(new Color(63, 81, 181));
        withdrawLabel.setForeground(Color.gray);
        transferLabel.setForeground(Color.gray);
        actionLabel.setForeground(new Color(63, 81, 181));
        actionBalanceField.setBackground(null);
        actionButton.setBackground(new Color(63, 81, 181));
        actionButton.setForeground(Color.white);
        
        toSearchField.setBackground(null);
        fromSearchField.setBackground(null);
        fromLabel.setForeground(new Color(63, 81, 181));
        toLabel.setForeground(new Color(63, 81, 181));
        transferBalanceLabel.setForeground(new Color(63, 81, 181));
        transferBalanceField.setBackground(null);

        //Setting fonts
        individualLabel.setFont(new Font("Open sans", Font.PLAIN, 18));
        companyLabel.setFont(new Font("Open sans", Font.PLAIN, 18));
        
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        depositLabel.setFont(new Font("Open sans", Font.PLAIN, 20));
        withdrawLabel.setFont(new Font("Open sans", Font.PLAIN, 20));
        transferLabel.setFont(new Font("Open sans", Font.PLAIN, 20));
        
        nameLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        addressLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        SSNLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        websiteLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        moneyBalanceLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        actionLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        
        toLabel.setFont(new Font(font, Font.PLAIN, 19));
        fromLabel.setFont(new Font(font, Font.PLAIN, 19));
        toNameLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        fromNameLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        toMoneyBalanceLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        fromMoneyBalanceLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        transferBalanceLabel.setFont(new Font(font, Font.PLAIN, fontSize));
        
        actionButton.setFont(new Font("Arial", Font.PLAIN, 18));

        //Setting text alignment
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        actionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        transferBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //Setting cursor
        individualLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        companyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        depositLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        withdrawLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        transferLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Setting borders
        searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        actionBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        transferBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        toSearchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        fromSearchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        actionButton.setBorder(null);

        //Setting positions
        individualLabel.setBounds(50, 103, 100, 40);
        companyLabel.setBounds(140, 103, 125, 40);
        
        depositLabel.setBounds(400, 100, 130, 40);
        withdrawLabel.setBounds(500, 100, 130, 40);
        transferLabel.setBounds(620, 100, 130, 40);
        
        searchField.setBounds(225, 10, 250, 40);
        
        nameLabel.setBounds(firstColumn, 80, labelWidth, labelHeight);
        SSNLabel.setBounds(firstColumn, nameLabel.getBounds().y + margin, labelWidth, labelHeight);
        websiteLabel.setBounds(firstColumn, nameLabel.getBounds().y + margin, labelWidth + 150, labelHeight);
        addressLabel.setBounds(secondColumn, nameLabel.getBounds().y + margin, labelWidth, labelHeight);
        moneyBalanceLabel.setBounds(firstColumn, SSNLabel.getBounds().y + margin, labelWidth, labelHeight);
        actionLabel.setBounds(secondColumn - 250, addressLabel.getBounds().y + margin, labelWidth, labelHeight);
        actionBalanceField.setBounds(actionLabel.getBounds().x + labelWidth + 5, addressLabel.getBounds().y + margin, 60, labelHeight);
        actionBalanceErrorSign.setBounds(actionBalanceField.getBounds().x + 62, addressLabel.getBounds().y + margin - 10, 40, 40);
        
        fromLabel.setBounds(firstColumn, 10, 80, 30);
        fromSearchField.setBounds(fromLabel.getBounds().x + 60, 10, 120, 30);
        fromNameLabel.setBounds(firstColumn, fromLabel.getBounds().y + margin - 10, labelWidth, labelHeight);
        fromMoneyBalanceLabel.setBounds(secondColumn, fromLabel.getBounds().y + margin - 10, labelWidth, labelHeight);
        
        toLabel.setBounds(firstColumn, 130, 80, 30);
        toSearchField.setBounds(toLabel.getBounds().x + 60, 130, 120, 30);
        toNameLabel.setBounds(firstColumn, toLabel.getBounds().y + margin - 10, labelWidth, labelHeight);
        toMoneyBalanceLabel.setBounds(secondColumn, toLabel.getBounds().y + margin - 10, labelWidth, labelHeight);
        
        transferBalanceLabel.setBounds(firstColumn - 100, 250, labelWidth, labelHeight);
        transferBalanceField.setBounds(transferBalanceLabel.getBounds().x + labelWidth + 5, 250, 40, labelHeight);
        transferBalanceErrorSign.setBounds(transferBalanceField.getBounds().x + 62, transferBalanceField.getBounds().y + margin - 10, 40, 40);
        
        actionButton.setBounds(250, actionBalanceField.getBounds().y + 60, 200, 40);

        //Focus handling
        searchField.addFocusListener(new FocusListener() {
            int Counter = 0;
            
            @Override
            public void focusLost(FocusEvent arg0) {
                searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }
            
            @Override
            public void focusGained(FocusEvent arg0) {
                if (Counter == 0 || (searchField.getText()).equals("Search")) {
                    searchField.setText("");
                }
                
                Counter++;
                searchField.setVisible(true);
                searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });
        
        searchField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if ((searchField.getText()).equals("Search")) {
                    searchField.setText("");
                }
            }
        });
        
        actionBalanceField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                actionBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }
            
            @Override
            public void focusGained(FocusEvent arg0) {
                actionBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
            
        });
        
        toSearchField.addFocusListener(new FocusListener() {
            int Counter = 0;
            
            @Override
            public void focusLost(FocusEvent arg0) {
                toSearchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }
            
            @Override
            public void focusGained(FocusEvent arg0) {
                if (Counter == 0 || (toSearchField.getText()).equals("Search")) {
                    toSearchField.setText("");
                }
                
                Counter++;
                toSearchField.setVisible(true);
                toSearchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });
        
        fromSearchField.addFocusListener(new FocusListener() {
            int Counter = 0;
            
            @Override
            public void focusLost(FocusEvent arg0) {
                fromSearchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }
            
            @Override
            public void focusGained(FocusEvent arg0) {
                if (Counter == 0 || (fromSearchField.getText()).equals("Search")) {
                    fromSearchField.setText("");
                }
                
                Counter++;
                fromSearchField.setVisible(true);
                fromSearchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });
        
        transferBalanceField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                transferBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }
            
            @Override
            public void focusGained(FocusEvent arg0) {
                transferBalanceField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });
        
        actionButton.setFocusPainted(false);

        //Adding components to the frame
        screen.add(individualLabel);
        screen.add(companyLabel);
        
        screen.add(depositLabel);
        screen.add(withdrawLabel);
        screen.add(transferLabel);
        
        individualPanel.add(searchField);
        individualPanel.add(SSNLabel);
        individualPanel.add(addressLabel);
        addCommonThings(1);
        
        companyPanel.add(websiteLabel);
        switchActionPanel(1);
        
        transferPanel.add(toLabel);
        transferPanel.add(toSearchField);
        transferPanel.add(toNameLabel);
        transferPanel.add(toMoneyBalanceLabel);
        
        transferPanel.add(fromLabel);
        transferPanel.add(fromSearchField);
        transferPanel.add(fromNameLabel);
        transferPanel.add(fromMoneyBalanceLabel);
        
        transferPanel.add(transferBalanceLabel);
        transferPanel.add(transferBalanceField);
        
        individualPanel.setVisible(true);
        actionPanel.setVisible(true);
        actionBalanceErrorSign.setVisible(false);
        screen.add(actionPanel);
        screen.add(transferPanel);
        
        individualLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                individualLabel.setForeground(new Color(63, 81, 181));
                companyLabel.setForeground(Color.gray);
                
                if (actionPanel.isVisible()) {
                    addCommonThings(1);
                    switchActionPanel(1);
                    
                    individualPanel.setVisible(true);
                    companyPanel.setVisible(false);
                    searchField.setText("Search");
                    actionButton.setBounds(250, actionBalanceField.getBounds().y + 60, 200, 40);
                } else {
                    toSearchField.setText("Search");
                    fromSearchField.setText("Search");
                    transferPanel.setVisible(true);
                }
                clearAllFields();
                
                clientType = 1;
            }
        });
        
        companyLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                individualLabel.setForeground(Color.gray);
                companyLabel.setForeground(new Color(63, 81, 181));
                
                if (actionPanel.isVisible()) {
                    addCommonThings(2);
                    switchActionPanel(2);
                    individualPanel.setVisible(false);
                    companyPanel.setVisible(true);
                    searchField.setText("Search");
                    actionButton.setBounds(250, actionBalanceField.getBounds().y + 60, 200, 40);
                } else {
                    
                    toSearchField.setText("Search");
                    fromSearchField.setText("Search");
                    transferPanel.setVisible(true);
                }
                clearAllFields();
                clientType = 2;
            }
        });
        
        depositLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                actionButton.setBounds(250, actionBalanceField.getBounds().y + 60, 200, 40);
                
                depositLabel.setForeground(new Color(63, 81, 181));
                withdrawLabel.setForeground(Color.gray);
                transferLabel.setForeground(Color.gray);
                if (individualPanel.isVisible()) {
                    switchActionPanel(1);
                    addCommonThings(1);
                }
                searchField.setText("Search");
                actionLabel.setText("Deposit:");
                actionPanel.setVisible(true);
                transferPanel.setVisible(false);
                actionType = 1;
                
                clearAllFields();
            }
        });
        
        withdrawLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                actionButton.setBounds(250, actionBalanceField.getBounds().y + 60, 200, 40);
                
                withdrawLabel.setForeground(new Color(63, 81, 181));
                depositLabel.setForeground(Color.gray);
                transferLabel.setForeground(Color.gray);

                switchActionPanel(1);
                addCommonThings(1);
                
                searchField.setText("Search");
                actionLabel.setText("Withdraw:");
                actionButton.setBounds(250, actionBalanceField.getBounds().y + 60, 200, 40);
                actionPanel.setVisible(true);
                transferPanel.setVisible(false);
                
                actionType = 2;
                clearAllFields();
            }
        });
        
        transferLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                transferLabel.setForeground(new Color(63, 81, 181));
                withdrawLabel.setForeground(Color.gray);
                depositLabel.setForeground(Color.gray);
                
                actionButton.setBounds(transferBalanceField.getBounds().x + 50 + 5, 240, 200, 40);
                addCommonThings(3);
                
                searchField.setText("Search");
                actionPanel.setVisible(false);
                transferPanel.setVisible(true);
                actionType = 3;
                clearAllFields();
                
            }
        });
        transferBalanceField.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent de) {
                char Vaild[] = transferBalanceField.getText().toCharArray();
                for (char check : Vaild) {
                    if (Character.isLetter(check)) {
                        transferBalanceErrorSign.setVisible(true);
                        actionButton.setEnabled(false);
                    } else {
                        transferBalanceErrorSign.setVisible(false);
                        actionButton.setEnabled(true);
                    }
                }
                
            }
            
            @Override
            public void removeUpdate(DocumentEvent de) {
                char Vaild[] = transferBalanceField.getText().toCharArray();
                boolean checkv = true;
                for (char check : Vaild) {
                    if (Character.isLetter(check)) {
                        checkv = false;
                    }
                }
                
                if (checkv) {
                    transferBalanceErrorSign.setVisible(true);
                    actionButton.setEnabled(false);
                } else {
                    transferBalanceErrorSign.setVisible(false);
                    actionButton.setEnabled(true);
                }
                
            }
            
            @Override
            public void changedUpdate(DocumentEvent de) {
                
            }
        }
        );
        actionBalanceField.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent de) {
                char Vaild[] = actionBalanceField.getText().toCharArray();
                for (char check : Vaild) {
                    if (Character.isLetter(check)) {
                        actionBalanceErrorSign.setVisible(true);
                        actionButton.setEnabled(false);
                    } else {
                        actionBalanceErrorSign.setVisible(false);
                        actionButton.setEnabled(true);
                    }
                }
                /* if(Double.parseDouble(""+actionBalanceField.getText())>Double.parseDouble(""+moneyBalanceLabel.getText()))
                {
                    actionBalanceErrorSign.setVisible(true);
                        actionButton.setEnabled(false);
                }
               */
            }
            
            @Override
            public void removeUpdate(DocumentEvent de) {
                char Vaild[] = actionBalanceField.getText().toCharArray();
                boolean checkv = true;
                for (char check : Vaild) {
                    if (Character.isLetter(check)) {
                        checkv = false;
                    }
                }
                
                if (checkv) {
                    actionBalanceErrorSign.setVisible(true);
                    actionButton.setEnabled(false);
                } else {
                    actionBalanceErrorSign.setVisible(false);
                    actionButton.setEnabled(true);
                }
                
            }
            
            @Override
            public void changedUpdate(DocumentEvent de) {
                
            }
        }
        );
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Teller user = new Teller();
                
                if (individualPanel.isVisible()) {
                    Account clientAccount = new Account();
                    clientAccount.setUserName(searchField.getText());
                    try {
                        clientAccount = (Account) user.searchAccount(clientAccount);
                        
                        if (clientAccount.getFirstName() != null) {
                            fillIndividualFields(clientAccount);
                            actionButton.setEnabled(true);
                        } else {
                            actionButton.setEnabled(false);
                        }
                    } catch (ClassNotFoundException | IOException ex) {
                        //NOTHING TODO
                    }
                } else {
                    Company company = new Company();
                    company.setUserName(searchField.getText());
                    
                    try {
                        company = (Company) user.searchAccount(company);
                        
                        if (company.getName() != null) {
                            fillCompanyFields(company);
                        }
                    } catch (ClassNotFoundException | IOException ex) {
                        //NOTHING TODO
                    }
                }
                
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                //NOTHING TODO
            }
        });
        
        toSearchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Teller user = new Teller();
                
                if (clientType == 1) {
                    
                    Account clientAccount = new Account();
                    clientAccount.setUserName(toSearchField.getText());
                    
                    try {
                        clientAccount = (Account) user.searchAccount(clientAccount);
                        
                        if (clientAccount.getFirstName() != null) {
                            
                            toNameLabel.setText("Name: " + clientAccount.getFirstName() + " " + clientAccount.getLastName());
                            toMoneyBalanceLabel.setText("Money Balance: " + Double.toString(clientAccount.getMoneyBalance()));
                        }
                        
                    } catch (ClassNotFoundException | IOException ex) {
                        //NOTHING TODO
                    }
                } else {
                    Company company = new Company();
                    company.setUserName(toSearchField.getText());
                    
                    try {
                        company = (Company) user.searchAccount(company);
                        
                        if (company.getName() != null) {
                            toNameLabel.setText("Name: " + company.getName());
                            toMoneyBalanceLabel.setText("Money Balance: " + Double.toString(company.getMoneyBalance()));
                        }
                        
                    } catch (ClassNotFoundException | IOException ex) {
                        //NOTHING TODO
                    }
                }
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                //NOTHING TODO
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                //NOTHING TODO
            }
        });
        fromSearchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                Teller user = new Teller();
                
                if (clientType == 1) {
                    Account clientAccount = new Account();
                    clientAccount.setUserName(fromSearchField.getText());
                    try {
                        clientAccount = (Account) user.searchAccount(clientAccount);
                        
                        if (clientAccount.getFirstName() != null) {
                            fromNameLabel.setText("Name: " + clientAccount.getFirstName() + " " + clientAccount.getLastName());
                            fromMoneyBalanceLabel.setText("Money Balance: " + Double.toString(clientAccount.getMoneyBalance()));
                        }
                        
                    } catch (ClassNotFoundException | IOException ex) {
                        //NOTHING fromDO
                    }
                } else {
                    Company company = new Company();
                    company.setUserName(fromSearchField.getText());
                    
                    try {
                        company = (Company) user.searchAccount(company);
                        
                        if (company.getName() != null) {
                            fromNameLabel.setText("Name: " + company.getName());
                            fromMoneyBalanceLabel.setText("Money Balance: " + Double.toString(company.getMoneyBalance()));
                        }
                        
                    } catch (ClassNotFoundException | IOException ex) {
                        //NOTHING fromDO
                    }
                }
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                //NOTHING fromDO
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                //NOTHING fromDO
            }
        });
        
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Teller user = new Teller();
                Account clientAccount = new Account();
                Company company = new Company();
                
                if (actionType == 1) {
                    if (individualPanel.isVisible()) {
                        try {
                            clientAccount.setUserName(searchField.getText());
                            clientAccount = (Account) user.searchAccount(clientAccount);
                            user.deposit(clientAccount, Double.parseDouble(actionBalanceField.getText()));
                        } catch (ClassNotFoundException | IOException ex) {
                            //NOTHING TODO
                        }
                    } else {
                        try {
                            
                            company.setUserName(searchField.getText());
                            
                            company = (Company) user.searchAccount(company);
                            user.deposit(company, Double.parseDouble(actionBalanceField.getText()));
                        } catch (ClassNotFoundException | IOException ex) {
                            //NOTHING TODO
                        }
                    }
                }
                
                if (actionType == 2) {
                    if (individualPanel.isVisible()) {
                        try {
                            clientAccount.setUserName(searchField.getText());
                            clientAccount = (Account) user.searchAccount(clientAccount);
                            
                            user.withDraw(clientAccount, Double.parseDouble(actionBalanceField.getText()));
                        } catch (ClassNotFoundException | IOException ex) {
                            //NOTHING TODO
                        }
                    } else {
                        try {
                            
                            company.setUserName(searchField.getText());
                            company = (Company) user.searchAccount(company);
                            user.withDraw(company, Double.parseDouble(actionBalanceField.getText()));
                        } catch (ClassNotFoundException | IOException ex) {
                            //NOTHING TODO
                        }
                    }
                }
                if (actionType == 3) {
                    if (individualPanel.isVisible()) {
                        try {
                            Account fromclientAccount = new Account();
                            fromclientAccount.setUserName(fromSearchField.getText());
                            fromclientAccount = (Account) user.searchAccount(fromclientAccount);
                            Account toclientAccount = new Account();
                            toclientAccount.setUserName(toSearchField.getText());
                            toclientAccount = (Account) user.searchAccount(toclientAccount);
                            user.Transfer(fromclientAccount, toclientAccount, Double.parseDouble(transferBalanceField.getText()));
                            
                        } catch (ClassNotFoundException | IOException ex) {
                            //NOTHING TODO
                        }
                    } else {
                        try {
                            Company fromcompany = new Company();
                            fromcompany.setUserName(fromSearchField.getText());
                            fromcompany = (Company) user.searchAccount(fromcompany);
                            Company toCompany = new Company();
                            toCompany.setUserName(toSearchField.getText());
                            toCompany = (Company) user.searchAccount(toCompany);
                            user.Transfer(fromcompany, toCompany, Double.parseDouble(transferBalanceField.getText()));
                        } catch (ClassNotFoundException | IOException ex) {
                            //NOTHING TODO
                        }
                    }
                }
            }
        });
    }
    
    private void addCommonThings(int panel) {
        switch (panel) {
            case 1:
                toSearchField.setVisible(false);
                fromSearchField.setVisible(false);
                transferBalanceField.setVisible(false);
                individualPanel.add(searchField);
                individualPanel.add(nameLabel);
                individualPanel.add(addressLabel);
                individualPanel.add(moneyBalanceLabel);
                individualPanel.add(actionBalanceField);
                individualPanel.add(actionLabel);
                individualPanel.add(actionButton);
                individualPanel.add(actionBalanceErrorSign);
                break;
            case 2:
                companyPanel.add(searchField);
                companyPanel.add(nameLabel);
                companyPanel.add(addressLabel);
                companyPanel.add(moneyBalanceLabel);
                companyPanel.add(actionBalanceField);
                companyPanel.add(actionLabel);
                companyPanel.add(actionButton);
                companyPanel.add(actionBalanceErrorSign);
                break;
            default:
                toSearchField.setVisible(true);
                fromSearchField.setVisible(true);
                transferBalanceField.setVisible(true);
                transferPanel.add(actionButton);
                break;
        }
    }
    
    private void switchActionPanel(int panel) {
        if (panel == 1) {
            actionPanel.add(individualPanel);
        } else {
            actionPanel.add(companyPanel);
            
        }
    }
    
    private void fillIndividualFields(Account clientAccount) {
        nameLabel.setText("Name: " + clientAccount.getFirstName() + " " + clientAccount.getLastName());
        SSNLabel.setText("SSN: " + clientAccount.getSSN());
        addressLabel.setText("Address: " + clientAccount.getAddress());
        moneyBalanceLabel.setText("Money Balance: " + Double.toString(clientAccount.getMoneyBalance()));
    }
    
    private void fillCompanyFields(Company company) {
        nameLabel.setText("Name: " + company.getName());
        SSNLabel.setText("Website: " + company.getWebsite());
        addressLabel.setText("Address: " + company.getAddress());
        moneyBalanceLabel.setText("Money Balance: " + Double.toString(company.getMoneyBalance()));
    }
    
    private void clearAllFields() {
        nameLabel.setText("Name: ");
        SSNLabel.setText("SSN: ");
        addressLabel.setText("Address: ");
        moneyBalanceLabel.setText("Money Balance: ");
    }
    
    public static void main(String[] args) {
        new TellerScreen().setVisible(true);
    }
}
