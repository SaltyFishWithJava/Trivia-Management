package model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

    protected DataSource dataSource;

    protected DbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

}
