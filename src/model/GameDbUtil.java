package model;

import bean.Game;
import bean.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameDbUtil extends DbUtil {

    //Constructor
    public GameDbUtil(DataSource dataSource) {
        super(dataSource);
    }

    public List<Game> getGameListbyAdmin(String playerName, int id, boolean searchId) throws Exception {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = dataSource.getConnection();
            myStmt = myConn.createStatement();

            String sql = "select * from Trivia.Games WHERE ";
            if(playerName != null && playerName != ""){
                sql = sql + "(Player1 = \"" +playerName + "\"" +  " or Player2 = \"" +playerName + "\""
                        + " or Player3 = \"" +playerName + "\"" + " or Player4 = \"" +playerName + "\")"
                        + " AND ";
            }
            if(searchId){
                sql = sql + "ID = " + id;
            }
            else{
                sql = sql + "ID IS NOT NULL ";
            }
            System.out.println(sql);
            myRs = myStmt.executeQuery(sql);

            List<Game> mGameList = new ArrayList<>();
            while(myRs.next()){
                Game it = new Game().setId(myRs.getInt("ID"))
                        .setPlayer1(myRs.getString("Player1"))
                        .setPlayer2(myRs.getString("Player2"))
                        .setPlayer3(myRs.getString("Player3"))
                        .setPlayer4(myRs.getString("Player4"))
                        .setScore1(myRs.getInt("score1"))
                        .setScore2(myRs.getInt("score2"))
                        .setScore3(myRs.getInt("score3"))
                        .setScore4(myRs.getInt("score4"))
                        .setTime(myRs.getTimestamp("Time"));
                mGameList.add(it);
            }
            return mGameList;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }
}
