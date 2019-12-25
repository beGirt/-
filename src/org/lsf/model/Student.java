package org.lsf.model;

public class Student {
    private int stuId;
    private String stuAccount;
    private String stuPassword;
    private String stuName;
    private boolean gender;         /*true : 男 ; false : 女*/
    private String phoneNumber;
    private int stuScore;



    /*无参构造器*/
    public Student() {
    }

    public Student(String stuAccount, String stuPassword, String stuName) {
        this.stuAccount = stuAccount;
        this.stuPassword = stuPassword;
        this.stuName = stuName;
    }

    public Student(int stuId, String stuAccount, String stuPassword, String stuName, boolean gender, String phoneNumber, int stuScore) {
        this.stuId = stuId;
        this.stuAccount = stuAccount;
        this.stuPassword = stuPassword;
        this.stuName = stuName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.stuScore = stuScore;
    }

    public int getStuScore() {
        return stuScore;
    }

    public void setStuScore(int stuScore) {
        this.stuScore = stuScore;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuAccount() {
        return stuAccount;
    }

    public void setStuAccount(String stuAccount) {
        this.stuAccount = stuAccount;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuAccount='" + stuAccount + '\'' +
                ", stuPassword='" + stuPassword + '\'' +
                ", stuName='" + stuName + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
