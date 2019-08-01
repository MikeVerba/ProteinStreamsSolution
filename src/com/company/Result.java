package com.company;

import java.io.Serializable;

public class Result implements Serializable {
    static int RESULT_COUNT = 0;
    private String s1;
    private String s2;
    private boolean isChangePossible;

    public Result(String s1, String s2, boolean isChangePossible) {
        this.s1 = s1;
        this.s2 = s2;
        this.isChangePossible = isChangePossible;
        RESULT_COUNT++;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public boolean isChangePossible() {
        return isChangePossible;
    }

    public void setChangePossible(boolean changePossible) {
        isChangePossible = changePossible;
    }


    @Override
    public String toString() {
        return "Result{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", isChangePossible=" + isChangePossible +
                '}';
    }
}
