package com.sean.dunn;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CodePencilTests {

    CodePencil myPencil = new CodePencil();

    @Test
    public void NewCodePencilHasBlankPaper(){
        myPencil = new CodePencil();
        String expected = "";
        String actual= myPencil.getPaper();
        assertEquals(expected, actual);

    }

    @Test
    public void SettingPaperWorks(){
        String desiredPaper= "It's a new paper";
        myPencil.setPaper(desiredPaper);
        assertEquals(desiredPaper, myPencil.getPaper());

    }

    @Test
    public void WritingOnABlankPageWorks(){
        myPencil.setPaper("");
        myPencil.write("Hi Sean");
        assertEquals("Hi Sean", myPencil.getPaper());
    }

    @Test
    public void WritingOnNonBlankPageWorks(){
        myPencil.setPaper("He couldn't have");
        myPencil.write(" jumped across the river.");
        assertEquals("He couldn't have jumped across the river.", myPencil.getPaper());
    }

    @Test
    public void PointDegredationIsSetTo500ByDefault(){
        myPencil = new CodePencil();
        assertEquals(500, myPencil.getPointDurability());
    }
    @Test
    public void NonDefaultConstructorWorks(){
        myPencil = new CodePencil(10,7, 57);
        assertEquals(10, myPencil.getPointDurability());
        assertEquals(7, myPencil.getPencilLength());
        assertEquals(57, myPencil.getEraserDurability());
        assertEquals("", myPencil.getPaper());
    }

    @Test
    public void setterWorksForPointDurability(){
        myPencil.setInitialPointDurablity(5);
        assertEquals(5, myPencil.getInitialPointDurability());
    }

    @Test
    public void PointDegredationWorksForLowercase(){
        myPencil = new CodePencil();
        myPencil.write("apple");
        assertEquals(495, myPencil.getPointDurability());
        myPencil.write("pear");
        assertEquals(491, myPencil.getPointDurability());
    }

    @Test
    public void PointDegredationWorksForUppercase(){
        myPencil = new CodePencil();
        myPencil.write("Apple");
        assertEquals(494, myPencil.getPointDurability());
        myPencil.write("PEAR");
        assertEquals(486, myPencil.getPointDurability());
    }

    @Test
    public void PointDegredationWorksForSpaces(){
        myPencil = new CodePencil();
        myPencil.write("apple pear");
        assertEquals(491, myPencil.getPointDurability());
        myPencil.write("   ");
        assertEquals(491, myPencil.getPointDurability());

    }
    @Test
    public void PointDegredationWorksForNewLines(){
        myPencil.setPointDurability(10);
        myPencil.write("\n\n\n\n");
        assertEquals(10, myPencil.getPointDurability());
        myPencil.write("hello \n there");
        assertEquals(0, myPencil.getPointDurability());
    }


    @Test
    public void PencilStopsWritingWhenDurabilityisZero(){
        myPencil = new CodePencil();
        myPencil.setPointDurability(7);
        myPencil.write("apples and pears");
        assertEquals("apples a" + numSpaces(8)   , myPencil.getPaper());
    }

    @Test
    public void pencilLengthIsSetToTenByDefault(){
        myPencil= new CodePencil();
        assertEquals(10, myPencil.getPencilLength());
    }
    @Test
    public void setterForPencilLengthWorks(){
        myPencil.setPencilLength(4);
        assertEquals(4, myPencil.getPencilLength());

    }
    @Test
    public void SharpenRestoresDurability(){
        myPencil = new CodePencil(400, 5, 50);
        myPencil.setPointDurability(50);
        myPencil.sharpen();
        assertEquals(400, myPencil.getPointDurability());
    }

    @Test
    public void SharpenDecreasesPencilLength(){
        myPencil.setPencilLength(5);
        myPencil.sharpen();
        assertEquals(4, myPencil.getPencilLength());

    }

    @Test
    public void SharpenWillNotSharpenIfPencilLengthIsZero(){
        myPencil = new CodePencil(350, 0, 50);
        myPencil.setPointDurability(100);
        myPencil.sharpen();
        assertEquals(100, myPencil.getPointDurability());
    }

    @Test
    public void EraserHasDurabilityOfOneHundredByDefault(){
        myPencil = new CodePencil();
        assertEquals(100, myPencil.getEraserDurability());
    }

    @Test
    public void settingEraserDurabilityWorks(){
        myPencil.setEraserDurability(47);
        assertEquals(47, myPencil.getEraserDurability());
    }

    @Test
    public void ErasingWorks(){
        myPencil.setEraserDurability(600);
        myPencil.setPaper("Apples and Bananas");
        myPencil.erase("Apples");
        assertEquals(numSpaces(6) + " and Bananas", myPencil.getPaper());
        assertEquals( 594, myPencil.getEraserDurability());


        myPencil.setPaper("Apples and Bananas");
        myPencil.erase("Bananas");
        assertEquals("Apples and " + numSpaces(7), myPencil.getPaper());
        assertEquals(587, myPencil.getEraserDurability());

        myPencil.setPaper("Apples and Bananas");
        myPencil.erase("and");
        assertEquals("Apples " + numSpaces(3)+ " Bananas", myPencil.getPaper());
        assertEquals(584, myPencil.getEraserDurability());

    }

    @Test
    public void ErasingingWhiteSpaceDoesNotDegradeEraser(){
        myPencil.setEraserDurability(600);
        myPencil.setPaper("Apples and Bananas");
        myPencil.erase(" ");
        assertEquals(600, myPencil.getEraserDurability());
    }

    @Test
    public void ErasingRemovestheLastWord(){
        myPencil.setEraserDurability(600);
        myPencil.setPaper("Apples and Bananas and Apples again");
        myPencil.erase("Apples");
        assertEquals("Apples and Bananas and " + numSpaces(6)+ " again", myPencil.getPaper());
    }

    @Test
    public void ErasingStringNotInPaperDoesNotDegradeOrErase(){
        myPencil.setEraserDurability(560);
        myPencil.setPaper("Apple and Bananas");
        myPencil.erase("Apples");
        assertEquals("Apple and Bananas", myPencil.getPaper());
        assertEquals(560, myPencil.getEraserDurability());
    }

    @Test
    public void ErasingStringDoesNothingIfEraserIsDegraded(){
        myPencil.setEraserDurability(0);
        myPencil.setPaper("Hunger and War");
        myPencil.erase("War");
        assertEquals("Hunger and War", myPencil.getPaper());
        assertEquals(0, myPencil.getEraserDurability());
    }

    @Test
    public void DegredationinMiddleofErasingStopsDeletion(){
        myPencil.setEraserDurability(2);
        myPencil.setPaper("Cargo Shorts");
        myPencil.erase("Cargo");
        assertEquals("Car   Shorts", myPencil.getPaper());
        assertEquals(0, myPencil.getEraserDurability());

        myPencil.setPaper("Buffalo Bill");
        myPencil.setEraserDurability(3);
        myPencil.erase("Buffalo B   ");

    }

    @Test
    public void EditingWithoutCollisionWorks(){
        myPencil.setPointDurability(100);
        myPencil.setPaper("An " + numSpaces(5) + " a day keeps the doctor away");
        myPencil.edit(3, "onion");
        assertEquals("An onion a day keeps the doctor away", myPencil.getPaper());
        assertEquals(95, myPencil.getPointDurability());

    }

    @Test
    public void EditingWithCollisionWorks(){
        myPencil.setPointDurability(100);
        myPencil.setPaper("An "+ numSpaces(5) + " a day keeps the doctor away");
        myPencil.edit(3, "artichoke");
        assertEquals("An artich@k@ay keeps the doctor away", myPencil.getPaper());
        assertEquals(93, myPencil.getPointDurability());


    }

    @Test
    public void EdittingDefaultsToFirstPlaceWithTwoSpaces(){
        myPencil.setPointDurability(50);
        myPencil.setPaper("An "+ numSpaces(5) + " a day keeps the doctor away"
                +numSpaces(5));
        myPencil.edit("onion");
        assertEquals("An onion a day keeps the doctor away" +numSpaces(5), myPencil.getPaper());

    }
    @Test
    public void DefaultEdittingDoesNotEditIfThereAreNotTwoSpacesInPaper(){
        myPencil.setPointDurability(50);
        myPencil.setPaper("An ordinary article without 2 spaces");
        myPencil.edit("straight");
        assertEquals("An ordinary article without 2 spaces", myPencil.getPaper());
    }


    public String numSpaces(int numberOfSpaces){
        String stringOfSpaces="";
        for (int i =0; i<numberOfSpaces; i++)
            stringOfSpaces+=' ';

        return stringOfSpaces;
    }





}

