package model;

import bean.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDbUtil extends DbUtil {

    //Constructor
    public UserDbUtil(DataSource dataSource) {
        super(dataSource);
    }

    public boolean updateUserById(String userId, String userPsw, String userCell) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            // get a connection
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = new StringBuilder().append("UPDATE 2017j2ee.user SET user_psw =\"").append(userPsw).append("\", user_cell=\"").append(userCell).append("\" WHERE user_id=").append(userId).toString();
            System.out.println(sql);
            myStmt.executeUpdate(sql);
            return true;

        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void suspendUserById(String userId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            // create sql statement
            String sql = "UPDATE 2017j2ee.user SET user_valid = 0 WHERE user_id =".concat(userId);
            myStmt.executeUpdate(sql);

        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void activateUserById(String user_id) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            // create sql statement
            String sql = "UPDATE 2017j2ee.user SET user_valid = 1 WHERE user_id =".concat(user_id);
            myStmt.executeUpdate(sql);

        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public List<User> getUserListbyAdmin(String userName, String userStatus) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();

            String sql = "select * from Trivia.User WHERE ";

            if(userName != null && !userName.equals("")){
                sql = sql + "userName = \"" + userName + "\"";
            }else{
                sql = sql + "userName IS NOT NULL";
            }
            sql += " AND ";
            if(userStatus != null && userStatus.equals("")){
                sql = sql + "valid = " + userStatus;
            }
            else{
                sql = sql + "valid IS NOT NULL ";
            }

            System.out.println("sql:" + sql);
            myRs = myStmt.executeQuery(sql);

            List<User> userList = new ArrayList<User>();
            User mUser = null;

            while (myRs.next()) {
                mUser = new User().setUserName(myRs.getString("userName"))
                        .setUserPsw(myRs.getString("password"))
                        .setValid(myRs.getBoolean("valid"))
                        .setFriendNumber(myRs.getInt("friendNumber"))
                        .setScore(myRs.getInt("score"));
                userList.add(mUser);
            }

            return userList;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }
}
