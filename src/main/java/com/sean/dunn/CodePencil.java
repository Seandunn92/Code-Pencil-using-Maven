package com.sean.dunn;

public class CodePencil {

    private String paper;

    public CodePencil(){
        paper = "";
    }

    public String getPaper(){
        return paper;
    }


    public void setPaper(String desiredPaper) {
        paper=desiredPaper;
    }
}