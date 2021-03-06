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

    public CodePencil(int pointDurability, int pencilLength, int eraserDurability) {
        this.initialPointDurability = pointDurability;
        this.pointDurability = pointDurability;
        this.pencilLength=pencilLength;
        this.eraserDurability = eraserDurability;
        paper="";

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
    public void setEraserDurability(int eraserDurability) {
        this.eraserDurability=eraserDurability;
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

    private String performDelete(String deletionTarget){
        for (int i=deletionTarget.length()-1; i>=0; i--){
            if (eraserDurability==0)
                return deletionTarget;
            if(deletionTarget.charAt(i)!=' ') {
                deletionTarget = deletionTarget.substring(0, i) + ' ' + deletionTarget.substring(i + 1);
                eraserDurability--;
            }
        }
        return deletionTarget;
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


    public void erase(String deletionTarget) {
        int beginningOfDeletion = paper.lastIndexOf(deletionTarget);
        if (beginningOfDeletion<0)
            return;

        int endOfDeletion = paper.lastIndexOf(deletionTarget) + deletionTarget.length();
        String paperAfterDeletion = paper.substring(endOfDeletion);
        String paperBeforeDeletion = paper.substring(0, beginningOfDeletion);
        paper = paperBeforeDeletion + performDelete(deletionTarget) + paperAfterDeletion;


    }

    public void edit(int startIndex, String newText) {
        int nextNewCharIndex=0;
        char insertion;

        for (int i=startIndex; i<startIndex+newText.length(); i++){
            if (newText.charAt(nextNewCharIndex)!=' ' && pointDurability>0) {
                if(paper.charAt(i)!=' ')
                    insertion ='@';
                else {
                    insertion = newText.charAt(nextNewCharIndex);
                }
                if (insertion != paper.charAt(i)) {
                    paper = paper.substring(0, i) + insertion + paper.substring(i + 1);
                    if (insertion!='@')
                    pointDurability--;
                }

            }
            nextNewCharIndex++;
        }
    }

    public void edit(String newText) {
        int startIndex= paper.indexOf("  ")+1;
        if (startIndex-1!=-1)
        edit(startIndex, newText);

    }
}
