
import bean.User;
import model.UserDbUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * UserDbUtil Tester.
 */
public class UserDbUtilTest {
    private UserDbUtil userDbUtil;
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
    public void before() {
        userDbUtil = new UserDbUtil(dataSource);
    }

    @AfterClass
    public static void afterClass() throws SQLException {
        dataSource.close();
        System.out.println("Ends Testing.");
    }


    @Test
    /* 数据库中不存在tt5*/
    public void testGetUserByName_With_tt5() throws Exception {
        String userName = "tt5";
        User it = userDbUtil.getUserByName(userName);
        assertNull(it);
    }

    @Test
    /*数据库中存在tt1*/
    public void testGetUserByName_With_tt1() throws Exception {
        String userName = "tt1";
        User it = userDbUtil.getUserByName(userName);
        assertEquals(it.getUserName(), userName);
    }

    /**
     * Method: updateUserByName(String userName, String userPsw)
     */
    @Test
    public void testUpdateUserByName() throws Exception {
//TODO: Test goes here...

    }

    /**
     * Method: suspendUserByName(String userName)
     */
    @Test
    public void testSuspendUserByName() throws Exception {
//TODO: Test goes here...
        userDbUtil.suspendUserByName("tt1");
        userDbUtil.suspendUserByName("tt2");
        userDbUtil.suspendUserByName("tt3");
        userDbUtil.suspendUserByName("tt4");
        userDbUtil.suspendUserByName("tt6");
        userDbUtil.suspendUserByName("tt7");

        assertFalse(userDbUtil.getUserByName("tt1").isValid());
        assertFalse(userDbUtil.getUserByName("tt2").isValid());
        assertFalse(userDbUtil.getUserByName("tt3").isValid());
        assertFalse(userDbUtil.getUserByName("tt4").isValid());
        assertFalse(userDbUtil.getUserByName("tt6").isValid());
        assertFalse(userDbUtil.getUserByName("tt7").isValid());

    }

    /**
     * Method: activateUserByName(String userName)
     */
    @Test
    public void testActivateUserByName() throws Exception {
//TODO: Test goes here...
        userDbUtil.activateUserByName("tt1");
        userDbUtil.activateUserByName("tt2");
        userDbUtil.activateUserByName("tt3");
        userDbUtil.activateUserByName("tt4");
        userDbUtil.activateUserByName("tt6");
        userDbUtil.activateUserByName("tt7");

        assertTrue(userDbUtil.getUserByName("tt1").isValid());
        assertTrue(userDbUtil.getUserByName("tt2").isValid());
        assertTrue(userDbUtil.getUserByName("tt3").isValid());
        assertTrue(userDbUtil.getUserByName("tt4").isValid());
        assertTrue(userDbUtil.getUserByName("tt6").isValid());
        assertTrue(userDbUtil.getUserByName("tt7").isValid());
    }

    /**
     * Method: getUserListbyAdmin(String userName, String userStatus)
     */
    @Test
    public void testGetUserListbyAdmin_with_null_and_null() throws Exception {
//TODO: Test goes here...
        List<User> ret = userDbUtil.getUserListbyAdmin(null, null);
        assertNotEquals(ret.size(), 0);
    }

    @Test
    public void testGetUserListbyAdmin_with_t1_and_null() throws Exception {
//TODO: Test goes here...
        List<User> ret = userDbUtil.getUserListbyAdmin("t1", null);
        assertEquals(ret.size(), 1);
        assertEquals(ret.get(0).getUserName(), "t1");
    }

    @Test
    public void testGetUserListbyAdmin_with_t1_and_1() throws Exception {
//TODO: Test goes here...
        List<User> ret = userDbUtil.getUserListbyAdmin("t1", "1");
        assertEquals(ret.size(), 0);
    }

    @Test
    public void testGetUserListbyAdmin_with_t1_and_0() throws Exception {
//TODO: Test goes here...
        List<User> ret = userDbUtil.getUserListbyAdmin("t1", "0");
        assertEquals(ret.size(), 1);
        assertEquals(ret.get(0).getUserName(), "t1");
    }

    @Test
    public void testGetUserListbyAdmin_with_null_and_0() throws Exception {
//TODO: Test goes here...
        List<User> ret = userDbUtil.getUserListbyAdmin(null, "0");
        assertTrue(ret.size() >= 2);
    }

    @Test
    public void testUpdateUserByName_with_t1_and_10152160137() throws Exception {
        userDbUtil.updateUserByName("t1", "10152160137");
        assertEquals(userDbUtil.getUserByName("t1").getUserPsw(), "10152160137");
    }

    @Test
    public void testUpdateUserByName_with_tt_and_10152160137() throws Exception {
        userDbUtil.updateUserByName("tt", "10152160137");
        assertEquals(userDbUtil.getUserByName("tt").getUserPsw(), "10152160137");
    }


}
