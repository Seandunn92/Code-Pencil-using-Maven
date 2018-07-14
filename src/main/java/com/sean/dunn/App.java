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
           System.out.println("Welcome to the Code Pencil menu: Please enter in the option number you would like");
           System.out.println("-1 : Quit");
           System.out.println("1  : Display my Paper");
           System.out.println("2  : Write");
           System.out.println("**********************************************************************************");
           input = scanner.nextInt();
           System.out.println();
           switch(input){
               case 1: DisplayPaper();break;
               case 2: Write(); break;
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
}
