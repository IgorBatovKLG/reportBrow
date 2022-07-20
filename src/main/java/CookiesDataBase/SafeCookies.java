package CookiesDataBase;

import Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SafeCookies {
        public void SafeCookies(ArrayList<String> strings) {
            Connection connection = DBConnection.connection;
            try (PreparedStatement statement = connection.prepareStatement("UPDATE cookies SET name = (?) , value = (?) WHERE id = '1'")) {
                statement.setString(1, strings.get(0));
                statement.setString(2, strings.get(2));
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try (PreparedStatement statement = connection.prepareStatement("UPDATE cookies SET name = (?) , value = (?) WHERE id = '2'")) {
                statement.setString(1, strings.get(1));
                statement.setString(2, strings.get(3));
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
