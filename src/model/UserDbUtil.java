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

    public int userCount() throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM 2017j2ee.user";
            myRs = myStmt.executeQuery(sql);
            myRs.last();
            return myRs.getRow();
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    public boolean registerUser(String userName, String userPsw, String userEmail, String userCell) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            String sql = "insert into 2017j2ee.user (user_name, user_psw, user_cell, user_email, user_register_date) VALUES (?,?,?,?,?)";
            PreparedStatement prstmt = myConn.prepareStatement(sql);

            prstmt.setString(1, userName);
            prstmt.setString(2, userPsw);
            prstmt.setString(3, userCell);
            prstmt.setString(4, userEmail);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            prstmt.setDate(5, java.sql.Date.valueOf(df.format(new Date())));

            prstmt.execute();
            return true;

        } finally {
            close(myConn, myStmt, myRs);
        }

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

    public void updateUserLastSeen(int userId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String sql = new StringBuilder().append("UPDATE 2017j2ee.user SET user_last_seen = \"").append(df.format(new Date())).append("\" WHERE user_id = ").append(userId).toString();
            System.out.println(sql);
            myStmt.executeUpdate(sql);

        } finally {
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

    public User getUserByCell(String userCell) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql statement
//            String sql = "select * from 2017j2ee.user WHERE user_name=\"".concat(userName).concat("\"");
            String sql = "select * from 2017j2ee.user WHERE user_cell=?";//注释部分窝最后再删哦
            PreparedStatement ptmt = (PreparedStatement) myConn.prepareStatement(sql);//夸我夸我哦
            //传参
            ptmt.setString(1, userCell);
            //执行
            myRs = ptmt.executeQuery();
            while (myRs.next()) {
                return new User(myRs.getInt("user_id"),
                        myRs.getString("user_name"),
                        myRs.getString("user_psw"),
                        myRs.getString("user_cell"),
                        myRs.getInt("user_valid"),
                        myRs.getString("user_email"),
                        myRs.getBoolean("user_admin"),
                        myRs.getBoolean("user_avatar"),
                        myRs.getInt("user_balance"),
                        myRs.getDate("user_last_seen"),
                        myRs.getDate("user_register_date"),
                        myRs.getDate("user_last_order_date"));
            }
            return null;
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public User getUserByName(String userName) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql statement
//            String sql = "select * from 2017j2ee.user WHERE user_name=\"".concat(userName).concat("\"");
            String sql = "select * from 2017j2ee.user WHERE user_name=?";//注释部分窝最后再删哦
            PreparedStatement ptmt = (PreparedStatement) myConn.prepareStatement(sql);//夸我夸我哦
            //传参
            ptmt.setString(1, userName);
            //执行
            myRs = ptmt.executeQuery();
            while (myRs.next()) {
                return new User(myRs.getInt("user_id"),
                        myRs.getString("user_name"),
                        myRs.getString("user_psw"),
                        myRs.getString("user_cell"),
                        myRs.getInt("user_valid"),
                        myRs.getString("user_email"),
                        myRs.getBoolean("user_admin"),
                        myRs.getBoolean("user_avatar"),
                        myRs.getInt("user_balance"),
                        myRs.getDate("user_last_seen"),
                        myRs.getDate("user_register_date"),
                        myRs.getDate("user_last_order_date"));
            }
            return null;
        } finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public List<User> getUserListbyAdmin(String userId, String userStatus, String userName,
                                         String userCell, String dateLastLogined, String dateRegister, String dateDealed) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();

            String sql = "select * from 2017j2ee.user WHERE";
//                    " user_id=? AND user_valid=? AND user_name=?";

//            System.out.println(userId);
//            System.out.println(userStatus);
//            System.out.println(userName);
//            System.out.println(dateLastLogined);
//            System.out.println(dateRegister);
//            System.out.println(dateDealed);


            SimpleDateFormat dateFormatFrom = new SimpleDateFormat("mm/dd/yyyy");
            SimpleDateFormat dateFormatTo = new SimpleDateFormat("yyyy-mm-dd");

            if (null != userId && userId.length() != 0) {
                sql = sql + " user_id=" + userId;
            } else {
                sql = sql + " user_id IS NOT NULL";
            }
            sql += " AND ";
            if (null != userStatus && userStatus.length() != 0 && !userStatus.equals("3")) {
                sql = sql + " user_valid=" + userStatus;
            } else {
                sql = sql + " user_valid IS NOT NULL";
            }
            sql += " AND ";
            if (null != userCell && userCell.length() != 0) {
                sql = sql + " user_cell=" + userCell;
            } else {
                sql = sql + " user_cell IS NOT NULL ";
            }
            sql += " AND ";
            if (null != userName && userName.length() != 0) {
                sql = sql + " user_name=\"" + userName + "\"";
            } else {
                sql = sql + " user_name IS NOT NULL";
            }
            if (null != dateLastLogined && dateLastLogined.length() != 0) {
                sql += " AND ";
                sql = sql + " user_last_seen=\"" + dateFormatTo.format(dateFormatFrom.parse(dateLastLogined)) + "\"";
            }
            sql += " AND ";
            if (null != dateRegister && dateRegister.length() != 0) {
                sql = sql + "user_register_date=\"" + dateFormatTo.format(dateFormatFrom.parse(dateRegister)) + "\"";
            } else {
                sql = sql + "user_register_date IS NOT NULL";
            }

            if (null != dateDealed && dateDealed.length() != 0) {
                sql += " AND ";
                sql = sql + " user_last_order_date=\"" + dateFormatTo.format(dateFormatFrom.parse(dateDealed)) + "\"";
            }

//            //预编译
//            PreparedStatement ptmt = (PreparedStatement) myConn.prepareStatement(sql); //预编译SQL，减少sql执行
//
//            //传参
//            ptmt.setInt(1, Integer.parseInt(userId));
//            ptmt.setInt();
//            ptmt.setString(2, userName);
////            ptmt.setDate(4, new Date(g.getBirthday().getTime()));

            //执行
            System.out.println("sql:" + sql);
            myRs = myStmt.executeQuery(sql);

            List<User> userList = new ArrayList<User>();
            User mUser = null;

            while (myRs.next()) {
                mUser = new User().setUserId(myRs.getInt("user_id"))
                        .setUserName(myRs.getString("user_name"))
                        .setUserPsw(myRs.getString("user_psw"))
                        .setUserCell(myRs.getString("user_cell"))
                        .setUserValid(myRs.getInt("user_valid"))
                        .setUserEmail(myRs.getString("user_email"))
                        .setUserAdmin(myRs.getBoolean("user_admin"))
                        .setUserAvatar(myRs.getBoolean("user_avatar"))
                        .setUserBalance(myRs.getInt("user_balance"))
                        .setUserLastSeen(myRs.getDate("user_last_seen"))
                        .setUserRegisterDate(myRs.getDate("user_register_date"))
                        .setUserLastOrderDate(myRs.getDate("user_last_order_date"));
//                System.out.println("UserDbUtil:select success! User Select= " + mUser.getUserId() + " || " + mUser.getUserName());
                userList.add(mUser);
            }


//            while(myRs.next()) {
//                mUser = new User();
//
//
//                userList.add(mUser);
//            }
            return userList;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }
}
