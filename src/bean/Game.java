package bean;

import java.sql.Timestamp;

public class Game {
    private String player1;
    private String player2;
    private String player3;
    private String player4;
    private int score1;
    private int score2;
    private int score3;
    private int score4;
    private int id;
    private Timestamp time;

    public String getPlayer1() {
        return player1;
    }

    public Game setPlayer1(String player1) {
        this.player1 = player1;
        return this;
    }

    public String getPlayer2() {
        return player2;
    }

    public Game setPlayer2(String player2) {
        this.player2 = player2;
        return this;
    }

    public String getPlayer3() {
        return player3;
    }

    public Game setPlayer3(String player3) {
        this.player3 = player3;
        return this;
    }

    public String getPlayer4() {
        return player4;
    }

    public Game setPlayer4(String player4) {
        this.player4 = player4;
        return this;
    }

    public int getScore1() {
        return score1;
    }

    public Game setScore1(int score1) {
        this.score1 = score1;
        return this;
    }

    public int getScore2() {
        return score2;
    }

    public Game setScore2(int score2) {
        this.score2 = score2;
        return this;
    }

    public int getScore3() {
        return score3;
    }

    public Game setScore3(int score3) {
        this.score3 = score3;
        return this;
    }

    public int getScore4() {
        return score4;
    }

    public Game setScore4(int score4) {
        this.score4 = score4;
        return this;
    }

    public int getId() {
        return id;
    }

    public Game setId(int id) {
        this.id = id;
        return this;
    }

    public Timestamp getTime() {
        return time;
    }

    public Game setTime(Timestamp time) {
        this.time = time;
        return this;
    }
}
