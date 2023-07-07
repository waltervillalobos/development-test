package com.cloudpay.recruitment.UI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
    private static int getChoice(Scanner scanner) {
    	
    	int choice = 0;
    	
    	 try {
    		 	
    		 choice = scanner.nextInt();
             scanner.nextLine(); 
             
    	 }  catch (InputMismatchException e) {
    		 
    		 scanner.nextLine(); 
    	 }
    	 
    	 return choice;
    }
    
    public static void execute() {
    	
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println(" === Run-Length Encoding Program (RLE) === ");
                System.out.println();
                System.out.println("Choose an option:");
                System.out.println("1. Compress a string");
                System.out.println("2. Decompress a string");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = getChoice(scanner);

                switch (choice) {
                    case 1:
                        StringCompressionHandler.handle(scanner);
                        break;
                    case 2:
                        StringDecompressionHandler.handle(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting the program.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }

                System.out.println();
            }
        }
    }

}
