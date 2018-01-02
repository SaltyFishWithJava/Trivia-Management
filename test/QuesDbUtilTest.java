import bean.Ques;
import model.QuesDbUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

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

    @AfterClass
    public static void afterClass() throws SQLException {
        System.out.println("Ends Testing.");
        dataSource.close();
    }

    /**
     * Method: getGameListbyAdmin(String playerName, int id, boolean searchId)
     */
    @Test
    public void testGetGameListbyAdmin_with_null_and_no_cate() throws Exception {
        //TODO: Test goes here...
        List<Ques> ret = quesDbUtil.getQuesListByAdmin(null, 0, false);
        assertTrue(ret.size() >= 200);
    }

    @Test
    public void testGetGameListByAdmin_with_null_and_cate_1() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin(null, 1, true);
        assertTrue(ret.size() > 0);
        for (Ques it : ret) {
            assertEquals(1, it.getQuesCate());
        }
    }

    @Test
    public void testGetGameListByAdmin_with_null_and_cate_2() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin(null, 2, true);
        assertTrue(ret.size() > 0);
        for (Ques it : ret) {
            assertEquals(2, it.getQuesCate());
        }
    }

    @Test
    public void testGetGameListByAdmin_with_null_and_cate_3() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin(null, 3, true);
        assertTrue(ret.size() > 0);
        for (Ques it : ret) {
            assertEquals(3, it.getQuesCate());
        }
    }

    @Test
    public void testGetGameListByAdmin_with_null_and_cate_4() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin(null, 4, true);
        assertTrue(ret.size() > 0);
        for (Ques it : ret) {
            assertEquals(4, it.getQuesCate());
        }
    }

    @Test
    public void testGetGameListByAdmin_with_notindb_and_no_cate() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin("notindb", 0, false);
        assertEquals(0, ret.size());
    }

    @Test
    public void testGetGameListByAdmin_with_ceshi_and_no_cate() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin("测试", 0, false);
        for (Ques it : ret) {
            assertThat(it.getQuesText(), containsString("测试"));
        }
    }

    @Test
    public void testGetGameListByAdmin_with_ceshi_and_cate_1() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin("测试", 1, true);
        for (Ques it : ret) {
            assertThat(it.getQuesText(), containsString("测试"));
            assertEquals(1, it.getQuesCate());
        }
    }

    @Test
    public void testAddDeleteQues_with_adding_ques_1() throws Exception {
        int quesId = quesDbUtil.addQues("ques_1", "ques_1", "ques_1", "ques_1", "ques_1"
                , "A", 1);
        Ques retFromDb = quesDbUtil.getQues(quesId, 1);
        assertThat(retFromDb.getQuesText(), is("ques_1"));
        assertThat(retFromDb.getChoiceA(), is("ques_1"));
        assertThat(retFromDb.getChoiceB(), is("ques_1"));
        assertThat(retFromDb.getChoiceC(), is("ques_1"));
        assertThat(retFromDb.getChoiceD(), is("ques_1"));
        assertThat(retFromDb.getAns(), is("A"));
        assertEquals(1, retFromDb.getQuesCate());
        assertEquals(quesId, retFromDb.getQuesId());

        quesDbUtil.deleteQuesById(quesId, 1);
        retFromDb = quesDbUtil.getQues(quesId, 1);
        assertNull(retFromDb);
    }

    @Test
    public void testAddDeleteQues_with_adding_ques_2() throws Exception {
        int quesId = quesDbUtil.addQues("ques_2", "ques_2", "ques_2", "ques_2", "ques_2"
                , "B", 2);
        Ques retFromDb = quesDbUtil.getQues(quesId, 2);
        assertThat(retFromDb.getQuesText(), is("ques_2"));
        assertThat(retFromDb.getChoiceA(), is("ques_2"));
        assertThat(retFromDb.getChoiceB(), is("ques_2"));
        assertThat(retFromDb.getChoiceC(), is("ques_2"));
        assertThat(retFromDb.getChoiceD(), is("ques_2"));
        assertThat(retFromDb.getAns(), is("B"));
        assertEquals(2, retFromDb.getQuesCate());
        assertEquals(quesId, retFromDb.getQuesId());

        quesDbUtil.deleteQuesById(quesId, 2);
        retFromDb = quesDbUtil.getQues(quesId, 2);
        assertNull(retFromDb);
    }

    @Test
    public void testAddDeleteQues_with_adding_ques_3() throws Exception {
        int quesId = quesDbUtil.addQues("ques_3", "ques_3", "ques_3", "ques_3", "ques_3"
                , "C", 3);
        Ques retFromDb = quesDbUtil.getQues(quesId, 3);
        assertThat(retFromDb.getQuesText(), is("ques_3"));
        assertThat(retFromDb.getChoiceA(), is("ques_3"));
        assertThat(retFromDb.getChoiceB(), is("ques_3"));
        assertThat(retFromDb.getChoiceC(), is("ques_3"));
        assertThat(retFromDb.getChoiceD(), is("ques_3"));
        assertThat(retFromDb.getAns(), is("C"));
        assertEquals(3, retFromDb.getQuesCate());
        assertEquals(quesId, retFromDb.getQuesId());

        quesDbUtil.deleteQuesById(quesId, 3);
        retFromDb = quesDbUtil.getQues(quesId, 3);
        assertNull(retFromDb);
    }

    @Test
    public void testAddDeleteQues_with_adding_ques_4() throws Exception {
        int quesId = quesDbUtil.addQues("ques_4", "ques_4", "ques_4", "ques_4", "ques_4"
                , "D", 4);
        Ques retFromDb = quesDbUtil.getQues(quesId, 4);
        assertThat(retFromDb.getQuesText(), is("ques_4"));
        assertThat(retFromDb.getChoiceA(), is("ques_4"));
        assertThat(retFromDb.getChoiceB(), is("ques_4"));
        assertThat(retFromDb.getChoiceC(), is("ques_4"));
        assertThat(retFromDb.getChoiceD(), is("ques_4"));
        assertThat(retFromDb.getAns(), is("D"));
        assertEquals(4, retFromDb.getQuesCate());
        assertEquals(quesId, retFromDb.getQuesId());

        quesDbUtil.deleteQuesById(quesId, 4);
        retFromDb = quesDbUtil.getQues(quesId, 4);
        assertNull(retFromDb);
    }

    @Test
    public void testUpdateQues_with_ceshi1_ques_1() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin("测试1", 1, true);
        for(Ques it : ret){
            int id = it.getQuesId();
            quesDbUtil.updateQuesById(id, "测试2", "测试2", "测试2", "测试2", "测试2"
                    , "B", 1);
            Ques tmp = quesDbUtil.getQues(id, 1);
            assertThat(tmp.getQuesText(), is("测试2"));
            assertThat(tmp.getChoiceA(), is("测试2"));
            assertThat(tmp.getChoiceB(), is("测试2"));
            assertThat(tmp.getChoiceC(), is("测试2"));
            assertThat(tmp.getChoiceD(), is("测试2"));
            assertThat(tmp.getAns(), is("B"));
            assertEquals(id, tmp.getQuesId());
            assertEquals(1, tmp.getQuesCate());
            quesDbUtil.updateQuesById(id, "测试1", "测试1", "测试1", "测试1", "测试1"
                    , "A", 1);
            tmp = quesDbUtil.getQues(id, 1);
            assertThat(tmp.getQuesText(), is("测试1"));
            assertThat(tmp.getChoiceA(), is("测试1"));
            assertThat(tmp.getChoiceB(), is("测试1"));
            assertThat(tmp.getChoiceC(), is("测试1"));
            assertThat(tmp.getChoiceD(), is("测试1"));
            assertThat(tmp.getAns(), is("A"));
            assertEquals(id, tmp.getQuesId());
            assertEquals(1, tmp.getQuesCate());
        }
    }

    @Test
    public void testUpdateQues_with_ceshi1_ques_2() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin("测试1", 2, true);
        for(Ques it : ret){
            int id = it.getQuesId();
            quesDbUtil.updateQuesById(id, "测试2", "测试2", "测试2", "测试2", "测试2"
                    , "C", 2);
            Ques tmp = quesDbUtil.getQues(id, 2);
            assertThat(tmp.getQuesText(), is("测试2"));
            assertThat(tmp.getChoiceA(), is("测试2"));
            assertThat(tmp.getChoiceB(), is("测试2"));
            assertThat(tmp.getChoiceC(), is("测试2"));
            assertThat(tmp.getChoiceD(), is("测试2"));
            assertThat(tmp.getAns(), is("C"));
            assertEquals(id, tmp.getQuesId());
            assertEquals(2, tmp.getQuesCate());
            quesDbUtil.updateQuesById(id, "测试1", "测试1", "测试1", "测试1", "测试1"
                    , "A", 2);
            tmp = quesDbUtil.getQues(id, 2);
            assertThat(tmp.getQuesText(), is("测试1"));
            assertThat(tmp.getChoiceA(), is("测试1"));
            assertThat(tmp.getChoiceB(), is("测试1"));
            assertThat(tmp.getChoiceC(), is("测试1"));
            assertThat(tmp.getChoiceD(), is("测试1"));
            assertThat(tmp.getAns(), is("A"));
            assertEquals(id, tmp.getQuesId());
            assertEquals(2, tmp.getQuesCate());
        }
    }

    @Test
    public void testUpdateQues_with_ceshi1_ques_3() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin("测试1", 3, true);
        for(Ques it : ret){
            int id = it.getQuesId();
            quesDbUtil.updateQuesById(id, "测试2", "测试2", "测试2", "测试2", "测试2"
                    , "D", 3);
            Ques tmp = quesDbUtil.getQues(id, 3);
            assertThat(tmp.getQuesText(), is("测试2"));
            assertThat(tmp.getChoiceA(), is("测试2"));
            assertThat(tmp.getChoiceB(), is("测试2"));
            assertThat(tmp.getChoiceC(), is("测试2"));
            assertThat(tmp.getChoiceD(), is("测试2"));
            assertThat(tmp.getAns(), is("D"));
            assertEquals(id, tmp.getQuesId());
            assertEquals(3, tmp.getQuesCate());
            quesDbUtil.updateQuesById(id, "测试1", "测试1", "测试1", "测试1", "测试1"
                    , "A", 3);
            tmp = quesDbUtil.getQues(id, 3);
            assertThat(tmp.getQuesText(), is("测试1"));
            assertThat(tmp.getChoiceA(), is("测试1"));
            assertThat(tmp.getChoiceB(), is("测试1"));
            assertThat(tmp.getChoiceC(), is("测试1"));
            assertThat(tmp.getChoiceD(), is("测试1"));
            assertThat(tmp.getAns(), is("A"));
            assertEquals(id, tmp.getQuesId());
            assertEquals(3, tmp.getQuesCate());
        }
    }

    @Test
    public void testUpdateQues_with_ceshi1_ques_4() throws Exception {
        List<Ques> ret = quesDbUtil.getQuesListByAdmin("测试1", 4, true);
        for(Ques it : ret){
            int id = it.getQuesId();
            quesDbUtil.updateQuesById(id, "测试2", "测试2", "测试2", "测试2", "测试2"
                    , "B", 4);
            Ques tmp = quesDbUtil.getQues(id, 4);
            assertThat(tmp.getQuesText(), is("测试2"));
            assertThat(tmp.getChoiceA(), is("测试2"));
            assertThat(tmp.getChoiceB(), is("测试2"));
            assertThat(tmp.getChoiceC(), is("测试2"));
            assertThat(tmp.getChoiceD(), is("测试2"));
            assertThat(tmp.getAns(), is("B"));
            assertEquals(id, tmp.getQuesId());
            assertEquals(4, tmp.getQuesCate());
            quesDbUtil.updateQuesById(id, "测试1", "测试1", "测试1", "测试1", "测试1"
                    , "A", 4);
            tmp = quesDbUtil.getQues(id, 4);
            assertThat(tmp.getQuesText(), is("测试1"));
            assertThat(tmp.getChoiceA(), is("测试1"));
            assertThat(tmp.getChoiceB(), is("测试1"));
            assertThat(tmp.getChoiceC(), is("测试1"));
            assertThat(tmp.getChoiceD(), is("测试1"));
            assertThat(tmp.getAns(), is("A"));
            assertEquals(id, tmp.getQuesId());
            assertEquals(4, tmp.getQuesCate());
        }
    }
}
