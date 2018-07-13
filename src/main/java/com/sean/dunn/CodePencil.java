package com.sean.dunn;

public class CodePencil {

    private String paper;
    int pointDurability;
    int pointDurabilityLeft;

    public CodePencil(){
        paper = "";
        pointDurability = 500;
        pointDurabilityLeft=500;
    }

    public CodePencil(int pointDurability) {
        this.pointDurability = pointDurability;
        this.pointDurabilityLeft = pointDurability;
    }

    public void setPaper(String desiredPaper) {
        paper=desiredPaper;
    }

    public void setPointDurablity(int pointDurability) {
        this.pointDurability=pointDurability;
    }

    public void setPointDurabilityLeft(int pointDurabilityLeft){
        this.pointDurabilityLeft = pointDurabilityLeft;
    }

    public String getPaper(){
        return paper;
    }

    public int getPointDurability() {
        return pointDurability;
    }

    public int getPointDurabilityLeft() {
        return pointDurabilityLeft;
    }

    public void write(String whatToWrite) {


        pointDurabilityLeft -= calculatePointDegredation(whatToWrite);
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
