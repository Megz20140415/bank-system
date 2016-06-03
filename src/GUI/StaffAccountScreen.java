package GUI;

import Core.Human;
import Core.Staff.Manager;
import Core.Staff.Staff;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class StaffAccountScreen extends SecondaryScreenMainLayout {

    private JLabel userNameLabel;
    private JTextField userNameField;
    private JLabel userNameErrorSign;

    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel passwordErrorSign;

    private JLabel passwordConfirmLabel;
    private JPasswordField passwordConfirmField;
    private JLabel passwordConfirmErrorSign;

    private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JLabel firstNameErrorSign;

    private JLabel lastNameLabel;
    private JTextField lastNameField;
    private JLabel lastNameErrorSign;

    private JLabel salaryLabel;
    private JTextField salaryField;
    private JLabel salaryErrorSign;

    private JLabel posistionLabel;
    private JComboBox positionComboBox;

    private JButton saveButton;
    private JButton cancelButton;
    private JLabel confirmationLabel;
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

    public StaffAccountScreen(final String operationType, final Staff staff, final String userType) {
        super(operationType + userType, operationType + userType);

        //Making the latout absolute
        screen = getContentPane();
        screen.setLayout(null);

        //Creating components
        Icon error = new ImageIcon(getClass().getResource("Icons\\error.png"));
        userNameLabel = new JLabel("<html><b>Username:</b></html>");
        userNameField = new JTextField();
        userNameErrorSign = new JLabel(error);

        passwordLabel = new JLabel("<html><b>Password:</b></html>");
        passwordField = new JPasswordField();
        passwordErrorSign = new JLabel(error);

        passwordConfirmLabel = new JLabel("<html><b>Confirm your password:</b></html>");
        passwordConfirmField = new JPasswordField();
        passwordConfirmErrorSign = new JLabel(error);

        firstNameLabel = new JLabel("<html><b>First Name:</b></html>");
        firstNameField = new JTextField();
        firstNameErrorSign = new JLabel(error);

        lastNameLabel = new JLabel("<html><b>Last Name:</b></html>");
        lastNameField = new JTextField();
        lastNameErrorSign = new JLabel(error);

        salaryLabel = new JLabel("<html><b>Salary:</b></html>");
        salaryField = new JTextField();
        salaryErrorSign = new JLabel(error);

        posistionLabel = new JLabel("<html><b>Position:</b></html>");
        positionComboBox = new JComboBox();

        saveButton = new JButton("  ");
        cancelButton = new JButton("Cancel");
        confirmationLabel = new JLabel();
        choosePictureButton = new JButton("Choose picture");

        //Adding items to the combp box
        if(userType.equalsIgnoreCase("Manager")){
        positionComboBox.addItem("humanResources");}
        else
        {
            positionComboBox.addItem("Teller");
            positionComboBox.addItem("loanEmployee");
            positionComboBox.addItem("accountManager");
        }

        //Setting colors
        userNameLabel.setForeground(new Color(63, 81, 181));
        passwordLabel.setForeground(new Color(63, 81, 181));
        passwordConfirmLabel.setForeground(new Color(63, 81, 181));
        firstNameLabel.setForeground(new Color(63, 81, 181));
        lastNameLabel.setForeground(new Color(63, 81, 181));
        salaryLabel.setForeground(new Color(63, 81, 181));
        posistionLabel.setForeground(new Color(63, 81, 181));

        saveButton.setBackground(new Color(63, 81, 181));
        saveButton.setForeground(Color.white);

        cancelButton.setBackground(Color.white);
        cancelButton.setForeground(new Color(63, 81, 181));

        confirmationLabel.setForeground(Color.black);

        choosePictureButton.setBackground(new Color(63, 81, 181));
        choosePictureButton.setForeground(Color.white);

        //Setting fonts
        userNameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        userNameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));

        passwordLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        passwordField.setFont(new Font(font, Font.PLAIN, fieldFontSize));

        passwordConfirmLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        passwordConfirmField.setFont(new Font(font, Font.PLAIN, fieldFontSize));

        firstNameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        firstNameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));

        lastNameLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        lastNameField.setFont(new Font(font, Font.PLAIN, fieldFontSize));

        salaryLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        salaryField.setFont(new Font(font, Font.PLAIN, fieldFontSize));

        posistionLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
        positionComboBox.setFont(new Font(font, Font.PLAIN, fieldFontSize));

        saveButton.setFont(new Font("Arial", Font.PLAIN, 18));
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmationLabel.setFont(new Font(font, Font.PLAIN, 19));
        choosePictureButton.setFont(new Font("Arial", Font.PLAIN, 13));

        //Setting text alignment
        userNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        confirmationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        salaryLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        posistionLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        //Setting positions
        userNameLabel.setBounds(firstColumnMargin, 170, labelWidth, labelHeight);
        userNameField.setBounds(userNameLabel.getBounds().x + labelWidth + 10, userNameLabel.getBounds().y + 9, fieldWidth - 30, fieldHeight);
        userNameErrorSign.setBounds(userNameField.getBounds().x + fieldWidth - 25 + 5, userNameField.getBounds().y + 3, iconSize, iconSize);

        passwordLabel.setBounds(firstColumnMargin, userNameLabel.getBounds().y + margin, labelWidth, labelHeight);
        passwordField.setBounds(passwordLabel.getBounds().x + labelWidth + 10, passwordLabel.getBounds().y + 9, fieldWidth, fieldHeight);
        passwordErrorSign.setBounds(passwordField.getBounds().x + fieldWidth + 5, passwordField.getBounds().y + 3, iconSize, iconSize);

        passwordConfirmLabel.setBounds(secondColumnMargin - 80, userNameLabel.getBounds().y + margin, labelWidth + 80, labelHeight);
        passwordConfirmField.setBounds(passwordConfirmLabel.getBounds().x + labelWidth + 90, passwordConfirmLabel.getBounds().y + 9, fieldWidth, fieldHeight);
        passwordConfirmErrorSign.setBounds(passwordConfirmField.getBounds().x + fieldWidth + 5, passwordConfirmField.getBounds().y + 3, iconSize, iconSize);

        firstNameLabel.setBounds(firstColumnMargin, passwordLabel.getBounds().y + margin, labelWidth, labelHeight);
        firstNameField.setBounds(firstNameLabel.getBounds().x + labelWidth + 10, firstNameLabel.getBounds().y + 9, fieldWidth - 60, fieldHeight);
        firstNameErrorSign.setBounds(firstNameField.getBounds().x + fieldWidth - 60 + 5, firstNameField.getBounds().y + 3, iconSize, iconSize);

        lastNameLabel.setBounds(secondColumnMargin, passwordLabel.getBounds().y + margin, labelWidth, labelHeight);
        lastNameField.setBounds(lastNameLabel.getBounds().x + labelWidth + 10, lastNameLabel.getBounds().y + 9, fieldWidth - 60, fieldHeight);
        lastNameErrorSign.setBounds(lastNameField.getBounds().x + fieldWidth - 60 + 5, lastNameField.getBounds().y + 3, iconSize, iconSize);

        salaryLabel.setBounds(firstColumnMargin, firstNameLabel.getBounds().y + margin, labelWidth, labelHeight);
        salaryField.setBounds(salaryLabel.getBounds().x + labelWidth + 10, salaryLabel.getBounds().y + 9, fieldWidth - 60, fieldHeight);
        salaryErrorSign.setBounds(salaryField.getBounds().x + fieldWidth - 60 + 5, salaryField.getBounds().y + 3, iconSize, iconSize);

        posistionLabel.setBounds(secondColumnMargin - 50, firstNameLabel.getBounds().y + margin, labelWidth + 50, labelHeight);
        positionComboBox.setBounds(posistionLabel.getBounds().x + labelWidth + 60, posistionLabel.getBounds().y + 9, fieldWidth - 40, fieldHeight);

        saveButton.setBounds(235, 330, 200, 40);
        confirmationLabel.setBounds(300, 380, 200, 50);
        cancelButton.setBounds(440, 330, 100, 40);
        choosePictureButton.setBounds(firstColumnMargin + 480, posistionLabel.getBounds().y + (2 * margin), labelWidth + 60, labelHeight - 5);

        //Controlling visiblity options
        userNameErrorSign.setVisible(false);
        passwordErrorSign.setVisible(false);
        passwordConfirmErrorSign.setVisible(false);
        firstNameErrorSign.setVisible(false);
        lastNameErrorSign.setVisible(false);
        salaryErrorSign.setVisible(false);

        //Setting borders
        userNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        salaryField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        positionComboBox.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        //Adding components to the frame
        screen.add(userNameLabel);
        screen.add(userNameField);
        screen.add(userNameErrorSign);

        screen.add(passwordLabel);
        screen.add(passwordField);
        screen.add(passwordErrorSign);

        screen.add(passwordConfirmLabel);
        screen.add(passwordConfirmField);
        screen.add(passwordConfirmErrorSign);

        screen.add(firstNameLabel);
        screen.add(firstNameField);
        screen.add(firstNameErrorSign);

        screen.add(lastNameLabel);
        screen.add(lastNameField);
        screen.add(lastNameErrorSign);

        screen.add(salaryLabel);
        screen.add(salaryField);
        screen.add(salaryErrorSign);

        screen.add(posistionLabel);
        screen.add(positionComboBox);

        screen.add(posistionLabel);
        screen.add(positionComboBox);
        
        if (operationType.equalsIgnoreCase("Search")) {
            filldata(staff);
            userNameField.setEnabled(false);
            firstNameField.setEnabled(false);
            lastNameField.setEnabled(false);
            positionComboBox.setEnabled(false);
            passwordField.setEnabled(false);
            passwordConfirmField.setEnabled(false);
            salaryField.setEnabled(false);
            removeBackground();
        }
        //Focus handling
        userNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                userNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                userNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });

        passwordConfirmField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });

        passwordConfirmField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                passwordConfirmField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });

        firstNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                firstNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });

        lastNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                lastNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });

        salaryField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                salaryField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                salaryField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63, 81, 181)));
            }
        });

        saveButton.setFocusPainted(false);
        cancelButton.setFocusPainted(false);

        //Event Handling
        userNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    if (Human.checkUserName(userNameField.getText()) == false) {
                        userNameErrorSign.setVisible(false);
                        saveButton.setEnabled(true);
                    } else {
                        userNameErrorSign.setVisible(true);
                        saveButton.setEnabled(false);

                    }
                } catch (ClassNotFoundException | IOException ex) {
                    userNameErrorSign.setVisible(true);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                userNameErrorSign.setVisible(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                userNameErrorSign.setVisible(false);
            }
        });

        passwordConfirmField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!Arrays.equals(passwordField.getPassword(), passwordConfirmField.getPassword())) {
                    passwordConfirmErrorSign.setVisible(true);
                    saveButton.setEnabled(false);
                } else {
                    passwordConfirmErrorSign.setVisible(false);
                    saveButton.setEnabled(true);
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
        
        if (operationType.equalsIgnoreCase("Create")) {
            add(saveButton);
            saveButton.setText("Create Account");
            saveButton.setBounds(300, 380, 200, 50);
            removeBackground();
        }
        if (operationType.equalsIgnoreCase("Update")) {
            filldata(staff);
            userNameField.setEnabled(false);
            firstNameField.setEnabled(false);
            lastNameField.setEnabled(false);
            positionComboBox.setEnabled(false);
            userNameErrorSign.setVisible(false);
            removeBackground();
            add(saveButton);
            saveButton.setText("Update");
            saveButton.setVisible(true);
            saveButton.setBounds(300, 380, 200, 50);
        }
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (operationType.equalsIgnoreCase("create")) {
                    Manager manager = new Manager();
                    Staff staff = new Staff();
                    staff.setUserName(userNameField.getText());
                    staff.setFirstName(firstNameField.getText());
                    staff.setLastName(lastNameField.getText());
                    staff.setPassword(passwordField.getText());
                    staff.setPosition((String) positionComboBox.getSelectedItem());
                    staff.setSalary(Double.parseDouble(salaryField.getText()));

                    try {
                        if (manager.createAccount(staff) == true) {
                            saveButton.setVisible(false);
                            add(confirmationLabel);
                            confirmationLabel.setText("Succssed");
                            confirmationLabel.setVisible(true);
                        } else {
                            saveButton.setVisible(false);
                             add(confirmationLabel);
                            confirmationLabel.setText("Wrong");
                            confirmationLabel.setVisible(true);
                        }
                    } catch (Exception ex) {

                    }
                }
                if(operationType.equalsIgnoreCase("Update"))
                {
                    staff.setSalary(Double.parseDouble(salaryField.getText()));
                    staff.setPassword(passwordField.getText());
                    Manager manager = new Manager();
                    try {
                        manager.updateAccount(staff);
                        passwordField.setText(staff.getPassword());
                        passwordConfirmField.setText(staff.getPassword());
                        salaryField.setText(Double.toString(staff.getSalary()));
                    } catch (ClassNotFoundException |IOException ex) {
                        //Logger.getLogger(StaffAccountScreen.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            }
        });

    }

    void filldata(Staff staff) {
        userNameField.setText(staff.getUserName());
            passwordField.setText(staff.getPassword());
            passwordConfirmField.setText(staff.getPassword());
            salaryField.setText(Double.toString(staff.getSalary()));
            firstNameField.setText(staff.getFirstName());
            lastNameField.setText(staff.getLastName());
            positionComboBox.setSelectedItem(staff.getPosition());
    }
    
    private void removeBackground()
    {
        userNameField.setBackground(null);
            firstNameField.setBackground(null);
            lastNameField.setBackground(null);
            positionComboBox.setBackground(null);
            passwordField.setBackground(null);
            passwordConfirmField.setBackground(null);
            salaryField.setBackground(null);
    }
    public static void main(String[] args) {
        //new StaffAccountScreen("Create").setVisible(true);
    }
}
