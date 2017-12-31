package bean;

public class Ques {
    private int quesId;
    private String quesText;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private char ans;

    public int getQuesId() {
        return quesId;
    }

    public Ques setQuesId(int quesId) {
        this.quesId = quesId;
        return this;
    }

    public String getQuesText() {
        return quesText;
    }

    public Ques setQuesText(String quesText) {
        this.quesText = quesText;
        return this;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public Ques setChoiceA(String choiceA) {
        this.choiceA = choiceA;
        return this;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public Ques setChoiceB(String choiceB) {
        this.choiceB = choiceB;
        return this;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public Ques setChoiceC(String choiceC) {
        this.choiceC = choiceC;
        return this;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public Ques setChoiceD(String choiceD) {
        this.choiceD = choiceD;
        return this;
    }

    public char getAns() {
        return ans;
    }

    public Ques setAns(char ans) {
        this.ans = ans;
        return this;
    }
}
