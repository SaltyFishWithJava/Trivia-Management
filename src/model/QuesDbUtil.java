package model;

import bean.Ques;

import javax.sql.DataSource;
import java.util.List;

public class QuesDbUtil extends DbUtil {

    //Constructor
    public QuesDbUtil(DataSource dataSource) {
        super(dataSource);
    }

    public List<Ques> getQuesListByAdmin(String quesText, int quesCate, boolean searchCate, int quesId
            , boolean searchId) throws Exception {

    }

    public int addQues(String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {

    }

    public void updateQuesById(int quesId, String quesText, String ansA, String ansB, String ansC, String ansD) throws Exception {

    }

    public void deleteQuesById(int quesId) throws Exception{

    }
}
