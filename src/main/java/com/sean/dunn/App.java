package com.sean.dunn;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        Scanner scanner= new Scanner(System.in);
       CodePencil appPencil= new CodePencil();
       int input = -1;
       do {
           System.out.println("Welcome to the Code Pencil menu: Choose an option");
           System.out.println("-1: Quit");
           input = scanner.nextInt();
       }while (input>-1);
    }
}
