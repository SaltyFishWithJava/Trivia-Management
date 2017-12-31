import bean.Ques;
import model.QuesDbUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * GameDbUtil Tester.
 *
 * @author CHEN YIJUN
 * @version 1.0
 */
public class QuesDbUtilTest {
    private QuesDbUtil quesDbUtil;
    private static BasicDataSource dataSource;

    @BeforeClass
    public static void beforeClass() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("RJCS123456");
        dataSource.setUrl("jdbc:mysql://59b6aed4552fc.sh.cdb.myqcloud.com:5244/Trivia?useUnicode=true&amp;characterEncoding=UTF-8&amp;useSSL=false");
        System.out.println(dataSource);
        System.out.println("Starts Testing.");
    }

    @Before
    public void before() throws Exception {
        quesDbUtil = new QuesDbUtil(dataSource);
    }

    @After
    public void after() throws Exception {
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        System.out.println("Ends Testing.");
        dataSource.close();
    }

    /**
     * Method: getGameListbyAdmin(String playerName, int id, boolean searchId)
     */
    @Test
    public void testGetGameListbyAdmin_with_null_and_no_id() throws Exception {
//TODO: Test goes here...

    }


}
