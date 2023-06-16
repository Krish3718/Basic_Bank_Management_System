package Bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    String cardNumber;
    JButton hunderdButton,thousandButton,tenthousandButton,fivehundredButton,fivethousandButton,twothousandButton,exitButton;
    FastCash(String card_Number)
    {
        this.cardNumber=card_Number;

        ImageIcon background_img=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage=background_img.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        background_img.setImage(scaledImage);


        JLabel background=new JLabel(background_img);
        background.setBounds(0,0,900,900);
        add(background);

        JLabel top=new JLabel("Fast Cash");
        top.setFont(new Font("System", Font.BOLD,22));
        top.setForeground(Color.WHITE);
        top.setBounds(280,300,500,35);
        background.add(top);

        hunderdButton=new JButton("100 Rs");
        hunderdButton.setBounds(170,415,150,30);
        background.add(hunderdButton);
        hunderdButton.addActionListener(this);

        fivehundredButton=new JButton("500 Rs");
        fivehundredButton.setBounds(355,415,150,30);
        background.add(fivehundredButton);
        fivehundredButton.addActionListener(this);

        thousandButton=new JButton("1000 Rs");
        thousandButton.setBounds(170,450,150,30);
        background.add(thousandButton);
        thousandButton.addActionListener(this);

        twothousandButton=new JButton("2000 Rs");
        twothousandButton.setBounds(355,450,150,30);
        background.add(twothousandButton);
        twothousandButton.addActionListener(this);

        fivethousandButton=new JButton("5000 Rs");
        fivethousandButton.setBounds(170,485,150,30);
        background.add(fivethousandButton);
        fivethousandButton.addActionListener(this);

        tenthousandButton=new JButton("10000 Rs");
        tenthousandButton.setBounds(355,485,150,30);
        background.add(tenthousandButton);
        tenthousandButton.addActionListener(this);

        exitButton=new JButton("Exit");
        exitButton.setBounds(355,520,150,30);
        background.add(exitButton);
        exitButton.addActionListener(this);

        setSize(900,900);
        setLayout(null);
        setLocation(450,50);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exitButton)
        {
            setVisible(false);
            new Transactions(cardNumber).setVisible(true);
            return;
        }
        Conn conn=new Conn();
        Date date=new Date();
        String type="Withdraw";
        String amount=null;
        if(e.getSource()==hunderdButton)amount="100";
        else if(e.getSource()==fivehundredButton)amount="500";
        else if(e.getSource()==thousandButton)amount="1000";
        else if(e.getSource()==twothousandButton)amount="2000";
        else if(e.getSource()==fivethousandButton)amount="5000";
        else if(e.getSource()==tenthousandButton)amount="10000";

        String query="insert into credit_logs(cardnumber,date,type,amount) values('"+cardNumber+"','"+date.toString()+"','"+type+"','"+amount+"')";
        String query2="select * from bank where cardnumber='"+cardNumber+"'";
        try
        {
            ResultSet rs=conn.s.executeQuery(query2);
            if(!rs.next())
            {
                JOptionPane.showMessageDialog(null,"Something went wrong");
            }
            int balance_amount=Integer.parseInt(rs.getString("amount"));
            if(balance_amount<Integer.parseInt(amount))
            {
                JOptionPane.showMessageDialog(null,"Insufficient Balance");
                return;
            }
            balance_amount-=Integer.parseInt(amount);
            String query3="update bank set amount='"+balance_amount+"'where cardnumber='"+cardNumber+"'";
            conn.s.executeUpdate(query);
            conn.s.executeUpdate(query3);
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }

        JOptionPane.showMessageDialog(null,"Rs "+amount+" withdrawn successfully");
        setVisible(false);
        new Transactions(cardNumber).setVisible(true);

    }

}
