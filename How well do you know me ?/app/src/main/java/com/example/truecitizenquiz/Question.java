package com.example.truecitizenquiz;

public class Question {
    private int answerResid;
    private boolean answerTrue;

    public Question(int answerResid, boolean answerTrue) {
        this.answerResid = answerResid;
        this.answerTrue = answerTrue;

    }

    public int getAnswerResid() {
        return answerResid;
    }

    public void setAnswerResid(int answerResid) {
        this.answerResid = answerResid;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }


}
