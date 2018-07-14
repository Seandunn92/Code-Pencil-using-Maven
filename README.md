# Code-Pencil-using-Maven

For this project I used Test Driven Development to solve the Code Pencil Kata Found Here (https://github.com/PillarTechnology/kata-pencil-durability)

To run this project you can use Maven.

mvn install    will build the project

java -cp target/mt-1.0-SNAPSHOT.jar com.sean.dunn.App  will run the App (build the project first to see recent changes)

mvn test will run all of the test cases for the CodePencilClass.


You may also use an ide such as Intelij or Eclipse if you choose but it is not required.





** CODE PENCIL CLASS**
   private String paper; -- What the user will write on
    private int initialPointDurability; -- the durability the pencil started with
    private int pointDurability;  -- the durability the pencil has now. When durability hits 0 the pencil will no longer erase
    private int pencilLength;   -- the length of the pencil, Once this is 0 you can no longer sharpen pencil
    private int eraserDurability;  --the durability of the eraser. Once this hits 0 you can no longer erase

   ** Construtors **
    CodePencil() - starts with blank paper, 500 pointDurablity, 100 eraserDurability, and pencil Lenght 10
    CodePencil(int pointDurability, int pencilLength, int eraserDurability) - You set everything but the blank piece paper users start with
    (initalpointDurablility will start off equal to pointDurability)

    **SETTERS**
    public void setPaper(String desiredPaper);

    public void setInitialPointDurablity(int initialPointDurability);

    public void setPointDurability(int pointDurability)

    public void setPencilLength(int pencilLength)

    public void setEraserDurability(int eraserDurability)

   **GETTERS**
    public String getPaper()

    public int getInitialPointDurability()

    public int getPointDurability()

    public int getPencilLength()

    public int getEraserDurability()


    public void write(String whatToWrite)    -- Take in a string and adds that string to the pencil's paper

    public void sharpen()      -- sets Durability back to initalDurability, and decreases pencilLength. Will not work if
    pencil length is 0

    public void erase(String deletionTarget) - erases the last instance of the given string


    public void edit(int startIndex, String newText)  - edits the paper at the given start index, inserting a string
    passed in by the user.If there is a character other than a space  occupying a spot where a new text would go, that
    character is replaced by '@' representing a confict in the paper

    public void edit(String newText)  inserts the new text at the first instance of 2 consecutive spaces (the first
    space is used in front of the new Text.)
}


**APPLICATION**
Menu

**********************************************************************************
Pencil Durability: 500     -Display the pencil stats so the user will know when they need to sharpen,
                            and when they can no longer erase
Eraser Durabality: 100
Pencil Length    :10

Welcome to the Code Pencil menu: Please enter in the option number you would like
-1 : Quit                       When the user types a number less than 1 the app will stop
1  : Display my Paper           Type 1 to see the current paper (CodePencil.getPaper()
2  : Write                      Type 2 to Write on the paper     (CodePencil.write(String))
3  : Erase                      Type 3 to Erase from the paper  (CodePencil.erase(String))
4  : Edit                       Type 4 to Edit the paper  (CodePencil.edit(String))
5  : Sharpen                    Type 5 to Sharpen Pencil (CodePencil.sharpen())
**********************************************************************************




**TESTS**
--When a pencil is created, It starts with a blank piece of paper.--
    public void NewCodePencilHasBlankPaper()
--When a pencil is created using overRide Values those values are honored--
     public void NonDefaultConstructorWorks(){
            myPencil = new CodePencil(10,7, 57);
            assertEquals(10, myPencil.getPointDurability());
            assertEquals(7, myPencil.getPencilLength());
            assertEquals(57, myPencil.getEraserDurability());
            assertEquals("", myPencil.getPaper());
        }


    --Tests that a user can write on a blank page successfully--
    public void WritingOnABlankPageWorks(){


    --Test to check that writing on a non blank page, appends the new text to the paper without a problem--
    public void WritingOnNonBlankPageWorks(){




    --tests that lower Case Letters degrade the pencil by 1 each time--
    public void PointDegredationWorksForlowercase()

    --tests that upper case letters degrade the pencil by 2 each time--
    public void PointDegredationWorksForUppercase()

    --tests that spaces degrade the pencil by 0 each time--
    public void PointDegredationWorksForSpaces()

    --tests that new lin characters degrade the pencil by 0 each time--
    public void PointDegredationWorksForNewLines()

    --When the pencil is degraded the user should not be able to write--
    public void PencilStopsWritingWhenDurabilityisZero()

    --When a pencil is sharpened, the durablilty should be reset, so the user can have a sharp pencil again--
    public void SharpenRestoresDurability()

    --The user using sharpen should decrease the pencil length, so that eventually the user will buy a new pencil--
    public void SharpenDecreasesPencilLength()

    --The User can not sharpen a pencil when the length is 0 and must buy a new one--
    public void SharpenWillNotSharpenIfPencilLengthIsZero()




   -- Tests that erasing text, replaces the text with blank spaces, and wears down the eraser.--
    public void ErasingWorks()

    -- White Spaces do not need replacing so should not degrade eraser --
    public void ErasingingWhiteSpaceDoesNotDegradeEraser()

    -- If a word appears more than once the last one will be deleted
    public void ErasingRemovestheLastWord()

    --Nothing should happen to the eraser or Paper when the string to delete isn't there
    public void ErasingStringNotInPaperDoesNotDegradeOrErase()

    --If the eraser is degraded the pencil can not erase --
    public void ErasingStringDoesNothingIfEraserIsDegraded()

    --If the eraser degrades to in the middle of erasing, erasing will stop
    public void DegredationinMiddleofErasingStopsDeletion()


   --Word is inserted successfully without collisions
    public void EditingWithoutCollisionWorks()
  --Colission, insertion created conflicts
    public void EditingWithCollisionWorks()

    --The first place with 2 spaces is the first place an insertion can happen. (One space is to pad in front of the word)
    public void EdittingDefaultsToFirsttPlaceWithTwoSpaces()


    -- Used to represent an amount of spaces to make reading tests easier --
    public String numSpaces(int numberOfSpaces)