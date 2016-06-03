package GUI;
import Core.Staff.Manager;
import Core.Staff.Staff;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ManagerScreen extends StaffMainLayout
{
    private JLabel headlineLabel;
    private JButton Statistics = new JButton("");
    private JButton totalDeposit = new JButton("");
    private static String name = "Muhammad Tarek";
    
    public ManagerScreen()
    {
        //Setting layout
        super("Manager", name);
        screen=getContentPane();
        screen.setLayout(null);
        
         Manager m1= new Manager();
            int [] values = new int[2];
            try {
                int deposits = m1.chart(1);
                int withdraws = m1.chart(2);
                values[0]=deposits;
                values[1]=withdraws;
            } catch (Exception ex) {
            
            }
            String[] names={"Deposits","Withdraws"};
            
            Statistics.setText("Statistics");
            Statistics.setBackground(new Color(63, 81, 181));
            Statistics.setForeground(Color.white);
            Statistics.setBounds(50, 80, 170, 30);
            totalDeposit.setText("Total Deposit");
            totalDeposit.setBackground(new Color(63, 81, 181));
            totalDeposit.setForeground(Color.white);
            totalDeposit.setBounds(270, 80, 170, 30);
            add(Statistics);
            add(totalDeposit);
            ChartPanel panel = new ChartPanel(values, names, "Bank Report");
            panel.setBounds(50, 170, 700, 400);
            screen.add(panel);
        searchField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                Manager manager = new Manager();
                Staff staff = new Staff();
                staff.setUserName(searchField.getText());
                try {
                    staff = (Staff)manager.searchAccount(staff);
                    if(staff.getFirstName()!= null){
                    new StaffAccountScreen("Search",staff,"Manager").setVisible(true);}
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
               new StaffAccountScreen("create",null,"Manager").setVisible(true);
            }
        });
       updateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Manager manager = new Manager();
                    Staff staff = new Staff();
                    staff.setUserName(searchField.getText());
                    staff = (Staff) manager.searchAccount(staff);
                    new StaffAccountScreen("Update",staff,"Manager").setVisible(true);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(ManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
       deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Manager manager = new Manager();
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
                } 
            }
        });
       Statistics.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Manager manager = new Manager();
                try {
                    JOptionPane.showMessageDialog(new JFrame(), manager.showStatistics());
                } catch (IOException | ClassNotFoundException ex) {
                    //Logger.getLogger(ManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
       totalDeposit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Manager manager = new Manager();
                try {
                    JOptionPane.showMessageDialog(new JFrame(), "Total Deposit = "+ manager.showTotalDeposits());
                } catch (IOException | ClassNotFoundException ex) {
                    //Logger.getLogger(ManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }
    
    public static void main(String[] args)
    {
        new ManagerScreen().setVisible(true);
    } 
}

