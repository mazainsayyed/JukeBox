package main_jukebox_portal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Custom_Exception.Incorrect_Email;
import Custom_Exception.Incorrect_Password;

public class checking_user
{
    Connection con;
    public static int CheckUser(Connection con, String User_Name)
    {
        int found = 0;
        try {
            String sql = "Select * from User where User_Name=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, User_Name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                found++;
                break;
            }
        }
        catch (SQLException e) {System.out.println(e);}
        if (found == 1) {
            return 1;
        } else
            return 0;
    }

    public int signUp(Connection con, String User_Name, String USer_PassWord, String Email, long MobileNumber) throws Incorrect_Password,Incorrect_Email
    {
        {
            int exist = CheckUser(con, User_Name);
            if (exist == 1)
            {
                System.out.println(".............User Already Exist...................... \n.....................");
                return exist;
            }

        }
        try {
            String sql = "insert into User(User_Name,USer_PassWord,Email,MobileNumber) values(?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(sql);
            // statement.setInt(1,  user_Id);
            statement.setString(1, User_Name);        //giving value to database
            statement.setString(2, USer_PassWord);
            statement.setString(3, Email);
            statement.setLong(4, MobileNumber);
            statement.execute();
           System.out.println(" -------------☺---✅--Successfully REGISTERED---✅-☺-----------");
            System.out.println();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return 1;
    }

    public boolean Login(Connection conn, String user_Name, String USer_password) {
        Scanner src = new Scanner(System.in);
        try {
            String sql = "Select * from User where User_Name=? and USer_PassWord=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, USer_password);


            statement.setString(2, USer_password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next())
            {
                System.out.println("\n  Welcome user:  \uD83E\uDD17 "+  User_Name.toUpperCase());
            }
            else
            {
                System.out.println("......   ☹☹️ SORRY !!  ☹ ☹️ Your Entered Wrong User Name or  Password " +
                        "  ..........");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("-----------------------" + e.getMessage() + "---------------------------------------------");
        }
        return true;
    }
}