package com.java.code.cz3002.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {

    @Override
    public String execute() throws Exception {
        if (validateString(getUsername()) && validateString(getPassword()))
            if (attemptLogin(getUsername(),getPassword()) == true) {
            	return "SUCCESS";
            } else {
            	resultsMsg = "Failed to login: wrong credentials provided!";
            	return "ERROR";
            }
        else {
        	resultsMsg = "Failed to login: credentials cannot be empty!";
        	return "ERROR";
        }
    }
    
    private String username;
    private String password;
    private String resultsMsg;
    
    public boolean attemptLogin(String username, String password) {
        boolean returnMsg = false;
        Connection dbConn = null;

        try {
           String URL = "jdbc:mysql://localhost/userbase";
           Class.forName("com.mysql.jdbc.Driver");
           dbConn = DriverManager.getConnection(URL, "root", "");
           String sql = "SELECT username FROM users WHERE";
           sql+=" username = ? AND password = ?";
           PreparedStatement ps = dbConn.prepareStatement(sql);
           ps.setString(1, username);
           ps.setString(2, password);
           ResultSet rs = ps.executeQuery();

           while (rs.next()) {
              returnMsg = true;
           }
        } catch (Exception e) {
        	returnMsg = false;
        } finally {
           if (dbConn != null) {
              try {
                 dbConn.close();
              } catch (Exception e) {
              }
           }
        }
        return returnMsg;
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
    
    public String getResultsMsg() {
        return resultsMsg;
    }

    public void setResultsMsg(String resultsMsg) {
        this.resultsMsg = resultsMsg;
    }

    private boolean validateString(String str) {
        if (str != null && !str.equals(""))
            return true;
        return false;
    }
}
