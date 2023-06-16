package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String cardNumber;
    JButton cancelButton;
    BalanceEnquiry(String card_Number) {
        this.cardNumber = card_Number;
        ImageIcon background_img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage = background_img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        background_img.setImage(scaledImage);

        JLabel background = new JLabel(background_img);
        background.setBounds(0, 0, 900, 900);
        add(background);

        JLabel text = new JLabel("Balance Enquiry");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(280, 300, 200, 20);
        background.add(text);


        JLabel card_no=new JLabel("Card Number : ");
        card_no.setForeground(Color.WHITE);
        card_no.setFont(new Font("System", Font.BOLD, 12));
        card_no.setBounds(230, 350, 100, 20);
        background.add(card_no);

        JLabel actual_no=new JLabel(card_Number);
        actual_no.setForeground(Color.WHITE);
        actual_no.setFont(new Font("System", Font.BOLD, 12));
        actual_no.setBounds(330, 350, 150, 20);
        background.add(actual_no);

        JLabel text1 =new JLabel("Available Balance : ");
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System", Font.BOLD, 12));
        text1.setBounds(230, 370, 150, 20);
        background.add(text1);

        Conn conn=new Conn();
        String query="select * from bank where cardnumber='"+cardNumber+"'";
        String balance_amount=null;
        try
        {
            ResultSet rs=conn.s.executeQuery(query);
            if(!rs.next())
            {
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            balance_amount= String.valueOf(Integer.parseInt(rs.getString("amount")));
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }

        JLabel balance=new JLabel(balance_amount);
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("System", Font.BOLD, 12));
        balance.setBounds(400, 370, 150, 20);
        background.add(balance);


        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Raleway", Font.BOLD, 22));
        cancelButton.setBounds(380, 500, 130, 25);
        background.add(cancelButton);
        cancelButton.addActionListener(this);

        setSize(900, 900);
        setLayout(null);
        setLocation(450, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cancelButton)
        {
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }

}
