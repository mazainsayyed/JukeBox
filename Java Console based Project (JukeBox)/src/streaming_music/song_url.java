package streaming_music;
import java.sql.*;
import java.util.Scanner;
public class song_url
{
    Connection con;
    String path;
    Scanner s=new Scanner(System.in);
    public String showSongPath(Connection con)
    {
        try{

            int choice=s.nextInt();
            String song_Name ="select * from songs_list where song_Id=?";
            PreparedStatement statement1= con.prepareStatement(song_Name);
            statement1.setInt(1,choice);
            ResultSet url=statement1.executeQuery();
            while (url.next())
            {
                path=url.getString(7);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Table not showing");
        }
        return path;
    }
}
