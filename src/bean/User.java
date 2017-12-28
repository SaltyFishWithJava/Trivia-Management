package bean;

import controller.UserController;

import java.util.Date;

public class User {
    private String userName;
    private String userPsw;
    private int score;
    private int friendNumber;
    private boolean valid;

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public User setUserPsw(String userPsw) {
        this.userPsw = userPsw;
        return this;
    }

    public int getScore() {
        return score;
    }

    public User setScore(int score) {
        this.score = score;
        return this;
    }

    public int getFriendNumber() {
        return friendNumber;
    }

    public User setFriendNumber(int friendNumber) {
        this.friendNumber = friendNumber;
        return this;
    }

    public boolean isValid() {
        return valid;
    }

    public User setValid(boolean valid) {
        this.valid = valid;
        return this;
    }
}
