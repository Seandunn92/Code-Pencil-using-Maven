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
        assertEquals(500, myPencil.getPointDurabilityLeft());
    }
    @Test
    public void NonDefaultConstructorWorks(){
        myPencil = new CodePencil(10,7);
        assertEquals(10, myPencil.getPointDurabilityLeft());
        assertEquals(7, myPencil.getPencilLength());
    }

    @Test
    public void setterWorksForPointDurability(){
        myPencil.setPointDurablity(5);
        assertEquals(5, myPencil.getPointDurability());
    }

    @Test
    public void PointDegredationWorksForlowercase(){
        myPencil = new CodePencil();
        myPencil.write("apple");
        assertEquals(495, myPencil.getPointDurabilityLeft());
        myPencil.write("pear");
        assertEquals(491, myPencil.getPointDurabilityLeft());
    }

    @Test
    public void PointDegredationWorksForUppercase(){
        myPencil = new CodePencil();
        myPencil.write("Apple");
        assertEquals(494, myPencil.getPointDurabilityLeft());
        myPencil.write("PEAR");
        assertEquals(486, myPencil.getPointDurabilityLeft());
    }

    @Test
    public void PointDegredationWorksForSpaces(){
        myPencil = new CodePencil();
        myPencil.write("apple pear");
        assertEquals(491, myPencil.getPointDurabilityLeft());
        myPencil.write("   ");
        assertEquals(491, myPencil.getPointDurabilityLeft());

    }
    @Test
    public void PointDegredationWorksForNewLines(){
        myPencil.setPointDurabilityLeft(10);
        myPencil.write("\n\n\n\n");
        assertEquals(10, myPencil.getPointDurabilityLeft());
        myPencil.write("hello \n there");
        assertEquals(0, myPencil.getPointDurabilityLeft());
    }


    @Test
    public void PencilStopsWritingWhenDurabilityisZero(){
        myPencil = new CodePencil();
        myPencil.setPointDurabilityLeft(7);
        myPencil.write("apples and pears");
        //8 spaces after apple a
        assertEquals("apples a        "   , myPencil.getPaper());
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
        myPencil = new CodePencil(400, 5);
        myPencil.setPointDurabilityLeft(50);
        myPencil.sharpen();
        assertEquals(400, myPencil.getPointDurabilityLeft());
    }

    @Test
    public void SharpenDecreasesPencilLength(){
        myPencil.setPencilLength(5);
        myPencil.sharpen();
        assertEquals(4, myPencil.getPencilLength());

    }

    @Test
    public void SharpenWillNotSharpenIfPencilLengthIsZero(){
        myPencil = new CodePencil(350, 0);
        myPencil.setPointDurabilityLeft(100);
        myPencil.sharpen();
        assertEquals(100, myPencil.getPointDurabilityLeft());
    }

    @Test
    public void EraserHasDurabilityOfOneHundredByDefault(){
        myPencil = new CodePencil();
        assertEquals(100, myPencil.getEraserDurability());

    }
}
