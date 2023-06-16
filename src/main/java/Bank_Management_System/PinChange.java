package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {
    String cardNumber;
    JButton cancelButton,submitButton;
    JPasswordField oldPinText,newPinText;
    PinChange(String card_Number)
    {
        this.cardNumber=card_Number;

        ImageIcon background_img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage = background_img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        background_img.setImage(scaledImage);

        JLabel background = new JLabel(background_img);
        background.setBounds(0, 0, 900, 900);
        add(background);

        JLabel text = new JLabel("Pin Change");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(280, 300, 200, 20);
        background.add(text);

        JLabel oldPin=new JLabel("Old Pin : ");
        oldPin.setForeground(Color.WHITE);
        oldPin.setFont(new Font("System", Font.BOLD,12));
        oldPin.setBounds(220,350,100,20);
        background.add(oldPin);

        oldPinText=new JPasswordField();
        oldPinText.setFont(new Font("Raleway", Font.BOLD,12));
        oldPinText.setBounds(280,350,100,25);
        background.add(oldPinText);

        JLabel newPin=new JLabel("New Pin : ");
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("System", Font.BOLD,12));
        newPin.setBounds(220,400,100,20);
        background.add(newPin);

        newPinText=new JPasswordField();
        newPinText.setFont(new Font("Raleway", Font.BOLD,12));
        newPinText.setBounds(280,400,100,25);
        background.add(newPinText);

        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("Raleway", Font.BOLD,12));
        cancelButton.setBounds(200,450,130,25);
        background.add(cancelButton);
        cancelButton.addActionListener(this);

        submitButton=new JButton("Submit");
        submitButton.setFont(new Font("Raleway", Font.BOLD,12));
        submitButton.setBounds(370,450,130,25);
        background.add(submitButton);
        submitButton.addActionListener(this);

        setSize(900,900);
        setLayout(null);
        setLocation(450,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancelButton)
        {
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
        else if(e.getSource()==submitButton)
        {
            String soldpin=oldPinText.getText();
            String snewpin=newPinText.getText();

            if(soldpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Old Pin");
                return;
            }

            if(snewpin.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter New Pin");
                return;
            }

            Conn conn=new Conn();
            String query="select * from login where cardnumber='"+cardNumber+"'";
            String query2="update login set pin='"+snewpin+"'where cardnumber='"+cardNumber+"'";
            String query3="update signupthree set pin='"+snewpin+"'where cardnumber='"+cardNumber+"'";
            try
            {
                ResultSet rs=conn.s.executeQuery(query);
                if(!rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Something went wrong");
                }
                String pin_old=rs.getString("pin");
                if(!pin_old.equals(soldpin))
                {
                    JOptionPane.showMessageDialog(null,"Old Pin Incorrect");
                    return;
                }
                if(snewpin.length()>4)
                {
                    JOptionPane.showMessageDialog(null,"New pin should be only 4 digits");
                    return;
                }
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Pin Successfully Changed");
                setVisible(false);
                new Transactions(cardNumber).setVisible(true);
            }
            catch (Exception exception)
            {
                System.out.println(exception);
            }
        }
    }

}
