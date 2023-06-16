package Bank_Management_System;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem?useSSL=false","root","<Password>");
            s=c.createStatement();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
