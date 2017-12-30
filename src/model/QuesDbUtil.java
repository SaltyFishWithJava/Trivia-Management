package model;

import bean.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuesDbUtil extends DbUtil {

    //Constructor
    public QuesDbUtil(DataSource dataSource) {
        super(dataSource);
    }

}
