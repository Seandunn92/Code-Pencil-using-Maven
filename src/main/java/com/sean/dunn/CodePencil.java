package com.sean.dunn;

public class CodePencil {

    private String paper;
    int pointDegredation;

    public CodePencil(){
        paper = "";
        pointDegredation = 500;
    }

    public String getPaper(){
        return paper;
    }

    public void setPaper(String desiredPaper) {
        paper=desiredPaper;
    }


    public void write(String whatToWrite) {

        paper += whatToWrite;
    }


    public int getPointDegredation() {
        return pointDegredation;
    }
}
