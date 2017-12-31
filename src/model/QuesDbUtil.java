package model;

import bean.Ques;

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


    private List<Ques> getQuesListFromQues1(String quesText, List<Ques> quesList) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM Trivia.questions_1 WHERE description LIKE \'%" + quesText + "%\'";
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                Ques it = new Ques().setAns(myRs.getString("answer"))
                        .setChoiceA(myRs.getString("A"))
                        .setChoiceB(myRs.getString("B"))
                        .setChoiceC(myRs.getString("C"))
                        .setChoiceD(myRs.getString("D"))
                        .setQuesCate(myRs.getInt("cate"))
                        .setQuesText(myRs.getString("description"))
                        .setQuesId(myRs.getInt("ID"));
                quesList.add(it);
            }
            return quesList;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private List<Ques> getQuesListFromQues2(String quesText, List<Ques> quesList) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM Trivia.questions_2 WHERE description LIKE \'%" + quesText + "%\'";
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                Ques it = new Ques().setAns(myRs.getString("answer"))
                        .setChoiceA(myRs.getString("A"))
                        .setChoiceB(myRs.getString("B"))
                        .setChoiceC(myRs.getString("C"))
                        .setChoiceD(myRs.getString("D"))
                        .setQuesCate(myRs.getInt("cate"))
                        .setQuesText(myRs.getString("description"))
                        .setQuesId(myRs.getInt("ID"));
                quesList.add(it);
            }
            return quesList;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private List<Ques> getQuesListFromQues3(String quesText, List<Ques> quesList) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM Trivia.questions_3 WHERE description LIKE \'%" + quesText + "%\'";
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                Ques it = new Ques().setAns(myRs.getString("answer"))
                        .setChoiceA(myRs.getString("A"))
                        .setChoiceB(myRs.getString("B"))
                        .setChoiceC(myRs.getString("C"))
                        .setChoiceD(myRs.getString("D"))
                        .setQuesCate(myRs.getInt("cate"))
                        .setQuesText(myRs.getString("description"))
                        .setQuesId(myRs.getInt("ID"));
                quesList.add(it);
            }
            return quesList;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private List<Ques> getQuesListFromQues4(String quesText, List<Ques> quesList) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM Trivia.questions_4 WHERE description LIKE \'%" + quesText + "%\'";
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                Ques it = new Ques().setAns(myRs.getString("answer"))
                        .setChoiceA(myRs.getString("A"))
                        .setChoiceB(myRs.getString("B"))
                        .setChoiceC(myRs.getString("C"))
                        .setChoiceD(myRs.getString("D"))
                        .setQuesCate(myRs.getInt("cate"))
                        .setQuesText(myRs.getString("description"))
                        .setQuesId(myRs.getInt("ID"));
                quesList.add(it);
            }
            return quesList;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    public List<Ques> getQuesListByAdmin(String quesText, int quesCate, boolean searchCate) throws Exception {
        if (quesText == null) {
            quesText = "";
        }
        List<Ques> result = new ArrayList<>();
        if (searchCate) {
            switch (quesCate) {
                case 1:
                    result = getQuesListFromQues1(quesText, result);
                    break;
                case 2:
                    result = getQuesListFromQues2(quesText, result);
                    break;
                case 3:
                    result = getQuesListFromQues3(quesText, result);
                    break;
                case 4:
                    result = getQuesListFromQues4(quesText, result);
                    break;
            }
        } else {
            result = getQuesListFromQues1(quesText, result);
            result = getQuesListFromQues2(quesText, result);
            result = getQuesListFromQues3(quesText, result);
            result = getQuesListFromQues4(quesText, result);
        }
        return result;
    }

    public int addQues(String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        return 0;
    }

    public void updateQuesById(int quesId, String quesText, String ansA, String ansB, String ansC, String ansD) throws Exception {

    }

    public void deleteQuesById(int quesId, int cate) throws Exception {
        switch (cate) {
            case 1:
                deleteQues1(quesId);
                break;
            case 2:
                deleteQues2(quesId);
                break;
            case 3:
                deleteQues3(quesId);
                break;
            case 4:
                deleteQues4(quesId);
                break;
        }
    }

    private void deleteQues4(int quesId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "DELETE FROM questions_4 WHERE ID = " + quesId;
            System.out.println(sql);
            myStmt.execute(sql);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private void deleteQues3(int quesId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "DELETE FROM questions_3 WHERE ID = " + quesId;
            System.out.println(sql);
            myStmt.execute(sql);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private void deleteQues2(int quesId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "DELETE FROM questions_2 WHERE ID = " + quesId;
            System.out.println(sql);
            myStmt.execute(sql);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private void deleteQues1(int quesId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "DELETE FROM questions_1 WHERE ID = " + quesId;
            System.out.println(sql);
            myStmt.execute(sql);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }
}
