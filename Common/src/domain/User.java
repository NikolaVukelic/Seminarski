/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class User implements GeneralEntity {

    private int userID;
    private String username;
    private String password;
    private String email;

    public User() {
    }

    
    public User(int userID, String username, String password, String email) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getAtrValue() {
        return (getUserID() == -1 ? null : "'" + getUserID() + "'")+ ", " + (username == null ? null : "'" + username + "'") + ", " + (password == null ? null : "'" + password + "'")+ ", " + (email == null ? null : "'" + email + "'");
    }

    @Override
    public String setAtrValue() {
        return "userID=" + (getUserID() == -1 ? null : "'" + getUserID() + "'") + "username=" + (username == null ? null : "'" + username + "'") + "password=" + (password == null ? null : "'" + password + "'")+ "email=" + (email == null ? null : "'" + email + "'");
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getWhereCondition() {
        return "username= " + (username == null ? null : "'" + username + "'") + " AND password=" + (password == null ? null : "'" + password + "'");
    }

    @Override
    public List<GeneralEntity> getList(ResultSet rs) throws Exception {
        return null;
    }

    @Override
    public void setPrimaryKey(int id) {
    }

    @Override
    public List<GeneralEntity> vratiListu() {
        return null;
    }

    @Override
    public GeneralEntity getEntity(ResultSet rs) throws Exception {
        User user = null;
        if (rs.next()) {
            user = new User(userID, username, password, email);
        }
        if (username != null) {
            return user;
        } else {
            return null;
        }
    }

}
