package Direction.DataBase;

import Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectionSelectDb {

    public ArrayList<String> getHrefNotCloset(){
        Connection connection = DBConnection.connection;
        ArrayList<String> result = new ArrayList<>();
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT href from Direction where docStatus != 'Закрыто' and stop ='false'");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                result.add(resultSet.getString(1));
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }

    public ArrayList<String> getHrefCloset(){
        Connection connection = DBConnection.connection;
        ArrayList<String> result = new ArrayList<>();
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT href from Direction where docStatus = 'Закрыто' and stop ='false'");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                result.add(resultSet.getString(1));
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }
    public ArrayList<String> getHrefCloset1(){
        Connection connection = DBConnection.connection;
        ArrayList<String> result = new ArrayList<>();
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT href from Direction where docStatus = 'Закрыто' and stop ='false'");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                result.add(resultSet.getString(1));
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }
}
