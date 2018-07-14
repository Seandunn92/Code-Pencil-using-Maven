package com.sean.dunn;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{

    private static CodePencil appPencil;
    public static void main( String[] args )
    {
        Scanner scanner= new Scanner(System.in);
        appPencil= new CodePencil();
       int input = -1;
       do {
           System.out.println("**********************************************************************************");
           System.out.println("Welcome to the Code Pencil menu: Please enter in the option number you would like");
           System.out.println("-1 : Quit");
           System.out.println("1 : Display my Paper");
           System.out.println("**********************************************************************************");
           input = scanner.nextInt();
           switch(input){
               case 1: DisplayPaper();
           }
       }while (input>-1);
    }

    private static void DisplayPaper() {
        System.out.println(appPencil.getPaper());
    }
}
