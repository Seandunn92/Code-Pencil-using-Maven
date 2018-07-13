package com.sean.dunn;

public class CodePencil {

    private String paper;
    private int pointDurability;
    private int pointDurabilityLeft;
    private int pencilLength;

    public CodePencil(){
        paper = "";
        pointDurability = 500;
        pointDurabilityLeft=500;
        pencilLength =10;
    }

    public CodePencil(int pointDurability, int pencilLength) {
        this.pointDurability = pointDurability;
        this.pointDurabilityLeft = pointDurability;
        this.pencilLength=pencilLength;
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
    public void setPencilLength(int pencilLength) {

        this.pencilLength=pencilLength;

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
    public int getPencilLength() {
        return pencilLength;
    }

    public void write(String whatToWrite) {


        int stoppingPoint = getWritingStopPoint(whatToWrite);
        if (stoppingPoint == whatToWrite.length())
            paper+=whatToWrite;
        else
            paper += whatToWrite.substring(0,stoppingPoint) + calculateStringOfSpaces(whatToWrite.length()-stoppingPoint);

    }

    private String calculateStringOfSpaces(int numOfSpaces) {
        String spaceString="";
         for (int i=0; i<numOfSpaces; i++){
             spaceString+=" ";
         }
        return spaceString;
    }

    private int getWritingStopPoint(String whatToWrite) {
        int pointDegradation =0;
        for (int i = 0; i<whatToWrite.length(); i++)
        {
            char currentChar = whatToWrite.charAt(i);
            if (currentChar != ' '  && currentChar !='\n') {
                if (Character.toLowerCase(currentChar) == currentChar) {
                    pointDurabilityLeft--;
                } else pointDurabilityLeft -= 2;
            }
            if (pointDurabilityLeft<0){
                return i;
            }
        }
        return whatToWrite.length();
    }


    public void sharpen() {
        if (pencilLength>0) {
            pointDurabilityLeft = pointDurability;
            pencilLength--;
        }
    }
}
