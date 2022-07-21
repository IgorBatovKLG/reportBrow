package Direction.DataBase;

import Configuration.DBConnection;

import javax.sound.sampled.EnumControl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

public class DirectionInsertDB {
    public boolean InsertNewDirection(String href,
                                      String hashRemd,
                                      String info,
                                      String dateStart,
                                      String dateAnd,
                                      String docStatus){
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Direction VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            statement.setString(2, href);
            statement.setString(3, hashRemd);
            statement.setString(4, info);
            statement.setString(10, dateStart);
            statement.setString(11, dateAnd);
            statement.setString(13, docStatus);
            statement.setString(14, "false");
            statement.setString(17, "null");
            statement.setString(18, "null");
            statement.setString(19, "null");

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
