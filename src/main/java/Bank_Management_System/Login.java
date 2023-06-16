package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signInButton,clearButton,signUpButton;
    JTextField cardNumberField;
    JPasswordField pinTextField;

    Login()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon loginIcon=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image scaledIcon=loginIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        loginIcon=new ImageIcon(scaledIcon);
        JLabel icon=new JLabel(loginIcon);
        icon.setBounds(80,30,100,100);
        add(icon);

        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(265,55,400,40);
        add(text);

        JLabel cardNumber=new JLabel("Card No : ");
        cardNumber.setFont(new Font("Raleway", Font.BOLD,28));
        cardNumber.setBounds(175,175,150,40);
        add(cardNumber);

        cardNumberField=new JTextField();
        cardNumberField.setBounds(325,175,250,40);
        cardNumberField.setFont(new Font("Arial", Font.BOLD,14));
        add(cardNumberField);

        JLabel pin=new JLabel("        Pin : ");
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        pin.setBounds(175,230,150,40);
        add(pin);

        pinTextField=new JPasswordField();
        pinTextField.setBounds(325,230,250,40);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(pinTextField);

        signInButton=new JButton("Sign In");
        signInButton.setBounds(325,290,120,40);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.addActionListener(this);
        add(signInButton);

        clearButton=new JButton("Clear");
        clearButton.setBounds(455,290,120,40);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        add(clearButton);

        signUpButton=new JButton("Sign Up");
        signUpButton.setBounds(325,340,250,40);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.addActionListener(this);
        add(signUpButton);


        setSize(800,480);
        setVisible(true);
        setLocation(500,300);
        setTitle("Bank Management System");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==signInButton)
        {
            Conn conn=new Conn();
            String query="Select * from login where cardnumber='"+cardNumberField.getText()+"'and pin='"+pinTextField.getText()+"'";
            try {
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(cardNumberField.getText()).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Card Number or Pin");
                }
            }catch (Exception exception)
            {
                System.out.println(exception);
            }
        }
        else if(e.getSource()==clearButton)
        {
            cardNumberField.setText("");
            pinTextField.setText("");
        }
        else if(e.getSource()==signUpButton)
        {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }


}
