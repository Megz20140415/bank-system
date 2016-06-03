package GUI;

import Core.Staff.Manager;
import Core.Staff.Staff;
import Core.Staff.humanResources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HumanResourcesScreen extends StaffMainLayout {

    public HumanResourcesScreen(Staff user) {
        //Setting layout
        super("Human Resources", user.getFirstName() + user.getLastName());
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                Staff staff = new Staff();
                staff.setUserName(searchField.getText());
                try {
                    humanResources user = new humanResources();
                    staff = (Staff) user.searchAccount(staff);
                    if (staff.getFirstName() != null) {
                        new StaffAccountScreen("Search", staff, "humanResources").setVisible(true);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    //Logger.getLogger(ManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new StaffAccountScreen("Create", null, "Employees").setVisible(true);
            }
        });
        updateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Staff staff = new Staff();
                humanResources user = new humanResources();
                try {
                    staff.setUserName(searchField.getText());
                    staff = (Staff) user.searchAccount(staff);
                    if (staff.getFirstName() != null) {
                        new StaffAccountScreen("Update", staff, "humanResources").setVisible(true);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    //Logger.getLogger(HumanResourcesScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
try {
                    humanResources manager = new humanResources();
                    Staff staff = new Staff();
                    staff.setUserName(searchField.getText());
                    staff = (Staff) manager.searchAccount(staff);
                    if(staff.getFirstName()!=null)
                    {
                        manager.deleteAccount(staff);
                        JOptionPane.showMessageDialog(new JFrame(), "Succssed");
                    }
                    else
                    {
                         JOptionPane.showMessageDialog(new JFrame(), "not found");
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    //Logger.getLogger(ManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                }             }
        });
    }

    public static void main(String[] args) {
        Staff user = new Staff();
        user.setFirstName("Mohammed");
        user.setLastName("Kamal");
        new HumanResourcesScreen(user).setVisible(true);
    }
}
