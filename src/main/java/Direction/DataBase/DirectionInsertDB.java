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
                                      String docStatus,
                                      String number){
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Direction VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
            statement.setString(2, href);
            statement.setString(3, hashRemd);
            statement.setString(4, info);
            statement.setString(10, dateStart);
            statement.setString(11, dateAnd);
            statement.setString(13, docStatus);
            statement.setString(15, number);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            return true;
        }
        return false;
    }
}
