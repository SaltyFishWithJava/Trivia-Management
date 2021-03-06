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

    public int addQues(String quesText, String ansA, String ansB, String ansC, String ansD, String ans, int quesCate) throws Exception {
        int ret = 0;
        switch (quesCate) {
            case 1:
                ret = addQues1(quesText, ansA, ansB, ansC, ansD, ans);
                break;
            case 2:
                ret = addQues2(quesText, ansA, ansB, ansC, ansD, ans);
                break;
            case 3:
                ret = addQues3(quesText, ansA, ansB, ansC, ansD, ans);
                break;
            case 4:
                ret = addQues4(quesText, ansA, ansB, ansC, ansD, ans);
                break;
        }
        return ret;
    }

    private int addQues4(String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = String.format("INSERT INTO Trivia.questions_4 (description, A, B, C, D, answer, cate) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', 4)",
                    quesText, ansA, ansB, ansC, ansD, ans);
            System.out.println(sql);
            myStmt.execute(sql);
            String getLastInsert = "SELECT LAST_INSERT_ID()";
            myRs = myStmt.executeQuery(getLastInsert);
            myRs.first();
            return myRs.getInt(1);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private int addQues3(String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = String.format("INSERT INTO Trivia.questions_3 (description, A, B, C, D, answer, cate) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', 3)",
                    quesText, ansA, ansB, ansC, ansD, ans);
            System.out.println(sql);
            myStmt.execute(sql);
            String getLastInsert = "SELECT LAST_INSERT_ID()";
            myRs = myStmt.executeQuery(getLastInsert);
            myRs.first();
            return myRs.getInt(1);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private int addQues2(String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = String.format("INSERT INTO Trivia.questions_2 (description, A, B, C, D, answer, cate) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', 2)",
                    quesText, ansA, ansB, ansC, ansD, ans);
            System.out.println(sql);
            myStmt.execute(sql);
            String getLastInsert = "SELECT LAST_INSERT_ID()";
            myRs = myStmt.executeQuery(getLastInsert);
            myRs.first();
            return myRs.getInt(1);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private int addQues1(String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = String.format("INSERT INTO Trivia.questions_1 (description, A, B, C, D, answer, cate) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', 1)",
                    quesText, ansA, ansB, ansC, ansD, ans);
            System.out.println(sql);
            myStmt.execute(sql);
            String getLastInsert = "SELECT LAST_INSERT_ID()";
            myRs = myStmt.executeQuery(getLastInsert);
            myRs.first();
            return myRs.getInt(1);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    public void updateQuesById(int quesId, String quesText, String ansA, String ansB, String ansC, String ansD, String ans, int quesCate) throws Exception {
        switch (quesCate) {
            case 1:
                updateQues1(quesId, quesText, ansA, ansB, ansC, ansD, ans);
                break;
            case 2:
                updateQues2(quesId, quesText, ansA, ansB, ansC, ansD, ans);
                break;
            case 3:
                updateQues3(quesId, quesText, ansA, ansB, ansC, ansD, ans);
                break;
            case 4:
                updateQues4(quesId, quesText, ansA, ansB, ansC, ansD, ans);
                break;
        }
    }

    private void updateQues4(int quesId, String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = String.format("UPDATE Trivia.questions_4 SET description = '%s', A = '%s', B = '%s', C = '%s', D = '%s', answer = '%s' WHERE id = %d",
                    quesText, ansA, ansB, ansC, ansD, ans, quesId);
            System.out.println(sql);
            myStmt.execute(sql);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private void updateQues3(int quesId, String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = String.format("UPDATE Trivia.questions_3 SET description = '%s', A = '%s', B = '%s', C = '%s', D = '%s', answer = '%s' WHERE id = %d",
                    quesText, ansA, ansB, ansC, ansD, ans, quesId);
            System.out.println(sql);
            myStmt.execute(sql);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private void updateQues2(int quesId, String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = String.format("UPDATE Trivia.questions_2 SET description = '%s', A = '%s', B = '%s', C = '%s', D = '%s', answer = '%s' WHERE id = %d",
                    quesText, ansA, ansB, ansC, ansD, ans, quesId);
            System.out.println(sql);
            myStmt.execute(sql);
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private void updateQues1(int quesId, String quesText, String ansA, String ansB, String ansC, String ansD, String ans) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = String.format("UPDATE Trivia.questions_1 SET description = '%s', A = '%s', B = '%s', C = '%s', D = '%s', answer = '%s' WHERE id = %d",
                    quesText, ansA, ansB, ansC, ansD, ans, quesId);
            System.out.println(sql);
            myStmt.execute(sql);
        } finally {
            close(myConn, myStmt, myRs);
        }
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

    public Ques getQues(int quesId, int quesCate) throws Exception {
        Ques ret = null;
        switch (quesCate) {
            case 1:
                ret = getQues1(quesId);
                break;
            case 2:
                ret = getQues2(quesId);
                break;
            case 3:
                ret = getQues3(quesId);
                break;
            case 4:
                ret = getQues4(quesId);
                break;
        }
        return ret;
    }

    private Ques getQues4(int quesId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM Trivia.questions_4 WHERE ID = " + quesId;
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);
            if(!myRs.first()) return null;
            Ques it = new Ques().setAns(myRs.getString("answer"))
                    .setChoiceA(myRs.getString("A"))
                    .setChoiceB(myRs.getString("B"))
                    .setChoiceC(myRs.getString("C"))
                    .setChoiceD(myRs.getString("D"))
                    .setQuesCate(myRs.getInt("cate"))
                    .setQuesText(myRs.getString("description"))
                    .setQuesId(myRs.getInt("ID"));
            return it;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private Ques getQues3(int quesId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM Trivia.questions_3 WHERE ID = " + quesId;
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);
            if(!myRs.first()) return null;
            Ques it = new Ques().setAns(myRs.getString("answer"))
                    .setChoiceA(myRs.getString("A"))
                    .setChoiceB(myRs.getString("B"))
                    .setChoiceC(myRs.getString("C"))
                    .setChoiceD(myRs.getString("D"))
                    .setQuesCate(myRs.getInt("cate"))
                    .setQuesText(myRs.getString("description"))
                    .setQuesId(myRs.getInt("ID"));
            return it;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private Ques getQues2(int quesId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM Trivia.questions_2 WHERE ID = " + quesId;
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);
            if(!myRs.first()) return null;
            Ques it = new Ques().setAns(myRs.getString("answer"))
                    .setChoiceA(myRs.getString("A"))
                    .setChoiceB(myRs.getString("B"))
                    .setChoiceC(myRs.getString("C"))
                    .setChoiceD(myRs.getString("D"))
                    .setQuesCate(myRs.getInt("cate"))
                    .setQuesText(myRs.getString("description"))
                    .setQuesId(myRs.getInt("ID"));
            return it;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    private Ques getQues1(int quesId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();
            String sql = "SELECT * FROM Trivia.questions_1 WHERE ID = " + quesId;
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);
            if(!myRs.first()) return null;
            Ques it = new Ques().setAns(myRs.getString("answer"))
                    .setChoiceA(myRs.getString("A"))
                    .setChoiceB(myRs.getString("B"))
                    .setChoiceC(myRs.getString("C"))
                    .setChoiceD(myRs.getString("D"))
                    .setQuesCate(myRs.getInt("cate"))
                    .setQuesText(myRs.getString("description"))
                    .setQuesId(myRs.getInt("ID"));
            return it;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }
}
