package com.sean.dunn;

public class CodePencil {

    private String paper;
    private int initialPointDurability;
    private int pointDurability;
    private int pencilLength;
    private int eraserDurability;

    public CodePencil(){
        paper = "";
        initialPointDurability = 500;
        pointDurability =500;
        pencilLength =10;
        eraserDurability=100;
    }

    public CodePencil(int pointDurability, int pencilLength) {
        this.initialPointDurability = pointDurability;
        this.pointDurability = pointDurability;
        this.pencilLength=pencilLength;
    }

    public void setPaper(String desiredPaper) {
        paper=desiredPaper;
    }

    public void setInitialPointDurablity(int initialPointDurability) {
        this.initialPointDurability =initialPointDurability;
    }

    public void setPointDurability(int pointDurability){
        this.pointDurability = pointDurability;
    }
    public void setPencilLength(int pencilLength) {

        this.pencilLength=pencilLength;

    }

    public String getPaper(){
        return paper;
    }

    public int getInitialPointDurability() {
        return initialPointDurability;
    }

    public int getPointDurability() {
        return pointDurability;
    }
    public int getPencilLength() {
        return pencilLength;
    }

    public int getEraserDurability() {
        return eraserDurability;
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
                    pointDurability--;
                } else pointDurability -= 2;
            }
            if (pointDurability <0){
                return i;
            }
        }
        return whatToWrite.length();
    }


    public void sharpen() {
        if (pencilLength>0) {
            pointDurability = initialPointDurability;
            pencilLength--;
        }
    }


}
