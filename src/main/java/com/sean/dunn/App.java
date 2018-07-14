package com.sean.dunn;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{

    private static CodePencil appPencil;
    private static Scanner scanner;
    public static void main( String[] args )
    {
        scanner= new Scanner(System.in);
        appPencil= new CodePencil();
       int input = -1;
       do {
           System.out.println();
           System.out.println("**********************************************************************************");
           System.out.println("Pencil Durability: " + appPencil.getPointDurability());
           System.out.println("Eraser Durabality: " + appPencil.getEraserDurability());
           System.out.println("Pencil Length    :"  + appPencil.getPencilLength() );
           System.out.println();
           System.out.println("Welcome to the Code Pencil menu: Please enter in the option number you would like");
           System.out.println("-1 : Quit");
           System.out.println("1  : Display my Paper");
           System.out.println("2  : Write");
           System.out.println("3  : Erase");
           System.out.println("4  : Edit");
           System.out.println("5  : Sharpen");
           System.out.println("**********************************************************************************");
           input = scanner.nextInt();
           System.out.println();
           switch(input){
               case 1: DisplayPaper();break;
               case 2: Write(); break;
               case 3: Erase(); break;
               case 4: Edit(); break;
               case 5: appPencil.sharpen(); break;
           }
       }while (input>-1);
    }

    private static void DisplayPaper() {
        System.out.println(appPencil.getPaper());
    }
    private static void Write() {
        scanner.nextLine();
        System.out.print(appPencil.getPaper());
        appPencil.write(scanner.nextLine());
    }
    private static void Erase() {
        System.out.println("What would you like to erase?");
        scanner.nextLine();
        appPencil.erase(scanner.nextLine());
    }
    private static void Edit() {
        System.out.println("What would you like to insert into you paper?");
        scanner.nextLine();
        String whatToInsert = scanner.nextLine();
        System.out.println("What index do you want to start at: (-1 to default to the first instance of 2 spaces in " +
                          "your paper)");
        int editIndex=scanner.nextInt();

        if(editIndex<=-1)
            appPencil.edit(whatToInsert);
        else
            appPencil.edit(editIndex, whatToInsert);
    }




}
