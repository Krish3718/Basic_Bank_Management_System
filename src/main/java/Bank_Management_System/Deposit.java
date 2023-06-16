package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String cardNumber;
    JButton depositButton,cancelButton;
    JTextField amount;

    Deposit(String card_Number)
    {
        this.cardNumber=card_Number;

        ImageIcon background_img=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage=background_img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        background_img.setImage(scaledImage);

        JLabel background=new JLabel(background_img);
        background.setBounds(0,0,900,900);
        add(background);

        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(180,300,300,20);
        background.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,22));
        amount.setBounds(180,350,300,25);
        background.add(amount);

        cancelButton=new JButton("Cancel");
        cancelButton.setFont(new Font("Raleway", Font.BOLD,22));
        cancelButton.setBounds(180,400,130,25);
        background.add(cancelButton);
        cancelButton.addActionListener(this);

        depositButton=new JButton("Deposit");
        depositButton.setFont(new Font("Raleway", Font.BOLD,22));
        depositButton.setBounds(350,400,130,25);
        background.add(depositButton);
        depositButton.addActionListener(this);

        setSize(900,900);
        setLayout(null);
        setLocation(450,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==depositButton)
        {
            String number=amount.getText();
            Date date=new Date();
            String type="Deposit";
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter an amount to deposit");
                return;
            }
            Conn conn=new Conn();
            String query="insert into credit_logs(cardnumber,date,type,amount) values('"+cardNumber+"','"+date.toString()+"','"+type+"','"+number+"')";
            String query2="select * from bank where cardnumber='"+cardNumber+"'";
            try
            {
                ResultSet rs=conn.s.executeQuery(query2);
                if(!rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Something went wrong");
                }
                int balance_amount=Integer.parseInt(rs.getString("amount"));
                balance_amount+=Integer.parseInt(number);
                String query3="update bank set amount='"+balance_amount+"'where cardnumber='"+cardNumber+"'";
                conn.s.executeUpdate(query3);
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" deposited successfully");
                setVisible(false);
                new Transactions(cardNumber).setVisible(true);
            }
            catch (Exception exception)
            {
                System.out.println(exception);
            }
        }
        else if(e.getSource()==cancelButton)
        {
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
        }
    }
}
