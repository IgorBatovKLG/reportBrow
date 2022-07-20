package Signature.DateBase;

import Configuration.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SignatureDateBase {

    public boolean setJsonBuro(String json, String date){
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO BuroSignature VALUES (?,?,?)")) {
            statement.setString(1, date);
            statement.setString(2, json);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            return true;
        }
        return false;
    }

    public boolean setJsonWorkers(String json, String date){
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO WorkersSignature VALUES (?,?,?)")) {
            statement.setString(1, date);
            statement.setString(2, json);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            return true;
        }
        return false;
    }

    public int getCountForNews(){
        Connection connection = DBConnection.connection;
        int count = 0;
        try {
            PreparedStatement pstmt;
            pstmt = connection.prepareStatement("SELECT seq from sqlite_sequence where name='NewsReport'");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next())
                count = resultSet.getInt(1);
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return count;
        }
        return count;
    }


    public boolean setNews(int id, String date){
        Connection connection = DBConnection.connection;
        int s = LocalDateTime.now().getHour();

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO NewsReport VALUES (?,?,?,?,?,?)")) {
            statement.setString(2, LocalDate.now().toString());
            statement.setString(3, "Открыть отчёт возможно по кнопке ниже");
            statement.setString(4, "Доступен новый отчёт по электронным подписям за " + date + " (Время " + s + "-00)");
            statement.setString(5, "http://10.40.99.10:801/signature?id=" + id);
            statement.setString(6, "2");
            statement.executeUpdate();
        } catch (SQLException throwables) {
            return true;
        }
        return false;
    }



}
