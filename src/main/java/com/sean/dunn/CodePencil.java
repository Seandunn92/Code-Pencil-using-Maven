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


        pointDegredation -= calculatePointDegredation(whatToWrite);
        paper += whatToWrite;
    }

    private int calculatePointDegredation(String whatToWrite) {
        int count =0;
        for (int i = 0; i<whatToWrite.length(); i++)
        {
            char currentChar = whatToWrite.charAt(i);
           if(Character.toLowerCase(currentChar) == currentChar){
                count++;
           }
        }
        return count;
    }


    public int getPointDegredation() {
        return pointDegredation;
    }


}
