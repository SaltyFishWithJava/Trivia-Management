import bean.Game;
import model.GameDbUtil;
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
public class GameDbUtilTest {
    private GameDbUtil gameDbUtil;
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
        gameDbUtil = new GameDbUtil(dataSource);
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
        List<Game> ret = gameDbUtil.getGameListbyAdmin(null, 0, false);
        assertTrue(ret.size() >= 1);
    }

    @Test

    public void testGetGameListbyAdmin_with_tt1_and_no_id() throws Exception {
//TODO: Test goes here...
        List<Game> ret = gameDbUtil.getGameListbyAdmin("tt1", 0, false);
        for (Game it : ret) {
            assertTrue("tt1".equals(it.getPlayer1())
                    || "tt1".equals(it.getPlayer2())
                    || "tt1".equals(it.getPlayer3())
                    || "tt1".equals(it.getPlayer4()));
        }
    }


    @Test
    public void testGetGameListbyAdmin_with_tt2_and_no_id() throws Exception {
//TODO: Test goes here...
        List<Game> ret = gameDbUtil.getGameListbyAdmin("tt2", 0, false);
        for (Game it : ret) {
            assertTrue("tt2".equals(it.getPlayer1())
                    || "tt2".equals(it.getPlayer2())
                    || "tt2".equals(it.getPlayer3())
                    || "tt2".equals(it.getPlayer4()));
        }
    }

    @Test
    public void testGetGameListbyAdmin_with_tt3and_no_id() throws Exception {
//TODO: Test goes here...
        List<Game> ret = gameDbUtil.getGameListbyAdmin("tt3", 0, false);
        for (Game it : ret) {
            assertTrue("tt3".equals(it.getPlayer1())
                    || "tt3".equals(it.getPlayer2())
                    || "tt3".equals(it.getPlayer3())
                    || "tt3".equals(it.getPlayer4()));
        }
    }

    @Test
    public void testGetGameListbyAdmin_with_tt4_and_no_id() throws Exception {
//TODO: Test goes here...
        List<Game> ret = gameDbUtil.getGameListbyAdmin("tt4", 0, false);
        for (Game it : ret) {
            assertTrue("tt4".equals(it.getPlayer1())
                    || "tt4".equals(it.getPlayer2())
                    || "tt4".equals(it.getPlayer3())
                    || "tt4".equals(it.getPlayer4()));
        }
    }

    @Test
    public void testGetGameListbyAdmin_with_null_and_2() throws Exception {
//TODO: Test goes here...
        List<Game> ret = gameDbUtil.getGameListbyAdmin(null, 2, true);
        assertEquals(1, ret.size());
        assertEquals(2, ret.get(0).getId());
    }


    @Test
    public void testGetGameListbyAdmin_with_tt5_and_2() throws Exception {
//TODO: Test goes here...
        List<Game> ret = gameDbUtil.getGameListbyAdmin("tt5", 2, true);
        assertEquals(0, ret.size());
    }

    @Test
    public void testGetGameListbyAdmin_with_tt1_and_2() throws Exception {
//TODO: Test goes here...
        List<Game> ret = gameDbUtil.getGameListbyAdmin("tt1", 2, true);
        assertEquals(1, ret.size());
    }

}
