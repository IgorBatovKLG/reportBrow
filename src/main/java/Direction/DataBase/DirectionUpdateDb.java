package Direction.DataBase;

import Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public boolean updateDayReg(String href) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Direction SET dayReg = (?) WHERE href = (?)")) {
            statement.setString(1, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
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
                                  String href,
                                  String number) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Direction SET countRecord = (?)" +
                " , countMisEx = (?)" +
                " , countRemd = (?)" +
                " , errorRAndM = (?)" +
                " , errorRemd = (?)" +
                " , stop = (?)" +
                " , number = (?)" +
                " WHERE href = (?)")) {
            statement.setInt(1, countRecord);
            statement.setInt(2, countMisEx);
            statement.setInt(3, countRemd);
            statement.setString(4, errorRAndM);
            statement.setString(5, errorRemd);
            statement.setString(6, stop);
            statement.setString(7, number);
            statement.setString(8, href);
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

    public boolean updateError(String href) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Direction SET error = 'true' WHERE href = (?)")) {
            statement.setString(1, href);
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

    public boolean daysReg(String href, String days) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Direction SET dayRegCal = (?) WHERE href = (?)")) {
            statement.setString(2, href);
            statement.setString(1, days);
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

    public boolean daysRecord(String href, String days) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("UPDATE Direction SET dayRecordCal = (?) WHERE href = (?)")) {
            statement.setString(2, href);
            statement.setString(1, days);
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




}
