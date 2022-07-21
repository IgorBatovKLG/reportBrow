package Direction.DataBase;

import Configuration.DBConnection;
import Direction.Models.DirectionErrorModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<String> getHrefNotDayReg(){
        Connection connection = DBConnection.connection;
        ArrayList<String> result = new ArrayList<>();
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("select href from Direction where docStatus = 'Закрыто' and dayReg = 'null'");
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


    /**
     *     String dayEnd;
     *     String dayReg;
     *     String dayRecord;
     *     String maxDayReg;
     *     String maxDayRecord;
     *     String docStatus;
     *     String number;
     */
    public ArrayList<DirectionErrorModel> getFinalErrorRecord(){
        Connection connection = DBConnection.connection;
        ArrayList<DirectionErrorModel> result = new ArrayList<>();
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("select dayReg,dateAnd,dayRecord,maxDayReg,maxDayRecord,docStatus,number FROM Direction where dayRecord = 'null'");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                result.add(new DirectionErrorModel(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                ));
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }



}
