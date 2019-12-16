package org.lsf.model;

public class Question {
    private int quesId;
    private String quesStem;
    private String quesA;
    private String quesB;
    private String quesC;
    private String quesD;
    private String quesCorrect;

    public Question() {
    }

    public Question(int quesId, String quesStem, String quesA, String quesB, String quesC, String quesD, String quesCorrect) {
        this.quesId = quesId;
        this.quesStem = quesStem;
        this.quesA = quesA;
        this.quesB = quesB;
        this.quesC = quesC;
        this.quesD = quesD;
        this.quesCorrect = quesCorrect;
    }

    @Override
    public String toString() {
        return "Question{" +
                "quesId=" + quesId +
                ", quesStem='" + quesStem + '\'' +
                ", quesA='" + quesA + '\'' +
                ", quesB='" + quesB + '\'' +
                ", quesC='" + quesC + '\'' +
                ", quesD='" + quesD + '\'' +
                ", quesCorrect='" + quesCorrect + '\'' +
                '}';
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getQuesStem() {
        return quesStem;
    }

    public void setQuesStem(String quesStem) {
        this.quesStem = quesStem;
    }

    public String getQuesA() {
        return quesA;
    }

    public void setQuesA(String quesA) {
        this.quesA = quesA;
    }

    public String getQuesB() {
        return quesB;
    }

    public void setQuesB(String quesB) {
        this.quesB = quesB;
    }

    public String getQuesC() {
        return quesC;
    }

    public void setQuesC(String quesC) {
        this.quesC = quesC;
    }

    public String getQuesD() {
        return quesD;
    }

    public void setQuesD(String quesD) {
        this.quesD = quesD;
    }

    public String getQuesCorrect() {
        return quesCorrect;
    }

    public void setQuesCorrect(String quesCorrect) {
        this.quesCorrect = quesCorrect;
    }


}
