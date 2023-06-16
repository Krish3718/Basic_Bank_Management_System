package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String cardNumber;
    JButton cancelButton;
    MiniStatement(String card_Number)
    {
        this.cardNumber=card_Number;

        ImageIcon background_img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage = background_img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        background_img.setImage(scaledImage);

        JLabel background = new JLabel(background_img);
        background.setBounds(0, 0, 900, 900);
        add(background);


        JLabel text = new JLabel("My Bank");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(300, 300, 200, 20);
        background.add(text);

        JLabel card_no=new JLabel("Card Number : ");
        card_no.setForeground(Color.WHITE);
        card_no.setFont(new Font("System", Font.BOLD, 12));
        card_no.setBounds(200, 330, 100, 20);
        background.add(card_no);

        JLabel actual_no=new JLabel(cardNumber);
        actual_no.setForeground(Color.WHITE);
        actual_no.setFont(new Font("System", Font.BOLD, 12));
        actual_no.setBounds(300, 330, 150, 20);
        background.add(actual_no);

        JLabel statement=new JLabel();
        statement.setFont(new Font("System", Font.BOLD, 10));
        background.add(statement);
        statement.setBounds(200,325,400,200);
        statement.setForeground(Color.WHITE);

        Conn conn=new Conn();
        String query="Select * from credit_logs where cardnumber='"+cardNumber+"'order by id DESC";
        try
        {
            ResultSet rs=conn.s.executeQuery(query);
            int i=0;
            while(rs.next() && i<5)
            {
                statement.setText(statement.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br> <html>");
                i++;
            }
        }catch (Exception exception)
        {
            System.out.println(exception);
        }


        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("Raleway", Font.BOLD,12));
        cancelButton.setBounds(350,500,130,25);
        background.add(cancelButton);
        cancelButton.addActionListener(this);

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
    }
}
