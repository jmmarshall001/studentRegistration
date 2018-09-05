package studentregistration;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * John Marshall
 */
public class StudentRegistration extends JFrame {

    JLabel firstLabel = new JLabel("First Name:");
    JLabel lastLabel = new JLabel("Last Name:");
    JLabel yearLabel = new JLabel("Year of Birth:");
    JLabel passLabel = new JLabel("Temporary Password:");
    JLabel displayLabel = new JLabel("");
    private JTextField firstField;
    private JTextField lastField;
    private JTextField yearField;
    private JTextField passField;
    private JButton registerButton;
    private JButton exitButton;
    
    public StudentRegistration() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }

    private void initComponents() {
        setTitle("Student Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        
        firstField = new JTextField("");
        lastField = new JTextField("");
        yearField = new JTextField("");
        passField = new JTextField("");
    
        passField.setEditable(false);
        
        Dimension dim = new Dimension(150, 20);
        
        firstField.setPreferredSize(dim);
        firstField.setMinimumSize(dim);
        lastField.setPreferredSize(dim);
        lastField.setMinimumSize(dim);
        yearField.setPreferredSize(dim);
        yearField.setMinimumSize(dim);
        passField.setPreferredSize(dim);
        passField.setMinimumSize(dim);
        
        registerButton = new JButton("Register");
        exitButton = new JButton("Exit");
        // components go here
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(firstLabel, getConstraints(0,0,1));
        panel.add(lastLabel, getConstraints(0,1, 1));
        panel.add(yearLabel, getConstraints(0,2,1));
        panel.add(passLabel, getConstraints(0,3,1));
        panel.add(displayLabel, getConstraints(0,4,2));

        panel.add(firstField, getConstraints(1,0,1));
        panel.add(lastField, getConstraints(1,1,1));
        panel.add(yearField, getConstraints(1,2,1));
        panel.add(passField, getConstraints(1,3,1));
        
        add(panel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(registerButton);
        buttonPanel.add(exitButton);
        
        registerButton.addActionListener(e -> registerButtonClicked());
        exitButton.addActionListener(e -> exitButtonClicked());
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        setSize(new Dimension(400, 250));
        setVisible(true);
    }

    private GridBagConstraints getConstraints(int x, int y, int w) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        return c;
    }

    private void registerButtonClicked() {
       String firstName = firstField.getText();
       String lastName = lastField.getText();
       String year = yearField.getText();
       int numYear = 0;
       String pass = "";
       boolean good = true;
       
       if(firstName.equals("") || lastName.equals(""))
       {
           displayLabel.setText("Please enter first name, last name, and year of birth.");
       }
       else
       {
           try
           {
              numYear = Integer.parseInt(year); 
           }
           catch(NumberFormatException e)
           {
               displayLabel.setText("Please enter first name, last name, and year of birth.");
               good = false;
           }
           
           if(good)
           {
                pass = firstName + "*" + numYear;
           
                passField.setText(pass);
           
                displayLabel.setText("Welcome " + firstName + " " + lastName);
           }
       }
        
    }

    private void exitButtonClicked() {
        System.exit(0);
     }
    
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new StudentRegistration();
        });        
    }
}

    



