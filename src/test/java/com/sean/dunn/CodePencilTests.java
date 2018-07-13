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
    public void PointDegredationWorksForlowercase(){
        myPencil = new CodePencil();
        myPencil.write("apple");
        assertEquals(495, myPencil.getPointDurability());
    }

    @Test
    public void PointDegredationWorksForUppercase(){
        myPencil = new CodePencil();
        myPencil.write("Apple");
        assertEquals(494, myPencil.getPointDurability());
    }

}
