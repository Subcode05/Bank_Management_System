import java.sql.*;

public class Connect
{
    Connection c;
    Statement s;
    public Connect()
    {
        try{
            c= DriverManager.getConnection("jdbc:mysql:///BANKMANAGEMENTSYSTEM", "root","SUBHADIP@2004");
            s=c.createStatement();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
