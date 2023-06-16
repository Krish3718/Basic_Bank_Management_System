package Bank_Management_System;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton depositButton,withdrawButton,miniStatementButton,fastCashButton,balanceEnquiryButton,pinChangeButton,exitButton;
    String cardNumber;
    Transactions(String card_Number)
    {
        this.cardNumber=card_Number;
        ImageIcon background_img=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image scaledImage=background_img.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        background_img.setImage(scaledImage);

        JLabel background=new JLabel(background_img);
        background.setBounds(0,0,900,900);
        add(background);

        JLabel top=new JLabel("Please Select Your Transaction");
        top.setFont(new Font("System", Font.BOLD,16));
        top.setForeground(Color.WHITE);
        top.setBounds(220,300,500,35);
        background.add(top);

        depositButton=new JButton("Deposit");
        depositButton.setBounds(170,415,150,30);
        background.add(depositButton);
        depositButton.addActionListener(this);

        withdrawButton=new JButton("Cash Withdrawl");
        withdrawButton.setBounds(355,415,150,30);
        background.add(withdrawButton);
        withdrawButton.addActionListener(this);

        fastCashButton=new JButton("Fast Cash");
        fastCashButton.setBounds(170,450,150,30);
        background.add(fastCashButton);
        fastCashButton.addActionListener(this);

        miniStatementButton=new JButton("Mini Statement");
        miniStatementButton.setBounds(355,450,150,30);
        background.add(miniStatementButton);
        miniStatementButton.addActionListener(this);

        pinChangeButton=new JButton("Pin Change");
        pinChangeButton.setBounds(170,485,150,30);
        background.add(pinChangeButton);
        pinChangeButton.addActionListener(this);

        balanceEnquiryButton=new JButton("Balance Enquiry");
        balanceEnquiryButton.setBounds(355,485,150,30);
        background.add(balanceEnquiryButton);
        balanceEnquiryButton.addActionListener(this);

        exitButton=new JButton("Exit");
        exitButton.setBounds(355,520,150,30);
        background.add(exitButton);
        exitButton.addActionListener(this);

        setLayout(null);
        setSize(900,900);
        setLocation(450,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==depositButton)
        {
            setVisible(false);
            new Deposit(cardNumber).setVisible(true);
        }
        else if(e.getSource()==withdrawButton)
        {
            setVisible(false);
            new Withdraw(cardNumber).setVisible(true);
        }
        else if(e.getSource()==miniStatementButton)
        {
            setVisible(false);
            new MiniStatement(cardNumber).setVisible(true);
        }
        else if(e.getSource()==balanceEnquiryButton)
        {
            setVisible(false);
            new BalanceEnquiry(cardNumber).setVisible(true);
        }
        else if(e.getSource()==fastCashButton)
        {
            setVisible(false);
            new FastCash(cardNumber).setVisible(true);
        }
        else if(e.getSource()==pinChangeButton)
        {
            setVisible(false);
            new PinChange(cardNumber).setVisible(true);
        }
        else if(e.getSource()==exitButton)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
