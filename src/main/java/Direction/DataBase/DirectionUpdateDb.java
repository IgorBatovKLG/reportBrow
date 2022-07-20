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
                                  String href) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Direction SET countRecord = (?)" +
                " and countMisEx = (?)" +
                " and countRemd = (?)" +
                " and errorRAndM = (?)" +
                " and errorRemd = (?)" +
                " and stop = (?)" +
                " and error = (?)" +
                " WHERE href = (?)")) {
            statement.setInt(1, countRecord);
            statement.setInt(2, countMisEx);
            statement.setInt(3, countRemd);
            statement.setString(4, errorRAndM);
            statement.setString(5, errorRemd);
            statement.setString(6, stop);
            statement.setString(7, error);
            statement.setString(8, href);
            statement.executeUpdate();
        } catch (SQLException e) {
            return true;
        }
        return false;
    }




}
