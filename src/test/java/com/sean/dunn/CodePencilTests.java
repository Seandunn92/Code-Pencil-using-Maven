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
    }

    @Test
    public void setterWorksForPointDurability(){
        myPencil.setInitialPointDurablity(5);
        assertEquals(5, myPencil.getInitialPointDurability());
    }

    @Test
    public void PointDegredationWorksForlowercase(){
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
    public void SharpenRestoresDurabilityLeft(){
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
    public void ErasingWorksWhenDurabilityIsNotAConcern(){
        myPencil.setEraserDurability(6000);
        myPencil.setPaper("Apples and Bananas");
        myPencil.erase("Apples");
        assertEquals(numSpaces(6) + " and Bananas", myPencil.getPaper());


        myPencil.setPaper("Apples and Bananas");
        myPencil.erase("Bananas");
        assertEquals("Apples and " + numSpaces(7), myPencil.getPaper());


        myPencil.setPaper("Apples and Bananas");
        myPencil.erase("and");
        assertEquals("Apples " + numSpaces(3)+ " Bananas", myPencil.getPaper());
    }



    public String numSpaces(int numberOfSpaces){
        String stringOfSpaces="";
        for (int i =0; i<numberOfSpaces; i++)
            stringOfSpaces+=' ';

        return stringOfSpaces;
    }





}

