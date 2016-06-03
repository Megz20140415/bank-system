package GUI;

import GUI.MainLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class StaffMainLayout extends MainLayout
{
    protected JTextField searchField;
    protected JButton createButton;
    protected JButton updateButton;
    protected JButton deleteButton;
    
    private JTable accountsTable;
    protected int buttonsMargin = 120;
    protected int buttonWidth = 40;
    protected int buttonHeight = 40;
    
    protected Icon create;
    protected Icon update;
    protected Icon delete;
    
    public StaffMainLayout(String screenTitle, String name)
    {
        //Setting screen title
        super(screenTitle, name);
          
        //Creating components
        create = new ImageIcon(getClass().getResource("Icons\\create.png"));
        update = new ImageIcon(getClass().getResource("Icons\\update.png"));
        delete = new ImageIcon(getClass().getResource("Icons\\delete.png"));
        searchField = new JTextField("Search");
        createButton = new JButton(create);
        updateButton = new JButton(update);
        deleteButton = new JButton(delete);
        
        //Setting colors
        searchField.setBackground(null);
        createButton.setBackground(new Color(63,81,181));
        updateButton.setBackground(new Color(63,81,181));
        deleteButton.setBackground(new Color(63,81,181));
        
        //Setting fonts
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        
        //Setting positions
        searchField.setBounds(590, 80, 170, 30);
        createButton.setBounds(600, buttonsMargin, buttonWidth, buttonHeight);
        updateButton.setBounds(655, buttonsMargin, buttonWidth, buttonHeight);
        deleteButton.setBounds(710, buttonsMargin, buttonWidth, buttonHeight);
        
        //Setting borders
        searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY)); 
        createButton.setBorder(null);
        updateButton.setBorder(null);
        deleteButton.setBorder(null);
        
        //Setting border focus
        createButton.setFocusPainted(false);
        updateButton.setFocusPainted(false);
        deleteButton.setFocusPainted(false);
        
        //Focus handling
        searchField.addFocusListener(new FocusListener() 
        {
            int Counter = 0;
            @Override
            public void focusLost(FocusEvent arg0)
            {
                searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            }

            @Override
            public void focusGained(FocusEvent arg0)
            { 
                if (Counter == 0 || (searchField.getText()).equals("Search"))
                    searchField.setText("");
                    
                Counter++;
                searchField.setVisible(true);
                searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(63,81,181)));
            }
        });
        
        searchField.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if ((searchField.getText()).equals("Search"))
                    searchField.setText("");
            }
        });
        
        //Adding components to the frame
        screen.add(searchField);
        screen.add(createButton);
        screen.add(updateButton);
        screen.add(deleteButton);
    }

    public static void main(String[] args)
    {
        new MainLayout(" ", " ").setVisible(true);
    } 
}

