/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import domain.GeneralEntity;
import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import storage.database.connection.DatabaseConnection;

/**
 *
 * @author Nikola
 */
public class DatabaseBroker {

    public List<GeneralEntity> vratiSve(GeneralEntity entity) throws Exception {
        List<GeneralEntity> list;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM " + entity.getTableName();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = entity.getList(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public GeneralEntity kreirajObjekat(GeneralEntity entity) throws SQLException, Exception {

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO " + entity.getTableName() + " VALUES( " + entity.getAtrValue() + ")";
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();

            ResultSet rsKeys = ps.getGeneratedKeys();
            int id = 0;
            if (rsKeys.next()) {
                id = rsKeys.getInt(1);
                entity.setPrimaryKey(id);
            } else {
                throw new Exception("Invalid id!");
            }

            ps.close();
            rsKeys.close();
            return entity;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

    }


    public void kreirajObjekatSaKljucem(GeneralEntity entity) throws SQLException {

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO " + entity.getTableName() + " VALUES (" + entity.getAtrValue() + ")";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            throw ex;
        }

    }

    public void kreirajListuObjekataSaKljucem(ArrayList<GeneralEntity> entities) throws SQLException {

        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            for (GeneralEntity gn : entities) {
                String query = "INSERT INTO " + gn.getTableName() + " VALUES (" + gn.getAtrValue() + ")";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.executeUpdate();

                ps.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }

    }

    public List<GeneralEntity> vratiSaUslovom(GeneralEntity entity) throws SQLException, Exception {
        List<GeneralEntity> list;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM " + entity.getTableName() + " WHERE " + entity.getWhereCondition();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            list = entity.getList(rs);
            rs.close();
            st.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public User prijavljivanje(GeneralEntity entity) throws SQLException, Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM " + entity.getTableName() + " WHERE " + entity.getWhereCondition();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("userID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                return new User(id, username, password, email);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void obrisiObjekat(GeneralEntity entity) throws Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "DELETE FROM " + entity.getTableName() + " WHERE " + entity.getWhereCondition();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void storniraj(GeneralEntity entity) throws SQLException {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            System.out.println("entity je "+entity);
            String query = "UPDATE " + entity.getTableName() + " SET "+entity.setAtrValue()+" WHERE " + entity.getWhereCondition();
            System.out.println(query);
            Statement st = connection.createStatement();
            st.executeUpdate(query);

            st.close();
        } catch (SQLException ex) {
            throw ex;
        }

    }

}
