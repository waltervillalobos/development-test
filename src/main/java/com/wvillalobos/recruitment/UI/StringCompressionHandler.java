package com.wvillalobos.recruitment.UI;

import java.util.Scanner;

import com.wvillalobos.recruitment.compression.StringCompressionRle;

public class StringCompressionHandler {
	
	public static void handle(Scanner scanner) {
		
        System.out.print("Enter the string to compress: ");
        String inputToCompress = scanner.nextLine();
        String compressedString = StringCompressionRle.process(inputToCompress);
        System.out.println("Compressed string: " + compressedString);
	}

}
