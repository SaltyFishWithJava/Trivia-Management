package model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpaceDbUtil extends DbUtil {
    public SpaceDbUtil(DataSource dataSource) {
        super(dataSource);
    }

    public boolean setSpaceRemainByIdAndType(int spaceId, int spaceType, int spaceLeft) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String spaceTypeCol = "阿爸还是很失望";
            switch (spaceType) {
                case 1:
                    spaceTypeCol = "space_small_left";
                    break;
                case 2:
                    spaceTypeCol = "space_large_left";
                    break;
                default:
                    break;
            }
            String sql = "UPDATE 2017j2ee.space SET " + spaceTypeCol + " = " + spaceLeft + " WHERE space_id = " + spaceId;
            System.out.println(sql);
            myStmt.executeUpdate(sql);
            return true;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }
    


}
