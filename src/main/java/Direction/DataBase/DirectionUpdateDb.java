package Direction.DataBase;

import Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DirectionUpdateDb {

    public boolean updateStatus(String status, String href) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Direction SET docStatus = (?) WHERE href = (?)")) {
            statement.setString(1, status);
            statement.setString(2, href);
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public boolean updateFullStop(int countRecord,
                                  int countMisEx,
                                  int countRemd,
                                  String errorRAndM,
                                  String errorRemd,
                                  String stop,
                                  String error,
                                  String href,
                                  String number) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Direction SET countRecord = (?)" +
                " , countMisEx = (?)" +
                " , countRemd = (?)" +
                " , errorRAndM = (?)" +
                " , errorRemd = (?)" +
                " , stop = (?)" +
                " , error = (?)" +
                " , number = (?)" +
                " WHERE href = (?)")) {
            statement.setInt(1, countRecord);
            statement.setInt(2, countMisEx);
            statement.setInt(3, countRemd);
            statement.setString(4, errorRAndM);
            statement.setString(5, errorRemd);
            statement.setString(6, stop);
            statement.setString(7, error);
            statement.setString(8, number);
            statement.setString(9, href);
            statement.executeUpdate();
            System.out.println(statement.getUpdateCount());
        } catch (SQLException e) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return true;
        }
        return false;
    }




}
