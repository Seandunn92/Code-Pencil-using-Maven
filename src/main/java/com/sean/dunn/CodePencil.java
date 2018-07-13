package com.sean.dunn;

public class CodePencil {

    private String paper;
    int pointDurability;

    public CodePencil(){
        paper = "";
        pointDurability = 500;
    }

    public CodePencil(int pointDurability) {
        this.pointDurability = pointDurability;
    }

    public String getPaper(){
        return paper;
    }

    public void setPaper(String desiredPaper) {
        paper=desiredPaper;
    }

    public int getPointDurability() {
        return pointDurability;
    }


    public void setPointDurablity(int pointDurability) {
        this.pointDurability=pointDurability;
    }


    public void write(String whatToWrite) {


        pointDurability -= calculatePointDegredation(whatToWrite);
        paper += whatToWrite;
    }

    private int calculatePointDegredation(String whatToWrite) {
        int pointDegradation =0;
        for (int i = 0; i<whatToWrite.length(); i++)
        {

            char currentChar = whatToWrite.charAt(i);
            if (currentChar != ' '  && currentChar !='\n') {
                if (Character.toLowerCase(currentChar) == currentChar) {
                    pointDegradation++;
                } else pointDegradation += 2;
            }
        }
        return pointDegradation;
    }

}
