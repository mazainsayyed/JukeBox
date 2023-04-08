package sql_connection_jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class sql_Connect
{
    public Connection get_Connection()
    {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // load the driver   register the driver type
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Jukebox_Project", "root", "Root");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return con;
    }
}